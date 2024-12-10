import { ADD_FAVORITE, REMOVE_FAVORITE } from './actionTypes'

const favoritesReducer = (state = [], action) => {

  switch (action.type) 
  {
    case ADD_FAVORITE:
      return [...state, action.payload]

    case REMOVE_FAVORITE:
      return state.filter(company => company !== action.payload)

    default:
      return state
  }
};

export default favoritesReducer