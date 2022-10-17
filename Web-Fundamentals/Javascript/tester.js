var nameTag = document.querySelector("#name-tag");

function setName(element) {
    console.log(element.value);
    nameTag.innerText = element.value;
}


function add(num3, num4) {
    sum = num3 + num4 
    console.log(sum)
    return sum
}
