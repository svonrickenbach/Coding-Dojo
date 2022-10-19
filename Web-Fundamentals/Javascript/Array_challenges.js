function alwaysHungry(arr){
    var foodCount = 0 
    for (let index = 0; index < arr.length; index++) {
        if(arr[index] == "food"){
            console.log("yummy");
            foodCount++
        }
        }
        if(foodCount == 0) {
            console.log("I'm Hungry")
        }
}

alwaysHungry([3.14, "food", "pie", true, "food"]);

alwaysHungry([4, 1, 5, 7, 2]);


function highPass(arr, cutoff) {
    var filteredArr = [];
    for (let index = 0; index < arr.length; index++) {
        if(arr[index] > cutoff) {
            filteredArr.push(arr[index])
        }
        }
        return filteredArr;
}
var result = highPass([6,8,3,10,-2,5,9], 5);
console.log(result)

function betterThanAverage(arr) {
    var sum = 0;
    for (let index = 0; index < arr.length; index++) {
        sum = sum + arr[index] 
    }
    avg = sum / arr.length;
    var count = 0 
    for (let index = 0; index < arr.length; index++) {
        if(arr[index] > avg) {
            count++
    }
    }
    return count; 
}

var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result)

function reverse(arr) {
    arr[0] = "e";
    arr[1] = "d";
    arr[3] = "b";
    arr[4] = "a";
    return arr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result);

function reverse(arr) {
    var rev = []
    for (let index = 4; index >= 0; index--) {
        rev.push(arr[index])
    }
    return rev;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result);

function fibonacciArray(n) {
    var fibArr = [0, 1]
    for (let index = 0; index < n-2; index++) {
        fib = fibArr[index] + fibArr[index +1]
        fibArr.push(fib)
    }
    return fibArr;
}

var result = fibonacciArray(10)
console.log(result); 