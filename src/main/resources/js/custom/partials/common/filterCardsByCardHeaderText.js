(function() {
    // Inițializarea după o scurtă întârziere pentru a ne asigura că DOM-ul este încărcat
    setTimeout(function() {
        const searchInput = document.getElementById('cardSearchInput');
        const clearButton = document.getElementById('clearSearch');
        const searchInfo = document.getElementById('searchResultCount');
        const cardsContainer = document.getElementById('cardsContainer');

        if (!searchInput || !clearButton || !searchInfo || !cardsContainer) {
            console.error('Elementele necesare pentru filtrare nu au fost găsite');
            return;
        }

        const cards = cardsContainer.querySelectorAll('.card');
        const totalCards = cards.length;

        // Actualizare contor inițial
        updateSearchResultCount(totalCards);

        // Funcție pentru filtrarea cardurilor în funcție de text
        function filterCards() {
            const searchTerm = searchInput.value.trim().toLowerCase();
            let visibleCount = 0;

            cards.forEach(card => {
                const cardHeader = card.querySelector('.card-header');
                if (cardHeader) {
                    const headerText = cardHeader.textContent.toLowerCase();

                    if (searchTerm === '' || headerText.includes(searchTerm)) {
                        card.style.display = '';
                        visibleCount++;
                    } else {
                        card.style.display = 'none';
                    }
                }
            });

            // Actualizează informațiile despre rezultate
            updateSearchResultCount(visibleCount);
        }

        function updateSearchResultCount(count) {
            if (searchInput.value.trim() === '') {
                searchInfo.textContent = "Se afișează toate cele " + totalCards + " module";
            } else {
                searchInfo.textContent = "Se afișează " + count + " din " + totalCards + " module";
            }
        }

        // Event listeners pentru căutare
        searchInput.addEventListener('input', filterCards);

        // Resetare căutare
        clearButton.addEventListener('click', function() {
            searchInput.value = '';
            filterCards();
        });
    }, 100); // Întârziere mică pentru a ne asigura că DOM-ul este încărcat
})();