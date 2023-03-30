import React from 'react';
import './taskDisplay.css'

const TaskDisplay = (props) => {
    // console.log(props);
    const {taskList, setTaskList} = props
    console.log(taskList);
    // const [taskComplete, setTaskComplete] = useState(false)

    const toggleTask = (task) => {
        const updatedTaskList = taskList.map((item) => {
            if(item === task){
                item.taskComplete = !item.taskComplete
            }
            return item
        })
        setTaskList(updatedTaskList)
    }

    const deleteHandler = (task) => {
        const updatedTaskList = taskList.filter((item) => item !== task)
        setTaskList(updatedTaskList)
    }

    return(
        <div>
            {
                taskList.map((task, idx) => (
                    <div key={idx}>
                        {
                            task.taskComplete?
                            <h3 className='line-through'> {idx+1}. {task.task}</h3>: 
                            <h3>{idx+1}. {task.task} </h3>
                        }
                        <input type="checkbox" name="taskComplete" onClick={() => toggleTask(task)}/>
                        <button onClick={() => deleteHandler(task)}>Delete</button>
                    </div>
                ))
            }
        </div>
    );
}

export default TaskDisplay;