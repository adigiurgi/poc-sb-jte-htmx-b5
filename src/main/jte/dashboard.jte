@import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider
@import com.example.webapp.application.dto.query.UserProfileDto
@import java.util.List
@import java.util.Map

@param String appName
@param String appDescription
@param String appDeveloperShort
@param String appDeveloperLong
@param String activeAppProfile
@param UserActiveProfileProvider currentUserProfile
@param List<UserProfileDto> userProfileNotActiveList

@param List<Map<String, String>> menuItems
@param String contextPath
@param String usernameFromDatabaseContext
@param String appVersion

<!DOCTYPE html>
<!--suppress HtmlUnknownTarget -->
<html lang="ro" data-bs-theme="light">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="${contextPath}/static/logo/app-logo.ico" type="image/x-icon">
    <title>${appName} - SFINX</title>
    <!-- Bootstrap 5 CSS -->
    @if (activeAppProfile.equals("dev"))
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.5.3.5.css">
        <link rel="stylesheet"
              href="${contextPath}/css/vendor/bootstrap/bootstrap-icons-1.11.3/font/bootstrap-icons.css">
    @else
        <link rel="stylesheet" href="${contextPath}/css/vendor/bootstrap/bootstrap.5.3.5.min.css.gz">
        <link rel="stylesheet"
              href="${contextPath}/css/vendor/bootstrap/bootstrap-icons-1.11.3/font/bootstrap-icons.min.css.gz">
    @endif

    <!-- Custom styles -->
    <link rel="stylesheet" href="${contextPath}/css/custom/webapp.css">

</head>
<body>

<!-- Header -->
<header id="header" class="bg-body-tertiary d-flex align-items-center px-3">
    <div class="container-fluid">
        <div class="row w-100 align-items-center">
            <div class="col-2 d-flex align-items-center">
                <!-- Logo -->
                <div class="me-2">
                    <img src="${contextPath}/static/logo/app-logo-light.svg" alt="Logo"
                         class="app-logo theme-logo-light">
                    <img src="${contextPath}/static/logo/app-logo-dark.svg" alt="Logo"
                         class="app-logo theme-logo-dark d-none">
                </div>
                <div>
                    <h2 class="app-name mb-0 fw-semibold">${appName}</h2>
                </div>
            </div>
            <div class="col-6 text-center">
                <!-- App Title -->
                <h4 class="mb-0 fw-semibold">${appDescription}</h4>
            </div>

            <div class="col-3 align-items-end d-flex justify-content-end">
                <!-- User Info -->
                <a href="#" class="form-label p-2 mb-0"
                   data-bs-toggle="tooltip"
                   data-bs-placement="bottom"
                   data-bs-title="Cont - Nume Profil">Profil activ:
                    <i class="bi bi-person-circle"></i>
                </a>
                <div class="dropdown d-inline-block"
                     data-bs-toggle="tooltip"
                     data-bs-placement="right"
                     data-bs-title="Schimba profil">
                    <button class="btn btn-outline-secondary dropdown-toggle text-center" type="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="d-inline-block text-truncate">${currentUserProfile.getAuthenticatedUser()} - ${currentUserProfile.getProfileName()}/66/D3/S10/B2</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end">
                        @for(var profile : userProfileNotActiveList)
                            <li>
                                <span class="dropdown-item-text">
                                    <i class="bi bi-person"></i>
                                    ${profile.profileName()}/66/D3/S10/B1
                                </span>
                            </li>
                        @endfor
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="bi bi-person-fill-gear"></i>
                                Configurare preferinte cont
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-1 align-items-end d-flex justify-content-end">
                <!-- Theme Toggle Button -->
                <button id="theme-toggle" class="btn btn-sm btn-outline-secondary text-center" type="button"
                        aria-label="Theme Toggle">
                    <i class="bi bi-sun-fill theme-toggle-light"></i>
                    <i class="bi bi-moon-fill theme-toggle-dark d-none"></i>
                </button>
            </div>

        </div>
    </div>
