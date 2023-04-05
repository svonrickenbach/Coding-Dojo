import React from 'react';
import { useParams } from "react-router-dom";

const Color = (props) => {

    const { word, textColor, backgroundColor } = useParams();

    return(
        <div>
            <h1 style={{backgroundColor:backgroundColor, color:textColor}}>The word is: {word} !</h1>
        </div>
    );
}

export default Color;