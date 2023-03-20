import './App.css';
import Person from './components/person'
import React, {useState} from 'react';

function App() {
  // const [text, setText] = useState("");
  // setText("state state I am setting state!!!");
  // console.log(text);
  return (
    <div className="App">
      <Person firstName = {'Jane'} lastName = {'Doe'} age = {'25'} hairColor = {'black'} />
      <Person firstName = {'John'} lastName = {'Smith'} age = {'88'} hairColor = {'brown'} />
      <Person firstName = {'Millard'} lastName = {'Filmore'} age = {'50'} hairColor = {'brown'} />
      <Person firstName = {'Maria'} lastName = {'Smith'} age = {'62'} hairColor = {'brown'} />
      <button onClick={ ()=> alert("This Button has been clicked!") }> Click Me </button> 
    </div>
  );
}

export default App;
