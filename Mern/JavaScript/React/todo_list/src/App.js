import './App.css';
import { useState } from 'react';
import TaskForm from './components/taskForm'
import TaskDisplay from './components/taskDisplay'

function App() {
  const [taskList, setTaskList] = useState([]);
  return (
    <div className="App">
      <TaskForm taskList={taskList} setTaskList={setTaskList} /> 
      <TaskDisplay taskList={taskList} setTaskList={setTaskList} /> 
    </div>
  );
}

export default App;
