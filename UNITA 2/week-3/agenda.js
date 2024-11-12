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

let secondi = parseInt(sessionStorage.getItem('secondi')) || 0

const attualeContatore = function ()
{
  secondi++
  sessionStorage.setItem('secondi', secondi)
  document.getElementById('secondi').textContent = secondi
}

setInterval(attualeContatore, 1000)

document.addEventListener("DOMContentLoaded", () => {
  const toggleButton = document.getElementById("theme-toggle");
  const body = document.body;

  const savedTheme = localStorage.getItem("theme");
  if (savedTheme) {
      body.classList.add(savedTheme);
  } else {
      body.classList.add("light");
  }

  toggleButton.addEventListener("click", () => {
      
      if (body.classList.contains("light")) {
          body.classList.remove("light");
          body.classList.add("dark");
          localStorage.setItem("theme", "dark");
      } 
      else 
      {
          body.classList.remove("dark");
          body.classList.add("light");
          localStorage.setItem("theme", "light");
      }
  });
});