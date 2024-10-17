import React, {useState} from "react";

import GardenForm from "./GardenForm.tsx";
import { useParams } from 'react-router-dom';
import useFetch from "../hooks/useFetch.tsx";
import {Garden} from "../pages/gardens/GardensPage.tsx";


const EditGardenForm = () => {
    const {gardenId} = useParams()

    const {data, isPending, error} = useFetch<Garden>('http://localhost:9000/internal/gardens/' + gardenId)
    console.log(data)


    return <GardenForm data={data}/>
}

export default EditGardenForm