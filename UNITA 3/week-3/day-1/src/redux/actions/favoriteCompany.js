export const ADD_FAVORITE = 'ADD_FAVORITE';
export const REMOVE_FAVORITE = 'REMOVE_FAVORITE';
export const SET_JOBS = 'SET_JOBS';
export const SET_LOADING = 'SET_LOADING';
export const SET_ERROR = 'SET_ERROR';

export const addFavorite = (company) => ({
    type: ADD_FAVORITE,
    payload: company,
  });
  
  export const removeFavorite = (company) => ({
    type: REMOVE_FAVORITE,
    payload: company,
  });
  
  export const setJobs = (jobs) => ({
    type: SET_JOBS,
    payload: jobs,
  });
  
  export const setLoading = (isLoading) => ({
    type: SET_LOADING,
    payload: isLoading,
  });
  
  export const setError = (error) => ({
    type: SET_ERROR,
    payload: error,
  });
  
  export const fetchJobs = (company) => async (dispatch) => {
    
    dispatch(setLoading(true))
    dispatch(setError(null))
  
    const baseEndpoint = "https://strive-benchmark.herokuapp.com/api/jobs?company=";
    
    try {
      const response = await fetch(baseEndpoint + company);
      if (response.ok) {
        const { data } = await response.json();
        dispatch(setJobs(data));
      } else {
        throw new Error("Error fetching results");
      }
    } catch (error) {
      dispatch(setError(error.message));
    } finally {
      dispatch(setLoading(false));
    }
  };