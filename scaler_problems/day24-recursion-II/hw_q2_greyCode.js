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

/**
 * Grey code recursive function
 * TC: O(2^N) for iterating no of array elements
 * SC: O(2^N) array size
 * @param {Array} array current grey code array elements
 * @param {Number} N power value of 2
 * @param {Number} A 
 * @returns 
 */
const greyRecursive = (array, N, A) => {
    // base condition
    if (N === A) {
        return array;
    }
    let out = [];
    const addValue = Math.pow(2, N);
    // iterate from last to first
    for (let i = array.length - 1; i >= 0; i--) {
        // grey code recursive
        out.push(Number(array[i]) + Number(addValue));
    }
    // call the function recursively
    // decrease power value by 1
    return greyRecursive([...array, ...out], N + 1, A);
}

//param A : integer
//return a array of integers
const grayCode = function (A) {
    // pass initial pow value as 0 and initial array element as 0
    return greyRecursive([0], 0, A);
}

console.log(grayCode(5));
console.log(grayCode(2));
console.log(grayCode(10));
console.log(grayCode(16));

/**
 * Solution Approach:
 *
 * We can exploits one of the Grey code property.

Initially,  lets say the first grey code is 0 and output array is [0]

Step 1:
Try adding 2^0 to elements in array from reverse direction

current output array = [0] and 2^0 = 1
0+ 2^0 = 0+1 = 1
The output array after step 1 becomes [0,1]

Step 2:
Repeat same thing.
Try adding 2^1 to elements in array [0,1] from reverse direction

current output array = [0,1] and 2^1 = 2

1+2 = 3
0+2 = 2
So next two elements in output array should be 3 and 2
The output array after step 2 is: [0,1,3,2]

Step 3:
Repeat same thing.
Try adding 2^2 to elements in array [0,1,3,2] from reverse direction

current output array = [0,1,3,2] and 2^2 = 4

2+4 = 6
3+4 = 7
1+4 = 5
0+4 = 4
So next set of grey codes in output array should be [6,7,5,4]
output array after step 3 becomes : [0,1,3,2,6,7,5,4]

This way you can generate grey code.
I hope this helps.
 */