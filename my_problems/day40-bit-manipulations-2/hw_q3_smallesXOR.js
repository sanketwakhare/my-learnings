/**
 * Smallest XOR problem
 * 
 * Problem Description

Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.

Problem Constraints
0 <= A <= 10^9
0 <= B <= 30

Input Format
First argument contains a single integer A. Second argument contains a single integer B.

Output Format
Return a single integer X.

Example Input
Input 1:
 A = 3
 B = 3
Input 2:
 A = 15
 B = 2


Example Output
Output 1:
 7
Output 2:
 12


Example Explanation
Explanation 1:

 3 xor 7 = 4 which is minimum
Explanation 2:

 15 xor 12 = 3 which is minimum
 * 
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

    let minXOR = A;
    console.log(`input`, A);
    const noOfSetBitsInA = countSetBits(A);
    // console.log(`no of set bits in ${A}`, noOfSetBitsInA);
    // console.log(`after toggling 2nd bit of ${A}`, toggleIthBit(A, 2));
    // console.log(`after toggling 0th bit of ${A}`, toggleIthBit(A, 0));

    // Idea
    // case 1: when no of set bits in A > B
    // replace set bits to unset bits starting from right MSB
    if (noOfSetBitsInA > B) {
        for (let i = 31; i >= 0; i--) {
            // if set bit
            if ((minXOR & (1 << i)) && B > 0) {
                minXOR = toggleIthBit(minXOR, i);
                B--;
            }
            if (B === 0) {
                break;
            }
        }
    }

    // case 2: when no of set bits in A < B
    // replace (B- set bits in A) unset bits to set bits starting from left LSB
    // replace remaining set bits to unset bits
    else {
        let diff = B - noOfSetBitsInA;
        for (let i = 0; i < 32; i++) {
            if (((minXOR & (1 << i)) === 0) && diff > 0) {
                minXOR = toggleIthBit(minXOR, i);
                diff--;
            } else if (minXOR & (1 << i)) {
                minXOR = toggleIthBit(minXOR, i);
            }
        }
    }

    // find x
    let x = A ^ minXOR;
    console.log(`output: ${x}`);

}

smallestXOR(15, 2);
smallestXOR(14, 2);
smallestXOR(7, 1);
smallestXOR(3, 3);
smallestXOR(8, 3);