</header>

<!-- Main Content Container -->
<div class="main-container">
    <!-- Sidebar Navigation -->
    <nav id="sidebar" class="bg-body-secondary">
        <div class="list-group list-group-flush pt-2">
            @for(var item : menuItems)
                <a href="#${item.get("id")}"
                   class="list-group-item list-group-item-action nav-link d-flex align-items-center"
                   hx-get="${contextPath}${item.get("link")}"
                   hx-target="#content-area"
                   hx-swap="innerHTML"
                   hx-trigger="click">
                    <i class="bi bi-${item.get("icon")} me-2"></i>
                    ${item.get("name")}
                    @if(item.get("id").equals("notifications-forms"))
                        <span class="badge text-bg-danger ms-2">forms</span>
                    @elseif(item.get("id").equals("notifications-web"))
                        <span class="badge text-bg-warning ms-2">web</span>
                        <span class="badge rounded-pill bg-primary ms-3">489</span>
                    @endif
                    <div class="my-indicator-overlay"></div>
                </a>
            @endfor
        </div>

        <!-- Help Guide Navigation - Static Bottom Item -->
        <div class="help-guide-nav">
            <a href="#user-guide"
               class="list-group-item list-group-item-action nav-link d-flex align-items-center"
               hx-get="${contextPath}/partials/user-guide"
               hx-target="#content-area"
               hx-swap="innerHTML"
               hx-trigger="click">
                <i class="bi bi-question-circle me-2"></i>
                Ghid de utilizare
                <div class="my-indicator-overlay"></div>
            </a>
        </div>
    </nav>

    <!-- Content Area -->
    <main id="content" class="bg-body-tertiary pb-5">
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
                <button type="button" class="btn btn-sm btn-outline-danger"
                        onclick="document.getElementById('error-container').classList.add('d-none')">
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
</div>    <!-- Footer -->
<footer id="footer" class="bg-body-secondary d-flex align-items-center px-3 fixed-bottom">
    <div class="container-fluid">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8 text-center">
                <%--                    <small class="text-muted">© <span id="current-year"></span> ${appName} | Profil activ: ${activeAppProfile}</small>--%>
                <small class="text-muted">© <span id="current-year"></span> | ${appDeveloperShort} |</small>
                <div class="d-inline-block">
                    <img src="${contextPath}/static/logo/developer-logo.svg" alt="Logo-Footer" width="15" height="15">
                </div>
                <small class="text-muted"> | ${appDeveloperLong} |</small>
            </div>
            <div class="col-2 text-center">
                <small class="text-muted">
                    <a href="#changelog"
                       hx-get="${contextPath}/partials/changelog"
                       hx-target="#content-area"
                       hx-swap="innerHTML"
                       hx-trigger="click">versiune ${appVersion} </a>
                </small>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap 5 & htmx JS -->
@if (activeAppProfile.equals("dev"))
<script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.5.3.5.js"></script>
<script src="${contextPath}/js/vendor/htmx/htmx.2.0.4.js"></script>
@else
<script src="${contextPath}/js/vendor/bootstrap/bootstrap.bundle.min.5.3.5.js.gz"></script>
<script src="${contextPath}/js/vendor/htmx/htmx.min.2.0.4.js.gz"></script>
@endif
<script src="${contextPath}/js/custom/general/tooltipInitialisation.js"></script>
<script src="${contextPath}/js/custom/general/domLoad.js"></script>
<script src="${contextPath}/js/custom/general/onAnyPartialSwap.js"></script>
<script src="${contextPath}/js/custom/general/navBarActivation.js"></script>
<script src="${contextPath}/js/custom/general/themeToggling.js"></script>
<script src="${contextPath}/js/custom/general/themeInitialisation.js"></script>
<script src="${contextPath}/js/custom/general/globalErrorHandling.js"></script>
</body>
</html>