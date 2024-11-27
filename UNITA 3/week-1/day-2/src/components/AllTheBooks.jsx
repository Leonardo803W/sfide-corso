import { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import books from '../data/history.json';

class AllTheBooks extends Component {
    render() {
        return (
            <>
                {books.map((book) => {
                    return (
                        <div className='col-3' key={book.asin}>
                            <Card>
                                <img src={book.img} alt={'foto copertina ' + book.title} />
                                <Card.Body>
                                    <h3>{book.title}</h3>
                                    <p>{book.price}</p>
                                    <Button variant="primary">{book.category}</Button>
                                </Card.Body>
                            </Card>
                        </div>
                    );
                })}
            </>
        );
    }
}

export default AllTheBooks;