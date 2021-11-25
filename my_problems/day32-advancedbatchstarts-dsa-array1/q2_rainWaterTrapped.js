/***
 * Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is the vector A

Output Format
Return one integer, the answer to the question

Example Input
Input 1:
A = [0, 1, 0, 2]
Input 2:
A = [1, 2]

Example Output
Output 1:
1
Output 2:
0

Example Explanation

Explanation 1:
1 unit is trapped on top of the 3rd element.
Explanation 2:
No water is trapped.
 */

/**
 * Find total water trapped/accumulated
 * TC: O(N)
 * SC: O(N)
 * @param {Array} A input array
 * @returns Number total water accumulated/trapped
 */
const rainWaterTrapped = (A) => {

    const N = A.length;

    // generate left max array of size N
    let leftMax = new Array(N).fill(0);
    leftMax[0] = A[0];
    for (let i = 1; i < N; i++) {
        if (leftMax[i - 1] < A[i]) {
            leftMax[i] = A[i];
        } else {
            leftMax[i] = leftMax[i - 1];
        }
    }
    console.log(A);
    console.log(leftMax)

    // generate right max array of size N
    let rightMax = new Array(N).fill(0);
    rightMax[N - 1] = A[N - 1];
    for (let i = N - 2; i >= 0; i--) {
        if (rightMax[i + 1] < A[i]) {
            rightMax[i] = A[i];
        } else {
            rightMax[i] = rightMax[i + 1];
        }
    }
    console.log(rightMax);

    // calculate total water accumulation
    let totalWaterTrapped = 0;
    for (let i = 0; i < N; i++) {
        totalWaterTrapped += Math.min(leftMax[i], rightMax[i]) - A[i];
    }

    console.log(totalWaterTrapped);
    return totalWaterTrapped;

}

rainWaterTrapped([0, 1, 0, 2]);
rainWaterTrapped([1, 2]);
rainWaterTrapped([4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3]);