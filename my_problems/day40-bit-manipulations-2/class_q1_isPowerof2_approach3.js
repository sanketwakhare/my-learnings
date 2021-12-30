/**
 * Find if the given number N is power of 2 or not
 */

/**
 * Bit Manipulations technique
 * Observation: N & (N-1) = 0 then N is power of 2
 * Iterations: 1
 * TC: O(1)
 * @param {Number} N integer
 */
const power_of_2_approach3 = (N) => {

    let isPowerOf2 = false;
    if ((N & (N - 1)) === 0) {
        isPowerOf2 = true;
    }

    console.log('Approach 3-> is', N, 'power of 2 ->', isPowerOf2);
    return isPowerOf2;
}

power_of_2_approach3(8);
power_of_2_approach3(5);
power_of_2_approach3(15);
power_of_2_approach3(12);
power_of_2_approach3(32);
power_of_2_approach3(30);