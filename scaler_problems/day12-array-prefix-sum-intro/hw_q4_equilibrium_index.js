/**
 * Equilibrium index of an array
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
First argument contains an array A .

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
 * solved using Observations/pattern
 * use left prefix sum array and right prefix sum array
 * and compare the left[i-1] and right[i+1] indexes
 * TC: O(N+N+N)~ O(N)
 * SC: O(N+N) ~ O(N)
 * @param {Array} A 
 */
const findEquilibriumIndex = (A) => {
    // generate left prefix array. TC: O(N) SC: O(N)
    let left = [];
    left.push(A[0]);
    for (let i = 1; i < A.length; i++) {
        left.push(left[i - 1] + A[i]);
    }
    // generate right prefix array. TC: O(N) SC: O(N)
    let right = [];
    right[A.length - 1] = A[A.length - 1];
    for (let i = (A.length - 2); i >= 0; i--) {
        right[i] = right[i + 1] + A[i];
    }
    console.log(left);
    console.log(right);

    // for the current index i, compare the [i-1]th element from left prefix sum array and [i+1]th right prefix sum array
    let prevEleSum = left[0];
    let nextEleSum = right[right.length - 1];
    let minEquilibriumIndex = A.length;
    // TC: O(N) SC: O(1)
    for (let i = 0; i < A.length; i++) {

        if (i === 0) {
            prevEleSum = left[0];
            nextEleSum = right[i + 1];
        }
        if (i === A.length - 1) {
            prevEleSum = left[i - 1];
            nextEleSum = right[A.length - 1];
        }
        if (i !== 0 && i !== A.length - 1) {
            prevEleSum = left[i - 1];
            nextEleSum = right[i + 1];
        }
        if (prevEleSum === nextEleSum) {
            minEquilibriumIndex = Math.min(minEquilibriumIndex, i);
            // as we just need to return smallest equilibrium index
            break;
        }
    }
    if (minEquilibriumIndex === A.length) {
        minEquilibriumIndex = -1;
    }
    console.log(minEquilibriumIndex);
}

const findEquilibriumIndexOptimizedWithNoExtraSpace = (A) => {


    // find totalSum
    let totalSum = A[0];
    for (let i = 1; i < A.length; i++) {
        totalSum += A[i];
    }

    let minEquilibriumIndex = A.length;
    let leftSum = 0;
    for (let i = 0; i < A.length; i++) {
        // calculate leftSum on the fly using carry forward technique
        leftSum += A[i];
        // rightSum can be calculated using totalSum and leftSum
        let rightSum = totalSum - leftSum + A[i];

        // alternate way to calculate leftSUm and rightSum
        // leftSum = sum of [0,i]
        // rightSum = sum of [i, N-1]

        if (leftSum === rightSum) {
            minEquilibriumIndex = Math.min(minEquilibriumIndex, i);
        }
    }
    if (minEquilibriumIndex === A.length) {
        minEquilibriumIndex = -1;
    }
    console.log(minEquilibriumIndex);
}


// findEquilibriumIndex([-7, 1, 5, 2, -4, 3, 0]);
findEquilibriumIndexOptimizedWithNoExtraSpace([-7, 1, 5, 2, -4, 3, 0]);