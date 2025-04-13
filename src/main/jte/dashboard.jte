@import com.example.webapp.model.User
@import java.util.List
@import java.util.Map

@param String appName
@param String activeProfile
@param User currentUser
@param List<Map<String, String>> menuItems
@param String contextPath

<!DOCTYPE html>
<html lang="ro">
<head>    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${appName} - Dashboard</title>    <!-- Bootstrap 5 CSS -->
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.min-5.3.5.css">
    
    <!-- Custom styles -->
    <link rel="stylesheet" href="${contextPath}/css/custom/webapp.css">
    <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/icons/bootstrap-icons.min-1.11.3.css">

</head>
<body>
    <!-- Header -->
    <header id="header" class="bg-body-tertiary d-flex align-items-center px-3">
        <div class="container-fluid">
            <div class="row w-100 align-items-center">
                <div class="col-3 d-flex align-items-center">                    <!-- Logo -->
                    <div class="me-2">
                        <img src="${contextPath}/static/4636.jpg" alt="Logo" class="app-logo">
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
                    <a href="#${item.get("id")}" class="list-group-item list-group-item-action nav-link d-flex align-items-center" hx-get="${contextPath}${item.get("link")}" hx-target="#content-area" hx-swap="innerHTML" hx-trigger="click">
                        <i class="bi bi-${item.get("icon")} me-2"></i>
                        ${item.get("name")}
                    </a>
                @endfor
            </div>
        </nav>

        <!-- Content Area -->
        <main id="content" class="bg-body-tertiary">
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
        </div>    </footer>    <!-- Bootstrap 5 & htmx JS -->
    <script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.min-5.3.5.js"></script>
    <script src="${contextPath}/js/vendor/htmx/htmx.min-2.0.4.js"></script>
    <!-- Bootstrap Icons -->
    
    
    <script>
        // Activează tooltip-urile Bootstrap
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
    </script>
</body>
</html>