import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

//import bootstrap serve poiche in questo modo posso utilizzare bootstrap, e avendolo installato con npm i bootstrap@5.2.3 e anche react-bootstrap@2.7.2 -save-exact, contando che sono due cose diverse ma entrambe indispensabili, avendoli tramite il terminale di git bush non devo cercare il link sul sito ma fare il semplice import
//in caso mi servisse di nuovo la dipendenz ma ho tolto il node_modules per recuperarlo mi basta fare npm install sempre sul terminale di git bush

import MyNav from './components/MyNav';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';
import AllTheBooks from './components/AllTheBook';

//importo i componenti e l'impiego nella funzione app, dentro puo esserci solo un conteniutore padre anche se al posto del div ci fosse <></> andrebbe bene
//in questo caso il div serve per fare la classe app tale classe ci deve essere sempre, oppure fare un misto come si vede sotto

function App() {
  return (
    <>
    <div className="App">

       <header>
         <MyNav/>
       </header>

       <main>
         <Welcome/>

         <AllTheBooks/>
       </main>

       <footer>
         <MyFooter/>
       </footer>

    </div>
    </>
  );
}

export default App;
