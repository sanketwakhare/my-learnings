/***
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
Find and return the required subarray.

NOTE:
    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.

Input Format:
The first and the only argument of input contains an integer array A, of length N.
Output Format:
Return an array of integers, that is a subarray of A that satisfies the given conditions.

Constraints:
1 <= N <= 1e5
-INT_MAX < A[i] <= INT_MAX

Examples:
Input 1:
    A = [1, 2, 5, -7, 2, 3]
Output 1:
    [1, 2, 5]
Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    A = [10, -1, 2, 3, -4, 100]
Output 2:
    [100]
Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.
 */

/**
 * Find subarray with max sum with only positive integers
 * TC: O(N)
 * SC: O(N)
 * @param {Array} A input array of integer elements
 * @returns 
 */
const findSubArrayWithMaxSum = (A) => {

    // as per question,we have to find subarray only with positive integers

    const N = A.length;
    // generate prefix sum array
    // if -ve element is found, store the same element in array and reset the sum to 0
    // SC: O(N)
    let prefixSumArray = new Array(N).fill(0);
    let sum = 0;
    for (let i = 0; i < N; i++) {
        if (A[i] < 0) {
            sum = 0;
            prefixSumArray[i] = A[i];

        } else {
            sum = sum + A[i];
            prefixSumArray[i] = sum;
        }
    }
    console.log('prefixSumArray', prefixSumArray);

    // find maxSum from prefix array
    let maxSum = prefixSumArray[0];
    for (let i = 1; i < N; i++) {
        if (maxSum < prefixSumArray[i]) {
            maxSum = prefixSumArray[i];
        }
    }
    console.log('maxSum', maxSum);

    // now find the length and start index of subarray with max length of sum = maxSum
    let maxLength = 0;
    let startIndexOfMaxSum = 0;
    let count = 0;
    // O(N): even though there are 2 loops, same i is decrementing so it O(N)
    for (let i = N - 1; i >= 0; i--) {
        if (prefixSumArray[i] === maxSum) {
            while (prefixSumArray[i] >= 0) {
                count++;
                i--;
            }
            // update the maxLength and startIndexOfMaxSum
            if (count > maxLength) {
                maxLength = count;
                startIndexOfMaxSum = i + 1;
            }
            // when -ve element is found, reset count to 0
            count = 0;
        }
    }
    console.log('startIndexOfMaxSum', startIndexOfMaxSum);
    console.log('maxLength', maxLength);

    // now return the subarray with max sum as we already have startIndexOfMaxSum and length of subarray
    let result = [];
    for (let i = startIndexOfMaxSum; i < maxLength + startIndexOfMaxSum; i++) {
        result.push(A[i]);
    }

    console.log('A', A);
    console.log('result', result);
    return result;
}

findSubArrayWithMaxSum([1, 2, 5, -7, 2, 3]);
findSubArrayWithMaxSum([1, 2, 5, -100, 2, 1, 1, 2, 2]);
findSubArrayWithMaxSum([10, -1, 2, 3, -4, 100]);
