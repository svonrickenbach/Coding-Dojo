import React from 'react';

const Person = (props) => {
    const { firstName, lastName, age, hairColor } = props
    return(
        <div>
            <h2>{lastName}, {firstName} </h2>
            <p>Age: {age}</p>
            <p>Hair Color: {hairColor}</p>
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