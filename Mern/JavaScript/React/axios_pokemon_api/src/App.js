import {useState, useEffect} from 'react'
import axios from 'axios'
import './App.css';

function App() {
  
  const [pokemon, setPokemon] = useState([])

  useEffect(() => {
    axios.get('https://pokeapi.co/api/v2/pokemon?limit=808&offset=0')
    .then((response) => {
      console.log(`Response: ${response}`);
      console.log(response);
      setPokemon(response.data.results)
    })
    .catch((err) => {
      console.log(err);
    })
  }, [])

  // console.log(pokemon());

  return (
    <div className="App">
      <h1>Pokemon API</h1>
      {
        pokemon.map((character, idx) => (
            <h2>
              {idx}. { character.name}
            </h2>
        ))
        }
    </div>
  );
}

export default App;
