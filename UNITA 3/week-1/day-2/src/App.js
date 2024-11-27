import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import { Container, Row } from 'react-bootstrap'

import CustomNavbar from './components/CustomNavbar';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';
import AllTheBooks from './components/AllTheBooks';

function App() {
  return (
    <div className="App">

      <header>

        <CustomNavbar/>

      </header>

      <main>

      <Welcome/>

      <Container>
          {/* <div class="row"> */}
          <Row>
              <AllTheBooks/>
          </Row>
        </Container>

      </main>

      <footer>

        <MyFooter/>

      </footer>

    </div>
  );
}

export default App;
