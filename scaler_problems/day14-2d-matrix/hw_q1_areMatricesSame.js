/*********
 * Are Matrices Same ?
Problem Description

You are given two two matrices A & B of equal sizes and you have to check whether two matrices are equal or not.

NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.

Problem Constraints
1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000

Input Format
First argument is vecotor of vector of integers representing matrix A.
Second argument is vecotor of vector of integers representing matrix B.

Output Format
Return 1 if both matrices are equal or return 0.

Example Input
Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
==> Clearly all the elements of both matrices are equal at respective positions.
Explanation 2:
==> Clearly all the elements of both matrices are not equal at respective positions.
 */

/**
 * arrays A and B of same size N*M
 * TC: O(N*N)
 * @param {Array} A 
 * @param {Array} B 
 * @returns 
 */
const areMatricesSame = (A, B) => {

    const N = A.length;
    const M = A[0].length;

    let areMatricesSame = 1;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (A[i][j] !== B[i][j]) {
                areMatricesSame = 0;
            }
        }
    }
    console.log(areMatricesSame);
    return areMatricesSame;
}

areMatricesSame([[1, 2, 3], [4, 5, 6], [7, 8, 9]],
    [[1, 2, 3], [4, 5, 6], [7, 8, 9]]);

areMatricesSame([[1, 2, 3], [4, 5, 6], [7, 8, 9]],
    [[1, 2, 3], [7, 8, 9], [4, 5, 6]]);