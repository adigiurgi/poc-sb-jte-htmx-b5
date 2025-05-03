// --- After htmx Swap ---
// Listen for the htmx:afterSwap event on the body
document.body.addEventListener('htmx:afterSwap', function(event) {
    console.log("htmx:afterSwap triggered on target:", event.target); // Debugging line
    // event.target is the element that htmx swapped content into.
    // Initialize tooltips only within the newly loaded content area.
    initializeTooltips(event.target);
});