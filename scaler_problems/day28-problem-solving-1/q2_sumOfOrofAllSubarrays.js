/*******
 * Problem Description

Given an array of integers A of size N.
Value of a subarray is defined as BITWISE OR of all elements in it.
Return the sum of Value of all subarrays of A % 109 + 7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^8

Input Format
The first argument given is the integer array A.

Output Format
Return the sum of Value of all subarrays of A % 109 + 7.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [7, 8, 9, 10]

Example Output
Output 1:
 71
Output 2:
 110

Example Explanation
Explanation 1:
 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71

 Explanation 2:
 Sum of value of all subarray is 110.
 */

/* count subarray with OR as 1 */
const countSubarrayOR = (A) => {
    // calculate no of subarray whose OR of all elements is 1
    const N = A.length;
    let count = 0;
    let subArrayCount = 0;
    for (let i = 0; i < A.length; i++) {
        if (A[i] === 1) {
            subArrayCount += (count * (count + 1)) / 2;
            // reset count to 0
            count = 0;
        } else {
            count++;
        }
    }
    if (count > 0) {
        subArrayCount += (count * (count + 1)) / 2;
    }
    const result = Math.floor(((N) * (N + 1)) / 2) - subArrayCount;
    return result;
}

/* check bit function */
const checkBit = (inputNumber, index) => {
    inputNumber = inputNumber >> index;
    if ((inputNumber & 1) === 1) {
        // the bit is set
        return true;
    }
    // the bit is not set
    return false;
};

/**
 * 
 * @param {Array} A input array
 * @returns 
 */
const sumOfOROfAllSubArrays = (A) => {
    let ans = 0;
    const N = A.length;
    const M = BigInt(1000000007);
    for (let i = 0; i <= 30; i++) {
        let bitArray = [];
        for (let j = 0; j < N; j++) {
            if (checkBit(A[j], i)) {
                bitArray.push(1);
            } else {
                bitArray.push(0);
            }
        }
        const count = countSubarrayOR(bitArray);
        ans = BigInt(ans) + (BigInt(count) % M * BigInt(1 << i) % M) % M;
    }
    ans = Number(ans % M);
    console.log(ans);
    return ans;
}

sumOfOROfAllSubArrays([1, 2, 3, 4, 5]);