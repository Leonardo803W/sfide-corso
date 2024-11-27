import React, { useState } from 'react';
import SingleBook from './SingleBook';
import { Form, Row, Col } from 'react-bootstrap';

const BookList = ({ books }) => 
{
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearchChange = (event) => 
    {
        setSearchTerm(event.target.value);
    };

  const filteredBooks = books.filter (book =>
    book.title.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <>
      <Form className=' pb-5'>
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

      <Row xs={1} md={2} lg={4}>
        {filteredBooks.map(book => (
          <Col key={book.id}>
            <SingleBook 
                title = {book.title} 
                img = {book.img} 
                price = {book.price} 
                category = {book.category} 
            />
          </Col>
        ))}
      </Row>
    </>
  );
};

export default BookList;



  