import { Component } from 'react';
import { Col, Row, Form, Dropdown } from 'react-bootstrap';
import SingleBook from './SingleBook';

//class BookList extends Component: Questa riga definisce una classe chiamata BookList che eredita da Component. 
//Questo significa che BookList è una componente React e può utilizzare tutte le funzionalità di Component.

class BookList extends Component {

  //constructor(props): Questo è il costruttore della classe. Viene chiamato quando la componente viene creata per la prima volta. 
  //props (proprietà) sono dati che vengono passati alla componente da altre parti dell'applicazione.
  //super(props): Questa riga chiama il costruttore della classe padre (Component). È importante farlo per inizializzare correttamente la componente.

  constructor(props) {
    super(props)

    //differenza con un componente funzione e uno a classe e che in questul'timo e che per potere avere le props passsater dal padre devo avere un costruttore e utilizzare super
    //inoltre per poter inizializzare delle variabili lo devo sempre fre dentro al costruttore e utilizzare la dicitura di this.state
    //per poter accedre ai valori di quelle variabili e impostarli

    //this.state = { ... }: Questa riga definisce lo stato (state) della componente. Lo stato è un oggetto che contiene i dati che possono cambiare nel tempo e che influenzano il rendering della componente.
    //inizializzo due variabili dandogli dei valori di defoult in cui il primo e vuoto,
    //mentre con il secondo fisso di defoult il json che riceve all'inizio, siccome i json non vengono importati in questo componente tra parentesi dico il nome del jason ma tra apici.

    this.state = {
      searchTerm: '',
      selectedCategory: 'history',
    }
  }
  

  // lo scopo del metodo handleSearchChange e gestire l'evento di cambiamento di un campo di ricerca.
  //Quando l'utente digita nel campo di ricerca, viene generato un evento change.
  //Questo evento viene passato come argomento alla funzione handleSearchChange.
  //All'interno della funzione, event.target.value recupera il testo corrente inserito nel campo di ricerca.
  //siccome che e un componente a classe per poter accedere al valore o per poterlo cambiare devo utilizzare this.setState()
  //setSearchTerm è una funzione che aggiorna lo stato del componente con il nuovo termine di ricerca.

  handleSearchChange = (event) => {

    this.setState({ searchTerm: event.target.value });
  };

  //Lo scopo del metodo filteredBooks filtra la lista di libri in base al termine di ricerca corrente.
  //props.lista è un array di oggetti che rappresentano i libri.
  //filter è un metodo di array che crea un nuovo array contenente solo gli elementi che soddisfano una condizione.
  //La condizione in questo caso è che il titolo del libro (in minuscolo) contenga il termine di ricerca (in minuscolo).
  //filteredBooks è un nuovo array contenente solo i libri che corrispondono al termine di ricerca.

