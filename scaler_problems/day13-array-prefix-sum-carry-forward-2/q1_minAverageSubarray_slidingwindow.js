/**
 * Subarray with least average
Problem Description
Given an array of size N, Find the subarray with least average of size k.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.


Output Format
Return the index of the first element of the subarray of size k that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3
Input 2:

A=[3, 7, 5, 20, -10, 0, 12]
B=2


Example Output
Output 1:
3
Output 2:

4


Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average
 * 
 */


/**
 * Find min average of subarray
 * Sliding window approach: TC: O(N) SC: O(1)
 * @param {Array} A input array
 * @param {Object} K length of subarray
 * @returns 
 */
const minAverage = (A, K) => {
    // sliding window approach since the subarray size K is constant
    let sum = 0;
    for (let i = 0; i < K; i++) {
        sum += A[i];
    }
    let minIndex = 0;
    let minAverage = sum;

    // iterate all subarray of length K from inddex 1
    for (let i = 1; i < A.length - K + 1; i++) {
        let j = i + K - 1;
        sum = sum - A[i - 1] + A[j];
        if (sum < minAverage) {
            // update min index and min sum/average
            minAverage = sum;
            minIndex = i;
        }
    }

    console.log(minIndex);
    // return minimum index
    return minIndex;
}

minAverage([18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19], 1);