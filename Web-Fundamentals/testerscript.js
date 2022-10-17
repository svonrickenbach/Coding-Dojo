function remove(donate) {
    donate.remove();
}

// var pet = ['dog', 'cat', 'dragon']
// var animal = [
//     document.querySelector(".dog"),
//     document.querySelector(".cat"),
//     document.querySelector(".dragon")
// ];

// console.log(animal)

function popup(select) {
    alert(select.value)
}

// function popup(select) {
//     alert(select.options[select.selectedIndex].text);
// }

var pets = [3, 5, 8];
var countelement = [
    document.querySelector(".pettings1"),
    document.querySelector(".pettings2"),
    document.querySelector(".pettings3")
];

function pet(index) {
    pets[index]++;
    countelement[index].innerText = pets[index] + " petting(s)";
    console.log(pets)
}