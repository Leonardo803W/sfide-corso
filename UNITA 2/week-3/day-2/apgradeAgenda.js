let yearElement = document.getElementById('data');

let data = new Date();
let year = data.getFullYear();
let month = data.getMonth() + 1;
let day = data.getDate();
yearElement.textContent = year + '/' + month + '/' + day;

let contacts = []
const key = 'agenda-memory'

const firstNameInput = document.getElementById('firstName');
const lastNameInput = document.getElementById('lastName');
const phoneInput = document.getElementById('phone');
const myForm = document.getElementById('user-form');

class User {
    constructor(_firstName, _lastName, _phone) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.phone = _phone;
    }
}

myForm.addEventListener('submit', function (e) {
    e.preventDefault();

    const utente = new User(
        firstNameInput.value,
        lastNameInput.value,
        phoneInput.value
    );

    const cardsRow = document.getElementById('cards-container');
    const newCol = document.createElement('div');

    newCol.classList.add('col', 'col-12', 'col-md-4');
    newCol.innerHTML = `
    <div class="card">
      <img src="https://static.vecteezy.com/system/resources/thumbnails/019/896/012/small_2x/female-user-avatar-icon-in-flat-design-style-person-signs-illustration-png.png" class="card-img-top" alt="generic user picture">
      <div class="card-body">
        <h5 class="card-title">${utente.firstName} ${utente.lastName}</h5>
        <p class="card-text">
          Numero di telefono: ${utente.phone}
        </p>
        <a href="#" class="btn btn-primary">Contatta</a>
      </div>
    </div>
  `;

    cardsRow.appendChild(newCol);

    contacts.push(utente);
    localStorage.setItem(key, JSON.stringify(contacts));

    const alertSuccess = document.querySelector('.alert-success');
    alertSuccess.classList.remove('d-none');

    firstNameInput.value = '';
    lastNameInput.value = '';
    phoneInput.value = '';
});


const saveButton = document.getElementById('save');
saveButton.addEventListener('click', function (e) {
    e.preventDefault();
    myForm.dispatchEvent(new Event('submit'));
});

loadButton.onclick = () => {
    const memory = localStorage.getItem(key);
    const cardsRow = document.getElementById('cards-container');
    cardsRow.innerHTML = ''; 

    if (memory) {
        const savedContacts = JSON.parse(memory);
        contacts = savedContacts;
        savedContacts.forEach((utente) => {
            const newCol = document.createElement('div');
            newCol.classList.add('col', 'col-12', 'col-md-4');
            newCol.innerHTML = `
            <div class="card">
                <img src="...png" class="card-img-top" alt="generic user picture">
                <div class="card-body">
                <h5 class="card-title">${utente.firstName} ${utente.lastName}</h5>
                <p class="card-text">Numero di telefono: ${utente.phone}</p>
                <a href="#" class="btn btn-primary">Contatta</a>
                </div>
            </div>
            `;
            cardsRow.appendChild(newCol);
        });

        const alertInfo = document.querySelector('.alert-info');
        alertInfo.classList.remove('d-none');
    } else {
        const alertDanger = document.querySelector('.alert-danger');
        alertDanger.classList.remove('d-none');
    }
};