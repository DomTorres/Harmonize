import { Routes, Route } from 'react-router-dom'
import SignIn from './pages/SignIn'
import Explore from './pages/Explore'
import Chats from './pages/Chats'
import ProtectedRoute from './components/ProtectedRoute'

function App() {
    return (
        <Routes>
            <Route path='signin' element={<SignIn />}/>
            <Route path='explore' element={<ProtectedRoute><Explore /></ProtectedRoute>}/>
            <Route path='chats' element={<ProtectedRoute><Chats /></ProtectedRoute>}></Route>
        </Routes>
    )
}

export default App
