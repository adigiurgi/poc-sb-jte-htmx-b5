// Funcție pentru inițializarea temei în funcție de preferința salvată
function initializeTheme() {
    const savedTheme = localStorage.getItem('theme-preference');
    const prefersDarkScheme = window.matchMedia('(prefers-color-scheme: dark)').matches;

    // Dacă există o preferință salvată, folosește-o, altfel folosește preferința sistemului
    const theme = savedTheme || (prefersDarkScheme ? 'dark' : 'light');

    // Aplică tema
    document.documentElement.setAttribute('data-bs-theme', theme);

    // Actualizează iconița butonului
    updateThemeDetails(theme);
    
    // Actualizează vizibilitatea SVG loaderelor
    if (typeof updateSvgLoaderVisibility === 'function') {
        updateSvgLoaderVisibility(theme);
    }
}