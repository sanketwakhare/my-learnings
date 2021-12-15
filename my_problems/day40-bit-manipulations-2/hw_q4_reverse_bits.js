/***
 * Reverse Bits
 * 
 * 
Problem Description
Reverse the bits of an 32 bit unsigned integer A.

Problem Constraints
0 <= A <= 2^32

Input Format
First and only argument of input contains an integer A.

Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Example Input
Input 1:
 0
Input 2:
 3

Example Output
Output 1:
 0
Output 2:
 3221225472

Example Explanation
Explanation 1:
        00000000000000000000000000000000    
=>      00000000000000000000000000000000
Explanation 2:
        00000000000000000000000000000011    
=>      11000000000000000000000000000000
 */

/**
 * Reverse bits in number A
 * @param {Number} A input integer number
 * @returns number which has bits reversed as A
 */
const reverseBits = function(A) {

    let reversedString = new String("");

    // perform reverse operation of number
    for (let i = 0; i < 32; i++) {
        const bit = String(1 & (A >> i));
        reversedString += bit;
    }

    // convert binary string to integer
    let ans = parseInt(reversedString, 2);
    console.log('input: ', A, 'ans: ', ans);
    return ans;

}

reverseBits(0);
reverseBits(3);
reverseBits(100);
reverseBits(327879);