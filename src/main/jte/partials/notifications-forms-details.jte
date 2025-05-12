@import com.example.webapp.infrastructure.config.security.profile.UserActiveProfileProvider
@import com.example.webapp.application.dto.query.UserProfileDto
@import java.util.List

@param String appName
@param String appDescription
@param String appDeveloperShort
@param String appDeveloperLong
@param String activeAppProfile
@param UserActiveProfileProvider currentUserProfile

@param String contextPath
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
                <a href="#" class="form-label p-2 mb-0" data-bs-toggle="tooltip" data-bs-placement="bottom"
                   data-bs-title="Cont - Nume Profil">Profil activ: &nbsp;</a>
                <div class="dropdown d-inline-block">
                    <button class="btn btn-outline-secondary dropdown-toggle text-center" type="button"
                            data-bs-toggle="dropdown" aria-expanded="false" disabled>
                        <span class="d-inline-block text-truncate userApp-info">${currentUserProfile.getAuthenticatedUser()} - ${currentUserProfile.getProfileName()}/66/D3/S10/B2</span>
                    </button>
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

<div class="container-fluid my-4">
    <div class="row">
        <div class="col-12">

            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <div>
                        <h5 class="mb-0">Notificări active</h5>
                    </div>
                    <button type="button" class="btn btn-sm btn-outline-secondary ms-2">
                        Actualizeaza Modul A
                        <i class="bi bi-arrow-clockwise"></i>
                    </button>
                    <div>
                        <small class="text-muted">Durata actualizare: 53 secunde</small>
                        <div class="vr"></div>
                        <small class="text-muted">Ultima actualizare: 07.05.2025 11:08</small>
                    </div>
                </div>
                <div class="card-body">

                    <!-- Notificări de flux -->
                    <div class="notification-group mb-4">
                        <h6 class="text-muted mb-3">Flux</h6>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow">
                            <div class="d-flex">
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <p class="fw-bold mb-1">Aveti 7 entitati aferente modulului [nume-modul] fara gata de avizat !</p>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow mt-3">
                            <div class="d-flex">
                                <div class="notification-icon bg-danger text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-envelope-exclamation-fill"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1 text-body-danger text-decoration-underline fs-5">Aveti de avizat 12 entitati aferente modulului [nume-modul] !</h6>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item flow mt-3">
                            <div class="d-flex">
                                <div class="notification-icon bg-danger text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-radioactive"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1 badge text-bg-warning fs-5">Aveti 12 notificari extrem de importante de rezolvat aferente modulului [nume-modul] !</h6>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Notificări informative -->
                    <div class="notification-group">
                        <h6 class="text-muted mb-3">Informative</h6>

                        <div class="notification-item informative">
                            <div class="d-flex">
                                <div class="notification-icon bg-info text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-info-circle"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1">Aveti 24 de entitati aferente modulului [nume-modul] pe care ati fost pus beneficiar !</h6>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                    <button class="btn btn-sm btn-light mt-1" data-id="1"
                                            data-bs-toggle="tooltip"
                                            data-bs-placement="right"
                                            data-bs-title="Notificarile vor fi sterse">
                                        <i class="bi bi-trash3-fill"></i> Nu ma intereseaza
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="notification-item informative mt-3">
                            <div class="d-flex">
                                <div class="notification-icon bg-info text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-info-circle"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1">Aveti 24 de entitati aferente modulului [nume-modul] pe care ati fost pus beneficiar !</h6>
                                        <a class="icon-link icon-link-hover fw-medium fs-5" style="--bs-link-hover-color-rgb: 25, 135, 84;" href="#">
                                            Acceseaza modul
                                            <svg xmlns="http://www.w3.org/2000/svg" class="bi" viewBox="0 0 16 16" aria-hidden="true">
                                                <path d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                                            </svg>
                                        </a>
                                    </div>
                                    <button class="btn btn-sm btn-light mt-1" data-id="1"
                                            data-bs-toggle="tooltip"
                                            data-bs-placement="right"
                                            data-bs-title="Notificarile vor fi sterse">
                                        <i class="bi bi-trash3-fill"></i> Nu ma intereseaza
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .notification-item {
        padding: 15px;
        border-radius: 8px;
        background-color: var(--bs-body-bg);
        border: 1px solid var(--bs-border-color);
    }

    .notification-item.flow {
        background-color: rgba(13, 110, 253, 0.05);
        border-left: 3px solid var(--bs-danger);
    }

    .notification-item.informative {
        background-color: rgba(13, 110, 253, 0.05);
        border-left: 3px solid var(--bs-info);
    }

    .notification-icon {
        width: 40px;
        height: 40px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .notification-group {
        position: relative;
    }

    .notification-group h6 {
        font-weight: 600;
    }

    /* Responsive adjustments */
    @media (max-width: 768px) {
        .notification-item .d-flex {
            flex-direction: column;
        }

        .notification-icon {
            margin-bottom: 10px;
        }
    }
</style>

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


