// Funcționalitate pentru comutarea între modurile light și dark
document.getElementById('theme-toggle').addEventListener('click', function() {
    const htmlElement = document.documentElement;
    const isCurrentlyDark = htmlElement.getAttribute('data-bs-theme') === 'dark';
    const newTheme = isCurrentlyDark ? 'light' : 'dark';

    // Schimbă tema
    htmlElement.setAttribute('data-bs-theme', newTheme);

    // Salvează preferința în localStorage
    localStorage.setItem('theme-preference', newTheme);

    // Actualizează iconița butonului
    updateThemeDetails(newTheme);
    
    // Actualizează vizibilitatea SVG loaderelor
    if (typeof updateSvgLoaderVisibility === 'function') {
        updateSvgLoaderVisibility(newTheme);
    }
});

// Funcție pentru actualizarea iconiței butonului de schimbare a temei precum si a logo-ului în funcție de temă
function updateThemeDetails(theme) {
    const lightToggle = document.querySelector('.theme-toggle-light');
    const darkToggle = document.querySelector('.theme-toggle-dark');
    const lightLogo = document.querySelector('.theme-logo-light');
    const darkLogo = document.querySelector('.theme-logo-dark');

    if (theme === 'dark') {
        lightToggle.classList.add('d-none');
        lightLogo.classList.add('d-none');
        darkToggle.classList.remove('d-none');
        darkLogo.classList.remove('d-none');
    } else {
        lightToggle.classList.remove('d-none');
        lightLogo.classList.remove('d-none');
        darkToggle.classList.add('d-none');
        darkLogo.classList.add('d-none');
    }
}