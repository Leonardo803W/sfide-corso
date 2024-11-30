import './App.css';

import ButtonComponent from './component/ButtonComponent';
import ImageComponent from './component/ImageComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
        <ButtonComponent text = 'Buongiorno coccole?!'/>

        <ImageComponent/>
        
      </header>
    </div>
  );
}

export default App;
