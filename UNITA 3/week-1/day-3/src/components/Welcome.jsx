import {Alert} from 'react-bootstrap'
import { useState } from 'react';

const Welcome = () => {

    const [show, setShow] = useState(true)

    const handleClose = () => 
    {
        setShow(false)
    };

    return (
        show && ( <div className=' text-center'>
                <Alert variant="success" className="alert-animation">
                <Alert.Heading>Welcome Adventure</Alert.Heading>
                <p>
                    The Great Library
                </p>
                <button id='closWelcome' onClick={handleClose}>
                    chiudi
                </button>
                </Alert>
            </div>
        )
    )
}

export default Welcome