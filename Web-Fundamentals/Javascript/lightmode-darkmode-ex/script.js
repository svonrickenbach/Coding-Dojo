function setActive(element) {

    if(element.classList.value.includes("darkmode")) {
        element.innerText = "Switch to light mode";
        element.classList.remove("darkmode");
    } else {
        element.innerText = "Switch to dark mode";
        element.classList.add("darkmode");
    }
}