/*******
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
 * Find if there exist and elements a and b in array such than a-b=K where a and b are having different indices
 * TC: O(N): iterate over array
 * SC: O(N) : extra space to maintain hashMap
 * @param {Array} A input array A of integers
 * @param {Number} K target difference between a-b = k
 * @returns 
 */
const diffPossible = (A, K) => {

    const N = A.length;
    // build hashMap. add every array element into hashMap with frequency
    let hashMap = new Map();
    for (let i = 0; i < N; i++) {
        if (hashMap.has(A[i])) {
            const currentFrequency = hashMap.get(A[i]);
            hashMap.set(A[i], currentFrequency + 1);
        } else {
            hashMap.set(A[i], 1);
        }
    }

    for (let i = 0; i < N; i++) {
        // A[i] - A[j] = K => A[j] = K - A[i]
        // here A[i] = a = current array element
        // A[j] = b = check if element b is present in hashMap
        // K = a - b
        let a = A[i];
        let b = a - K;

        if (a !== b) {
            // if a and b are different, check if it is present in hashMap
            if (hashMap.has(b)) {
                console.log(a, 'and', b, 'are present ~ a-b=K ', K);
                return 1;
            }
        }
        if (a === b) {
            // if both a and b are same, check if the frequency is at least 2
            const frequencyOfB = hashMap.get(b);
            if (frequencyOfB >= 2) {
                console.log(a, 'and', b, 'are present ~ a-b=K ', K);
                return 1;
            }
        }
    }
    // if element b is not present in hashMap ,return 0
    console.log('not found');
    return 0;
}

diffPossible([1, 5, 3], 2);
diffPossible([10, 15, 30, 5, 3, -6, 7], 23);