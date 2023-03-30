import React, {useState} from 'react';

const TaskForm = (props) => {
    // console.log(props);
    const {taskList, setTaskList} = props
    const [todoItem, setTodoItem] = useState({
        task: '',
        taskComplete: false
});

    const createTask = (e) => {
        e.preventDefault();


        setTaskList([...taskList, todoItem])
        
        setTodoItem({
            task: '',
            taskComplete: false
        });

    }

    const handleTask = (e) => {
        console.log(e);
        setTodoItem({...todoItem, [e.target.name]:e.target.value});
    }

    return(
        <div>
            <form onSubmit={createTask}>
                <div>
                    <label> To Do: </label>
                    <input type="text" name="task" value={todoItem.task} onChange= { handleTask } />
                    <input type="hidden" name='taskComplete' value={todoItem.taskComplete} onChange= { handleTask }/>
                </div>
                <div>
                        <input type="submit" value="Add Task" />
                </div>
            </form>
        </div>
    );
}

export default TaskForm;