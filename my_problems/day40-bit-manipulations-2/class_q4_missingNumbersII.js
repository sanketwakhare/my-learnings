/****
 * Given an array of numbers A , in which all elements are present from [1 to N+2] except 2 numbers.
 * Find the two elements that are missing.
 * Note: Output array must be sorted.
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
 * Use Bit Manipulation technique
 * @param {Array} A array of integers
 * @returns 
 */
const missingNumber = (A) => {
    const N = A.length;

    // step 1: take xor of all elements in array A and all elements from 1 to N+2
    let xorOfAll = 0;
    for (let i = 0; i < N; i++) {
        xorOfAll = xorOfAll ^ A[i];
    }
    for (let i = 1; i <= N + 2; i++) {
        xorOfAll = xorOfAll ^ i;
    }

    // step 2: find any set bit position
    const pos = getSetBitPos(xorOfAll);

    // step 3: based on set bit position, form 2 auxiliry buckets
    let missingNo1 = 0;
    let missingNo2 = 0;

    for (let i = 0; i < N; i++) {
        // find the bit at position pos
        if ((A[i] & (1 << pos))) {
            // set bit
            missingNo1 = missingNo1 ^ A[i];
        } else {
            // unset bit
            missingNo2 = missingNo2 ^ A[i];
        }
    }
    for (let i = 1; i <= N + 2; i++) {
        // find the bit at position pos
        if ((i & (1 << pos))) {
            // set bit
            missingNo1 = missingNo1 ^ i;
        } else {
            // unset bit
            missingNo2 = missingNo2 ^ i;
        }
    }

    const output = [missingNo1, missingNo2].sort((a, b) => a - b);
    console.log('Missing Numbers ->', output);
    return output;
}

missingNumber([1, 2, 3]);
missingNumber([1, 3, 5, 6, 7]);
missingNumber([5, 4, 2]);