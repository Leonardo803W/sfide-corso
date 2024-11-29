import './App.css'
import ButtonComponent from './components/ButtonComponent'
import ImageComponent from './components/ImageComponent'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* I need to place ButtonComponent here to make it reach the page! */}
        <ButtonComponent label="CLICK ME PLEASE!" />
        <ImageComponent
          imageSrc="http://placekitten.com/200/200"
          altText="cute kitten image"
        />
        <ImageComponent
          imageSrc="http://placekitten.com/300/300"
          altText="cute kitten image"
        />
        <ButtonComponent label="I'M ANOTHER BUTTON" />
      </header>
    </div>
  )
}

export default App
