const libreriaUrl = 'https://striveschool-api.herokuapp.com/books'

const getLibreria = function () {

    fetch(libreriaUrl,)

    .then((response) => {

        console.log('RESPONSE', response)

        if(response.ok)
        {
            return response.json()
        }
        else 
        {
        throw new Error('Errore nella response dal server!')
        }
    })

    .then((libreriaObject) => {

        console.log(libreriaObject)
        
        const title0 = document.getElementById('card-title0')
        const price0 = document.getElementById('card-price0')
        title0.innerText = libreriaObject[0].title
        price0.innerText = libreriaObject[0].price
        
        const title1 = document.getElementById('card-title1')
        const price1 = document.getElementById('card-price1')
        title1.innerText = libreriaObject[1].title
        price1.innerText = libreriaObject[1].price
        
        const title2 = document.getElementById('card-title2')
        const price2 = document.getElementById('card-price2')
        title2.innerText = libreriaObject[2].title
        price2.innerText = libreriaObject[2].price

    })

    .catch((err) => {

        console.log(err)
    })
}

getLibreria()

