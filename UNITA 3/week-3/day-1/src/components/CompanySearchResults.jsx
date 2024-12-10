import { useEffect } from "react"
import { Container, Row, Col, Button } from "react-bootstrap"
import Job from "./Job"
import { useParams } from "react-router-dom"
import { useDispatch, useSelector } from 'react-redux'
import { fetchJobs, addFavorite, removeFavorite } from './actions'

const CompanySearchResults = () => {

  const { company } = useParams()
  const dispatch = useDispatch()
  const { jobs, loading, error } = useSelector(state => state.jobs)
  const favorites = useSelector(state => state.favorites)

  useEffect(() => {

    dispatch(fetchJobs(company))

  }, [dispatch, company]);

  const toggleFavorite = () => {

    if (favorites.includes(company)) 
    {
      dispatch(removeFavorite(company))
    } 
    else 
    {
      dispatch(addFavorite(company))
    }
  };

  if (loading) return <div>Loading...</div>
  if (error) return <div>Error: {error}</div>

  return (
    <Container>
      <Row>
        <Col className="my-3">
          <h1 className="display-4">Job posting for: {company}</h1>
          <Button onClick={toggleFavorite}>
            {favorites.includes(company) ? "Remove from Favorites" : "Add to Favorites"}
          </Button>
          {jobs.map(jobData => (
            <Job key={jobData._id} data={jobData} />
          ))}
        </Col>
      </Row>
    </Container>
  );
};

export default CompanySearchResults;