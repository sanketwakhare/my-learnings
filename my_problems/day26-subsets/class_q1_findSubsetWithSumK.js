/* Given an array A of size N, check if there exist a subset with sum K */

/**
 * Check if there exist a subset with sum K
 * TC: O(2^n * n)
 * SC: O(1)
 * @param {Array} A input array A of size N
 * @param {Number} K number K
 * @returns 
 */
const isSubSetWithSumKPresent = (A, K) => {

    // for array of size N, 2^(N) - 1 subsets can be formed
    const N = A.length;

    for (let i = 0; i < (1 << N); i++) {
        // i is mapped to each subset

        let sum = 0;
        for (let j = 0; j < N; j++) {
            if (checkBit(i, j)) {
                // A[j] is considered
                sum = sum + A[j];
            }
        }
        if (sum === K) {
            console.log(true);
            return true;
        }
    }
    console.log(false);
    return false;
}

/* check bit function */
const checkBit = (inputNumber, index) => {
    inputNumber = inputNumber >> index;
    if ((inputNumber & 1) === 1) {
        // the bit is set
        return true;
    }
    // the bit is not set
    return false;
};

isSubSetWithSumKPresent([3, -1, 0, 6, 2, -3, 5], 10);
isSubSetWithSumKPresent([3, -1, 0, 6, 2, -3, 5], 8);
isSubSetWithSumKPresent([3, -1, 0, 6, 2, -3, 5], 17);