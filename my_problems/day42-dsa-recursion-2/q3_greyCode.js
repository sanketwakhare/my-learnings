/***
 * Gray Code
 * 
 * 

Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

Problem Constraints
1 <= A <= 16

Input Format
First argument is an integer A.

Output Format
Return an array of integers representing the gray code sequence.

Example Input
Input 1:
A = 2
Input 1:
A = 1

Example Output
output 1:
[0, 1, 3, 2]
output 2:
[0, 1]

Example Explanation
Explanation 1:
for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:
for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].
 */

const generateGreyCodes = (A, output) => {

    // base condition
    if (A === 0) {
        return output;
    }

    const N = output.length;

    // find the power which need to be added from reverse direction
    const power = Math.floor(Math.log2(N));
    const addValue = Math.pow(2, power);

    // add 2^logN to output from reverse order
    for (let i = N - 1; i >= 0; i--) {
        let val = addValue + output[i];
        output.push(val);
    }
    // call recursive function
    return generateGreyCodes(A - 1, output);
}

//param A : integer
//return a array of integers
const grayCode = (A) => {
    let output = [0];
    output = generateGreyCodes(A, output);
    console.log(output);
    return output;
}

grayCode(1);
grayCode(2);
grayCode(3);
grayCode(4);
grayCode(10);