# Hexagonal Architecture POC 

## Short description
- The project is a proof of concept for a web application that uses the hexagonal architecture pattern. 
- It is built with Spring Boot 2.7.18, Java 17, JTE (Java Template Engine), HTMX 2.0.4 (HTML over the wire), and Bootstrap 5.
- The application is designed to be a simple portal web application (gateway) for a bigger ERP that is integrated with Oracle SSO in production environment.
- The ERP is a distributed monolithic application with multiple modules deployed independently as WARs that are running on a WebLogic server and use one single common instance of an Oracle database.
---
### Core features
The application has the following core features:
1. Shows all the users profiles that are available in the ERP (the userApp profiles are defined in one of the ERP administration modules). 
2. The oldest profile is the default one and is persisted in a database table (WEBAPP.USER_ACTIVE_PROFILE) when the userApp access this portal webapp for the first time. This table acts as a userApp session store across all the other ERP modules.
3. The userApp can switch to any one of his profiles only from this application and not from any other modules. The application will change its UI accordingly (refresh the notifications and menu options) when the profile is switched and persists the new current active profile in the USER_ACTIVE_PROFILE table. 
4. Shows notifications from all the ERP modules with links to the corresponding module. There are 2 ways in which the notifications are produced: 
- In a deterministic way, on userApp request the application runs a set of database procedures which verifies the conditions for the notifications and inserts them in a database table from which the application reads them and ultimately displays them to the userApp (the legacy way of doing things); 
- On an event-driven way, the application simply reads the notifications from the database table and displays them to the userApp. The notifications are produced by the ERP modules and are inserted in the database table when the conditions for the notifications are met (the new way of doing things);
5. Shows the connected userApp all the ERP modules that are available for his current profile given that profile roles and privileges, grouped in the following navigation menu categories: 
      5.1. Introduction
      5.2. Search
      5.3. Statistics
      5.4. Administration
---
### Software design key principles for backend development
1. The application should follow a hexagonal architecture and is structured in a way that separates the core business logic from the presentation layer, making it easier to maintain and test.
2. The application should use DDD concepts when designing the domain model and the application services.
3. The application should use SOLID principles as much as possible throughout the codebase.
4. The application should have at least 80% code coverage for the unit tests and 100% code coverage for the integration tests.
---
### Software design key principles for frontend development
1. The application uses JTE (Java Template Engine) for server-side rendering of HTML templates.
2. The application uses HTMX to create a dynamic and responsive userApp interface.
3. The application uses Bootstrap 5 for styling and layout.
---
### Maven build profiles.
It has 4 profiles: 
- dev : default active profile (when using 'mvn spring-boot:run' cmd) - the app runs locally as a jar in spring's boot embedded Tomcat (the userApp is mocked from a configuration file)
- local: on this profile we build the project as a WAR for a locally installed WebLogic (without any sso integration, the userApp is mocked from a configuration file) and after that we copy the resulted war in the /autodeploy directory (used for developer testing of any possible WebLogic specific deploying issues regarding spring boot and any other dependencies)
- test: on this profile we build the project as a WAR for a remote installed WebLogic (with proper sso integration) and after that we copy the resulted war in the /autodeploy directory of the remote running weblogic instance domain (used by the QA team for testing the application in a production-like environment).
- prod: on this profile we build the project as a WAR for production with proper sso integration and after that we copy the resulted war in specific directory on the organization file server (used by the DevOps team for deploying the application in production environment).
---
### External dependency 
1. Oracle Database 23ai - it's a mandatory dependency - install it as a Docker container, following the guidelines provided here [oracle-23-ai-free](https://hub.docker.com/r/gvenzl/oracle-free)
2. WebLogic Server 14.1.2 - it's an optional dependency, only if you want to also build and test the 'local' profile - install it locally, following the guidelines provided here [weblogic-14.1.2-for-developers](https://docs.oracle.com/en/middleware/fusion-middleware/weblogic-server/14.1.2/wlsig/installing-weblogic-server-for-developers.html#WLSIG415) 
---

## How to RUN the project

Just follow this steps:
TODO
1. Step one
2. Step two...

### CLI Feature

Use this commands to build up a setup for testing the web-app. You basically need at least one userApp with the WEBAPP_ROLE and with at least one profile

---
#### User Management 
1. `create-user <username> <firstname> <lastname>` -> creates a new userApp
2. `create-profile <userId> <profileName>` -> creates a new profile for a certain userApp
3. `create-role <userId> <roleName>` -> creates a new rol for a certain userApp
---
#### Admin Commands
1. `system-info` -> shows info about the system
2. `app-help` -> guide for the CLI

#### Usage examples:

	   webapp-cli:> create-user john.doe John Doe
	   webapp-cli:> create-profile 1 First_Profile
	   webapp-cli:> create-role 1 WEBAPP_ROLE
	   webapp-cli:> system-info

