import React from 'react'
import useAuth from '../hooks/useAuth'

const Explore = () => {
    const { auth } = useAuth();
    console.log(auth);

  return (
    <div>
      Welcome, {auth.username}!
    </div>
  )
}

export default Explore
