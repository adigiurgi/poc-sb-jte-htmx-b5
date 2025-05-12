@param String contextPath
@param String roleName
@param int notificationsCount
@param float executionDurationTimeInSeconds
@param String executionTime

<section id="card-section-${roleName}"
         hx-get="${contextPath}/partials/notifications-forms-module-card/${roleName}"
         hx-trigger="refreshCard from:body"
         hx-swap="outerHTML">
    <div class="htmx-indicator" id="id-indicator-${roleName}">
        <div class="card-body">
            <img src="${contextPath}/static/svg-loaders/bars.svg" alt="Bars Loader" width="40" height="40">
        </div>
        <div class="card-footer text-body-secondary">
            Se verifica notificarile...
        </div>
    </div>

    @if(notificationsCount>0)
        <div class="card-body"
             id="card-body-${roleName}">
            <p class="card-text"></p>
            <a href="${contextPath}/partials/notifications-forms-details/${roleName}"
               id="a"
               class="btn btn-outline-info position-relative mx-3"
               data-bs-toggle="tooltip"
               data-bs-placement="left"
               data-bs-title="Numarul afisat arata cate TIPURI de mesaje aferente acestui modul exista!"
               target="_blank"
               rel="noopener">
                Acceseaza detalii notificari
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${notificationsCount}</span>
            </a>
        </div>
        <div class="card-footer text-body-secondary"
             id="card-footer-${roleName}">
            Durata / Data actualizare
            <div class="vr"></div>
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
