/* Problem in class

    Given 2d matrix which is row wise and column wise sorted, Find maximum sub matrix sum
*/

// Idea/Solution Approach: Generate prefix sum and as matrix is sorted the last element would be answer


/*  Check 2 cases
    case 1: Check Top left element to identify if all elements are positive
    case 2: Check Bottom right element to identify if all elements are negative
 */

/**
 * Find max possible sum of a submatrix
 * TC: O(N * M) + O(1) => prefix sum generation time + get max sum
 * SC: O(N * M) => prefix sum space
 * @param {Array} A 2d matrix with rows and columns are sorted
 * @returns max possible sum of any submatrix
 */
const maxSubMatrixSumOfSortedMatrix = (A) => {

    const N = A.length;
    const M = A[0].length;
    let maxSum = 0;

    /**
     * case 1: Check Top left element to identify if all elements are positive 
     * If yes, the max sum is sum of all elements in the matrix
     */
    if (A[0][0] >= 0) {
        for (let i = -0; i < N; i++) {
            for (let j = 0; j < M; j++) {
                maxSum += A[i][j];
            }
        }
        console.log('max sum', maxSum);
        return maxSum;
    }

    /**
     * case 2: Check Bottom right element to identify if all elements are negative,
     * If yes, the max sum is bottom right element in the matrix
     */
    else if (A[N - 1][M - 1] <= 0) {
        maxSum = A[N - 1][M - 1];
        console.log('max sum', maxSum);
        return maxSum;
    }

    // Generate prefix sum 2d array/matrix
    // step1: row wise column sum
    else {

        // initialize pf array
        let pf = [];
        for (let i = 0; i < N; i++) {
            let row = [];
            for (let j = 0; j < M; j++) {
                row.push(0);
            }
            pf.push(row);
        }

        //  step 1: row wise prefix sum
        for (let i = 0; i < N; i++) {
            for (let j = 0; j < M; j++) {
                if (j > 0) {
                    pf[i][j] = pf[i][j - 1] + A[i][j];
                } else {
                    pf[i][j] = A[i][j];
                }
            }
        }

        //  step 1: column wise prefix sum
        for (let j = 0; j < M; j++) {
            for (let i = 1; i < N; i++) {
                pf[i][j] = pf[i - 1][j] + A[i][j];
            }
        }

        console.log('prefix sum', pf);

        //  just return the last element in prefix array
        console.log('max sum', pf[N - 1][M - 1]);
        return pf[N - 1][M - 1];
    }

}

maxSubMatrixSumOfSortedMatrix([
    [-20, -16, -4, 8],
    [-10, -8, 12, 14],
    [-1, 6, 21, 30],
    [5, 7, 28, 42]
]);
maxSubMatrixSumOfSortedMatrix([
    [210, 316, 410],
    [310, 418, 512],
]);
maxSubMatrixSumOfSortedMatrix([
    [-14, -10, -6],
    [-10, -9, -5],
]);
maxSubMatrixSumOfSortedMatrix([
    [-14, -10, -6],
    [-10, 0, 0],
]);
maxSubMatrixSumOfSortedMatrix([
    [0, 10, 15],
    [10, 15, 20],
]);