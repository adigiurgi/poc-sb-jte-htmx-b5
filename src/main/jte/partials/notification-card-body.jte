@param String contextPath
@param String moduleName
@param Integer count
@param Long executionTime
@param String timestamp

<div class="card-body">
    <p class="card-text"></p>
    <a href="${contextPath}/notifications/details/${moduleName}"
       id="${moduleName.toLowerCase()}-details"
       class="btn btn-outline-info position-relative mx-3"
       data-bs-toggle="tooltip"
       data-bs-placement="left"
       data-bs-title="Indicatorul din coltul din dreapta sus arata numarul tipurilor de mesaje aferente acestui modul"
       target="_blank"
       rel="noopener">
        Acceseaza detalii notificari
        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${count}</span>
    </a>
</div>
<div class="card-footer text-body-secondary">
    Durata actualizare: ${executionTime / 1000} secunde
    <div class="vr"></div>
    Data actualizare: ${timestamp}
</div>
