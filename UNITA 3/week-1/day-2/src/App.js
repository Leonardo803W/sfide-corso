import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import CustomNavbar from './components/CustomNavbar';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';

function App() {
  return (
    <div className="App">

      <header>

        <CustomNavbar/>

      </header>

      <main>

      <Welcome/>

      </main>

      <footer>

        <MyFooter/>

      </footer>

    </div>
  );
}

export default App;
