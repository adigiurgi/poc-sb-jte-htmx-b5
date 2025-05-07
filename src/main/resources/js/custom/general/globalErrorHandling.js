// Handler global pentru erorile HTMX
document.body.addEventListener('htmx:responseError', function(event) {
    const errorContainer = document.getElementById('error-container');
    const errorContent = document.getElementById('error-content');
    const errorDetails = document.getElementById('error-details');
    const showDetailsBtn = document.getElementById('show-details-btn');

    const xhr = event.detail.xhr;
    const requestPath = event.detail.pathInfo ? event.detail.pathInfo.requestPath : '';

    // Extrage conținutul paginii de eroare din răspuns
    let errorHTML = xhr.responseText;
    let errorMessage = 'A apărut o eroare la procesarea cererii.';
    let errorTrace = '';

    try {
        // Extrage titlul și descrierea erorii
        const tempDiv = document.createElement('div');
        tempDiv.innerHTML = errorHTML;

        // Caută mesajul de eroare în HTML
        const leadParas = tempDiv.querySelectorAll('.lead');
        if (leadParas.length > 0) {
            errorMessage = leadParas[0].textContent;
        }

        // Caută stack trace-ul dacă există
        const traceElements = tempDiv.querySelectorAll('pre');
        if (traceElements.length > 0) {
            errorTrace = traceElements[0].textContent;
            showDetailsBtn.classList.remove('d-none');
        } else {
            showDetailsBtn.classList.add('d-none');
        }

        // Setează conținutul de eroare
        errorContent.innerHTML = '<p>' + errorMessage + '</p>' +
            '<p><strong>URL:</strong> ' + requestPath + '</p>';
        errorDetails.textContent = errorTrace;

    } catch (e) {
        // Fallback dacă parsarea eșuează
        errorContent.textContent = 'Eroare la încărcarea conținutului: ' + requestPath;
        showDetailsBtn.classList.add('d-none');
    }

    // Arată containerul de eroare
    errorContainer.classList.remove('d-none');

    // Scrollează la containerul de eroare
    errorContainer.scrollIntoView({ behavior: 'smooth' });
});