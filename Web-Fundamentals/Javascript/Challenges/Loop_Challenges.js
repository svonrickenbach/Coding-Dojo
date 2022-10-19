for (let i = 1; i < 20; i++) {
    if(i % 2 != 0) {
        console.log(i)
    }
    
}

for (let i = 100; i > 0; i--) {
    if(i % 3 == 0){
        console.log(i)
    }
}

for (let i = 4; i > -4; i-=1.5){
    console.log(i)
}

var sum = 0
for (let i = 1; i<=100; i++) {
    sum = sum + i 
    console.log(i)
}
console.log(sum)

var mult = 1
for (let i = 1; i <= 12; i++) {
    mult = mult * i
    console.log(i)
}
console.log(mult)