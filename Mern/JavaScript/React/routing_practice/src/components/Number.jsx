import React from 'react';
import { useParams } from "react-router-dom";

const Number = (props) => {

    const { number } = useParams();

    if (isNaN(number)) {
        return <h2>Error: The path must contain a non-number value.</h2>;
    }
    return <h2>The number is: {number}</h2>;
    }

export default Number; 