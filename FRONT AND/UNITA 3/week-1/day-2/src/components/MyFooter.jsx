import React, { useState, useEffect } from 'react';

const MyFooter = () => {
        
        //questa e un componente funzione differenza tra i componenti classe e che questultimi hanno molta piu logica
        //in questo caso non ho nessuna props da passare al componente
        const [now, setNow] = useState(new Date());
    
        //useEffect Questo è un altro hook di React, useEffect, che viene utilizzato per gestire effetti collaterali, 
        //come operazioni di registrazione o timer. La funzione passata a useEffect viene eseguita dopo che il componente è stato montato. 

        useEffect(() => {

            //const intervalId =: Qui si sta dichiarando una costante chiamata intervalId. Questa costante conterrà l'ID dell'intervallo creato dalla funzione setInterval. 
            //L'ID è utile se in futuro si desidera fermare l'intervallo con clearInterval.

            //setInterval(() => {...}, 1000): setInterval è una funzione JavaScript che esegue una funzione specificata a intervalli regolari, espressi in millisecondi. 
            //In questo caso, la funzione viene eseguita ogni 1000 millisecondi (1 secondo). Il primo argomento è una funzione freccia (arrow function) che verrà eseguita ad ogni intervallo.

            //() => { setNow(new Date()); }: Questa è la funzione che verrà eseguita ogni secondo. All'interno di questa funzione, viene chiamata un'altra funzione chiamata setNow,
            //passando come argomento un nuovo oggetto Date(). Questo significa che ad ogni intervallo (ogni secondo), la variabile o lo stato gestito da setNow verrà aggiornato 
            // con la data e l'ora correnti.

            const intervalId = setInterval(() => {
                setNow(new Date());
            }, 1000);
    
            return () => clearInterval(intervalId); // Pulisce l'intervallo al momento dello smontaggio del componente
        }, []);
    
        return (
            <div className="footerBorder">
                {now.toString()} {/* formatta la data in una stringa */}
            </div>
        );
    }
    

    //l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

    export default MyFooter;