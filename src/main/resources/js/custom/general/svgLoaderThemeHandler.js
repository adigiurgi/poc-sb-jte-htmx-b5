/**
 * Funcție pentru gestionarea vizibilității elementelor SVG loader în funcție de temă
 * Ascunde/arată elementele cu clasele svg-loader-light și svg-loader-dark în funcție de tema curentă
 * @param {string} theme - Tema curentă ('light' sau 'dark')
 */
function updateSvgLoaderVisibility(theme) {
    // Aplică pentru întregul document
    updateSvgLoaderVisibilityForTarget(document, theme);
}

/**
 * Funcție pentru gestionarea vizibilității elementelor SVG loader într-un container specific
 * @param {HTMLElement|Document} container - Containerul în care se caută elementele SVG loader
 * @param {string} theme - Tema curentă ('light' sau 'dark')
 */
function updateSvgLoaderVisibilityForTarget(container, theme) {
    // Selectează toate elementele cu clasele svg-loader-light și svg-loader-dark din container
    const lightLoaders = container.querySelectorAll('.svg-loader-light');
    const darkLoaders = container.querySelectorAll('.svg-loader-dark');

    if (theme === 'dark') {
        // În modul dark, ascunde elementele light și arată elementele dark
        lightLoaders.forEach(element => element.classList.add('d-none'));
        darkLoaders.forEach(element => element.classList.remove('d-none'));
    } else {
        // În modul light, arată elementele light și ascunde elementele dark
        lightLoaders.forEach(element => element.classList.remove('d-none'));
        darkLoaders.forEach(element => element.classList.add('d-none'));
    }

    console.log(`Actualizat vizibilitatea pentru ${lightLoaders.length} svg-loader-light și ${darkLoaders.length} svg-loader-dark în container cu tema: ${theme}`);
}
