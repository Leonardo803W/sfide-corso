import {Navbar, Container, Nav} from 'react-bootstrap'

const CustomNavbar = () =>{

    return (
    <>
      <Navbar data-bs-theme="dark" className=' bg-dark p-2'>
        <Container className=' m-0 d-flex justify-content-around'>
          <img src="https://placedog.net/50/50" alt="" />
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