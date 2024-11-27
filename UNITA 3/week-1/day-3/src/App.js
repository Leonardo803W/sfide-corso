import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import { Container } from 'react-bootstrap'

import CustomNavbar from './components/CustomNavbar';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';
import BookList from './components/BookList'
import books from './data/history.json'

function App() {
  return (
    <div className="App">

      <header>

        <CustomNavbar/>

      </header>

      <main>

      <Welcome/>

      <Container  className=' h-50 text-center'>
            <h1 className=' p-4'>
              My Book Collection
            </h1>

            <BookList books={books} />
        </Container>

      </main>

      <footer>

        <MyFooter/>

      </footer>

    </div>
  );
}



export default App;
