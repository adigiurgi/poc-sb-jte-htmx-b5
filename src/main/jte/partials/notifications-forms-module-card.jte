@param String contextPath
@param String roleName
@param int notificationsCount
@param double executionDurationTimeInSeconds
@param String executionTime

<section id="card-section-${roleName}"
         hx-get="${contextPath}/partials/notifications-forms-module-card/${roleName}"
         hx-trigger="refreshCard from:body"
         hx-swap="outerHTML"
         hx-indicator="#loading-indicator-${roleName}">
    <div id="loading-indicator-${roleName}" class="card-section-indicator">
        <img src="${contextPath}/static/svg-loaders/bars.svg" alt="Bars Loader" width="40" height="40">
    </div>
    <div class="card-body">
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
    <div class="card-footer text-body-secondary">
        Durata actualizare: ${executionDurationTimeInSeconds}s
        <div class="vr"></div>
        Data actualizare: ${executionTime}
    </div>
</section>
