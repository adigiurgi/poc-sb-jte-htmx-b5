@param String contextPath

<!-- Partial pentru Notificări -->
<div class="container-fluid py-3">
    <h2 class="mb-4">Notificări</h2>
    
    <div class="alert alert-info alert-dismissible fade show" role="alert">
        <strong>Info!</strong> Aveți 3 notificări noi.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    
    <div class="card mb-3">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h6 class="mb-0">Notificări recente</h6>
            <button class="btn btn-sm btn-outline-secondary">Marchează toate ca citite</button>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <span class="badge bg-primary rounded-pill me-2">Nou</span>
                    <span>Actualizare de sistem disponibilă</span>
                    <small class="text-muted d-block">Versiunea 2.7.18 este acum disponibilă pentru instalare.</small>
                </div>
                <small class="text-muted">Acum 1 oră</small>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <span class="badge bg-primary rounded-pill me-2">Nou</span>
                    <span>Mesaj de la administrator</span>
                    <small class="text-muted d-block">Mentenanță programată pentru mâine la ora 22:00.</small>
                </div>
                <small class="text-muted">Acum 3 ore</small>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <span class="badge bg-primary rounded-pill me-2">Nou</span>
                    <span>Raport nou generat</span>
                    <small class="text-muted d-block">Raportul lunar a fost generat și poate fi descărcat.</small>
                </div>
                <small class="text-muted">Acum 5 ore</small>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <div>
                    <span>Solicitare de aprobare</span>
                    <small class="text-muted d-block">O nouă cerere de aprobare așteaptă verificarea dvs.</small>
                </div>
                <small class="text-muted">Ieri</small>
            </li>
        </ul>
    </div>
    
    <div class="card">
        <div class="card-header">
            <h6 class="mb-0">Setări notificări</h6>
        </div>
        <div class="card-body">
            <div class="form-check form-switch mb-2">
                <input class="form-check-input" type="checkbox" id="notif-email" checked>
                <label class="form-check-label" for="notif-email">Primește notificări prin email</label>
            </div>
            <div class="form-check form-switch mb-2">
                <input class="form-check-input" type="checkbox" id="notif-system" checked>
                <label class="form-check-label" for="notif-system">Notificări de sistem</label>
            </div>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" id="notif-reports">
                <label class="form-check-label" for="notif-reports">Notificări pentru rapoarte noi</label>
            </div>
        </div>
    </div>
</div>
