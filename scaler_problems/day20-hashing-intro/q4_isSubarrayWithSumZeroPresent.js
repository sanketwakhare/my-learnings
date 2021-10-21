/**
 * Sub-array with 0 sum
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1 else return 0.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return whether the given array contains a subarray with a sum equal to 0.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [-1, 1]

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No subarray has sum 0.
Explanation 2:
 The array has sum 0.
 */

const isSubarrayWithSumZeroPresent = (A) => {

    // generate prefix sum
    let pf = [];
    pf.push(A[0]);
    for (let i = 1; i < A.length; i++) {
        // generate prefix sum
        pf.push(pf[i - 1] + A[i]);
    }

    // build hashMap
    let hashMap = new Map();
    for (let i = 0; i < pf.length; i++) {
        if (hashMap.has(pf[i])) {
            let currentFrequency = hashMap.get(pf[i]);
            hashMap.set(pf[i], currentFrequency + 1);
        } else {
            hashMap.set(pf[i], 1);
        }
    }

    let isSubArrayPresent = 0;
    if (hashMap.has(0)) {
        isSubArrayPresent = 1;
    }
    // check if there exist a duplicate element in prefix sum
    // or check if there exist a zero in prefix sum
    for (let i = 0; i < pf.length; i++) {
        if (hashMap.has(pf[i])) {
            let currentFrequency = hashMap.get(pf[i]);
            if (currentFrequency > 1) {
                isSubArrayPresent = 1;
                break;
            }
        }
    }

    return isSubArrayPresent;

}