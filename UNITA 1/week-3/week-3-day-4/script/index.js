const createNumberCells = function () {
  
    const numberSection = document.getElementById('number-table')
  
    for (let i = 0; i < 76; i++) {
      
      const numberCell = document.createElement('div')

      numberCell.classList.add('day')
      
      const cellValue = document.createElement('h3')
      cellValue.innerText = i + 1
  
      numberCell.appendChild(cellValue)
      
      numberSection.appendChild(numberCell)
    } 
}

addEventListener('click', function() {

    const number = document.getElementById('extractNumber')
    
    const numeroCasuale = Math.floor(Math.random() * 76) + 1
    const cellaEvidenziata = numeroCasuale
    cellaEvidenziata.classList.add('evidenziato')
});

createNumberCells()
addEventListener()
