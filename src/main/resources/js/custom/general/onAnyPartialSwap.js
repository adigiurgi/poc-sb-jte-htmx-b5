// --- After htmx Swap ---
// Listen for the htmx:afterSwap event on the body
document.body.addEventListener('htmx:afterSwap', function(event) {
    console.log("htmx:afterSwap triggered on target:", event.target); // Debugging line
    // event.target is the element that htmx swapped content into.
    // Initialize tooltips only within the newly loaded content area.
    initializeTooltips(event.target);
    
    // Actualizează vizibilitatea SVG loaderelor pentru conținutul nou încărcat
    if (typeof updateSvgLoaderVisibilityForTarget === 'function') {
        // Obține tema curentă
        const currentTheme = document.documentElement.getAttribute('data-bs-theme');
        console.log("Tema curenta este: ", currentTheme);
        // Aplică actualizarea doar pentru elementele din zona actualizată
        updateSvgLoaderVisibilityForTarget(event.target, currentTheme);
    }
});

//If tooltips are causing issues during swaps (e.g., lingering elements),
//we might need to manually dispose of them before the swap happens.
document.body.addEventListener('htmx:beforeSwap', function(event) {
   
   // Găsește toate elementele cu tooltip în zona care va fi actualizată
   const tooltipElements = event.target.querySelectorAll('[data-bs-toggle="tooltip"]');
   
   if (tooltipElements && tooltipElements.length > 0) {
      console.log(`Disposing ${tooltipElements.length} tooltips before swap`);
      
      // Parcurge fiecare element și elimină tooltip-ul asociat
      tooltipElements.forEach(element => {
         const tooltipInstance = bootstrap.Tooltip.getInstance(element);
         if (tooltipInstance) {
            tooltipInstance.dispose();
            console.log("Disposed tooltip on element:", element);
         }
      });
   }
});