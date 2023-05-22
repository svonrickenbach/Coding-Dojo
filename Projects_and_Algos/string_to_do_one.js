// Remove blanks
function removeBlanks(str) {
    let result = '';

    for (let i = 0; i < str.length; i++) {
        const char = str.charAt(i);
        if (char !== ' ') {
            result += char;
        }
    }

    return result;
}
    console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "));


    // Get digits
function getDigits(str) {
    let result = 0;

    for (let i = 0; i < str.length; i++) {
        const char = str[i];

        if (!isNaN(Number(char))) {
            result = result * 10 + (Number(char) - 0);
        }
    }

    return result;
}
console.log(getDigits("abc8c0d1ngd0j0!8"));

// Acronyms 
function acronym(str) {
    let acronym = '';
    let prevCharIsSpace = true;

    for (let i = 0; i < str.length; i++) {
        const char = str[i];

        if (char === ' ') {
            prevCharIsSpace = true;
        } else if (prevCharIsSpace) {
            acronym += char.toUpperCase();
            prevCharIsSpace = false;
        }
    }

    return acronym;
}
console.log(acronym(" there's no free lunch - gotta pay yer way. "));

// Count non-spaces
function countNonSpaces(str) {
    let count = 0;

    for (let i = 0; i < str.length; i++) {
        const char = str[i];

        if (char !== ' ') {
            count++;
        }
    }

    return count;
}
console.log(countNonSpaces("Honey pie, you are driving me crazy"));

// Remove Shorter Strings
function removeShorterStrings(arr, value) {
    const result = [];

    for (let i = 0; i < arr.length; i++) {
        const currentString = arr[i];

        let isLongerOrEqual = true;
        let j = 0;

        while (j < value.length) {
            if (currentString[j] === undefined) {
                isLongerOrEqual = false;
                break;
            }

            j++;
        }

        if (isLongerOrEqual) {
            result.push(currentString);
        }
    }

    return result;
}
console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4));