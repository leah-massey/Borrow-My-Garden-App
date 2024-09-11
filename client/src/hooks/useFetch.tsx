import {useEffect, useState} from "react";
import {Garden} from "../pages/gardens/GardensPage.tsx";

function useFetch(url) {

    const [data, setData] = useState([])
    const [isPending, setIsPending] = useState(true)
    const [error, setError] = useState(null)

    useEffect(() => {
        // const fetchGardens = async () => {
        //     try {
        //         const response = await fetch('http://localhost:9000/internal/gardens');
        //         const body = await response.json();
        //         setGardens(body);
        //     }
        //     catch (error: unknown) {
        //         if (error instanceof Error) {
        //             console.error("error fetching gardens", error.message)
        //         } else {
        //             console.error('Error fetching gardens:', error)
        //         }
        //     }
        // }
        //
        // fetchGardens()
        setTimeout(() => {
            fetch(url)
                .then(response => {
                    if(!response.ok) {
                        throw Error('could not fetch the data for that resource');
                    }
                    return response.json()
                })
                .then(returnedData => {
                    setData(returnedData)
                    setIsPending(false)
                })
                .catch(err => {
                    setIsPending(false)
                    setError(err.message)
                })
        }, 1000)
    }, [])

    return {data, isPending, error}
}

export default useFetch;