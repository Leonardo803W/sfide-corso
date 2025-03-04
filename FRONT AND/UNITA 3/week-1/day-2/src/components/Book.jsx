import { Card } from "react-bootstrap";

//in questo caso sto passando una props che contiene un jason
//in'oltre questa e un componente a funzione differenza ai componenti a classe poiche hanno piu logica dentro
//inoltre in questo componente imposto misure standard per tutte le card che si formeranno tramite la lista passsata dal componente allthebook

const Book = (props) => {
  return (
    <>
      <Card className="book-cover d-flex flex-column">
        <Card.Img variant="top" src={props.img} className="book-image"/>
        <Card.Body>
          <Card.Title style={{fontSize: 'medium', margin: '0'}}>{props.title}</Card.Title>
        </Card.Body>
      </Card>
    </>
  );
};

//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default Book;