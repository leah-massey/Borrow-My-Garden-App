import React, { useState, useEffect } from 'react';
import './App.css';

interface Garden {
  id: string;
  createdTimestamp: string;
  title: string;
  description: string;
  gardenOwnerFirstName: string;
  gardenStatus: string;
  gardenOwnerId: string;
}

const App: React.FC = () => {
  const [gardens, setGardens] = useState<Garden[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchGardens = async () => {
      try {
        const response = await fetch('http://localhost:9000/api/gardens');
        const body = await response.json();
        setGardens(body); // Set gardens in state
        setIsLoading(false); // Set loading to false after fetching data
      } catch (error: unknown) {
        if (error instanceof Error) {
          console.error('Error fetching gardens:', error.message);
        } else {
          console.error('Error fetching gardens:', error);
        }
      }
    };

    fetchGardens(); // Fetch gardens on component mount
  }, []); // Empty dependency array ensures the effect runs only once when the component mounts

  if (isLoading) {
    return <p>Loading...</p>;
  }

  return (
      <div className="App">
        <header className="App-header">
          <h2>Garden List</h2>
          {gardens.map(garden => (
              <div key={garden.id}>
                {garden.title}
              </div>
          ))}
        </header>
      </div>
  );
};

export default App;
