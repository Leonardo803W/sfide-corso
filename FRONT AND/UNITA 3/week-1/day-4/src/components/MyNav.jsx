import React from 'react';
import { Navbar, Container, Nav } from 'react-bootstrap';

const MyNav = () => {

    //questa e un componente funzione differenza tra i componenti classe e che questultimi hanno molta piu logica
    //in questo caso non ho nessuna props da passare al componente

    return(
        <>
            <Navbar bg="dark" data-bs-theme="dark">
                <Container>
                <Navbar.Brand href="#" className='text-light'>Navbar</Navbar.Brand>
                <Nav className=' flex-lg-row'>
                    <Nav.Link href="#" className='text-light m-2'>Home</Nav.Link>
                    <Nav.Link href="#" className='text-light m-2'>Features</Nav.Link>
                    <Nav.Link href="#" className='text-light m-2'>Pricing</Nav.Link>
                </Nav>
                </Container>
            </Navbar>
        </>
    )
}

//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default MyNav;