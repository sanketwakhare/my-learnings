/**
 * Min XOR value
Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 10^9

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer denoting minimum xor value.

Example Input
Input 1:
 A = [0, 2, 5, 7]
Input 2:
 A = [0, 4, 7, 9]

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:
 0 xor 2 = 2
 */

const minXORValue = (A) => {

    // sort the given array
    A.sort((a, b) => a - b);

    // find min xor of consecutive elements
    let minXor = Number.MAX_VALUE;
    for (let i = 0; i < A.length - 1; i++) {
        const xor = A[i] ^ A[i + 1];
        if (xor < minXor) {
            minXor = xor;
        }
    }

    console.log(minXor);
    return minXor;

}

minXORValue([0, 2, 5, 7]);
minXORValue([0, 4, 7, 9]);
minXORValue([10, 13, 4, 6, 14, 17, 19]);