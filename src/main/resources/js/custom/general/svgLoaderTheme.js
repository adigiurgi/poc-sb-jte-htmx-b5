// Funcție pentru actualizarea vizibilității SVG loaderelor în funcție de tema curentă
function updateSvgLoaderVisibility(theme) {
    // Selectăm toate elementele cu clasa svg-loader-light și svg-loader-dark din întregul document
    const lightLoaders = document.querySelectorAll('.svg-loader-light');
    const darkLoaders = document.querySelectorAll('.svg-loader-dark');
    
    if (theme === 'dark') {
        // În modul dark, ascundem loaderele light și afișăm loaderele dark
        lightLoaders.forEach(loader => loader.classList.add('d-none'));
        darkLoaders.forEach(loader => loader.classList.remove('d-none'));
    } else {
        // În modul light, ascundem loaderele dark și afișăm loaderele light
        darkLoaders.forEach(loader => loader.classList.add('d-none'));
        lightLoaders.forEach(loader => loader.classList.remove('d-none'));
    }
    
    console.log(`Updated SVG loaders visibility for ${theme} theme: ${lightLoaders.length} light loaders, ${darkLoaders.length} dark loaders`);
}

// Funcție pentru actualizarea vizibilității SVG loaderelor doar în cadrul unui element target specific
// Util pentru actualizări parțiale cu htmx
function updateSvgLoaderVisibilityForTarget(target, theme) {
    // Selectăm toate elementele cu clasa svg-loader-light și svg-loader-dark din target
    const lightLoaders = target.querySelectorAll('.svg-loader-light');
    const darkLoaders = target.querySelectorAll('.svg-loader-dark');
    
    if (theme === 'dark') {
        // În modul dark, ascundem loaderele light și afișăm loaderele dark
        lightLoaders.forEach(loader => loader.classList.add('d-none'));
        darkLoaders.forEach(loader => loader.classList.remove('d-none'));
    } else {
        // În modul light, ascundem loaderele dark și afișăm loaderele light
        darkLoaders.forEach(loader => loader.classList.add('d-none'));
        lightLoaders.forEach(loader => loader.classList.remove('d-none'));
    }
    
    console.log(`Updated SVG loaders visibility in target for ${theme} theme: ${lightLoaders.length} light loaders, ${darkLoaders.length} dark loaders`);
}
