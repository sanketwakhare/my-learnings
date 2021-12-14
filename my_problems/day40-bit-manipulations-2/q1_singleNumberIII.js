/****
 * Single Number III
 * 
 * Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
First argument is an array of integer of size N.

Output Format
Return an array of two integers that appear only once.

Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:
A = [1, 2]

Example Output
Output 1:
[3, 4]
Output 2:
[1, 2]

Example Explanation
Explanation 1:
 3 and 4 appear only once.
Explanation 2:
 1 and 2 appear only once.
 */

/**
 * Find position of set bit
 */
const getSetBitPos = (input) => {
    let pos = 0;
    for (let i = 0; i < 32; i++) {
        if (1 & (input >> i)) {
            pos = i;
            break;
        }
    }
    return pos;
}

/**
 * Find 2 non repeating numbers from array where all other elements are repeating twice
 * @param {Array} A array of integers
 * @returns 2 non repeating numbers
 */
const singleNumberIII = (A) => {

    const N = A.length;

    // step 1: take xor of all elements in array A
    let xorOfAll = 0;
    for (let i = 0; i < N; i++) {
        xorOfAll = xorOfAll ^ A[i];
    }

    // step 2: find any set bit position
    const pos = getSetBitPos(xorOfAll);

    // step 3: based on set bit position, form 2 auxiliry buckets
    let missingNo1 = 0;
    let missingNo2 = 0;

    for (let i = 0; i < N; i++) {
        // find the bit at position pos
        if (((A[i] >> pos) & 1) === 1) {
            // set bit
            missingNo1 = missingNo1 ^ A[i];
        } else {
            // unset bit
            missingNo2 = missingNo2 ^ A[i];
        }
    }

    // sort the output array before returning
    const output = [missingNo1, missingNo2].sort((a, b) => a - b);
    console.log(output);
    return output;
}

singleNumberIII([186, 256, 102, 377, 186, 377]);