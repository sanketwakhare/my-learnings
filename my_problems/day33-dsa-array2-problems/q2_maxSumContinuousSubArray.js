/******
 * Problem Description

Find the contiguous subarray within an array, A of length N which has the largest sum.

Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Example Input
Input 1:
 A = [1, 2, 3, 4, -10] 
Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Example Output
Output 1:
 10 
Output 2:
 6 

Example Explanation
Explanation 1:
 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:
 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 */

/**
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A 
 * @returns {Number} maximum sum 
 */
const maxSumContinuousSubArray = (A) => {
    // find max sum of subarray

    // this is Kadence's algo
    // initialize maxSum
    let maxSum = A[0];
    const N = A.length;
    let sum = 0;
    for (let i = 0; i < N; i++) {
        // use the previous sum to calculate the new sum with current element
        sum = sum + A[i];

        //  compare current sum with maxSum
        if (sum > maxSum) {
            maxSum = sum;
        }

        // if sum is less than 0, reset teh sum
        if (sum < 0) {
            sum = 0;
        }
    }
    console.log(`maxSum: ${maxSum}`);
    return maxSum;
}

maxSumContinuousSubArray([1, 2, 3, 4, -10]);
maxSumContinuousSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]);