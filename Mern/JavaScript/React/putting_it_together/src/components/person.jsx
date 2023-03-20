import React, {useState} from 'react';

const Person = (props) => {
    const {firstName, lastName, age, hairColor} = props 
    // In the answer key, they didn't have to cast age as a number. Why do I have to?
    const [state, setState] = useState(+age);

    const increaseBirthday = () => {
        setState(
            (state + 1)
        );
    }

        return(
            <div>
                <h2>{lastName}, {firstName}</h2>
                <p>Age: {state} </p>
                <p>Hair Color: {hairColor} </p>
                <button onClick = { increaseBirthday }> Birthday Button for {firstName} {lastName}</button>
            </div>
        )
}

export default Person; 