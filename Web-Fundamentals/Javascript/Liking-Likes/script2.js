var likes = [9, 12, 9];
var countelement = [
    document.querySelector(".count"),
    document.querySelector(".count2"),
    document.querySelector(".count3")
];

console.log(countelement);

function likeButton(index) {
    likes[index]++;
    countelement[index].innerText = likes[index] + " like(s)";
    console.log(likes)
}