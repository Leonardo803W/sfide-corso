import React, { useState } from 'react';
import SingleBook from './SingleBook';
import { Form, Row, Col } from 'react-bootstrap';

const BookList = ({ fantasy, history, horror, romance, scifi }) => {
    const categories = {
        fantasy,
        history,
        horror,
        romance,
        scifi
    };

    const [searchTerm, setSearchTerm] = useState('');
    const [selectedCategory, setSelectedCategory] = useState('');

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
    };

    const handleCategoryChange = (event) => {
        setSelectedCategory(event.target.value);
    };

    const filteredBooks = Object.values(categories)
        .flat()
        .filter(book => {
            const matchesCategory = selectedCategory ? book.category === selectedCategory : true;
            const matchesSearchTerm = book.title.toLowerCase().includes(searchTerm.toLowerCase());
            return matchesCategory && matchesSearchTerm;
        });

    return (
        <>
            <div className=' d-flex justify-content-between'>
                <Form.Group controlId="category-select" className=' w-50 m-1'>
                    <Form.Label></Form.Label>
                    <Form.Control as="select" onChange={handleCategoryChange} value={selectedCategory}>
                        <option value="">Do you want to change?</option>
                        <option value="fantasy">Fantasy</option>
                        <option value="history">History</option>
                        <option value="horror">Horror</option>
                        <option value="romance">Romance</option>
                        <option value="scifi">Science Fiction</option>
                    </Form.Control>
                </Form.Group>

                <Form className='pb-5 w-50 m-1'>
                    <Form.Group>
                        <Form.Label></Form.Label>
                        <Form.Control
                            placeholder='Search Books'
                            type="text"
                            value={searchTerm}
                            onChange={handleSearchChange}
                        />
                    </Form.Group>
                </Form>
            </div>

            <Row xs={1} md={2} lg={4}>
                {filteredBooks.map(book => (
                    <Col key={book.id}>
                        <SingleBook
                            title={book.title}
                            img={book.img}
                            price={book.price}
                            category={book.category}
                        />
                    </Col>
                ))}
            </Row>
        </>
    );
};

export default BookList;