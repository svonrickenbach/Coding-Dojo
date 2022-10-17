var abutton  = document.querySelector("#a1")
var rbutton = document.querySelector("#rej1")
var name1 = document.querySelector("#l1")
var pic1 = document.querySelector("#pic1")

var abutton2  = document.querySelector("#a2")
var rbutton2 = document.querySelector("#rej2")
var name2 = document.querySelector("#l2")
var pic2 = document.querySelector("#pic2")

// reduces connection requests by one and adds to "your connections" when pressing the first accept button

// function hide1() {
//     abutton.remove()
//     rbutton.remove()
//     name1.remove()
//     pic1.remove()
//     sub()
//     add()
// }                                       

// reduces connection requests by one when pressing the first reject button

// var abutton2  = document.querySelector("#a2")
// var rbutton2 = document.querySelector("#rej2")
// var name2 = document.querySelector("#l2")
// var pic2 = document.querySelector("#pic2")

// function hide2() {
//     abutton2.remove()
//     rbutton2.remove()
//     name2.remove()
//     pic2.remove()
//     sub()
//     add()
// }

// // reduces connection requests by one and adds to "your connections" when pressing the second accept button

// function hide3() {
//     abutton.remove()
//     rbutton.remove()
//     name1.remove()
//     pic1.remove()
//     sub()
// }

// // reduces connection requests by one to when pressing the second reject button

// function hide4() {
//     abutton2.remove()
//     rbutton2.remove()
//     name2.remove()
//     pic2.remove()
//     sub()
// }

// subtracts from connection requests

var count1 = 2
var element = document.querySelector(".reqnum")

function sub() {
    count1--
    element.innerText = count1
}

// adds to your connections

var count2 = 500
var connection = document.querySelector("#connectnum")

function add() {
    count2++
    connection.innerText = count2 
}

// changes profile name

var username = document.querySelector("h2")

function changename() {
    username.innerText = "Sam Rickenbach"
}


var req1 = document.querySelectorAll(".req1")
var req2 = document.querySelectorAll(".req2")

console.log(req1)

function hide() {
    for (let index = 0; index < req1.length; index++) {
        console.log(req1[index])
        req1[index].remove()
    }
    add()
    console.log(req1)
}
console.log(hide)


function hide2() {
    for (let index = 0; index < req2.length; index++) {
        req2[index].remove()
    }
}