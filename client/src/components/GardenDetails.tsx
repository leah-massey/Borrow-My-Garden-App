import React, {useEffect, useState} from 'react'
import {Link, useParams} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";
import useFetch from "../hooks/useFetch.tsx";
import GardenList from "./GardenList.tsx";

const GardenDetails = () => {
    const {gardenId} = useParams<{gardenId: string}>()
    const {data, isPending, error} = useFetch<Garden>('http://localhost:9000/internal/gardens/' + gardenId)

    return (
            <div className="garden-details">
                    <div>
                        {error && <div>{error}</div>}
                        {isPending && <div>Loading...</div>}
                        {data && <h3>{data?.title}</h3>}
                        {data &&  <p>{data?.description}</p>}
                    </div>
            </div>
    )
}

export default GardenDetails