/*******
 * Pick from both sides!

Problem Description:

Given an integer array A of size N.
You can pick B elements from either left or right end of the array A to get maximum sum.
Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then
You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints

1 <= N <= 10^5
1 <= B <= N
-10^3 <= A[i] <= 10^3

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you picked.

Example Input
Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:
 A = [1, 2]
 B = 1

Example Output
Output 1:
 8
Output 2:
 2

Example Explanation

Explanation 1:
 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:
 Pick element 2 from end as this is the maximum we can get
 */

/**
 * Pick from both ends and find the maximum possible sum of elements with size B
 * TC: O(N): we are iterating each element only once
 * SC: O(1): storing the maxSum number
 * @param {Array} A input array
 * @param {Number} B the size of window
 * @returns 
 */
const pickFromBothSides = (A, B) => {

    //  there can be maximum B+1 window for which we need to find the sum

    // use the sliding window approach
    const N = A.length;

    let sum = 0;
    // first calculate sum of first B elements
    for (let i = 0; i < B; i++) {
        sum = sum + A[i];
    }
    // initialize maxSum with sum of first window
    let maxSum = sum;

    // then subtract A[B-i] and add A[n-i] where i =1 to B
    for (let i = 1; i <= B; i++) {

        // for every window
        // subtract A[B-i]
        sum = sum - A[B - i];
        // add A[N-i]
        sum = sum + A[N - i];

        // compare current sum with maxSum and update maxSum if it is > present maxSum
        if (maxSum < sum) {
            maxSum = sum;
        }
    }
    return maxSum;

}

pickFromBothSides([5, -2, 3, 1, 2], 3);
pickFromBothSides([1, 2], 1);