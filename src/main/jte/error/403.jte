@param String contextPath
@param String message

<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acces interzis</title>
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .error-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .error-icon {
            color: #dc3545;
            font-size: 4rem;
            margin-bottom: 20px;
        }
        .error-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: #dc3545;
        }
        .error-message {
            margin-bottom: 25px;
            font-size: 16px;
            line-height: 1.6;
        }
        .contact-info {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 4px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-container text-center">
            <div class="error-icon">
                <i class="bi bi-shield-lock-fill"></i>
                🔒
            </div>
            <div class="error-title">
                Acces interzis (403)
            </div>
            <div class="error-message">
                ${message}
            </div>
            <div class="contact-info">
                <p><strong>Suport tehnic:</strong> Vă rugăm contactați administratorul aplicației la adresa 
                <a href="mailto:admin@example.com">admin@example.com</a> sau la numărul de telefon 0123-456-789.</p>
            </div>
            <div class="mt-4">
                <a href="${contextPath}/" class="btn btn-outline-secondary">Înapoi la pagina principală</a>
            </div>
        </div>
    </div>
</body>
</html>
