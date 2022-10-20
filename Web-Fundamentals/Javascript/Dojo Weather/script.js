function loading(element) {
    alert("Loading weather report...")
}

var popUp = document.querySelector(".popup")
function remove() {
    popUp.remove()
}

var high = document.querySelectorAll(".high")
var low = document.querySelectorAll(".low")
var numh = [24, 27, 21, 26]
var numl = [18, 19, 16, 21]

function convert(element) {
    for (let index = 0; index < numh.length; index++) {
        if(element.value == "farenheight") {
            numh[index] = numh[index] * 1.8 + 32;
            numh[index] = numh[index].toFixed(0)
            high[index].innerText = numh[index] + "°";
            numl[index] = numl[index] * 1.8 + 32;
            numl[index] = numl[index].toFixed(0)
            low[index].innerText = numl[index] + "°";
        }
        else{ 
            numh[index] = (numh[index] - 32) / 1.8;
            numh[index] = numh[index].toFixed(0)
            high[index].innerText = numh[index] + "°";
            numl[index] = (numl[index] - 32) / 1.8;
            numl[index] = numl[index].toFixed(0)
            low[index].innerText = numl[index] + "°";
        }
    }
}

var high = document.querySelectorAll(".high")
var low = document.querySelectorAll(".low")

function convert(element) {
    for (let index = 0; index < high.length; index++) {
        if(element.value == "farenheight") {
            var numh = parseInt(high[index].innerText)
            numh = numh * 1.8 + 32;
            numh = numh.toFixed(0);
            high[index].innerText = numh
            var numl = parseInt(low[index].innerText)
            numl = numl * 1.8 + 32;
            numl = numl.toFixed(0);
            low[index].innerText = numl
        }
        else{
            var numh = parseInt(high[index].innerText)
            numh = (numh-32) / 1.8;
            numh = numh.toFixed(0);
            high[index].innerText = numh
            var numl = parseInt(low[index].innerText)
            numl = (numl - 32) / 1.8;
            numl = numl.toFixed(0);
            low[index].innerText = numl
        }
    }
}


