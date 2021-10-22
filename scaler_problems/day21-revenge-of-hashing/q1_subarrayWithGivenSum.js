/***
 * Subarray with given sum
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110

Example Output
Output 1:
 [2, 3]
Output 2:
 -1

Example Explanation
Explanation 1:
 [2, 3] sums up to 5.
Explanation 2:
 No subarray sums up to required number.
 */

/**
 * Find subarray with sum matching B
 * @param {Array} A input positive integer array
 * @param {Number} B target sum of subarray
 * @returns 
 */
const subArrayWithGivenSum = (A, B) => {
    let start = 0;
    let end = 0;
    let sum = 0;
    let result = [];
    let subArrayFound = false;

    while (start <= end && end < A.length) {
        while (sum < B) {
            sum = sum + A[end];
            end++;
        }
        while (sum > B) {
            sum = sum - A[start];
            start++;
        }
        if (sum === B) {
            // subarray found
            // traverse from start to end
            while (start < end) {
                result.push(A[start]);
                start++;
            }
            subArrayFound = true;
            break;
        }
    }
    if (!subArrayFound) {
        result = [-1];
    }
    console.log(result);
    return result;
}

// subArrayWithGivenSum([1, 2, 3, 4, 5], 5);
subArrayWithGivenSum([5, 10, 20, 100, 105], 105);