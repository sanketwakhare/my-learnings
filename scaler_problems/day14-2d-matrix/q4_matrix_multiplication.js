/**
 * Matrix Multiplication
Problem Description
You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

Problem Constraints
1 <= M, N, P <= 100
-100 <= A[i][j], B[i][j] <= 100

Input Format
First argument is a 2D integer matrix A.
Second argument is a 2D integer matrix B.

Output Format
Return a 2D integer matrix denoting AB.

Example Input
Input 1:
 A = [[1, 2],            B = [[5, 6],
      [3, 4]]                 [7, 8]] 
Input 2:
 A = [[1, 1]]            B = [[2],
                              [3]] 

Example Output
Output 1:
 [[19, 22],
  [43, 50]]
Output 2:
 [[5]]

Example Explanation
Explanation 1:
Explanation 2:
 [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
*/

/**
 * Matrix Multiplication
 * @param {*} A 
 * @param {*} B 
 * @returns C multiplication of matrix A and B
 */
const matrixMultiplication = (A, B) => {

    const M = A.length;
    const N = B.length;
    const P = B[0].length;
    let C = [];
    for (let i = 0; i < M; i++) {
        let row = [];
        for (let k = 0; k < P; k++) {
            let sum = 0;
            for (let j = 0; j < N; j++) {
                sum += A[i][j] * B[j][k];
            }
            row.push(sum);
        }
        C.push(row);
    }

    console.log(C);
    return C;
}

matrixMultiplication(
    [[94, 91]],
    [[35, -52, -12, 26, -93, -61], [29, -20, -36, -9, 66, 15]]);