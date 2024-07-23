
import './App.css';
import {Component} from "react";


interface Garden {
  id: string;
  createdTimestamp: string;
  title: string;
  description: string;
  gardenOwnerFirstName: string;
  gardenStatus: string;
  gardenOwnerId: string;
}

interface AppState {
  isLoading: boolean;
  gardens: Garden[];
}

class App extends Component<{ }, AppState> {
  state: AppState = {
    isLoading: true,
    gardens: []
  }

  async componentDidMount () {
    try {
      console.log("Fetching gardens...");
    const response = await fetch('http://localhost:9000/api/gardens');
    const body = await response.json();
      console.log("API response:", body);
    this.setState({gardens: body, isLoading: false});
      console.log("State after fetching:", this.state);
    } catch (error: unknown) {
      if (error instanceof Error) {
        console.error('Error fetching gardens:', error.message);
      } else {
      console.error('Error fetching gardens:', error);
      }
    }
  }

  render() {
    const {gardens, isLoading} = this.state;
    console.log("Rendering component. isLoading:", isLoading, "gardens:", gardens);

    if (isLoading) {
      return <p>Loading...</p>;
    }
    return (
        <div className="App">
          <header className="App-header">
            <h2>Garden List</h2>
            {gardens.map(garden =>
                <div key={garden.id}>
                  {garden.title}
                </div>
            )}
          </header>
        </div>
    );
}
}

export default App;
