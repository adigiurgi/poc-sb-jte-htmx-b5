@param String appName
@param String appVersion
@param String contextPath

<div class="container-fluid my-4">
    <div class="row">
        <div class="col-12">
            <h2 class="mb-4"><i class="bi bi-bell"></i> Notificări</h2>
            
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <div>
                        <h5 class="mb-0">Notificări recente</h5>
                    </div>
                    <div>
                        <button class="btn btn-sm btn-outline-primary" id="mark-all-read">
                            <i class="bi bi-check-all"></i> Marchează toate ca citite
                        </button>
                    </div>
                </div>
                <div class="card-body">
                    <!-- Notificări neciite -->
                    <div class="notification-group mb-4">
                        <h6 class="text-muted mb-3">Necitite</h6>
                        
                        <div class="notification-item unread">
                            <div class="d-flex">
                                <div class="notification-icon bg-primary text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-info-circle"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="fw-bold mb-1">Actualizare sistem</h6>
                                        <small class="text-muted">Acum 2 ore</small>
                                    </div>
                                    <p class="mb-1">Sistemul a fost actualizat la versiunea ${appVersion}. Consultați changelog-ul pentru detalii.</p>
                                    <div class="mt-2">
                                        <a href="#changelog" 
                                           class="btn btn-sm btn-outline-primary"
                                           hx-get="${contextPath}/partials/changelog"
                                           hx-target="#content-area"
                                           hx-swap="innerHTML"
                                           hx-trigger="click">
                                            Vezi changelog
                                        </a>
                                        <button class="btn btn-sm btn-light ms-2 mark-read" data-id="1">
                                            <i class="bi bi-check"></i> Marchează ca citit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="notification-item unread mt-3">
                            <div class="d-flex">
                                <div class="notification-icon bg-warning text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-exclamation-triangle"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="fw-bold mb-1">Mentenanță programată</h6>
                                        <small class="text-muted">Acum 1 zi</small>
                                    </div>
                                    <p class="mb-1">Sistemul va fi indisponibil pentru mentenanță pe data de 5 Mai 2025, între orele 22:00-23:00.</p>
                                    <div class="mt-2">
                                        <button class="btn btn-sm btn-light mark-read" data-id="2">
                                            <i class="bi bi-check"></i> Marchează ca citit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Notificări citite -->
                    <div class="notification-group">
                        <h6 class="text-muted mb-3">Citite</h6>
                        
                        <div class="notification-item">
                            <div class="d-flex">
                                <div class="notification-icon bg-success text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-check-circle"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1">Profilul actualizat</h6>
                                        <small class="text-muted">15 Apr 2025</small>
                                    </div>
                                    <p class="mb-1">Profilul dumneavoastră a fost actualizat cu succes.</p>
                                </div>
                            </div>
                        </div>
                        
                        <div class="notification-item mt-3">
                            <div class="d-flex">
                                <div class="notification-icon bg-info text-white rounded-circle p-2 me-3">
                                    <i class="bi bi-bell"></i>
                                </div>
                                <div class="notification-content flex-grow-1">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="mb-1">Bine ați venit în sistem</h6>
                                        <small class="text-muted">15 Apr 2025</small>
                                    </div>
                                    <p class="mb-1">Bine ați venit în aplicația ${appName}! Puteți accesa ghidul de utilizare pentru ajutor.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0">Preferințe notificări</h5>
                </div>
                <div class="card-body">
                    <form>
                        <div class="mb-3">
                            <label class="form-label">Tipuri de notificări</label>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="system-updates" checked>
                                <label class="form-check-label" for="system-updates">
                                    Actualizări sistem
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="maintenance-notif" checked>
                                <label class="form-check-label" for="maintenance-notif">
                                    Notificări mentenanță
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="security-notif" checked>
                                <label class="form-check-label" for="security-notif">
                                    Notificări securitate
                                </label>
                            </div>
                        </div>
                        
                        <button type="button" class="btn btn-primary">Salvează preferințe</button>
                    </form>
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
    
    .notification-item.unread {
        background-color: rgba(13, 110, 253, 0.05);
        border-left: 3px solid var(--bs-primary);
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

<script>
    // Interacțiune marcare ca citit
    document.querySelectorAll('.mark-read').forEach(button => {
        button.addEventListener('click', function() {
            const notificationItem = this.closest('.notification-item');
            notificationItem.classList.remove('unread');
            this.disabled = true;
            this.innerHTML = '<i class="bi bi-check"></i> Citit';
            
            // Aici s-ar face un request la server pentru a marca notificarea ca citită
            // const notificationId = this.getAttribute('data-id');
            // htmx.ajax('POST', '/api/notifications/mark-read/' + notificationId, { target: '#notification-counter' });
        });
    });
    
    // Marcare toate ca citite
    document.getElementById('mark-all-read')?.addEventListener('click', function() {
        document.querySelectorAll('.notification-item.unread').forEach(item => {
            item.classList.remove('unread');
            const markButton = item.querySelector('.mark-read');
            if (markButton) {
                markButton.disabled = true;
                markButton.innerHTML = '<i class="bi bi-check"></i> Citit';
            }
        });
        
        // Aici s-ar face un request la server pentru a marca toate notificările ca citite
        // htmx.ajax('POST', '/api/notifications/mark-all-read', { target: '#notification-counter' });
    });
</script>
