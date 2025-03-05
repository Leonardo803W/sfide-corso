import { Card, Col, Row } from 'react-bootstrap';
import fantasy from '../data/fantasy.json';
import history from '../data/history.json'; 
import horror from '../data/horror.json';
import romance from '../data/romance.json';
import scifi from '../data/scifi.json';

//in questo caso non sto passando nessuna proprs
//in'oltre questa e un componente a funzione differenza ai componenti a classe poiche hanno piu logica dentro
//importo i jason dandogli una variabile che posso utilizzare

const AllTheBooks = () => {

  console.log(fantasy);
  console.log(history);
  console.log(horror);
  console.log(romance);
  console.log(scifi);

  //con fantasy sto dicendo quale jason gli verra passato, con slice quante card verranno generate, anziche 100 verranno generate le prime 20 card della lista jason
  //map ritorna una lista
  //inoltre non solo chiamo il componente book, ma gli dico cosa gli verra passato come props utilizzando una vriabile book come riferimento
  //con book.asin sto passando l'id dei libri, con book.title i titoli e con book.img le immagini

    return (
        <Row className="g-3 m-4">
          {fantasy.slice(0, 20).map((book) => {
            return (
              <Col xs={12} md={8} lg={4} key={book.asin} className=' w-25'>
                <Card className="book-cover d-flex flex-column">
                  <Card.Img variant="top" src={book.img} className="book-image"/>
                  <Card.Body>
                    <Card.Title style={{fontSize: 'medium', margin: '0'}}>{book.title}</Card.Title>
                  </Card.Body>
                </Card>
              </Col>
            );
          })}
        </Row>
    );
};

//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default AllTheBooks;