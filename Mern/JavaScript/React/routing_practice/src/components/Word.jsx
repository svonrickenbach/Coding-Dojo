import React from 'react';
import { useParams } from "react-router-dom";

const Word = (props) => {

    const { word } = useParams();

    if (isNaN(word)) {
    return <h2>The word is: {word}</h2>;
    }

}
export default Word;