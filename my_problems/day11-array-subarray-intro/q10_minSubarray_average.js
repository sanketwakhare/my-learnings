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
B=1;

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
The subarray {20, 10, 50} has the least average among all subarrays of size 3.
Explanation 2:
 Subarray between [4, 5] has minimum average
 */

/**
 * least average for given length B is nothing but the min sum of subarray of given length B
 * Time Complexity: O(N) - sliding window approach
 * 
 * @param {Array} A 
 * @param {Number} B 
 * @returns 
 */
const subarrayWithLeastAverage = (A, B) => {

    // sliding window approach
    let sum = 0;
    for (let i = 0; i < B; i++) {
        sum = sum + A[i];
    }
    // least average = min sum of subarray of length B
    let leastAverage = sum;
    let leastAverageSubarrayStartIndex = 0;

    // last subarray will start at N-B
    for (let i = 1; i <= A.length - B; i++) {
        // prev element index = i-1
        // next element index = j = i+B-1
        let j = i + B - 1;
        sum = sum - A[i - 1] + A[j];
        if (sum < leastAverage) {
            leastAverage = sum;
            leastAverageSubarrayStartIndex = i;
        }
    }
    console.log(leastAverageSubarrayStartIndex);
    return leastAverageSubarrayStartIndex;
}

// subarrayWithLeastAverage([3, 7, 90, 20, 10, 50, 40], 1);
// subarrayWithLeastAverage([3, 7, 5, 20, -10, 0, 12], 2);
// subarrayWithLeastAverage([3, 7, 90, 20, 10, 50, 40], 3);
subarrayWithLeastAverage([20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11], 9);