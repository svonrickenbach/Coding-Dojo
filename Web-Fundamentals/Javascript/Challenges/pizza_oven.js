function pizzaOven(crust, sauce, cheese, toppings) {
    var pizza = {};
    pizza.crust = crust;
    pizza.sauceType = sauce;
    pizza.cheese = cheese;
    pizza.toppings = toppings; 
    return pizza;
}

var p1 = pizzaOven("deep dish", "traditional", "mozzarella", ["pepperoni", "sausage"]);
console.log(p1)

var p2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"])
console.log(p2)

var p3 = pizzaOven("detroit", "marinara", "mozzarella", "pepperoni")
console.log(p3)

var p4 = pizzaOven("new york", "white", "mozzarella", ["bacon", "jalapeno", "pepperoni"])
console.log(p4)

// function pizzaOven() {
//     var pizza = {
//     crust: ["deep dish", "hand tossed", "detroit", "new york"],
//     sauce: ["traditional", "marinara", "white", "pesto", "bbq"],
//     cheese: ["mozzarella", "feta", "riccota", "jack"],
//     toppings: ["pepperoni", "sausage", "mushrooms", "olives", "onions", "bacon", "jalapeno",]
//     }
//     return(pizza.crust[0])
// }
// console.log(pizzaOven())

