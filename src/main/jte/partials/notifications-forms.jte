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
    </div>

    <div class="alert alert-info alert-dismissible fade show d-none" role="alert">
        <strong>Felicitări!</strong> Nu aveți nici un mesaj nerezolvat!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

    <div style="grid-template-columns: 1fr 1fr 1fr 1fr;" class="d-grid gap-3 mb-3" id="cardsContainer">

        <div class="card text-center">
            <h5 class="card-header">MODUL-A</h5>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="#notifications-forms-details"
                   class="btn btn-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="bottom"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   hx-get="${contextPath}/partials/notifications-forms-details"
                   hx-target="#content-area"
                   hx-swap="innerHTML"
                   hx-trigger="click">
                    Acceseaza detalii mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">14</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-B</h5>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="#notifications-forms-details"
                   class="btn btn-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="bottom"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   hx-get="${contextPath}/partials/notifications-forms-details"
                   hx-target="#content-area"
                   hx-swap="innerHTML"
                   hx-trigger="click">
                    Acceseaza detalii mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">14</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-C</h5>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="#notifications-forms-details"
                   class="btn btn-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="bottom"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   hx-get="${contextPath}/partials/notifications-forms-details"
                   hx-target="#content-area"
                   hx-swap="innerHTML"
                   hx-trigger="click">
                    Acceseaza detalii mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">14</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-D</h5>
            <div class="card-body">
                <p class="card-text"></p>
                <a href="#notifications-forms-details"
                   class="btn btn-info position-relative mx-3"
                   data-bs-toggle="tooltip"
                   data-bs-placement="bottom"
                   data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
                   hx-get="${contextPath}/partials/notifications-forms-details"
                   hx-target="#content-area"
                   hx-swap="innerHTML"
                   hx-trigger="click">
                    Acceseaza detalii mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">14</span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>

    </div>

</div>

<!-- Script inline pentru filtrarea cardurilor - execută imediat fără a aștepte DOMContentLoaded -->
<script src="${contextPath}/js/custom/partials/common/filterCardsByCardHeaderText.js"></script>
