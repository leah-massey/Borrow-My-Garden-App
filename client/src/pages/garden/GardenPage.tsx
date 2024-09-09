import React, {useEffect, useState} from 'react'
import {Garden} from "../gardens/GardensPage.tsx";

const GardenPage = (props) => {
    const {state} = props
    const {gardenId} = state;


    const [garden, setGarden] = useState<Garden>()

    useEffect(() => {
        const fetchGarden = async () => {
            try {
                const response = await fetch('http://localhost:9000/internal/gardens/{gardenId}')
                const body = await response.json();
                setGarden(body);
            }
            catch (error: unknown) {
                if (error instanceof Error) {
                    console.error("error fetching garden GARDEN NAME", error.message)
                } else {
                    console.error('Error fetching garden GARDEN NAME:', error)
                }
            }
        }
        fetchGarden()
    }, [])




    return (
        <div>
            <h1>{garden?.title}</h1>
        </div>

    )
}

export default GardenPage
