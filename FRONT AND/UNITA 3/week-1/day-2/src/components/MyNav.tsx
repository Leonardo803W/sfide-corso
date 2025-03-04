import React from 'react';
import { Navbar, Container, Nav } from 'react-bootstrap';

const MyNav = () => {

    return(
        <>
            <Navbar bg="dark" data-bs-theme="dark">
                <Container>
                <Navbar.Brand href="#">Navbar</Navbar.Brand>
                <Nav className="">
                    <Nav.Link href="">Home</Nav.Link>
                    <Nav.Link href="">Features</Nav.Link>
                    <Nav.Link href="">Pricing</Nav.Link>
                </Nav>
                </Container>
            </Navbar>
        </>
    )
}

export default MyNav;