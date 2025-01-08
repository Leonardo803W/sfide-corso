import { configureStore } from '@reduxjs/toolkit'
import favoritesReducer from './favoritesReducer'
import jobsReducer from './jobsReducer'

const store = configureStore({
  reducer: 
  {
    favorites: favoritesReducer,
    jobs: jobsReducer,
  },
})

export default store