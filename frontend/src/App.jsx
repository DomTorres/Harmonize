import { Routes, Route } from 'react-router-dom'
import SignIn from './pages/SignIn'
import Explore from './pages/Explore'

function App() {
  return (
    <Routes>
      <Route path='signin' element={<SignIn />}/>
      <Route path='explore' element={<Explore />}/>
    </Routes>
  )
}

export default App
