/*****
 * MaxMod
 * 

Problem Description

Given an array A of size N, Groot wants you to pick 2 indices i and j such that
1 <= i, j <= N
A[i] % A[j] is maximum among all possible pairs of (i, j).
Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000

Input Format
First and only argument in an integer array A.

Output Format
Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.

Example Input
Input 1:
 A = [1, 2, 44, 3]
Input 2:
 A = [2, 6, 4]

Example Output
Output 1:
 3
Output 2:
 4

Example Explanation
Explanation 1:
 For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
 No pair exists which has more value than 3.
Explanation 2:
 For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
 */

/**
 * Find Max Mod value
 * @param {Array} A array of integers
 * @returns 
 */
const maxMod = (A) => {

    // find max
    let max = Number.MIN_VALUE;
    for (let i = 0; i < A.length; i++) {
        if (max < A[i]) {
            max = A[i];
        }
    }

    // find 2nd max
    let secondMax = Number.MIN_VALUE;
    for (let i = 0; i < A.length; i++) {
        if (secondMax < A[i] && A[i] < max) {
            secondMax = A[i];
        }
    }

    //  if second max is not present, that means all the elements in array are same
    if (secondMax === Number.MIN_VALUE) {
        return 0;
    }
    return secondMax % max;

    // Approach 2: failing for some test cases like [2,3,4,4]
    // find 2nd largest element from array
    // A.sort((a, b) => a - b);
    // return A[A.length - 2] % A[A.length - 1];

    // Another approach can be to sort the array and fidn max mod of last 2 distuinct elements in
}

maxMod([1, 2, 44, 3]);
maxMod([2, 6, 4]);
maxMod([2, 3, 4, 4]);