import { useEffect, useState } from "react";

//in questo caso non sto passando nessuna proprs
//in'oltre questa e un componente a funzione differenza ai componenti a classe poiche hanno piu logica dentro

const Welcome = () => {

    //const [showSpan, setShowSpan] = useState(true);: Qui viene utilizzato l'hook useState per creare uno stato chiamato showSpan, che inizialmente 
    //è impostato su true. showSpan è una variabile che indica se un certo elemento 
    //deve essere mostrato o meno. setShowSpan è la funzione che permette di aggiornare il valore di showSpan.
    //invece useState e per impostare il valore di defoult

    const [showSpan, setShowSpan] = useState(true);

    //useEffect Questo è un altro hook di React, useEffect, che viene utilizzato per gestire effetti collaterali, 
    //come operazioni di registrazione o timer. La funzione passata a useEffect viene eseguita dopo che il componente è stato montato. 
    //L'array vuoto [] come secondo argomento indica che l'effetto deve essere eseguito solo una volta, al momento del montaggio del componente.

    useEffect(() => {

        //const timer = setTimeout(() => { setShowSpan(false); }, 5000);: Qui viene impostato un timer che attende 5000 millisecondi 
        //(5 secondi) prima di eseguire la funzione che imposta showSpan a false. 
        //Questo significa che dopo 5 secondi, il componente cambierà lo stato e showSpan diventerà false, facendo presumibilmente scomparire l'elemento.

        const timer = setTimeout(() => {
            setShowSpan(false);
        }, 5000);

        //return () => clearTimeout(timer);: Questa parte è una funzione di pulizia che viene eseguita quando il componente viene smontato o prima che l'effetto venga rieseguito. clearTimeout(timer) 
        //annulla il timer se il componente viene smontato prima che scadano i 5 secondi, evitando così di chiamare setShowSpan(false) quando il componente non è più presente.

        return () => clearTimeout(timer);
    }, []);

    return (
    <>
        {showSpan && <div className="spanAlert mt-3">
            <span>Welcome!!!</span>
        </div>}

            <p className="d-block mt-3 text-light">
                The Great Library!
            </p>

    </>
    );
}

//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default Welcome;