import React from 'react';
import { useParams } from "react-router-dom";

const Color = (props) => {

    const { word, textColor, backgroundColor } = useParams();

    return(
        <div>

            {
                isNaN(word)?
                <p style={
                    textColor?
                    {color: textColor, backgroundColor: backgroundColor}
                    :null
                }>
                    This is the word: {word}
                </p>
                :
                <p>
                    This is a number: {word}
                </p>
            }
            {/* <h1 style={{backgroundColor:backgroundColor, color:textColor}}>The word is: {word} !</h1> */}
        </div>
    );
}

export default Color;