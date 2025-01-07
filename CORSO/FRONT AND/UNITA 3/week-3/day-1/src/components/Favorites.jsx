import { Container, Row, Col } from "react-bootstrap"
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'

const Favorites = () => {
  
  const favorites = useSelector(state => state.favorites)

  return (
    <Container>
      <Row>
        <Col>
          <h1 className="display-4">Favorite Companies</h1>
          {favorites.length === 0 ? (
            <p>No favorite companies added yet.</p>
          ) : (
            favorites.map(company => (
              <Link key={company} to={`/${company}`}>
                <h5>{company}</h5>
              </Link>
            ))
          )}
        </Col>
      </Row>
    </Container>
  );
};

export default Favorites