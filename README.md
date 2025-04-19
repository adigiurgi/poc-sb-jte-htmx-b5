# Project Name: WEBAPP - Hexagonal Architecture POC 

## Short description
- The project is a proof of concept for a web application that uses the hexagonal architecture pattern. 
- It is built with Spring Boot 2.7.18, Java 17, JTE (Java Template Engine), HTMX 2.0.4 (HTML over the wire), and Bootstrap 5.
- The application is designed to be a simple portal web application (gateway) for a bigger ERP that is integrated with Oracle SSO in production environment.
- The ERP is a distributed monolithic application with multiple modules deployed independently as WARs that are running on a WebLogic server and have one single common instance of an Oracle database.

### Core features
The application has the following core features:
1. Shows all the users profiles that are available in the ERP (the user profiles are defined in one of the ERP administration modules). 
2. The oldest profile is the default one and is persisted in a database table (WEBAPP.USER_ACTIVE_PROFILE) when the user access this portal webapp for the first time. This table acts as a user session store across all the other ERP modules.
3. The user can switch to any one of his profiles only from this application and not from any other modules. The application will change its UI accordingly (refresh the notifications and menu options) when the profile is switched and persists the new current active profile in the USER_ACTIVE_PROFILE table. 
4. Shows notifications from all the ERP modules with links to the corresponding module. There are 2 ways in which the notifications are produced: 
- In a deterministic way, on user request the application runs a set of database procedures which verifies the conditions for the notifications and inserts them in a database table from which the application reads them and ultimately displays them to the user (the legacy way of doing things); 
- On an event-driven way, the application simply reads the notifications from the database table and displays them to the user. The notifications are produced by the ERP modules and are inserted in the database table when the conditions for the notifications are met (the new way of doing things);
5. Shows the user the list of all the ERP modules that are available for him for each of the 4 menu categories: 
      5.1. Introduction
      5.2. Search
      5.3. Statistics
      5.4. Administration

### Software design key principles for backend development
1. The application should follow a hexagonal architecture and is structured in a way that separates the core business logic from the presentation layer, making it easier to maintain and test.
2. The application should use DDD concepts when designing the domain model and the application services.
3. The application should use SOLID principles as much as possible throughout the codebase.
4. The application should have at least 80% code coverage for the unit tests and 100% code coverage for the integration tests.

### Software design key principles for frontend development
1. The application uses JTE (Java Template Engine) for server-side rendering of HTML templates.
2. The application uses HTMX to create a dynamic and responsive user interface.
3. The application uses Bootstrap 5 for styling and layout.

### The application uses Maven profiles to manage different environments and configurations.
It has 3 profiles: 
- dev : default active profile (when using 'mvn spring-boot:run' cmd) - the app runs locally as a jar in spring's boot embedded Tomcat
- local: on this profile we build the project as a WAR for a locally installed WebLogic (without any sso integration, the user is mocked from a configuration class) and after that we copy the resulted war in the /autodeoply directory (used for developer testing of any possible WebLogic specific issues regarding spring boot and other dependencies)
- test: on this profile we build the project as a WAR for a remote installed WebLogic (with proper sso integration) and after that we copy the resulted war in the /autodeoply directory of the remote running weblogic instance domain (used by the QA team for testing the application in a production-like environment).
- prod: on this profile we build the project as a WAR for production with proper sso integration and after that we copy the resulted war in specific directory of the organization file server (used by the DevOps team for deploying the application in production environment).
