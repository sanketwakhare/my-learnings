/****
 * Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
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
    let uniqueNo1 = 0;
    let uniqueNo2 = 0;

    for (let i = 0; i < N; i++) {
        // find the bit at position pos
        if (((A[i] >> pos) & 1) === 1) {
            // set bit
            uniqueNo1 = uniqueNo1 ^ A[i];
        } else {
            // unset bit
            uniqueNo2 = uniqueNo2 ^ A[i];
        }
    }

    const output = [uniqueNo1, uniqueNo2].sort((a, b) => a - b);
    console.log('Unique Numbers ->', output);
    return output;
}

singleNumberIII([1, 2, 3, 1, 2, 4]);
singleNumberIII([1, 2]);
singleNumberIII([1, 3, 5, 4, 3, 4, 1, 2]);