package com.example.webapp.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to set Oracle database context for repository methods.
 * This annotation will intercept database connections and call the specified 
 * stored procedure from DATABSE_CONNECTION_CONTEXT package before executing the method.
 * 
 * It's designed to work on repository methods to set context values like user identification,
 * that will be used by the database for auditing, row-level security, or other context-dependent operations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SetDatabaseContextForMethod {
    
    /**
     * The name of the procedure in the DATABSE_CONNECTION_CONTEXT package to call.
     * @return procedure name
     */
    String procedureName();
    
    /**
     * The name of the procedure's IN parameter.
     * @return parameter name
     */
    String parameterName();
    
    /**
     * Parameter value source strategy.
     * Defines how the value for the parameter should be obtained.
     * 
     * @return the strategy for obtaining the parameter value
     */
    ParameterValueSource valueSource() default ParameterValueSource.FIRST_METHOD_PARAMETER;
    
    /**
     * Optional static value to use when valueSource is set to STATIC_VALUE.
     * @return static parameter value
     */
    String staticValue() default "";
    
    /**
     * Optional SpEL expression to evaluate when valueSource is set to SPRING_EXPRESSION.
     * For example: "#user.username" to get username from SecurityContext
     * @return Spring Expression Language expression
     */
    String expression() default "";
    
    /**
     * Strategies for obtaining the parameter value to pass to the database procedure.
     */
    enum ParameterValueSource {
        /**
         * Use the first parameter of the annotated method
         */
        FIRST_METHOD_PARAMETER,
        
        /**
         * Use a static value provided in the annotation
         */
        STATIC_VALUE,
        
        /**
         * Use a Spring Expression Language (SpEL) expression to dynamically 
         * determine the value (e.g., from security context)
         */
        SPRING_EXPRESSION
    }
}
