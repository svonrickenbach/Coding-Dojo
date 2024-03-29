// var beatles = ['Paul', 'George', 'John', 'Ringo'];
// function printNames(names) {
//     function actuallyPrintingNames() {
//         for (var index = 0; index < names.length; index++) {
//             var name = names[index];

//             console.log(name + ' was found at index ' + index);
//         }
//         console.log('name and index after loop is ' + name + ':' + index);
//     }
//     actuallyPrintingNames();
// }
// printNames(beatles);

// var beatles = ['Paul', 'George', 'John', 'Ringo'];
// function printNames(names) {
//     function actuallyPrintingNames() {
//         let index = 0;
//         let name;
//         for (index; index < names.length; index++) {
//             name = names[index];
//             console.log(name + ' was found at index ' + index);
//         }
//         console.log('name and index after loop is ' + name + ':' + index);
//     }
//     actuallyPrintingNames();
// }
// printNames(beatles);

// var beatles = ['Paul', 'George', 'John', 'Ringo'];
// function printNames(names) {
//     function actuallyPrintingNames() {
//         for (let index = 0; index < names.length; index++) {
//             let name = names[index];
//             console.log(name + ' was found at index ' + index);
//         }
//         console.log('name and index after loop is ' + name + ':' + index);
//     }
//     actuallyPrintingNames();
// }
// printNames(beatles);

/*
    Given a number, return a boolean indicating whether the number is even.
*/

// isEven = (num) => num % 2 == 0;


// console.log(isEven(2) ? 'pass' : 'fail'); 
// console.log(!isEven(57) ? 'pass' : 'fail'); 
// console.log(isEven(0) ? 'pass' : 'fail'); 

/*
    Write a program that prints the numbers from 1 to 100 and 
        for multiples of ‘3’ add “Fizz” to the return array instead of the number and 
        for the multiples of ‘5’ add “Buzz” to the return array. 
*/

fizzBuzz = () => {

    let returnList = [];

    for(let i = 1; i <= 100; i++){
        if (i % 3 === 0 && i % 5 === 0){
            returnList.push("FizzBuzz");
        }
        else if (i % 5 === 0) {
            returnList.push("Buzz");
        }
        else if (i % 3 === 0){
            returnList.push("Fizz");
        }
        else {
            returnList.push(i);
        }
    }
    console.log(returnList)
    return returnList;
}

let testResult = '[1,2,"Fizz",4,"Buzz","Fizz",7,8,"Fizz","Buzz",11,"Fizz",13,14,"FizzBuzz",16,17,"Fizz",19,"Buzz","Fizz",22,23,"Fizz","Buzz",26,"Fizz",28,29,"FizzBuzz",31,32,"Fizz",34,"Buzz","Fizz",37,38,"Fizz","Buzz",41,"Fizz",43,44,"FizzBuzz",46,47,"Fizz",49,"Buzz","Fizz",52,53,"Fizz","Buzz",56,"Fizz",58,59,"FizzBuzz",61,62,"Fizz",64,"Buzz","Fizz",67,68,"Fizz","Buzz",71,"Fizz",73,74,"FizzBuzz",76,77,"Fizz",79,"Buzz","Fizz",82,83,"Fizz","Buzz",86,"Fizz",88,89,"FizzBuzz",91,92,"Fizz",94,"Buzz","Fizz",97,98,"Fizz","Buzz"]'
console.log(JSON.stringify(fizzBuzz()) === testResult ? 'pass' : 'fail');

// Message #🏫cohort-lee-may
