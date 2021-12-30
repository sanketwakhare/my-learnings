/**
 * Given an array of integers A of size N. All the numbers in array from 1 to N+1 except one missing number.
 * Find that number
 */

/**
 * Find missing number using XOR bit manipulations technique
 * TC: O(N)
 * @param {Array} A array of integers
 */
const findMissingNumber = (A) => {

    const N = A.length;
    // initialize answer
    let ans = 0;

    // iterate array elements and take xor of all numbers
    for (let i = 0; i < N; i++) {
        ans = ans ^ A[i];
    }

    // take xor of all numbers from [1 to N+1]
    for (let i = 1; i <= N + 1; i++) {
        ans = ans ^ i;
    }

    console.log('missing number -> ', ans);
    return ans;

}

findMissingNumber([1, 4, 3, 5, 6]); // missing number = 2
findMissingNumber([5, 6, 3, 4, 2, 1, 9, 8]); // missing number = 7
findMissingNumber([5, 6, 3, 12, 14, 13, 10, 4, 2, 1, 7, 9, 8]); // missing number = 11