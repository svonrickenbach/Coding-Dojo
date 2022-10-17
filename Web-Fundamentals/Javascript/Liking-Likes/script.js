var likes = 9;
var countelement = document.querySelector(".count");

console.log(countelement);

function likeButton() { 
    likes++
    countelement.innerText = likes + " like(s)";
    console.log(likes);

}

var likes2 = 12;
var countelement2 = document.querySelector(".count2");

console.log(countelement2);

function likeButton2() { 
    likes2++
    countelement2.innerText = likes2 + " like(s)";
    console.log(likes2);

}

var likes3 = 9;
var countelement3 = document.querySelector(".count3");

console.log(countelement3);

function likeButton3() { 
    likes3++
    countelement3.innerText = likes3 + " like(s)";
    console.log(likes3);
}