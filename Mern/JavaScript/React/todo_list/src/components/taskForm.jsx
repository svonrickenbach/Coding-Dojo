import React, {useState} from 'react';

const TaskForm = (props) => {
    // console.log(props);
    const {taskList, setTaskList} = props
    const [task, setTask] = useState("s");

    const createTask = (e) => {
        e.preventDefault();

        const newTask = {task};

        setTaskList([...taskList, task])
        
        setTask("");

    }

    const handleTask = (e) => {
        console.log(e);
        setTask(e.target.value);
    }

    return(
        <div>
            <form onSubmit={createTask}>
                <div>
                    <label> Task: </label>
                    <input type="text" value={task} onChange= { handleTask } />
                </div>
                <div>
                        <input type="submit" value="Add Task" />
                </div>
            </form>
        </div>
    );
}

export default TaskForm;