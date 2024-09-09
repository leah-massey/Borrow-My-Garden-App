import React, {useEffect, useState} from 'react'
import {Link, useParams} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";

const GardenDetails = () => {
    const {gardenId} = useParams()
    console.log(`this is the garden id: ${gardenId}`)
    const [gardenDetails, setGardenDetails] = useState<Garden[]> (null)

    useEffect( () => {
        const fetchGardenDetails = async () => {
            try {
                const response = await fetch('http://localhost:9000/internal/gardens/' + gardenId);
                const body: Garden[] = await response.json();
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

    return (
            <div className="blog-details">
                {gardenDetails.map(garden => (
                    <div>
                        <h3>{garden.title}</h3>
                        <p>{garden.description}</p>
                    </div>
                ))}
            </div>

    )
}

export default GardenDetails