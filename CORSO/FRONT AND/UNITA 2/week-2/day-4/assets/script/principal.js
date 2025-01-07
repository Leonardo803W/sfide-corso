// Ottieni il bottone e il contenuto del menu
const dropbtn = document.querySelector('.dropbtn');
const dropdownContent = document.querySelector('.dropdown-content');

// Aggiungi un evento click al bottone
dropbtn.addEventListener('click', function() {
    dropdownContent.classList.toggle('show');
});

// Chiudere il menu se si fa clic all'esterno
window.addEventListener('click', function(event) {
    if (!event.target.matches('.dropbtn')) {
        if (dropdownContent.classList.contains('show')) {
            dropdownContent.classList.remove('show');
        }
    }
});