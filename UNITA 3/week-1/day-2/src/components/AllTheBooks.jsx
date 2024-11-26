import { Component } from 'react';
import {Button, Card} from 'react-bootstrap'
import books from '../data/history.json'

class AllTheBooks extends Component {
    render () {
        return (
            <>
            {books.map((book) => {
                return (
                    <Card key={book.asin}>
                        <Card.Img variant="top" src="holder.js/100px180" />
                        <Card.Body>
                            <Card.Title>Card Title</Card.Title>
                            <Card.Text>
                            Some quick example text to build on the card title and make up the
                            bulk of the card's content.
                            </Card.Text>
                            <Button variant="primary">Go somewhere</Button>
                        </Card.Body>
                    </Card>
                    )
                })}
            </>
        )
    }
}

export default AllTheBooks