import React, {useEffect, useState} from 'react'
import {Link, useParams} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";
import useFetch from "../hooks/useFetch.tsx";
import GardenList from "./GardenList.tsx";
import {Box, Button, Center, Text} from "@chakra-ui/react";

const GardenDetails = () => {
    const {gardenId} = useParams<{gardenId: string}>()
    const {data, isPending, error} = useFetch<Garden>('http://localhost:9000/internal/gardens/' + gardenId)

    return (
            <div className="garden-details garden-list flex items-center justify-center mt-20">
                    <div className="bg-white  p-10 rounded-lg shadow-lg w-2/5">

                        {error && <div>{error}</div>}
                        {isPending && <div>Loading...</div>}
                        {data && <Text colour="black" >{data?.title}</Text>}
                        {data &&  <p>{data?.description}</p>}
                        <Button colorScheme='blue' margin="20px">Edit</Button>
                    </div>


        </div>
    )
}

export default GardenDetails