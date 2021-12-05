/*******
 * Problem Description

Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:
Rows are numbered from top to bottom and columns are numbered from left to right.
Sum may be large so return the answer mod 109 + 7.

Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M

Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.

Output Format
Return an integer array containing the submatrix sum for each query.

Example Input:
Input 1:
 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:
 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]

Example Output:
Output 1:
 [12, 28]
Output 2:
 [22, 19]

Example Explanation
Explanation 1:
 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:
 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 */

//param A : array of array of integers
//param B : array of integers
//param C : array of integers
//param D : array of integers
//param E : array of integers
//return a array of integers
const subMatrixSumQueries = (A, B, C, D, E) => {

    // Idea: Generate prefix sum array of 2d matrix and find sum for each submatrix using formula

    const P = BigInt(BigInt(1000000000) + BigInt(7));
    const N = A.length;
    const M = A[0].length;
    // generate prefix sum
    let pf = [];
    // step 1: find row wise sum first
    for (let i = 0; i < N; i++) {
        let row = [];
        for (let j = 0; j < M; j++) {
            if (j > 0) {
                row.push(BigInt(BigInt(BigInt(A[i][j]) % P + BigInt(row[j - 1]) % P) % P));
            } else {
                row.push(BigInt(BigInt(A[i][j]) % P));
            }
        }
        pf.push(row);
    }

    // step 2: find column wise sum on prefix array from step 1
    for (let j = 0; j < M; j++) {
        for (let i = 1; i < N; i++) {
            pf[i][j] = BigInt(pf[i - 1][j] % P + pf[i][j] % P) % P;
        }
    }

    // for every query, find sum
    let result = [];

    // length of B,C,D,E represents size of queries
    for (let i = 0; i < B.length; i++) {
        // convert to 1 based indexing
        const a1 = B[i] - 1;
        const b1 = C[i] - 1;
        const a2 = D[i] - 1;
        const b2 = E[i] - 1;

        let sum = BigInt(pf[a2][b2] % P);
        if (a1 > 0) {
            sum = BigInt(((BigInt(sum) % P) - (BigInt(pf[a1 - 1][b2])) % P) % P);
        }
        if (b1 > 0) {
            sum = BigInt((BigInt(sum % P) - (BigInt(pf[a2][b1 - 1]) % P)) % P);
        }
        if (a1 > 0 && b1 > 0) {
            sum = BigInt((BigInt(sum % P) + (pf[a1 - 1][b1 - 1] % P)) % P);
        }

        // when sum is -ve, add P to it
        if (sum < 0) {
            sum += P;
        }
        result.push(sum % P);
    }
    console.log(result);
    return result;
}

subMatrixSumQueries(
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ], [1, 2], [1, 2], [2, 3], [2, 3]
);