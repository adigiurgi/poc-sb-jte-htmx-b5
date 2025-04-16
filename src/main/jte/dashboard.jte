@import com.example.webapp.model.User
@import java.util.List
@import java.util.Map

@param String appName
@param String activeProfile
@param User currentUser
@param List<Map<String, String>> menuItems
@param String contextPath

<!DOCTYPE html>
<html lang="ro" data-bs-theme="light">
<head>    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${appName} - Dashboard</title>    
    <!-- Bootstrap 5 CSS -->
    @if (activeProfile == "dev") 
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.5.3.5.css">
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap-icons-1.11.3/font/bootstrap-icons.css">
    @else
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.5.3.5.min.css.gz">
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap-icons-1.11.3/font/bootstrap-icons.min.css.gz">
    @endif
    
    <!-- Custom styles -->
    <link rel="stylesheet" href="${contextPath}/css/custom/webapp.css">
    

</head>
<body>
    
    <!-- Header -->
    <header id="header" class="bg-body-tertiary d-flex align-items-center px-3">
        <div class="container-fluid">
            <div class="row w-100 align-items-center">
                <div class="col-3 d-flex align-items-center">                    <!-- Logo -->
                    <div class="me-2">
                        <img src="${contextPath}/static/logo_lion.png" alt="Logo" class="app-logo">
                    </div>
                </div>
                <div class="col-6 text-center">
                    <!-- App Title -->
                    <h4 class="mb-0 fw-semibold">${appName}</h4>
                </div>
                <div class="col-1">
                    <!-- Theme Toggle Button -->
                    <button id="theme-toggle" class="btn btn-sm btn-outline-secondary text-center" type="button" aria-label="Theme Toggle">
                        <i class="bi bi-sun-fill theme-icon-light"></i>
                        <i class="bi bi-moon-fill theme-icon-dark d-none"></i>
                    </button>
                </div>
                <div class="col-2 pull-right">                    
                    <!-- User Info -->
                    <div class="dropdown d-inline-block">
                        <button class="btn btn-outline-secondary dropdown-toggle text-center" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <span class="d-inline-block text-truncate user-info">${currentUser.getFullName()}</span>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><span class="dropdown-item-text">${currentUser.getRole()}</span></li>
                            <li><span class="dropdown-item-text">${currentUser.getEmail()}</span></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Profil</a></li>
                            <li><a class="dropdown-item" href="#">Deconectare</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content Container -->
    <div class="main-container">
        <!-- Sidebar Navigation -->
        <nav id="sidebar" class="bg-body-secondary">
            <div class="list-group list-group-flush pt-2">                @for(var item : menuItems)
                    <a href="#${item.get("id")}" 
                       class="list-group-item list-group-item-action nav-link d-flex align-items-center" 
                       hx-get="${contextPath}${item.get("link")}" 
                       hx-target="#content-area" 
                       hx-swap="innerHTML" 
                       hx-trigger="click">
                        <i class="bi bi-${item.get("icon")} me-2"></i>
                        ${item.get("name")}
                    <!-- Indicatori de încărcare pentru HTMX -->
                    <!-- <div class="my-indicator"></div> -->
                    <div class="my-indicator-overlay"></div>    
                    </a>
                @endfor
                
            </div>
        </nav>

        <!-- Content Area -->
        <main id="content" class="bg-body-tertiary">
            <!-- Loading Indicator -->
            <!-- <div id="loading-indicator" class="hx-loading-indicator">
                <div class="spinner-border text-primary" role="status">
                    <span class="visually-hidden">Se încarcă...</span>
                </div>
            </div> -->
            
            <!-- Error container for HTMX errors -->
            <div id="error-container" class="alert alert-danger d-none" role="alert">
                <h4 class="alert-heading">A apărut o eroare!</h4>
                <div id="error-content"></div>
                <hr>
                <div class="mt-2">
                    <button type="button" class="btn btn-sm btn-outline-danger" onclick="document.getElementById('error-container').classList.add('d-none')">
                        Închide
                    </button>
                    <button id="show-details-btn" type="button" class="btn btn-sm btn-outline-secondary ms-2 d-none" 
                            data-bs-toggle="collapse" data-bs-target="#error-details-collapse">
                        Afișează detalii
                    </button>
                </div>
                <div class="collapse mt-3" id="error-details-collapse">
                    <div class="card card-body">
                        <small class="text-muted" id="error-details"></small>
                    </div>
                </div>
            </div>
            
            <div id="content-area" class="h-100">
                <!-- Initial content on page load -->
                <div class="text-center py-5">
                    <h3>Bine ați venit la panoul de administrare</h3>
                    <p class="text-muted">Selectați o opțiune din meniul lateral pentru a începe.</p>
                </div>
            </div>
        </main>
    </div>

    <!-- Footer -->
    <footer id="footer" class="bg-body-secondary d-flex align-items-center px-3">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 text-center">
                    <small class="text-muted">© 2025 ${appName} | Profil activ: ${activeProfile}</small>
                </div>
            </div>
        </div>    </footer>    
    
    <!-- Bootstrap 5 & htmx JS -->
    @if (activeProfile == "dev") 
        <script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.5.3.5.js"></script>
        <script src="${contextPath}/js/vendor/htmx/htmx.2.0.4.js"></script> 
    @else
        <script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.min.5.3.5.js.gz"></script>
        <script src="${contextPath}/js/vendor/htmx/htmx.min.2.0.4.js.gz"></script>
    @endif    
    
    <script>
        // Activează tooltip-urile Bootstrap și inițializează tema
        document.addEventListener('DOMContentLoaded', function() {
            var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
            var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
                return new bootstrap.Tooltip(tooltipTriggerEl);
            });
            
            // Activează primul element din meniu la încărcarea paginii
            const firstMenuItem = document.querySelector('#sidebar .nav-link');
            if (firstMenuItem) {
                firstMenuItem.click();
            }
            
            // Inițializează tema în funcție de preferința salvată
            initializeTheme();
        });
        
        // Adaugă clasa active pentru elementul de meniu selectat
        document.addEventListener('click', function(event) {
            if (event.target.closest('#sidebar .nav-link')) {
                const navLinks = document.querySelectorAll('#sidebar .nav-link');
                navLinks.forEach(link => link.classList.remove('active'));
                event.target.closest('#sidebar .nav-link').classList.add('active');
            }
        });
        
        // Funcționalitate pentru comutarea între modurile light și dark
        document.getElementById('theme-toggle').addEventListener('click', function() {
            const htmlElement = document.documentElement;
            const isCurrentlyDark = htmlElement.getAttribute('data-bs-theme') === 'dark';
            const newTheme = isCurrentlyDark ? 'light' : 'dark';
            
            // Schimbă tema
            htmlElement.setAttribute('data-bs-theme', newTheme);
            
            // Salvează preferința în localStorage
            localStorage.setItem('theme-preference', newTheme);
            
            // Actualizează iconița butonului
            updateThemeIcon(newTheme);
        });
        
        // Funcție pentru inițializarea temei în funcție de preferința salvată
        function initializeTheme() {
            const savedTheme = localStorage.getItem('theme-preference');
            const prefersDarkScheme = window.matchMedia('(prefers-color-scheme: dark)').matches;
            
            // Dacă există o preferință salvată, folosește-o, altfel folosește preferința sistemului
            const theme = savedTheme || (prefersDarkScheme ? 'dark' : 'light');
            
            // Aplică tema
            document.documentElement.setAttribute('data-bs-theme', theme);
            
            // Actualizează iconița butonului
            updateThemeIcon(theme);
        }
        
        // Funcție pentru actualizarea iconiței butonului în funcție de temă
        function updateThemeIcon(theme) {
            const lightIcon = document.querySelector('.theme-icon-light');
            const darkIcon = document.querySelector('.theme-icon-dark');
            
            if (theme === 'dark') {
                lightIcon.classList.add('d-none');
                darkIcon.classList.remove('d-none');
            } else {
                lightIcon.classList.remove('d-none');
                darkIcon.classList.add('d-none');
            }
        }
        
        // Handler global pentru erorile HTMX
        
        document.body.addEventListener('htmx:responseError', function(event) {
            const errorContainer = document.getElementById('error-container');
            const errorContent = document.getElementById('error-content');
            const errorDetails = document.getElementById('error-details');
            const showDetailsBtn = document.getElementById('show-details-btn');
            
            const xhr = event.detail.xhr;
            const requestPath = event.detail.pathInfo ? event.detail.pathInfo.requestPath : '';
            
            // Extrage conținutul paginii de eroare din răspuns
            let errorHTML = xhr.responseText;
            let errorMessage = 'A apărut o eroare la procesarea cererii.';
            let errorTrace = '';
            
            try {
                // Extrage titlul și descrierea erorii
                const tempDiv = document.createElement('div');
                tempDiv.innerHTML = errorHTML;
                
                // Caută mesajul de eroare în HTML
                const leadParas = tempDiv.querySelectorAll('.lead');
                if (leadParas.length > 0) {
                    errorMessage = leadParas[0].textContent;
                }
                
                // Caută stack trace-ul dacă există
                const traceElements = tempDiv.querySelectorAll('pre');
                if (traceElements.length > 0) {
                    errorTrace = traceElements[0].textContent;
                    showDetailsBtn.classList.remove('d-none');
                } else {
                    showDetailsBtn.classList.add('d-none');
                }
                
                // Setează conținutul de eroare
                errorContent.innerHTML = '<p>' + errorMessage + '</p>' +
                    '<p><strong>URL:</strong> ' + requestPath + '</p>';
                errorDetails.textContent = errorTrace;
                
            } catch (e) {
                // Fallback dacă parsarea eșuează
                errorContent.textContent = 'Eroare la încărcarea conținutului: ' + requestPath;
                showDetailsBtn.classList.add('d-none');
            }
            
            // Arată containerul de eroare
            errorContainer.classList.remove('d-none');
            
            // Scrollează la containerul de eroare
            errorContainer.scrollIntoView({ behavior: 'smooth' });
        });
    </script>
</body>
</html>