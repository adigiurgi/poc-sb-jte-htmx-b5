@import java.util.List
@import com.example.webapp.application.domain.models.notifications.forms.NotificationForms

@param String contextPath
@param String roleName
@param int notificationsCount
@param float executionDurationTimeInSeconds
@param String executionTime
@param List<NotificationForms> notificationFormsList

<section id="card-section-${roleName}"
         hx-get="${contextPath}/partials/notifications-forms-module-card/${roleName}"
         hx-trigger="refreshCard from:body"
         hx-swap="outerHTML">
    <div class="htmx-indicator">
        <div class="card-body">
            <img src="${contextPath}/static/svg-loaders/bars-light.svg" class="svg-loader-light" alt="Bars Loader" width="40" height="40">
            <img src="${contextPath}/static/svg-loaders/bars-dark.svg" class="svg-loader-dark d-none" alt="Bars Loader" width="40" height="40">
        </div>
        <div class="card-footer text-body-secondary">
            Se verifica notificarile...
        </div>
    </div>

    @if(notificationsCount>0)
        <div class="card-body"
             id="card-body-${roleName}">
            <p class="card-text"></p>
            <button class="btn btn-outline-info position-relative mx-3" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasFor${roleName}" aria-controls="offcanvasFor${roleName}">
                Detalii notificari
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${notificationsCount}</span>
            </button>

            <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasFor${roleName}"
                 aria-labelledby="offcanvasLabelFor${roleName}">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasLabelFor${roleName}">Notificări active
                        pentru ${roleName}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body text-lg-start">
                    <p class="badge text-bg-secondary">Verificarea acestor mesaje a fost facuta la data de ${executionTime}</p>
                    @for(var notification : notificationFormsList)
                        @if(notification.isNormalStatus())
                            <div class="alert alert-info" role="alert">
                                <div class="d-flex justify-content-between">
                                    <a href="#" class="alert-link">${notification.getTextMesaj()}</a>
                                    @if(notification.canBeDismissed())
                                        <button type="button" class="btn btn-sm btn-outline-info">
                                            <i class="bi bi-trash3-fill"></i>
                                            Anuleaza mesajele
                                        </button>
                                    @endif
                                </div>
                            </div>
                        @elseif(notification.isPriorityStatus())
                            <div class="alert alert-warning" role="alert">
                                <div class="d-flex justify-content-between">
                                    <a href="#" class="alert-link">${notification.getTextMesaj()}</a>
                                    @if(notification.canBeDismissed())
                                        <button type="button" class="btn btn-sm btn-outline-info">
                                            <i class="bi bi-trash3-fill"></i>
                                            Anuleaza mesajele
                                        </button>
                                    @endif
                                </div>
                            </div>
                        @elseif(notification.isUrgentStatus())
                            <div class="alert alert-danger" role="alert">
                                <div class="d-flex justify-content-between">
                                    <a href="#" class="alert-link">${notification.getTextMesaj()}</a>
                                    @if(notification.canBeDismissed())
                                        <button type="button" class="btn btn-sm btn-outline-info">
                                            <i class="bi bi-trash3-fill"></i>
                                            Anuleaza mesajele
                                        </button>
                                    @endif
                                </div>
                            </div>
                        @else
                            <div class="alert alert-info" role="alert">
                                <div class="d-flex justify-content-between">
                                    <a href="#" class="alert-link">${notification.getTextMesaj()}</a>
                                    @if(notification.canBeDismissed())
                                        <button type="button" class="btn btn-sm btn-outline-info">
                                            <i class="bi bi-trash3-fill"></i>
                                            Anuleaza mesajele
                                        </button>
                                    @endif
                                </div>
                            </div>
                        @endif
                    @endfor
                </div>
            </div>


        </div>
        <div class="card-footer text-body-secondary"
             id="card-footer-${roleName}">
            ${executionDurationTimeInSeconds}s / ${executionTime}
        </div>
    @else
        <div class="card-body"
             id="card-body-${roleName}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Felicitări!</strong> Nu aveți nici un mesaj nerezolvat!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </div>
    @endif
</section>
