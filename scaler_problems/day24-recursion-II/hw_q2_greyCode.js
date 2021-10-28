/*****
 * Problem Description

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

const greyRecursive = (array, N, A) => {
    // base condition
    if (N === A) {
        return array;
    }
    let out = [];
    const addValue = Math.pow(2, N);
    // grey code recursive
    for (let i = array.length - 1; i >= 0; i--) {
        out.push(Number(array[i]) + Number(addValue));
    }
    // call the function recursively
    // decrease power value by 1
    return greyRecursive([...array, ...out], N + 1, A);
}

//param A : integer
//return a array of integers
const grayCode = function (A) {
    return greyRecursive([0], 0, A);
}

console.log(grayCode(5));
console.log(grayCode(2));
console.log(grayCode(10));
console.log(grayCode(16));