window.refreshAllCards = function() {
    // Get all card sections to be refreshed
    const cardSections = document.querySelectorAll('[id^="card-section-"]');
    // Trigger HTMX requests for all card bodies
    cardSections.forEach(section => {
        console.log('refreshing section {}',section.id);
        htmx.trigger(section, 'refreshCard');
    });
};