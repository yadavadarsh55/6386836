import React from 'react'

export const LoggedOut = (props) => {
  return (
    <div>
        <h1>Welcome to the Ticket Booking App</h1>
        <p>Please log in to book your tickets.</p>
        <button onClick={props.handleLogin}>Login</button>
    </div>
  )
}
