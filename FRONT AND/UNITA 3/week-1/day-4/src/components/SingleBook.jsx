import { Card } from "react-bootstrap";
import { Component } from 'react';
import CommentArea from "./CommentArea";

//in questo caso sto passando una props che contiene un jason
//in'oltre questa e un componente a funzione differenza ai componenti a classe poiche hanno piu logica dentro
//inoltre in questo componente imposto misure standard per tutte le card che si formeranno tramite la lista passsata dal componente allthebook

class SingleBook extends Component {

  constructor (props) {
    super(props)

    this.state = {

      selected: false,
      selectedBook: null,
    }
  }

  handleCardClick = () => {

    const { img, title } = this.props;

    this.setState(prevState => ({
      selected: !prevState.selected,
      selectedBook: prevState.selected ? null : { img, title }
    }));
  }
 
  render() {

    //utilizza una funzionalità di JavaScript chiamata destructuring assignment per estrarre le proprietà img e title dall'oggetto this.props.
    // const: Dichiara una variabile costante chiamata { img, title }.
    // { img, title }: Questo è l'oggetto destructured. Esso specifica che si desidera estrarre le proprietà img e title dall'oggetto this.props.
    // this.props: Questo è l'oggetto che contiene le proprietà passate al componente.

    const { img, title } = this.props;

    return (
      <div>
        <Card 
          className = "selected"
          onClick = {this.handleCardClick} 
          style={{ 
            border: this.state.selected ? '3px solid red' : 'none',
          }}
        >
          <Card.Img variant="top" src={img} className="book-image"/>
          <Card.Body>
            <Card.Title 
              style = {{ fontSize: 'medium', margin: '0' }}>
                {title}
            </Card.Title>
          </Card.Body>
        </Card>

        {this.state.selected && <CommentArea asin = {this.props.book} />}
      </div>
    );
  }
}
  
//l'export devo sempre farlo altrimenti non potro avere il componente da mettere in app.js

export default SingleBook;

