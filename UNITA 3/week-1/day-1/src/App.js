import './App.css';
import ButtonComponent from './components/ButtonComponent';
import ImageComponent from './components/ImageComponent';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <ButtonComponent customButton = "button personalizzato" myNumber = {100}/>
        <ImageComponent src = "https://placedog.net/500/510" alt = "gatto"/>
      </header>
    </div>
  );
}

export default App;
