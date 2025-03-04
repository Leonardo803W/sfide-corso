import './App.css';

import ButtonComponent from './component/ButtonComponent';
import ImageComponent from './component/ImageComponent';

//importo i componenti e l'impiego nella funzione app, dentro puo esserci solo un conteniutore padre anche se al posto del div ci fosse <></> andrebbe bene
//in questo caso il div serve per fare la classe app tale classe ci deve essere sempre, oppure fare un misto come si vede sotto

function App() {
  return (
    <>
    <div className="App">
      <header className="App-header">
        
        <ButtonComponent text = 'Buongiorno coccole?!'/>

        <ImageComponent/>
        
      </header>
    </div>
    </>
  );
}

export default App;
