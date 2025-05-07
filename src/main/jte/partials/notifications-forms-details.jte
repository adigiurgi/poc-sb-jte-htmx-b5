@param String contextPath

<div class="container-fluid my-4">
    <div class="row">
        <div class="col-12">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="#notifications-forms"
                                                   hx-get="${contextPath}/partials/notifications-forms"
                                                   hx-target="#content-area"
                                                   hx-swap="innerHTML"
                                                   hx-trigger="click">Toate notificarile</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Notificari Modul-A</li>
                </ol>
            </nav>

            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <div>
                        <h5 class="mb-0">Notificări active</h5>
                    </div>
                    <div>
                        <small class="text-muted">Acum 2 ore/minute/secunde</small>
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

