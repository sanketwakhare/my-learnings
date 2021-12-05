/***
 * Sum of all Submatrices
 * 

Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible submatrices.

Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10

Input Format
Single argument representing a 2-D array A of size N x N.

Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.

Example Input
A = [ [1, 1]
      [1, 1] ]

Example Output
16

Example Explanation
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
 */

/**
 * Find total sum of all submatrices
 * Use contribution of each element technique
 * TC: (N * M)
 * SC: (1)
 * @param {Array} A array of array of integers, 2D matrix
 * @returns total sum of all submatrices
 */
const sumOfAllSubMatrices = (A) => {

    const N = A.length;
    const M = A[0].length;
    let totalSum = 0;

    // Use contribution of each element technique
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            /* totalSum = contribution of A[i][j] * (total possible Top Left combinations where A[i][j] can occur) 
                            * (total possible Bottom Right combinations where A[i][j] can occur)
                        = A[i][j] * ((i + 1) * (j + 1)) * ((N - i) * (M - j))
             */
            totalSum += A[i][j] * (i + 1) * (j + 1) * (N - i) * (M - j);
        }
    }
    console.log(totalSum)
    return totalSum;

}

sumOfAllSubMatrices([
    [1, 1],
    [1, 1]
]);
sumOfAllSubMatrices([
    [4, 2],
    [-3, -2]
]);
sumOfAllSubMatrices([
    [3, 2],
    [1, 4]
]);