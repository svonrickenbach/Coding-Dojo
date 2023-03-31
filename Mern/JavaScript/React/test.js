import React, { useState } from 'react';

// const [text, setText] = useState("");
// setText("state state I am setting state!!!");
// console.log(text);

// const [state, setState] = useState({
//     items: [],
//     totalPrice: 0.00
// });
// setState({ items: state.items, totalPrice: state.totalPrice + 10.99 });
// console.log(state.items);

const noMondays = new Promise( (resolve, reject) => {
    if(new Date().getDay() !== 4) {
        resolve("Good, it's not Monday!");
    } else {
        reject("Someone has a case of the Mondays!");
    }
    console.log(new Date().getDay());
});
noMondays
    .then( res => console.log(res) )
    .catch( err => console.log(err) );