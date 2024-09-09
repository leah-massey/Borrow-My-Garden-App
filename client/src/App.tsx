
import './App.css'
import GardensPage from "./pages/gardens/GardensPage.tsx";
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import Layout from "./components/Layout.tsx";
import HomePage from "./pages/homePage/HomePage.tsx";
import GardenDetails from "./components/GardenDetails.tsx";




const App = () => {

    return (

        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<HomePage />}/>
                    <Route path={"gardens"} element={<GardensPage />}/>
                    <Route path={"gardens/:gardenId"} element={<GardenDetails />} />
                </Route>
            </Routes>
        </BrowserRouter>


    )

}

export default App
