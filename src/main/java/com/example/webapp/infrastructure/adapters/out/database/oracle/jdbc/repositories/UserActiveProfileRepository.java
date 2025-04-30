package com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.repositories;

import com.example.webapp.infrastructure.adapters.out.database.oracle.jdbc.entities.UserActiveProfileEntity;
import com.example.webapp.infrastructure.config.database.SetDatabaseContextForMethod;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserActiveProfileRepository extends CrudRepository<UserActiveProfileEntity, Long> {

    Optional<UserActiveProfileEntity> findByUsername(String username);
    @SetDatabaseContextForMethod(
            procedureName = "set_connection_context",
            parameterName = "p_username"
    )
    @Query("select sys_context('WEBAPP_CTX','USERNAME') from dual")
    String getUsernameFromDatabaseContext(String username);

    /*
    This annotation is used to set the database context for the method.
    Example 1: Using the first parameter of the method
@Repository
public class UserRepository {
    @SetDatabaseContextForMethod(
        procedureName = "set_connection_context",
        parameterName = "p_username"
    )
    public User findUserById(String username) {
        // The username parameter will be automatically passed to the procedure
        // ...repository code...
    }
}

Example 2: Using a static value
@Repository
public class ProductRepository {
    @SetDatabaseContextForMethod(
        procedureName = "set_connection_context",
        parameterName = "p_username",
        valueSource = ParameterValueSource.STATIC_VALUE,
        staticValue = "system_user"
    )
    public List<Product> findAllProducts() {
        // Always uses "system_user" as the parameter value
        // ...repository code...
    }
}

Example 3: Using a Spring Expression
@Repository
public class OrderRepository {
    @SetDatabaseContextForMethod(
        procedureName = "set_connection_context",
        parameterName = "p_username",
        valueSource = ParameterValueSource.SPRING_EXPRESSION,
        expression = "@securityService.getCurrentUsername()"
    )
    public void saveOrder(Order order) {
        // Gets username from a securityService bean
        // ...repository code...
    }
}
     */


}
