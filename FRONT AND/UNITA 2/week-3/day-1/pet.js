let petNameField = document.getElementById('pet-name')
let ownerNameField = document.getElementById('pet-owner')
let speciesField = document.getElementById('species')
let breedField = document.getElementById('breed')

let petList = document.getElementById('petList')
let ownerList = document.getElementById('ownerList')
let addButton = document.getElementById('add')

let pets = []

class Pet {

  constructor(petName, ownerName, species, breed) {

    this.petName = petName
    this.ownerName = ownerName
    this.species = species
    this.breed = breed
  }

  checkSameOwner(anotherPet) {

    if (this.ownerName === anotherPet.ownerName) 
    {
      
      return true
    } 
    else 
    {
      return false
    }
  }
}

const renderList = function () {
  petList.innerHTML = ''; 

  pets.forEach((pet) => {
    const newLi = document.createElement('li');
    newLi.innerText = 'Nome: ' + pet.petName + ', proprietario: ' + pet.ownerName + ', specie: ' + pet.species + ', razza: ' + pet.breed;
    petList.appendChild(newLi);
  });
}

addButton.onclick = function () {

  let newPet = new Pet(

    petNameField.value,
    ownerNameField.value,
    speciesField.value,
    breedField.value
  )

  pets.push(newPet)
  renderList()
  
  petNameField.value = '' 
  ownerNameField.value = '' 
  speciesField.value = '' 
  breedField.value = '' 
}
