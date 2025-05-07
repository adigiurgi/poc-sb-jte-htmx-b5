@param String contextPath

<!-- Partial pentru Notificări -->
<div class="container-fluid py-3">
    <h2 class="mb-4">Notificari Web</h2>

    <!-- Adăugare câmp de căutare pentru filtrare -->
    <div class="row mb-4">
        <div class="col-md-6">
            <div class="input-group">
                <span class="input-group-text"><i class="bi bi-search"></i></span>
                <input type="text" id="cardSearchInput" class="form-control" placeholder="Caută după numele modulului...">
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
                <p class="card-text"> </p>
                <a href="#" class="btn btn-info position-relative mx-3" data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Accesati pentru mai multe detalii">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    14
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-warning position-relative mx-3" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-title="Accesati pentru mai multe detalii">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    +99
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-B</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    7
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-warning position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    23
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-C</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    17
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-D</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-warning">
                    41
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    3
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-E</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    4
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-F</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    37
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    6
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-G</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    14
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-H</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    7
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    23
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-I</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    17
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-J</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    41
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    3
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-K</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    4
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-L</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    14
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-M</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    7
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    23
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-N</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    17
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-O</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    41
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    3
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-P</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    4
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-R</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    14
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-S</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    7
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    23
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-T</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    17
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-U</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    41
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    3
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-V</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    4
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-W</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    14
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-X</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    7
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    23
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 3 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-Y</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    17
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 14 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-Z</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    41
                    </span>
                </a>
                <div class="vr"></div>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje flux
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    3
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 5 secunde
            </div>
        </div>
        <div class="card text-center">
            <h5 class="card-header">MODUL-AA</h5>
            <div class="card-body">
                <p class="card-text"> </p>
                <a href="#" class="btn btn-outline-info position-relative mx-3">
                    Mesaje informative
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-info">
                    4
                    </span>
                </a>
            </div>
            <div class="card-footer text-body-secondary">
                Durata actualizare: 53 secunde
            </div>
        </div>


    </div>

</div>

<!-- Script inline pentru filtrarea cardurilor - execută imediat fără a aștepte DOMContentLoaded -->
<script src="${contextPath}/js/custom/partials/common/filterCardsByCardHeaderText.js"></script>
