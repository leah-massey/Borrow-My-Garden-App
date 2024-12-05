import React from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";
import useFetch from "../hooks/useFetch.tsx";

const GardenDetails = () => {
    const {gardenId} = useParams<{gardenId: string}>()
    const backendURL = import.meta.env.VITE_BACKEND_URL;
    const {data, isPending, error} = useFetch<Garden>(`${backendURL}/internal/gardens/` + gardenId)

    const navigate = useNavigate();

    function deleteGarden(){
        fetch(`${backendURL}/internal/gardens/${gardenId}`, {
            method: 'DELETE'
        }).then(response => {
            if (!response.ok) {
                throw new Error('Failed to delete garden');
            }
            console.log("your garden has been deleted ☠️")
            navigate("/gardens")
        }).catch(error => {
            console.error("There was an error with the fetch request:", error);
        })
    }

    return (
            <div className="garden-details garden-list flex items-center justify-center mt-20">
                    <div className="bg-white  p-10 rounded-lg shadow-lg w-2/5">
                        {error && <div>{error}</div>}
                        {isPending && <div>Loading...</div>}
                        {data && <h3 className="font-bold text-2xl mb-4">{data?.title}</h3>}
                        {data &&  <p>{data?.description}</p>}
                        <button
                            onClick={deleteGarden}
                            className="text-sm font-semibold leading-6 text-gray-900 bg-gray-400 rounded-md p-2 md-2">
                            Delete
                        </button>
                    </div>
            </div>
    )
}

export default GardenDetails