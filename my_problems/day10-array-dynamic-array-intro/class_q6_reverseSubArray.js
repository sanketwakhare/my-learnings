/**
 * Given an array A of size N, and a,b
 * Reverse subArray from a to b
 */

/**
 * Reverse sub array
 * @param {Array} A array with N elements
 * @param {object} a start index of subarray
 * @param {*} b end index of subarray
 * @returns array with reversed subarray
 */
const reverseSubArray = (A, a, b) => {
    console.log('original array: ', A);
    for (let i = a, j = b; i < j; i++, j--) {
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }
    console.log('reversed array: ', A);
    return A;
}

reverseSubArray([2, -3, 4, -5, 12, 7, 5, 9], 2, 6);

reverseSubArray([2, -3, 4, -5, 12, 7, 5, 9], 4,);