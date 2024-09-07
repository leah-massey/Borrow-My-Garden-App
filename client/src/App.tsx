
import './App.css'
import GardensPage from "./pages/gardens/GardensPage.tsx";
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import Layout from "./components/Layout.tsx";




const App = () => {

    return (

        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<GardensPage />}/>
                </Route>
            </Routes>
        </BrowserRouter>


    )

}

export default App
