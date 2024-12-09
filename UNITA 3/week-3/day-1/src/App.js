import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import MainSearch from "./components/MainSearch";
import CompanySearchResults from "./components/CompanySearchResults";
import { Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={MainSearch} />
        <Route path="/:company" component={CompanySearchResults} />
        <Route path="/favourites" component={Favorites} />
      </Switch>
    </Router>
  );
}

export default App;
