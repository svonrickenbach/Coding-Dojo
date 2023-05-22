// Push Front
function pushFront(arr, value) {
    for (let i = arr.length; i > 0; i--) {
        arr[i] = arr[i - 1];
    }
    arr[0] = value;
    return arr;
}

console.log(pushFront([5,7,2,3], 8));

// Pop Front 
function popFront(arr) {
    if (arr.length === 0) {
        return; // Return undefined if the array is empty
    }

    const firstValue = arr[0];

    for (let i = 0; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
    }

    arr.length = arr.length - 1; // Update the length to remove the last element

    console.log(arr);
    return firstValue;
}

console.log(popFront([0,5,10,15]))

// Insert At
function insertAt(arr, index, value) {
    if (index < 0 || index > arr.length) {
        return; // Return undefined if the index is out of range
    }

    for (let i = arr.length - 1; i >= index; i--) {
        arr[i + 1] = arr[i];
    }

    arr[index] = value;
    return arr;
}

console.log(insertAt([100,200,5], 2, 311) ); 