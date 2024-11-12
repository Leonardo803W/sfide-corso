const saveButton = document.getElementById('save')
const cancellaButton = document.getElementById('cancella')

const key = 'firstName-memory'
const textArea = document.getElementById('firstName')

saveButton.addEventListener('click', function () {
    
    localStorage.setItem(key, textArea.value)

    const firstAlert = document.getElementsByClassName('alert')[0]
    firstAlert.classList.remove('d-none')
    
    setTimeout(() => {
      
      firstAlert.classList.add('d-none')
    }, 2000)
})

cancellaButton.addEventListener('click', function () {
    
    const savedContent = localStorage.getItem(key)
  
  if (savedContent === null) {
    const fourthAlert = document.getElementsByClassName('alert')[3]
    fourthAlert.classList.remove('d-none')
    setTimeout(() => {
      
      fourthAlert.classList.add('d-none')
    }, 2000)
  }
  else
  {
    textArea.value = ''
     
    localStorage.removeItem(key)
      
    const secondAlert = document.getElementsByClassName('alert')[1]
    secondAlert.classList.remove('d-none')
    setTimeout(() => {
        
        secondAlert.classList.add('d-none')
    }, 2000)

  }
})

