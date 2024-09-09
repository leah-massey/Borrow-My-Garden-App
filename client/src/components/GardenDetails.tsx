import React, {useEffect, useState} from 'react'
import {Link, useParams} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";

const GardenDetails = () => {

    const {gardenId} = useParams<{gardenId: string}>()
    const [gardenDetails, setGardenDetails] = useState<Garden> ()

    useEffect( () => {
        const fetchGardenDetails = async () => {
            try {
                const response = await fetch('http://localhost:9000/internal/gardens/' + gardenId);
                const body: Garden = await response.json();
                setGardenDetails(body);
            }
            catch (error: unknown) {
                if (error instanceof Error) {
                    console.error(`error fetching garden ${gardenId}`, error.message)
                } else {
                    console.error(`Error fetching garden ${gardenId}:`, error)
                }
            }
        }
        fetchGardenDetails()
    }, []);

    if( !gardenDetails ){
        return <p>Loading...</p>
    }

    return (
            <div className="blog-details">
                    <div>
                        <h3>{gardenDetails.title}</h3>
                        <p>{gardenDetails.description}</p>
                    </div>
            </div>
    )
}

export default GardenDetails