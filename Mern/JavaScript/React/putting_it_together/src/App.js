import './App.css';
import Person from './components/person'

function App() {
  return (
    <div className="App">
        <Person firstName = {'Jane'} lastName = {'Doe'} age = {'25'} hairColor = {'black'} />
        <Person firstName = {'John'} lastName = {'Smith'} age = {'88'} hairColor = {'brown'} />
        <Person firstName = {'Millard'} lastName = {'Filmore'} age = {'50'} hairColor = {'brown'} />
        <Person firstName = {'Maria'} lastName = {'Smith'} age = {'62'} hairColor = {'brown'} />
    </div>
  );
}

export default App;
