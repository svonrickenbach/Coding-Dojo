import React, { useState } from 'react';

const Person = (props) => {
    const [state, setState] = useState({
        clickCount: 0
    })

    const handleClick = () => {
        setState({
            // Is this creating a copy of the state somewhere, or is state updated "in place"?
            clickCount: state.clickCount + 1
        });
    }
    // console.log(state);
    const { firstName, lastName, age, hairColor } = props
    return(
        <div>
            <h2>{lastName}, {firstName} </h2>
            <p>Age: {age}</p>
            <p>Hair Color: {hairColor}</p>
            <div>
                {/* why does this show up on page even though it's not being called in App.js? Because it the <Person/> tag grabs everything from the person component, it's just not passing anything back this way.*/}
                { state.clickCount }
                <button onClick = { handleClick }>Click Me</button>
            </div>
        </div>
    )
}

export default Person;


// const Person = (props) => {

//     return(
//         <div>
//             <h2>{props.lastName}, {props.firstName} </h2>
//             <p>Age: {props.age}</p>
//             <p>Hair Color: {props.hairColor}</p>
//         </div>
//     )
// }

// export default Person;