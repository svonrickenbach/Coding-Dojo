import React, { useState } from 'react';

const Demo = (props) => {
    const [text, setText] = useState("");
    setText("state state I am setting state!!!");
    console.log(text)
    return(
        <div>
            <h2>Hello World </h2>
        </div>
    )
}

export default Demo;