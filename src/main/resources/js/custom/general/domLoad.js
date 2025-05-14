document.addEventListener('DOMContentLoaded', function() {
    // Activează tooltip-urile Bootstrap
    console.log("Initial DOMContentLoaded"); // Debugging line
    initializeTooltips(document.body); // Initialize tooltips on the whole body initially
    
    // Inițializează tema aplicației
    if (typeof initializeTheme === 'function') {
        initializeTheme();
    }

    // Activează primul element din meniu la încărcarea paginii
    const firstMenuItem = document.querySelector('#sidebar .nav-link');
    if (firstMenuItem) {
        firstMenuItem.click();
    }

    // Inițializează tema în funcție de preferința salvată
    initializeTheme();

    // Actualizează anul curent în footer
    document.getElementById('current-year').textContent = new Date().getFullYear();
});