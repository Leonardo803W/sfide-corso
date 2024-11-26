import {Navbar, Container, Nav} from 'react-bootstrap'

const CustomNavbar = () =>{

    return (
    <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#">about</Nav.Link>
            <Nav.Link href="#">Browse</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
    )
}

export default CustomNavbar