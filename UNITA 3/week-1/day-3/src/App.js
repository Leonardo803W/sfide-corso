import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import { Container } from 'react-bootstrap'

import CustomNavbar from './components/CustomNavbar';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';
import BookList from './components/BookList'

import fantasy from './data/fantasy.json'
import history from './data/history.json'
import horror from './data/horror.json'
import romance from './data/romance.json'
import scifi from './data/scifi.json'

function App() {
  return (
    <div className="App">

      <header>

        <CustomNavbar/>

      </header>

      <main>

      <Welcome/>

      <Container  className=' h-50 text-center'>
            <h1 className=' p-4 text-light'>
              My Book Collection
            </h1>

            <BookList fantasy={fantasy} history = {history} horror = {horror} romance = {romance} scifi = { scifi} />
        </Container>

      </main>

      <footer>

        <MyFooter/>

      </footer>

    </div>
  );
}



export default App;
