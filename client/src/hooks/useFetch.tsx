import {useEffect, useState} from "react";

    function useFetch<T>(url: string) {
        const [data, setData] = useState<T | null>(null);  // Supports both single objects and lists
        const [isPending, setIsPending] = useState(true);
        const [error, setError] = useState<string | null>(null);

        useEffect(() => {
            const fetchData = async () => {
                try {
                    const response = await fetch(url);
                    if (!response.ok) {
                        throw new Error(`Failed to fetch: ${response.statusText}`);
                    }
                    const result: T = await response.json();  // Infer the type based on how the hook is used
                    setData(result);
                    setIsPending(false);
                } catch (err) {
                    setError((err as Error).message);
                    setIsPending(false);
                }
            };
            fetchData();
        }, [url]);

        return { data, isPending, error };
    }
export default useFetch

