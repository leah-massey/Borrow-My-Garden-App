import React, {useEffect, useState} from 'react'
import {Link} from "react-router-dom";
import GardenPage from "../garden/GardenPage.tsx";
import GardenList from "../../components/GardenList.tsx";

export interface Garden {
    id: string;
    createdTimestamp: string;
    title: string;
    description: string;
    gardenOwnerFirstName: string;
    gardenStatus: string;
    gardenOwnerId: string;
}

const GardensPage = () => {
    const [gardens, setGardens] = useState<Garden[]>([])

    useEffect(() => {
        const fetchGardens = async () => {
            try {
                const response = await fetch('http://localhost:9000/internal/gardens');
                const body = await response.json();
                setGardens(body);
            }
            catch (error: unknown) {
                if (error instanceof Error) {
                    console.error("error fetching gardens", error.message)
                } else {
                    console.error('Error fetching gardens:', error)
                }
            }
        }

        fetchGardens()
    }, [])

    return (
        <>
            <div>
                <h1>Gardens List</h1>
                <GardenList gardens={gardens}/>
            </div>
        </>
    )
}

export default GardensPage
