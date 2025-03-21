import { Component } from 'react'

import CommentList from './CommentList.jsx'
import AddComment from './AddComment.jsx'
import Loading from './Loading.jsx'
import Error from './Error.jsx'

class CommentArea extends Component {

  state = {

    comments: [],
    isLoading: true,
    isError: false,
  }

  componentDidMount = async () => {

    try {

      let response = await fetch(
        'https://striveschool-api.herokuapp.com/api/comments/' +
          this.props.asin,

        {
            method: 'GET',
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2QxY2JmMzI4ZWM3YjAwMTUyNmFhN2MiLCJpYXQiOjE3NDE4MDI0ODMsImV4cCI6MTc0MzAxMjA4M30.aZy2wxLpTNlaGgVObZOCKh86nTHRO7KL_fQwHBcaccs',
          },
        }
      )

      console.log(response)

      if (response.ok) {
        let comments = await response.json()
        this.setState({ comments: comments, isLoading: false, isError: false })
      } else {
        this.setState({ isLoading: false, isError: true })
      }
    } catch (error) {
      console.log(error)
      this.setState({ isLoading: false, isError: true })
    }
  }

  render() {
    return (
      <div className="text-center">
        {this.state.isLoading && <Loading />}
        {this.state.isError && <Error />}
        <AddComment asin = {this.props.asin} />
        <CommentList commentsToShow = {this.state.comments} />
      </div>
    )
  }
}

export default CommentArea
