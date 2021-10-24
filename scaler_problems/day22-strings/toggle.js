// toggle lower to uppercase letters and vice versa.
// String.fromCharCode((s[2].charCodeAt(0) ^ 32))

/**
 * Toggle given character array from lowercase to uppercase and vice versa.
 * @param {Array} A array of characters
 */
const toggle = (A) => {

    for (let i = 0; i < A.length; i++) {
        A[i] = String.fromCharCode(A[i].charCodeAt(0) ^ 32);
    }

    console.log(A);

    // OR toggle can be done as below
    // as difference between respective lower and upper case letter is 32
    for (let i = 0; i < A.length; i++) {
        let currentCharCode = A[i].charCodeAt(0);
        if (currentCharCode >= 65 && currentCharCode <= 90) {
            // char is capital letter, convert it into lower case
            let convertedCharCode = currentCharCode + 32;
            A[i] = String.fromCharCode(convertedCharCode);
        } else if (currentCharCode >= 97 && currentCharCode <= 122) {
            // char is lowercase letter, convert it into upper case
            let convertedCharCode = currentCharCode - 32;
            A[i] = String.fromCharCode(convertedCharCode);
        }
    }
    console.log(A);

}

toggle(['A', 'z', 'f', 'D', 'p', 'W']);
toggle(['r', 'w', 'G', 'P']);