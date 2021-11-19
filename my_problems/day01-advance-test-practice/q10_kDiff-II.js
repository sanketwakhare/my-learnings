/****
 * Diffk II
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */

/**
 * TC: O(N)
 * SC: O(N)
 * @param {Array} A 
 * @param {Number} K 
 * @returns 
 */
const diffPossible = (A, K) => {

    // hashMap, set frequency of each element in array
    let hashMap = new Map();
    for (let i = 0; i < A.length; i++) {
        if (hashMap.has(A[i])) {
            let currentFrequency = hashMap.get(A[i]);
            hashMap.set(A[i], currentFrequency + 1);
        } else {
            hashMap.set(A[i], 1);
        }
    }

    for (let i = 0; i < A.length; i++) {
        const a = A[i];
        const b = a - K;

        //check if b is present in hashMap
        if (a !== b) {
            if (hashMap.has(b)) {
                console.log(1);
                return 1;
            }
        } else {
            const currentFrequencyOfB = hashMap.get(b);
            if (currentFrequencyOfB >= 2) {
                console.log(1);
                return 1;
            }
        }
    }

    console.log(0);
    return 0;
}

diffPossible([4, 9, 6], 5);