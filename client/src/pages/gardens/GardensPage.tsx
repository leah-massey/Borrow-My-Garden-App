import React, {useEffect, useState} from 'react'
import GardenList from "../../components/GardenList.tsx";
import useFetch from "../../hooks/useFetch.tsx";
import {UUID} from "node:crypto";

export interface Garden {
    id: string;
    createdTimestamp: string;
    title: string;
    description: string;
    gardenOwnerFirstName: string;
    gardenStatus: string;
    gardenOwnerId: UUID;
}

const GardensPage = () => {
    const backendURL = import.meta.env.VITE_BACKEND_URL
    const {data, isPending, error} = useFetch<Garden[]>(`${backendURL}/internal/gardens`)

    return (
            <div className="garden-list flex items-center justify-center mt-20 ">
                <section className=" bg-white  p-10 rounded-lg shadow-lg w-2/5">
                <h1 className="font-bold text-2xl">Gardens List</h1>
                {error && <div>{error}</div>}
                {isPending && <div>Loading...</div>}
                {data && <GardenList gardens={data}/>}
                </section>
            </div>
    );
}

export default GardensPage
