const ButtonComponent = (props) => {

    //le props sono le stesse variabili con lo stesso valore mandato da app.js

    return (
        <>
            <button>
                {props.text}
            </button>
        </>
    )
}

//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default ButtonComponent