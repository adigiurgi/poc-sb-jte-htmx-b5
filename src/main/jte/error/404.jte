@param String contextPath
@param String path = ""
@param String error = ""
@param String message = "Page not found"
@param String timestamp = ""

<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Pagină negăsită</title>
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/custom/webapp.css">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .error-container {
            text-align: center;
            padding: 2rem;
            border-radius: 0.5rem;
            background-color: white;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
            max-width: 600px;
        }
        .error-code {
            font-size: 5rem;
            font-weight: bold;
            color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-container">
            <div class="error-code">404</div>
            <h1 class="mt-3">Pagină negăsită</h1>
            <p class="lead">Ne pare rău, dar pagina pe care încercați să o accesați nu există.</p>
            <p>URL solicitat: ${path}</p>
            <hr>
            <a href="${contextPath}/" class="btn btn-primary">Înapoi la pagina principală</a>
        </div>
    </div>

    <script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>