import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

interface Garden {
    id: string;
    createdTimestamp: string;
    title: string;
    description: string;
    gardenOwnerFirstName: string;
    gardenStatus: string;
    gardenOwnerId: string;
}


function App() {
    const [gardens, setGardens] = useState<Garden[]>([])

    useEffect(() => {
        const fetchGardens = async () => {
            try {
                const response = await fetch('http://localhost:9000/gardens');
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
    })



  return (
    <>
      <div>
      <h1>Gardens List</h1>
          {gardens.map(garden => (
              <div key = {garden.id}>
                  {garden.title}
              </div>
          ))}
      </div>
    </>
  )
}

export default App
