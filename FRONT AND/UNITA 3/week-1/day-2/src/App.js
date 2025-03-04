import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'

import MyNav from './components/MyNav'
//import bootstrap serve poiche in questo modo posso utilizzare bootstrap, e avendolo installato con npm i bootstrap@5.2.3 e anche react-bootstrap@2.7.2 -save-exact, contando che sono due cose diverse ma entrambe indispensabili, avendoli tramite il terminale di git bush non devo cercare il link sul sito ma fare il semplice import
//in caso mi servisse di nuovo la dipendenz ma ho tolto il node_modules per recuperarlo mi basta fare npm install sempre sul terminale di git bush

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <MyNav/>
      </header>
    </div>
  );
}

export default App;
