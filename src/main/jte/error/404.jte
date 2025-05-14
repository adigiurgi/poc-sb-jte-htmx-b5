@param String contextPath
@param String path = ""
@param String error = ""
@param String message = "Pagina nu a fost găsită"
@param String timestamp = ""

<!DOCTYPE html>
<html lang="ro" data-bs-theme="auto">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Pagină negăsită</title>
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.min-5.3.5.css">
    <link rel="stylesheet" href="${contextPath}/css/custom/webapp.css">
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/icons/bootstrap-icons.min-1.11.3.css">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: var(--bs-body-bg);
        }
        .error-container {
            text-align: center;
            padding: 2rem;
            border-radius: 0.5rem;
            background-color: var(--bs-body-bg);
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
            max-width: 600px;
        }
        .error-code {
            font-size: 5rem;
            font-weight: bold;
            color: var(--bs-danger);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-container">
            <div class="error-code">404</div>
            <h1 class="mt-3">Pagină negăsită</h1>
            <p class="lead">Ne pare rău, dar pagina pe care încercați să o accesați nu există.</p>
            <div class="details mt-4 mb-3">
                <p><strong>URL solicitat:</strong> ${path}</p>
                @if(!timestamp.isEmpty())
                    <p><strong>Timestamp:</strong> ${timestamp}</p>
                @endif
            </div>
            <hr>
            <a href="${contextPath}/" class="btn btn-primary">Înapoi la pagina principală</a>
        </div>
    </div>    <script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.min-5.3.5.js"></script>
    <script src="${contextPath}/js/custom/general/svgLoaderThemeHandler.js"></script>
    <script>
        // Detectează tema curentă și aplică-o la încărcare
        document.addEventListener('DOMContentLoaded', function() {
            const savedTheme = localStorage.getItem('theme-preference');
            const prefersDarkScheme = window.matchMedia('(prefers-color-scheme: dark)').matches;
            const theme = savedTheme || (prefersDarkScheme ? 'dark' : 'light');
            document.documentElement.setAttribute('data-bs-theme', theme);
            
            // Actualizează vizibilitatea SVG loaderelor
            if (typeof updateSvgLoaderVisibility === 'function') {
                updateSvgLoaderVisibility(theme);
            }
        });
    </script>
</body>
</html>