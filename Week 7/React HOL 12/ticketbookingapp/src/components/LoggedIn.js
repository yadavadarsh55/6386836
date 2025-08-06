import React from 'react'

export const LoggedIn = (props) => {
  return (
    <div>
        <h1>Welcome to the Ticket Booking App</h1>
        <p>You are logged in. You can now book your tickets.</p>
        <button onClick={props.handleLogout}>Logout</button>

    </div>
  )
}
