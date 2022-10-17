function hide(element) {
    element.remove();
}

function logout(element) {
    if(element.innerText == "Login") {
        element.innerText = "Logout";
    } else {
        element.innerText = "Login"
    }
}

function message() {
    alert("Ninja was liked!");
}