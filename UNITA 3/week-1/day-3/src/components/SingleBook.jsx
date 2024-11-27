import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';

class SingleBook extends Component 
{
    state = {
        selected: false,
    }

    toggleSelect = () => {
        this.setState(prevState => ({
            selected: !prevState.selected
        }));
    };

    render() 
    {
        const { title, img, price, category } = this.props;
        const { selected } = this.state;
        const borderColor = selected ? 'red 2px solid' : 'black 2px solid';

        return (
            <Card style={{ 
                    border: borderColor,
                    cursor: 'pointer'
                }}
                className=' m-2'
                onClick={this.toggleSelect}
            >
                <Card.Img src={img} alt={img + title} />
                <Card.Body>
                    <Card.Title>{title}</Card.Title>
                    <Card.Text>
                        Price: {price}$
                    </Card.Text>
                    <Card.Text>
                        Category: {category}
                    </Card.Text>
                    <Button variant="primary">Push me</Button>
                </Card.Body>
            </Card>
        );
    }
}

export default SingleBook