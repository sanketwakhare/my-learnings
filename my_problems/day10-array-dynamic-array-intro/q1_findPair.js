/***
 * Given an array A of size N, check if there exist a pair (i,j) such that A[i]+A[j]=k AND i!=j
 *
 * Note: Use no extra space. i.e. O(1)
 * 
 * Example1: 
 * Inputs: A = [3,-2,1,4,3,6,8], k=5
 * Output: true
 * 4 + 1 = 5
 * 
 * Inputs: A = [3,-2,1,4,3,6,8], k=15
 * Output: false
 * 
 */

/**
 * No of iterations: N(N-1)/2= (N^2/2)-(N/2)
 * Time Complexity: O(N^2)
 * @param {Array} A
 * @param {Object} k
 * @returns
 */
const findPair = (A, k) => {

    // iterate only lower/upper matrix
    for (let i = 0; i < A.length; i++) {
        for (let j = i + 1; j < A.length; j++) {
            if (A[i] + A[j] === k) {
                console.log('Pair exists: ', A[i], ' and ', A[j]);
                return true;
            }
        }
    }
    console.log('Pair does not exist')
    return false;
}

findPair([3, -2, 1, 4, 3, 6, 8], 5);
findPair([3, -2, 1, 4, 3, 6, 8], 15);
findPair([3, -2, 1, 4, 3, 6, 8], 6);
findPair([3, -2, 1, 4, 3, 6, 8], -1);