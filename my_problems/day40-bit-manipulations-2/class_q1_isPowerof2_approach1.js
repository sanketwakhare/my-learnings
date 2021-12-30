/**
 * Find if the given number N is power of 2 or not
 */

/**
 * Brute force approach: divide until N becomes 0
 * TC: O(logN base 2): each time the number gets divided to half
 * @param {Number} N integer
 */
const isPowerOf2_approach1 = (N) => {

    const x = N;
    let isPowerOf2 = true;
    while (N > 1) {
        if ((N % 2) !== 0) {
            isPowerOf2 = false;
            break;
        }
        N = N / 2;
    }
    console.log('Approach 1-> is', x, 'power of 2 ->', isPowerOf2);
    return isPowerOf2;
}

isPowerOf2_approach1(8);
isPowerOf2_approach1(5);
isPowerOf2_approach1(15);
isPowerOf2_approach1(12);
isPowerOf2_approach1(32);
isPowerOf2_approach1(30);