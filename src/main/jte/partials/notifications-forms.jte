@import java.util.List
@import com.example.webapp.application.dto.query.UserRoleDto

@param String contextPath
@param List<UserRoleDto> userRoles
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
            <button type="button" class="btn btn-outline-secondary" onclick="refreshAllCards()">
                Actualizeaza tot
                <i class="bi bi-arrow-clockwise"></i>
            </button>
        </div>

    </div>

    <div style="grid-template-columns: 1fr 1fr 1fr 1fr 1fr;" class="d-grid gap-3 mb-3" id="cardsContainer">

        @for(var userRole: userRoles)
            <div class="card text-center">
                <div class="card-header d-flex justify-content-between">
                    <h5>${userRole.roleName()}</h5>
                    <button type="button" class="btn btn-sm btn-outline-secondary" id="refreshCardBtn-${userRole.roleName()}"
                            hx-get="${contextPath}/partials/notifications-forms-module-card-refreshed/${userRole.roleName()}"
                            hx-target="#card-section-${userRole.roleName()}"
                            hx-swap="outerHTML">
                        <i class="bi bi-arrow-clockwise"></i>
                        <img src="${contextPath}/static/svg-loaders/bars-light.svg" alt="Bars Loader" class="button-indicator svg-loader-light" width="20" height="20">
                        <img src="${contextPath}/static/svg-loaders/bars-dark.svg" alt="Bars Loader" class="button-indicator svg-loader-dark d-none" width="20" height="20">
                    </button>
                </div>
                <section id="card-section-${userRole.roleName()}"
                         hx-get="${contextPath}/partials/notifications-forms-module-card/${userRole.roleName()}"
                        <%--                         hx-trigger="intersect once"--%>
                         hx-trigger="load"
                         hx-swap="outerHTML">
                    <div class="card-body">
                        <img src="${contextPath}/static/svg-loaders/bars-light.svg" class="svg-loader-light" alt="Bars Loader" width="40" height="40">
                        <img src="${contextPath}/static/svg-loaders/bars-dark.svg" class="svg-loader-dark d-none" alt="Bars Loader" width="40" height="40">
                    </div>
                    <div class="card-footer text-body-secondary">
                        Se verifica notificarile...
                    </div>
                </section>

            </div>
        @endfor

    </div>

</div>

<!-- Script inline pentru filtrarea cardurilor - execută imediat fără a aștepte DOMContentLoaded -->
<script src="${contextPath}/js/custom/partials/common/filterCardsByCardHeaderText.js"></script>
<script src="${contextPath}/js/custom/partials/notifications-forms.js"></script>
