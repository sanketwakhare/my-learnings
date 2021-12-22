/***
 * Kth Symbol
 * 
 * Problem Description

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).

Problem Constraints
1 <= A <= 20
1 <= B <= 2A - 1

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the Bth indexed symbol in row A.

Example Input
Input 1:
 A = 2
 B = 1
Input 2:
 A = 2
 B = 2

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 Row 1: 0
 Row 2: 01
Explanation 2:
 Row 1: 0
 Row 2: 01
 */

/**
 * recursive function to generate binary rows
 * @param {String} inpStr input string for next row
 * @param {Number} A integer
 * @returns 
 */
const kthSymbol = (inpStr, A) => {

    if (A === 1) {
        return inpStr;
    }

    // convert A to binary
    let newA = '';
    for (let i = 0; i < inpStr.length; i++) {
        if (inpStr.charAt(i) === '0') {
            newA = newA + '01';
        } else if (inpStr.charAt(i) === '1') {
            newA = newA + '10';
        }
    }
    return kthSymbol(newA, A - 1);

}

/**
 * Find Kth symbol
 * @param {Number} A 
 * @param {Number} B 
 * @returns 
 */
const kthSymbolMain = (A, B) => {

    const strOut = kthSymbol('0', A);
    console.log(strOut);
    console.log(B + 'th symbol: ' + Number(strOut.charAt(B - 1)));
    return Number(strOut.charAt(B - 1));
}

console.log(kthSymbolMain(2, 2));
console.log(kthSymbolMain(4, 2));
console.log(kthSymbolMain(3, 1));
console.log(kthSymbolMain(6, 5));
console.log(kthSymbolMain(7, 18));