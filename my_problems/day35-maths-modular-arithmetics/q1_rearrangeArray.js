/******
 * Rearrange Array
 * 
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:
Input : [1, 0]
Return : [0, 1]

Constraints: 
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */

/**
 * TC: O(N)
 * SC: O(1)
 * Re arrange input array such that A[i] = A[A[i]] without using any extra space
 * @param {Array} A input array to be rearranged
 * @returns 
 */
const arrangeArray = (A) => {

    console.log('input', A);
    // Idea: store both index and value in single value such that index and value can be fetched from array element 
    const N = A.length

    // step 1: multiple array with value N
    for (let i = 0; i < N; i++) {
        A[i] *= N;
    }

    // step 2: for every element in updated array from step 1, store index and value
    for (let i = 0; i < N; i++) {

        const index = Math.floor(A[i] / N);
        const value = Math.floor(A[index] / N);

        // update current value
        A[i] += value;
    }

    // step 3: take mod N with updated array
    for (let i = 0; i < N; i++) {
        A[i] %= N;
    }

    console.log('output: ', A);
    return A;
}

arrangeArray([2, 0, 1]);
arrangeArray([1, 0]);
arrangeArray([3, 2, 4, 1, 0]);
arrangeArray([6, 3, 2, 5, 1, 0, 4]);