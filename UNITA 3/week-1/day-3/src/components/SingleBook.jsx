import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';

class SingleBook extends Component 
{
  constructor(props) 
  {

    super(props);
    this.state = {selected: false,};
  }

  toggleSelect = () => 
    {
        this.setState((prevState) => ({ selected: !prevState.selected }));
    };

  render() 
  {
    const { title } = this.props;
    const { img } = this.props;
    const { price } = this.props;
    const { category } = this.props;
    const { selected } = this.state;
    
    return (
      <Card style={{ 
          border: selected ? '2px solid red' : 'none',
          cursor: 'pointer'
        }}
        onClick = {this.toggleSelect}
      >
        <Card.Img src = {img} alt = {img + title}/>
        <Card.Body>
            <Card.Title>{title}</Card.Title>
            <Card.Text>
                price {price}
            </Card.Text>
            <Card.Text>
                category {category}
            </Card.Text>
            <Button variant="primary">push me</Button>
        </Card.Body>
      </Card>
    );
  }
}

export default SingleBook;