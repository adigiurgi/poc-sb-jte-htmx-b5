// Adaugă clasa active pentru elementul de meniu selectat
document.addEventListener('click', function(event) {
    if (event.target.closest('#sidebar .nav-link')) {
        const navLinks = document.querySelectorAll('#sidebar .nav-link');
        navLinks.forEach(link => link.classList.remove('active'));
        event.target.closest('#sidebar .nav-link').classList.add('active');
    }
});