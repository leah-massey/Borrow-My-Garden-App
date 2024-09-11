import React, {useEffect, useState} from 'react'
import GardenList from "../../components/GardenList.tsx";
import useFetch from "../../hooks/useFetch.tsx";

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
    const {data, isPending, error} = useFetch('http://localhost:9000/internal/gardens')

    return (
            <div className="gardenList">
                <h1>Gardens List</h1>
                {error && <div>{error}</div>}
                {isPending && <div>Loading...</div>}
                {data && <GardenList gardens={data}/>}
            </div>
    );
}

export default GardensPage
