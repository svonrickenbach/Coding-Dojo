function remove(donate) {
    donate.remove();
}

function popup(select) {
    alert("You are looking for a " + (select.value) + ".")
}

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