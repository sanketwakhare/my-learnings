/*****
 * Number of 1 Bits
 * 
 * Problem Description

Write a function that takes an integer and returns the number of 1 bits it has.

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument contains integer A

Output Format
Return an integer as the answer

Example Input
Input1:
11

Example Output
Output1:
3

Example Explanation
Explanation 1:
11 is represented as 1011 in binary.
 */

const numSetBits = (A) => {

    let count = 0;

    for (let i = 0; i < 32; i++) {
        if ((A >> i) & 1) {
            count++;
        }
    }
    console.log('no of set bits in ', A, ' are ', count);
    return count;
}

numSetBits(15);
numSetBits(13);
numSetBits(64);
numSetBits(10);
numSetBits(255);