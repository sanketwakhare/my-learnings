/****
 * Subsequence-Sum Problem
 * You are given an array of integers of N size.
 * 
 * You have to find that there is any subsequence exists or not whose sum is equal to B.
 * 
 * Problem Constraints
 * 1 <= N <= 20
 * 1 <= A[i] <= 100000
 * 0 <= B <= 1e9
 */

/**
 * Check ith bit for N
 * @param {Number} N integer number
 * @param {Number} i bit position
 * @returns 
 */
const checkBit = (N, i) => {
    N = N >> i;
    if ((N & 1) === 1) {
        return true;
    }
    return false;
}

/**
 * Check if there is any subsequence with sum = K
 * TC: O(2^N)
 * @param {Array} A array of integers
 * @param {Number} K integer number
 * @returns 
 */
const subsequenceSumK = (A, K) => {

    // given an array of size N, there are 2^N subsequences
    const N = A.length;

    // 1<<N ~ 2^N
    // check for each subsequence/consider all subsequences
    for (let i = 0; i < (1 << N); i++) {
        let sum = 0;
        // check every bit of size N
        for (let j = 0; j < N; j++) {

            if (checkBit(i, j)) {
                sum = sum + A[j];
            }
        }
        if (sum === K) {
            return true;
        }
    }
    return false;
}

subsequenceSumK([1, 20, 13, 4, 5]);
subsequenceSumK([2, 2, 2, 2]);
subsequenceSumK([-1, 4, 6, 3, 7, 2]);