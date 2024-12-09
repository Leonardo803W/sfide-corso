import { useEffect, useState } from "react"
import { Container, Row, Col, Button } from "react-bootstrap"
import Job from "./Job"
import { useParams } from "react-router-dom"
import { useDispatch, useSelector } from 'react-redux'
import { addFavorite, removeFavorite } from './redux/favoritesSlice'

const CompanySearchResults = () => {
  const [jobs, setJobs] = useState([])
  const params = useParams()
  const dispatch = useDispatch()
  const favorites = useSelector(state => state.favorites)

  const baseEndpoint = "https://strive-benchmark.herokuapp.com/api/jobs?company="

  useEffect(() => {
    getJobs();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const getJobs = async () => {
    try {
      const response = await fetch(baseEndpoint + params.company);
      if (response.ok) {
        const { data } = await response.json()
        setJobs(data);
      } else {
        alert("Error fetching results")
      }
    } catch (error) {
      console.log(error)
    }
  };

  const toggleFavorite = () => {
    const companyName = params.company;
    if (favorites.includes(companyName)) {
      dispatch(removeFavorite(companyName))
    } else {
      dispatch(addFavorite(companyName))
    }
  };

  return (
    <Container>
      <Row>
        <Col className="my-3">
          <h1 className="display-4">Job posting for: {params.company}</h1>
          <Button onClick={toggleFavorite}>
            {favorites.includes(params.company) ? "Remove from Favorites" : "Add to Favorites"}
          </Button>
          {jobs.map(jobData => (
            <Job key={jobData._id} data={jobData} />
          ))}
        </Col>
      </Row>
    </Container>
  );
};

export default CompanySearchResults