import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import MyNav from './components/MyNav';
import MyFooter from './components/MyFooter';
import Welcome from './components/Welcome';
import BookList from './components/BookList';

//useState serve per utilizzare lo stato della variabile nel momento in cui il componente e a funzione, se invece fosse a classe utilizzerei lo state

import { useState } from 'react';

//nel momento in cui importo dei json dopo la chiave import come si vede sotto la parola che segue sara la variabile con cui si fara riferimento nel codice.

import fantasy from './data/fantasy.json';
import history from './data/history.json'; 
import horror from './data/horror.json';
import romance from './data/romance.json';
import scifi from './data/scifi.json';

function App() {

  //creo una variabile con cui posso cambiare il suo valore con set+nomeVariabile e invece useState dico il suo valore di defoult in questo caso di defoult ha il json history.

  const [currentList, setCurrentList] = useState(history);

  //creo un metodo in questo caso handleCategoryChange per poter cambiare il valore della variabile.
  //siccome che ci sono diversi json con case gli dico se il nome del jason corrisponde al case e con setCurrentList cambio il valore della variabile passandogli 
  //tra parentesi l'effettivo json che voglio con l'effettiva nome della variabil che corrsiponde a quel jason.

  const handleCategoryChange = (category) => {

    switch (category) {

      case 'fantasy':
        setCurrentList(fantasy);
        break;
      case 'history':
        setCurrentList(history);
        break;
      case 'horror':
        setCurrentList(horror);
        break;
      case 'romance':
        setCurrentList(romance);
        break;
      case 'scifi':
        setCurrentList(scifi);
        break;
      default:
        setCurrentList(history);
    }
  };

  return (
    <>
      <div className="App">
        <header>
          <MyNav />
        </header>

        {/*invoco il componente booklist passandogli il valore corrente del jason scelto tra parentesi graffe, cio che viene prima e il nome della props che ricevera il componente*/}
        {/*e passo al componente anche il metodo con cui cambio il valore del json, cio che viene prima e il nome del porps che ricevera il componente*/}

        <main>
          <Welcome />
          <BookList lista = {currentList} onCategoryChange = {handleCategoryChange} />
        </main>

        <footer>
          <MyFooter />
        </footer>
      </div>
    </>
  );
}

export default App;