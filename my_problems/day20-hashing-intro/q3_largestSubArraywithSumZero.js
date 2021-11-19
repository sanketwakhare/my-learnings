/***
 * Largest Continuous Sequence Zero Sum
Problem Description
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 106
-10^7 <= A[i] <= 10^7

Input Format
Single argument which is an integer array A.

Output Format
Return an array denoting the longest continuous sequence with total sum of zero.
NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

Example Input
A = [1,2,-2,4,-4]

Example Output
[2,-2,4,-4]

Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.
 */

/**
 * find largest subarray with sum=0
 * @param {Array} A 
 */
const findLargestSubArrayWithSumZero = (A) => {

    // create prefix sum array
    let pf = [];
    pf.push(A[0]);
    for (let i = 1; i < A.length; i++) {
        pf.push(pf[i - 1] + A[i]);
    }

    // store max length and start index of the max subarray
    let maxLength = 0;
    let startIndex = 0;
    // build hashMap
    let hashMap = new Map();
    // edge case for 0
    hashMap.set(0, -1);
    for (let i = 0; i < pf.length; i++) {
        if (!hashMap.has(pf[i])) {
            // store start index if element is not present in hashMap
            hashMap.set(pf[i], i);
        } else {
            // subarray with sum=0 found
            // calculate the length of the subarray
            let currentStartIndex = hashMap.get(pf[i]);
            let currentLength = (i - currentStartIndex);
            if (currentLength > maxLength) {
                // if the current length of subarray is more than existing length, update the max length and startIndex
                maxLength = currentLength;
                startIndex = currentStartIndex;
            }
        }
    }
    console.log('maxLength ', maxLength);
    console.log('startIndex ', startIndex + 1);

    // store result
    let result = [];
    for (let i = startIndex + 1; i < startIndex + 1 + maxLength; i++) {
        result.push(A[i]);
    }
    console.log('result ', result);
    return result;
}

findLargestSubArrayWithSumZero([1, 2, -2, 4, -4]);
findLargestSubArrayWithSumZero([3, 3, 4, -5, -2, 2, 1, -3, 3, -1, 5, -4, -1]);
findLargestSubArrayWithSumZero([4, -3, -1, 2, -2]);
findLargestSubArrayWithSumZero([1, 2, -3, 3]);