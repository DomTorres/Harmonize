import React, { useContext } from 'react'
import AuthContext from '../contexts/AuthProvider'
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ children }) => {
    // const { auth } = useContext(AuthContext); 

    // if (!auth) {
    //     return <Navigate to="/signin" replace />;
    // }

    return children;
}

export default ProtectedRoute
