import {Alert} from 'react-bootstrap'

const Welcome = () => {
    return (

        <Alert variant="success">
        <Alert.Heading>Welcome Adventure</Alert.Heading>
        <p>
            The Great Library
        </p>
        <button id='closWelcome'>
            chiudi
        </button>
        </Alert>
    )
}

export default Welcome