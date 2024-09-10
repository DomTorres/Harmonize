import React, { useContext, useEffect } from 'react'
import Navbar from '../components/Navbar';

const Explore = () => {
    // const { auth } = useContext(AuthContext); 
    // const user = auth;

    const user = { username: 'Dom' }

    return (
        <>
            <Navbar />
            <div>
            Welcome, {user.username}!
            </div>
        </>
    )
}

export default Explore
