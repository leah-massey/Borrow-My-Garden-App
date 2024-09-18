
import './App.css'
import GardensPage from "./pages/gardens/GardensPage.tsx";
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import Layout from "./components/Layout.tsx";
import HomePage from "./pages/homePage/HomePage.tsx";
import GardenDetails from "./components/GardenDetails.tsx";
import AddGardenForm from "./components/AddGardenForm.tsx";




const App = () => {

    return (
<div className="bg-lime-100 min-h-screen w-full">
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<HomePage />}/>
                    <Route path={"gardens"} element={<GardensPage />}/>
                    <Route path={"gardens/:gardenId"} element={<GardenDetails />} />
                    <Route path={"add-garden"} element={<AddGardenForm />} />
                </Route>
            </Routes>
        </BrowserRouter>
</div>

    )

}

export default App
