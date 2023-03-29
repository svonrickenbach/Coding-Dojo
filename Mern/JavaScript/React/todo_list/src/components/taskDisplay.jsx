import React, {useState} from 'react';

const TaskDisplay = (props) => {
    // console.log(props);
    const {taskList, setTaskList} = props
    console.log(taskList);

    return(
        <div>
            {
                taskList.map((task) => (
                    <div>
                        {/* why won't it itterate through the items in the task list?  */}
                        <h3>Task: {task} </h3>
                    </div>
                ))
            }
        </div>
    );
}

export default TaskDisplay;