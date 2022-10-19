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


// for (let i = 1; i <= 100; i++) {
//     if(i % 3 == 0 && i % 5 == 0) {
//         console.log("fizzbuzz")
//     }
//     else if(i % 5 == 0) {
//         console.log("buzz")
//     }
//     else if(i % 3 == 0) {
//         console.log("fizz")
//     }
//     else {
//         console.log(i)
//     }
// }

// var taco1 = {
//     "tortilla": "soft corn tortilla",
//     "protein":  "tinga chicken",
//     "cheese":   "cotija cheese",
//     "toppings": ["lettuce", "pico de gallo", "guacamole"]
// }

// console.log("Tortilla: " + taco1.tortilla);
// console.log("Protein:  " + taco1.protein);
// console.log("Cheese:   " + taco1.cheese);
// console.log("Toppings: " + taco1.toppings[0]);

// var taco1 = {
//     "tortilla": "soft corn tortilla",
//     "protein":  "tinga chicken",
//     "cheese":   "cotija cheese",
//     "toppings": ["lettuce", "pico de gallo", "guacamole"],
//     "tacoInfo": function() {
//         console.log("Tortilla: " + taco1.tortilla);
//         console.log("Protein:  " + taco1.protein);
//         console.log("Cheese:   " + taco1.cheese);
//         console.log("Toppings: " + taco1.toppings);
//     }
// }
    
// // we can now get all the delicious taco facts by
// taco1.tacoInfo(); // note we call this like a function because it is a function

// var taco1 = {
//     "tortilla": "soft corn tortilla",
//     "protein":  "tinga chicken",
//     "cheese":   "cotija cheese",
//     "toppings": ["lettuce", "pico de gallo", "guacamole"],
//     "tacoInfo": function() {
//         console.log("Tortilla: " + this.tortilla);
//         console.log("Protein:  " + this.protein);
//         console.log("Cheese:   " + this.cheese);
//         console.log("Toppings: " + this.toppings);
//     }
// }
    
// // we can now still get all the delicious taco facts by
// taco1.tacoInfo(); // note tacoInfo still gets called like a function

// function sandwichFactory(bread, protein, cheese, toppings) {
//     var sandwich = {};
//     sandwich.bread = bread;
//     sandwich.protein = protein;
//     sandwich.cheese = cheese;
//     sandwich.toppings = toppings;
//     return sandwich;
// }
    
// var s1 = sandwichFactory("wheat", "turkey", "provolone", ["mustard", "fried onions", "arugula"]);
// console.log(s1);


// var sandwich = {
//     bread:    "sourdough",
//     protein:  "london broil",
//     cheese:   "lacey swiss cheese",
//     toppings: ["romaine lettuce", "heirloom tomatoes", "horseradish sauce"]
// };
    
// console.log(sandwich.bread, sandwich.protein);

var colors = document.querySelectorAll(".color");
    
function applyColors(){
    for(var i=0; i<colors.length; i++) {
        colors[i].style.color = colors[i].innerText;
    }
}