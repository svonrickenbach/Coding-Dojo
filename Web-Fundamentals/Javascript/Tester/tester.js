// var nameTag = document.querySelector("#name-tag");

// function setName(element) {
//     console.log(element.value);
//     nameTag.innerText = element.value;
// }


// function add(num3, num4) {
//     sum = num3 + num4 
//     console.log(sum)
//     return sum
// }

// var today = new Date(); 
// if(today.getDay() == 1){
//     console.log("I hate Mondays!");
// }

// if(today.getDay() != 1) {
//     console.log("Today is alright!")
// }


// var today = new Date(); 
// if(today.getDay() == 1){
//     console.log("I hate Mondays!");
// }

// else{
//     console.log("Today is alright!")
// }

// var start = 1;
// var end = 10;

// while(start <= end) {
//     console.log("Pinche way" + start);
//     start++;
// }

// Print numbers 1-100 
// for multiples of 3 print fizz
// for multiples of 5 print buzz 
// for numbers that are a multiple of both 3 and 5 write fizzbuzz


for (let i = 1; i <= 100; i++) {
    if(i % 3 == 0 && i % 5 == 0) {
        console.log("fizzbuzz")
    }
    else if(i % 5 == 0) {
        console.log("buzz")
    }
    else if(i % 3 == 0) {
        console.log("fizz")
    }
    else {
        console.log(i)
    }
}
