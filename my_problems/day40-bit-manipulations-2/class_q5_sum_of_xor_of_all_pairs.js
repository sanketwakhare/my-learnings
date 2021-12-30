/**
 * Find Sum of XOR of all the pairs of a given array elements A of size N 
 */

/**
 * Use bit manipulation XOR property and contribution technique
 * FInd contribution of ith bit
 * TC: O(32*N)
 * @param {Array} A array of integers
 */
const sumOfXOROfAllPairs = (A) => {

    const N = A.length;
    let answer = 0;
    for (let i = 0; i < 32; i++) {

        let count = 0;
        for (let j = 0; j < N; j++) {

            // find elements count with ith bits set 
            if (A[j] & (1 << i)) {
                count++;
            }
        }

        // find contribution of each bit [1<<i ~ 2^i]
        contribution = count * (N - count) * (1 << i);
        // update answer
        answer += (contribution * 2);
    }
    console.log(answer);

}

sumOfXOROfAllPairs([1, 3, 5]); // expected answer = 24
sumOfXOROfAllPairs([3, 5, 6, 8]); //expected answer = 104