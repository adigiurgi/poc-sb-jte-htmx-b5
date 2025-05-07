package com.example.webapp.infrastructure.config.database;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Aspect that intercepts repository methods annotated with {@link SetDatabaseContextForMethod}
 * and executes the specified Oracle database context setting procedure before method execution.
 */
@Aspect
@Component
@Slf4j
public class DatabaseContextAspect {

    private final JdbcTemplate jdbcTemplate;
    private final ExpressionParser expressionParser = new SpelExpressionParser();
    private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    @Autowired
    public DatabaseContextAspect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Intercepts method calls on @Repository annotated classes with @SetDatabaseContextForMethod annotation
     * and sets the Oracle database context before executing the method.
     *
     * @param joinPoint The join point representing the intercepted method call
     * @return The result of the method execution
     * @throws Throwable if an error occurs during method execution
     */
    @Around("@within(org.springframework.stereotype.Repository) && " +
            "@annotation(com.example.webapp.infrastructure.config.database.SetDatabaseContextForMethod)")
    public Object setDatabaseContext(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SetDatabaseContextForMethod annotation = method.getAnnotation(SetDatabaseContextForMethod.class);

        // Get the parameter value based on the specified strategy
        Object parameterValue = determineParameterValue(annotation, joinPoint, method);

        // Set database context using JdbcTemplate
        log.info("Setting database context for method: {} with parameter: {}", method.getName(), parameterValue);
        setDatabaseContextInOracle(annotation.procedureName(), annotation.parameterName(), parameterValue);
        log.info("Database context set successfully for method: {}", method.getName());

        // Execute the original method
        return joinPoint.proceed();
    }

    /**
     * Determines the parameter value to be used in the database context procedure call
     * based on the value source strategy specified in the annotation.
     *
     * @param annotation The SetDatabaseContextForMethod annotation
     * @param joinPoint The join point representing the intercepted method call
     * @param method The method being intercepted
     * @return The parameter value to use
     */
    private Object determineParameterValue(SetDatabaseContextForMethod annotation, 
                                          ProceedingJoinPoint joinPoint, 
                                          Method method) {
        switch (annotation.valueSource()) {
            case FIRST_METHOD_PARAMETER:
                Object[] args = joinPoint.getArgs();
                if (args == null || args.length == 0) {
                    throw new IllegalArgumentException("Method " + method.getName() + 
                            " annotated with @SetDatabaseContextForMethod using FIRST_METHOD_PARAMETER strategy " +
                            "must have at least one parameter");
                }
                return args[0];
                
            case STATIC_VALUE:
                return annotation.staticValue();
                
            case SPRING_EXPRESSION:
                String expression = annotation.expression();
                if (expression == null || expression.isEmpty()) {
                    throw new IllegalArgumentException("Method " + method.getName() +
                            " annotated with @SetDatabaseContextForMethod using SPRING_EXPRESSION strategy " +
                            "must specify a valid expression");
                }

                Object[] arguments = joinPoint.getArgs();
                EvaluationContext context = new MethodBasedEvaluationContext(
                        joinPoint.getTarget(),
                        method,
                        arguments,
                        parameterNameDiscoverer
                );

                return expressionParser.parseExpression(expression).getValue(context);
                
            default:
                throw new IllegalArgumentException("Unsupported parameter value source: " + annotation.valueSource());
        }
    }

    /**
     * Sets the Oracle database context by calling the specified procedure.
     *
     * @param procedureName The name of the procedure to call
     * @param parameterName The name of the procedure's parameter
     * @param parameterValue The value to pass to the procedure
     */
    private void setDatabaseContextInOracle(String procedureName, String parameterName, Object parameterValue) {
        jdbcTemplate.execute((ConnectionCallback<Void>) connection -> {
            String callStatement = "{call DATABSE_CONNECTION_CONTEXT." + procedureName + "(?" + ")}";
            
            try (CallableStatement stmt = connection.prepareCall(callStatement)) {
                setParameterValue(stmt, 1, parameterValue);
                stmt.execute();
            }
            return null;
        });
    }

    /**
     * Sets the parameter value in the CallableStatement, handling different types appropriately.
     *
     * @param stmt The CallableStatement
     * @param paramIndex The parameter index
     * @param value The parameter value
     * @throws SQLException if a database access error occurs
     */
    private void setParameterValue(CallableStatement stmt, int paramIndex, Object value) throws SQLException {
        if (value == null) {
            stmt.setNull(paramIndex, java.sql.Types.VARCHAR);
        } else if (value instanceof String) {
            stmt.setString(paramIndex, (String) value);
        } else if (value instanceof Number) {
            stmt.setLong(paramIndex, ((Number) value).longValue());
        } else if (value instanceof Boolean) {
            stmt.setBoolean(paramIndex, (Boolean) value);
        } else {
            // For other types, use toString method
            stmt.setString(paramIndex, value.toString());
        }
    }
}
