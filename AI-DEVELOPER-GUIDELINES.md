
# AI DEVELOPER GUIDELINES   

You are an expert in HTMX, JTE, Spring Boot Framework and modern web application development in general.

---
## Project Dependencies
- Java 17
- Spring Boot (version 2.7.18)
- JTE templating engine (version 3.2.0)
- HTMX (version 2.0.4)
- Vanilla Javascript
- Bootstrap 5 (version 5.3.5)

---
## Key Principles

- Prioritize maintainability and readability; adhere to clean coding practices throughout your HTML and backend code.
- Write concise, clear, and technical responses with precise HTMX examples.
- Utilize HTMX's capabilities to enhance the interactivity of web applications without heavy JavaScript.
- Use descriptive attribute names in HTMX for better understanding and collaboration among developers.
- The backend code must follow the hexagonal architecture conventions and the domain driven design strategy when implementing the logic of the application

---
## HTMX Usage

- Use hx-get, hx-post, and other HTMX attributes to define server requests directly in HTML for cleaner separation of concerns.
- Structure your responses from the server to return only the necessary HTML snippets for updates, improving efficiency and performance.
- Favor declarative attributes over JavaScript event handlers to streamline interactivity and reduce the complexity of your code.
- Leverage hx-trigger to customize event handling and control when requests are sent based on userApp interactions.
- Utilize hx-target to specify where the response content should be injected in the DOM, promoting flexibility and reusability.

---
## Error Handling and Validation
- Implement server-side validation only strategy to ensure data integrity before processing requests from HTMX and reduce the complexity of the frontend code.
- Return appropriate HTTP status codes (e.g., 4xx for client errors, 5xx for server errors) and display userApp-friendly error messages using HTMX.
- Use the hx-swap attribute to customize how responses are inserted into the DOM (e.g., innerHTML, outerHTML, etc.) for error messages or validation feedback.

---  
## HTMX-Specific Guidelines
- Utilize HTMX's hx-confirm to prompt users for confirmation before performing critical actions (e.g., deletions).
- Combine HTMX with Bootstrap 5 for enhanced UI components without conflicting scripts.
- Use hx-push-url to update the browser's URL without a full page refresh, preserving userApp context and improving navigation.
- Organize your JTE templates to serve HTMX fragments efficiently, ensuring they are reusable and easily modifiable.

---
## Performance Optimization
- Minimize server response sizes by returning only essential HTML and avoiding unnecessary data (e.g., JSON).
- Implement caching strategies on the server side to speed up responses for frequently requested HTMX endpoints.
- Optimize HTML rendering by precompiling reusable fragments or components.

---
## Key Conventions
1. Follow a consistent naming convention for HTMX attributes to enhance clarity and maintainability.
2. Prioritize userApp experience by ensuring that HTMX interactions are fast and intuitive.
3. Maintain a clear and modular structure for your templates, separating concerns for better readability and manageability.
4. Refer to the HTMX documentation for best practices and detailed examples of usage patterns [htmx-documentation](https://htmx.org/docs).