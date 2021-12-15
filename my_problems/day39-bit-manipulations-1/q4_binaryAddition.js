/******
 * Add Binary Strings
 * 
 * 
Problem Description

Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111".
 */


/**
 * Add Binary Strings
 * @param {String} A 
 * @param {String} B 
 * @returns 
 */
const binaryAddition = (A, B) => {
    // pad 0s to start of strings to make them equal lengths
    if (A.length > B.length) {
        B = B.padStart(A.length, '0');
    } else {
        A = A.padStart(B.length, '0');
    }

    // perform binary addition
    let sum = 0;
    let carry = 0;
    let revString = [];
    for (let i = A.length - 1; i >= 0; i--) {
        no1 = Number(A[i]);
        no2 = Number(B[i]);
        sum = no1 + no2 + carry;
        quotient = Math.floor(sum % 2);
        carry = Math.floor(sum / 2);
        revString.push(quotient);
    }

    // handle additional carry
    let binaryCarry = "";
    if (carry > 0) {
        binaryCarry = carry.toString(2);
    }

    // append the bit from reverse string
    while (revString.length > 0) {
        binaryCarry += String(revString.pop());
    }

    // return final answer string
    return binaryCarry;
}

binaryAddition('1010110111001101101000', '1000011011000000111100110');