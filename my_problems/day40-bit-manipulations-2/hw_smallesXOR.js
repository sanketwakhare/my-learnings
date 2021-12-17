/**
 * Smallest XOR problem
 */

/**
 * count set bits
 * @param {Number} A
 * @returns 
 */
const countSetBits = (A) => {
    let count = 0;
    for (let i = 0; i < 32; i++) {
        if (A & (1 << i)) {
            count++;
        }
    }
    return count;
}

/**
 * toggle ith bit
 * @param {Number} A integer number A
 * @param {Number} i index / bit position
 * @returns 
 */
const toggleIthBit = (A, i) => {
    let x = 0;
    if (A & (1 << i)) {
        // subtract 2^i from A
        x = A - (1 << i);
    } else {
        // add 2^i in A
        x = A + (1 << i);
    }
    return x;
}

const smallestXOR = (A, B) => {

    const noOfSetBitsInA = countSetBits(A);
    console.log(`no of set bits in ${A}`, noOfSetBitsInA);
    console.log(`after toggling 2nd bit of ${A}`, toggleIthBit(A, 2));
    console.log(`after toggling 0th bit of ${A}`, toggleIthBit(A, 0));

    // Idea
    // case 1: when no of set bits in A > B
    // replace set bits to unset bits starting from right MSB


    // case 2: when no of set bits in A < B
    // replace (B- set bits in A) unset bits to set bits starting from left LSB

}

smallestXOR(15, 2);
smallestXOR(3, 3);
smallestXOR(14, 2);
smallestXOR(8, 3);