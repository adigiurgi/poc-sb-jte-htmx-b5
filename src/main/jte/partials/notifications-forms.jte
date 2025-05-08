@param String contextPath

<!-- Partial pentru Notificări -->
<div class="container-fluid py-3">
        <h2 class="mb-4">Notificari Forms</h2>

    <!-- Adăugare câmp de căutare pentru filtrare -->
    <div class="row mb-4">
        <div class="col-md-6">
            <div class="input-group">
                <span class="input-group-text"><i class="bi bi-search"></i></span>
                <input type="text" id="cardSearchInput" class="form-control"
                       placeholder="Caută după numele modulului...">
                <button class="btn btn-outline-secondary" type="button" id="clearSearch">Șterge</button>
            </div>
            <div id="searchInfo" class="mt-2 small text-muted">
                <span id="searchResultCount"></span>
            </div>
        </div>
        <div class="col-md-6">
            <button type="button" class="btn btn-outline-light">
                Actualizeaza tot
                <i class="bi bi-arrow-clockwise"></i>
            </button>
        </div>

    </div>

    <div class="alert alert-info alert-dismissible fade show d-none" role="alert">
        <strong>Felicitări!</strong> Nu aveți nici un mesaj nerezolvat!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

    <div style="grid-template-columns: 1fr 1fr 1fr 1fr;" class="d-grid gap-3 mb-3" id="cardsContainer">

        <div class="card text-center">
            <div class="card-header d-flex justify-content-between">
                <h5>MODUL-A</h5>
                <button type="button" class="btn btn-sm btn-outline-secondary">
                    <i class="bi bi-arrow-clockwise"></i>
                </button>
            </div>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="${contextPath}/partials/notifications-forms-details"
                   id="a"
                   class="btn btn-outline-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="left"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   target="_blank"
                   rel="noopener">
                    Acceseaza detalii notificari
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">4</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
                <div class="vr"></div>
                Data actualizare: 07.05.2025 16:40
            </div>
        </div>
        <div class="card text-center">
            <div class="card-header d-flex justify-content-between">
                <h5>MODUL-B</h5>
                <button type="button" class="btn btn-sm btn-outline-secondary">
                    <i class="bi bi-arrow-clockwise"></i>
                </button>
            </div>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="${contextPath}/partials/notifications-forms-details"
                   id="b"
                   class="btn btn-outline-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="left"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   target="_blank"
                   rel="noopener">
                    Acceseaza detalii notificari
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">12</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
                <div class="vr"></div>
                Data actualizare: 07.05.2025 16:40
            </div>
        </div>
        <div class="card text-center">
            <div class="card-header d-flex justify-content-between">
                <h5>MODUL-C</h5>
                <button type="button" class="btn btn-sm btn-outline-secondary">
                    <i class="bi bi-arrow-clockwise"></i>
                </button>
            </div>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="${contextPath}/partials/notifications-forms-details"
                   id="c"
                   class="btn btn-outline-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="left"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   target="_blank"
                   rel="noopener">
                    Acceseaza detalii notificari
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">5</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
                <div class="vr"></div>
                Data actualizare: 07.05.2025 16:40
            </div>
        </div>
        <div class="card text-center">
            <div class="card-header d-flex justify-content-between">
                <h5>MODUL-D</h5>
                <button type="button" class="btn btn-sm btn-outline-secondary">
                    <i class="bi bi-arrow-clockwise"></i>
                </button>
            </div>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="${contextPath}/partials/notifications-forms-details"
                   class="btn btn-outline-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="left"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   target="_blank"
                   rel="noopener">
                    Acceseaza detalii notificari
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">9</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
                <div class="vr"></div>
                Data actualizare: 07.05.2025 16:40
            </div>
        </div>

    </div>

</div>

<!-- Script inline pentru filtrarea cardurilor - execută imediat fără a aștepte DOMContentLoaded -->
<script src="${contextPath}/js/custom/partials/common/filterCardsByCardHeaderText.js"></script>
