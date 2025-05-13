@param String contextPath
@param String roleName

<section id="card-section-${roleName}"
         hx-get="${contextPath}/partials/notifications-forms-module-card/${roleName}"
        <%--                         hx-trigger="intersect once"--%>
         hx-trigger="load"
         hx-swap="outerHTML">
    <div class="card-body">
        <img src="${contextPath}/static/svg-loaders/bars.svg" alt="Bars Loader" width="40" height="40">
    </div>
    <div class="card-footer text-body-secondary">
        Se verifica notificarile...
    </div>
</section>