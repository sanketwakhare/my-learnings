/******
 * Equilibrium index of an array
 *
Problem Description

You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.

Problem Constraints
1<=N<=1e5
-1e5<=A[i]<=1e5

Input Format
First arugment contains an array A .

Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.

Example Input

Input 1:
A=[-7, 1, 5, 2, -4, 3, 0]
Input 2:
A=[1,2,3]

Example Output
Output 1:
3
Output 2:
-1

Example Explanation
Explanation 1:
3 is an equilibrium index, because: 
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Explanation 1:

There is no such index.
 */

/**
 * Find Equilibrium index
 * SC: O(1)
 * TC: O(N)
 * @param {Array} A 
 * @returns 
 */
const findEquilibriumIndex = (A) => {
    const N = A.length;

    // find totalSum
    let totalSum = 0;
    for (let i = 0; i < N; i++) {
        totalSum += A[i];
    }

    // iterate over array and find leftSum and rightSum using totalSum
    let leftSum = 0;
    for (let i = 0; i < N; i++) {
        // Observations: adding A[i] to both leftSum and rightSum will give the same sum
        leftSum += A[i];
        let rightSum = totalSum - leftSum + A[i];
        if (leftSum === rightSum) {
            return i;
        }
    }
    return -1;
}