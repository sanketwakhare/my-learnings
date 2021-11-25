/***
 * Problem Description

You are given an array of N integers, A1, A2, …. AN.
Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

Problem Constraints
1 <= N <= 100000
-10^9 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the maximum value of f(i, j).

Example Input
Input 1:
A = [1, 3, -1]
Input 2:
A = [2]

Example Output
Output 1:
5
Output 2:
0

Example Explanation
Explanation 1:
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

Explanation 2:
Only possibility is i = 1 and j = 1. That gives answer = 0.
 */

/**
 * Find minimum absolute difference
 * @param {Array} A array of integers
 * @return {Number} max value of |A[i]-A[j]| + |i-j|
 */
const minAbsoluteDifference = (A) => {

    // this logic/approach is based on the mathematical equations

    const N = A.length;

    // Case 1: for every element in array A, perform A[i]-i and min and max
    let minSub = A[0] - 0;
    let maxSub = A[0] - 0;
    for (let i = 1; i < N; i++) {
        const currentSub = A[i] - i;
        minSub = Math.min(minSub, currentSub);
        maxSub = Math.max(maxSub, currentSub);
    }
    //  case 1 answer
    let case1Answer = maxSub - minSub;

    // Case 2: for every element in array A, perform A[i]+i and min and max
    let minAdd = A[0] + 0;
    let maxAdd = A[0] + 0;
    for (let i = 1; i < N; i++) {
        const currentAdd = A[i] + i;
        minAdd = Math.min(minAdd, currentAdd);
        maxAdd = Math.max(maxAdd, currentAdd);
    }
    // case 2 answer
    let case2Answer = maxAdd - minAdd;

    let answer = Math.max(case1Answer, case2Answer);
    console.log(answer);
    return answer;
}

minAbsoluteDifference([6, 1, 8, 3, 4, 5]);
minAbsoluteDifference([1, 3, -1]);