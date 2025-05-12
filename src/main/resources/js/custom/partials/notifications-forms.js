window.refreshAllCards = function() {
    console.log('refresh all clicked');

    const cardBodies = document.querySelectorAll('[id^="card-body-"]')
    cardBodies.forEach(cardBody => {
        console.log('removing card body of {}',cardBody.id);
        htmx.remove(cardBody);
    });
    const cardFooters = document.querySelectorAll('[id^="card-footer-"]');
    cardFooters.forEach(cardFooter => {
        console.log('removing card body of {}',cardFooter.id);
        htmx.remove(cardFooter);
    });

    // Get all card sections to be refreshed
    const cardSections = document.querySelectorAll('[id^="card-section-"]');
    // Trigger HTMX requests for all card bodies
    cardSections.forEach(section => {
        console.log('triggering section {} for refresh',section.id);
        htmx.trigger(section, 'refreshCard');
    });
};