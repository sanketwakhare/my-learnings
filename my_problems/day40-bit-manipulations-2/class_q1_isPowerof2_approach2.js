/**
 * Find if the given number N is power of 2 or not
 */

/**
 * Bit Manipulations technique
 * Observation: If the number is power of 2, the number of set bits in N would always be 1
 * Iterations: 32 every time
 * TC: O(32) ~ O(1) but not exactly single operation
 * @param {Number} N integer
 */
const isPowerOf2_approach2 = (N) => {

    let isPowerOf2 = false;
    // count no of set bits in N
    let count = 0;
    for (let i = 0; i < 32; i++) {
        if (N & (1 << i)) {
            count++;
        }
    }
    // if no of set bits in N is 1, then it is a power of 2
    if (count == 1) {
        isPowerOf2 = true;
    }

    console.log('Approach 2-> is', N, 'power of 2 ->', isPowerOf2);
    return isPowerOf2;
}

isPowerOf2_approach2(8);
isPowerOf2_approach2(5);
isPowerOf2_approach2(15);
isPowerOf2_approach2(12);
isPowerOf2_approach2(32);
isPowerOf2_approach2(30);