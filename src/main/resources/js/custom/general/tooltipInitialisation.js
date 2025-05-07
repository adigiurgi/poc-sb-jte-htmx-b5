// Function to initialize tooltips on a given scope
function initializeTooltips(scope) {
    console.log("Initializing tooltips within:", scope); // Debugging line
    const tooltipTriggerList = scope.querySelectorAll('[data-bs-toggle="tooltip"]');
    const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => {
        console.log("Found tooltip target:", tooltipTriggerEl); // Debugging line
        return new bootstrap.Tooltip(tooltipTriggerEl)
    });
    console.log("Initialized", tooltipList.length, "tooltips."); // Debugging line
}