Proof of concept project with spring boot 2.7.18, java 17, server side rendering with JTE, HTMX and Bootstrap 5.

It has 3 profiles: 
- dev : default active profile (when using 'mvn sprinb-boot:run' cmd) - the app runs locally in spring's boot embedded Tomcat (used only for developers test)
- prod: on this profile we build the project in the same manner as we do for production and after that we copy the resulted war in the /autodeoply directory of the locally running weblogic instance domain (used only for developers test)
- remote-deploy: on this profile we build the project in the same manner as we do for production and after that we copy the resulted war in the /autodeoply directory of the remote running weblogic instance domain (used for integrated testing inside the organization)
