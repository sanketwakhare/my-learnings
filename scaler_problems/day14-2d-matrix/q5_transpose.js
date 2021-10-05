/********
 * Matrix Transpose
Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.
NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row


Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

Input Format
First argument is vector of vector of integers A representing matrix.

Output Format
You have to return a vector of vector of integers after doing required operations.

Example Input
Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:
A = [[1, 2],[1, 2],[1, 2]]

Example Output
Output 1:
[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:
[[1, 1, 1], [2, 2, 2]]


Example Explanation
Explanation 1:

Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]] we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
 */

/**
 * TC: O(M*N)
 * SC: O(M*N)
 * @param {Array} A 
 * @returns 
 */
const transpose = A => {

    const N = A.length;
    const M = A[0].length;

    let T = [];

    for (let j = 0; j < M; j++) {
        let newRow = [];
        for (let i = 0; i < N; i++) {
            newRow.push(A[i][j]);
        }
        T.push(newRow);
    }

    // iterate over lower/upper triangular matrix excluding diagonal and swap [i][j] and [j][i]
    // if(N> M){
    // for(let i=1;i<N;i++) {
    //     for(let j=0; j< i-1; j++) {
    //         A[i][j] = A[i][j] ^ A[j][i];
    //         A[j][i] = A[i][j] ^ A[j][i];
    //         A[i][j] = A[i][j] ^ A[j][i];
    //     }
    // }
    // }
    // else{

    // for(let i=0;i<M-1;i++) {
    //     for(let j=M-1; j>i; j--) {
    //         A[i][j] = A[i][j] ^ A[j][i];
    //         A[j][i] = A[i][j] ^ A[j][i];
    //         A[i][j] = A[i][j] ^ A[j][i];
    //     }
    // }
    // }

    return T;
}