  getFilteredBooks() {

    //const { searchTerm } = this.state;: Questa riga di codice utilizza la destructuring assignment, una funzionalità di JavaScript che permette di estrarre proprietà da un oggetto e assegnarle a variabili separate.
    //const { searchTerm }: Questa parte dichiara una costante chiamata searchTerm.
    //= this.state: Questa parte indica che la costante searchTerm riceverà il valore della proprietà searchTerm dall'oggetto this.state. 
    //book e la variabile che crea momentaneamente, con quella variabile cerca nel jason chiamando il campo che voglio, 
    //in questo caso title ovvero il titolo con toLowerCase trasforma ogni titolo in minuscolo,
    //in questo modo facendo includes quindi includendo anche il valore della barra di ricerca che viene trasformata in minuscolo, cosi che essendo il titolo e il valore della ricerca vi sia un confronto

    const { searchTerm } = this.state;
    return this.props.lista.filter(book =>
      book.title.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }

  //Lo scopo del metodo handleCategorySelect e gestire la selezione di una categoria.
  //category è la categoria selezionata dall'utente.
  //this.setState: funzione fondamentale in React per aggiornare lo stato del componente. Quando lo stato di un componente cambia, React rirenderizza il componente per riflettere le modifiche.
  //{ selectedCategory: category }: oggetto che contiene una singola proprietà chiamata selectedCategory. Il valore di questa proprietà viene impostato a category
  //this.props.onCategoryChange: Questa è una funzione che è stata passata al componente come prop (proprietà).
  //argomento passato alla funzione onCategoryChange. Rappresenta la categoria selezionata dall'utente.

  handleCategorySelect = (category) => {

    this.setState({ selectedCategory: category });
    this.props.onCategoryChange(category);
  };

  handleBookSelect = (book) => {

    this.setState({selectedBook: book})
  };

  render() {

    //const { searchTerm, selectedCategory }: Questa riga utilizza la destructuring assignment per estrarre le proprietà searchTerm e selectedCategory dall'oggetto this.state.
    //this.state: Questo si riferisce allo stato del componente, che contiene le informazioni che determinano l'aspetto e il comportamento del componente.
    
    const { searchTerm, selectedCategory } = this.state;

    //const filteredBooks: Questa riga dichiara una costante chiamata filteredBooks.
    //= this.getFilteredBooks(): Questa parte assegna alla costante filteredBooks il risultato della chiamata alla funzione this.getFilteredBooks().

    const filteredBooks = this.getFilteredBooks();

  //il form permette che l'utente digiti nel campo di ricerca.
  //handleSearchChange viene chiamato e aggiorna lo stato del componente con il nuovo termine di ricerca.
  //filteredBooks viene ricalcolato utilizzando il nuovo termine di ricerca, filtrando la lista di libri.
  //Il componente React ridisegna se stesso con la lista filtrata di libri.

  return (
    <div>
      <Form>
        <Form.Group controlId="search">
          <Form.Label></Form.Label>
          <Form.Control
            type="text"
            placeholder="Search for a book..."
            value={searchTerm}
            onChange={this.handleSearchChange}
          />
        </Form.Group>
      </Form>

      {/**
       * dropdown è l'elemento principale che definisce il menu a tendina. All'interno di questo tag, definisci le diverse parti del menu.
       * variant="success": Questo attributo definisce il colore di sfondo e il bordo del pulsante. In questo caso, è verde (success).
       * id="dropdown-basic": Questo attributo definisce l'ID del pulsante, utile per identificarlo nel DOM.
       * Select Category: ...: testo viene visualizzato all'interno del pulsante.
       * selectedCategory.charAt(0).toUpperCase() + selectedCategory.slice(1): Questo codice formatta il testo della categoria selezionata.
       * selectedCategory.charAt(0).toUpperCase(): Prende il primo carattere della categoria e lo converte in maiuscolo.
       * selectedCategory.slice(1): Prende tutti i caratteri successivi al primo carattere della categoria.
       * I due pezzi di codice vengono concatenati per visualizzare la categoria con la prima lettera in maiuscolo.
       * 
       * Ogni <Dropdown.Item> rappresenta una voce nel menu.
       * onClick={() => handleCategorySelect('fantasy')}: Questo attributo definisce l'azione da eseguire quando si clicca su una voce del menu.
       * tra parentesi il nome del jason corrispondente al metodo, sempre tra apici poiche non sono importati in questo componente
       */}

       <Dropdown className=' mt-4'>
       <Dropdown.Toggle variant="success" id="dropdown-basic">
         Select Category: {selectedCategory.charAt(0).toUpperCase() + selectedCategory.slice(1)}
       </Dropdown.Toggle>

        {/**
         * Il this qui è fondamentale perché indica che la funzione handleCategorySelect è una funzione membro del componente BookList. 
         * In altre parole, la funzione fa parte dell'oggetto che rappresenta il componente BookList.
         * Grazie a this, la funzione handleCategorySelect può accedere allo stato del componente (this.state) e ad altre funzioni del componente 
         * (this.setState, this.getFilteredBooks, ecc.).
         */}

       <Dropdown.Menu>
       <Dropdown.Item onClick={() => this.handleCategorySelect('fantasy')}>Fantasy</Dropdown.Item>
       <Dropdown.Item onClick={() => this.handleCategorySelect('history')}>History</Dropdown.Item>
       <Dropdown.Item onClick={() => this.handleCategorySelect('horror')}>Horror</Dropdown.Item>
       <Dropdown.Item onClick={() => this.handleCategorySelect('romance')}>Romance</Dropdown.Item>
       <Dropdown.Item onClick={() => this.handleCategorySelect('scifi')}>Sci-Fi</Dropdown.Item>
     </Dropdown.Menu>
   </Dropdown>

      <Row className="g-3 m-4">
          {filteredBooks.length > 2 ? (
            filteredBooks.map((book) => (
              <Col xs={12} md={8} lg={4} key={book.asin} className='w-25'>
                <SingleBook img={book.img} title={book.title} />
              </Col>
            ))
          ) : (

          //utilizzo ? e : e l'or per cui se il metodo filteredBooks viene chiamato, ovvero l'utente digita sulla barra di ricerca non viene messo lcun limiti di visualizzazione dei libri
          //se invece non viene invocato il metodo metto un limite nel visualizzare i libri con props.lista.slice(0, 20).map((book) in cui chiamo le props le chiamo con il nome dato nel padre del componente
          //e con slice imposto la quantita, mentre con map il metodo con una variabile provvisoria tra parentesi, stesso metodo anche sopra.
          //il ? e i : sono sostanzialmente il if e l'else ma in una forma diversa.

          this.props.lista.slice(0, 5).map((book) => (
            <Col xs={12} md={8} lg={4} key={book.asin} className='w-25'>
              <SingleBook 
                    img={book.img} 
                    title={book.title} 
              />
            </Col>
          ))
        )}
      </Row>
    </div>
  );
}
}

export default BookList;