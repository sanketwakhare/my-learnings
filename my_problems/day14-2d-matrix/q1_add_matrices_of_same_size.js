/**
 * Add the matrices
Problem Description

You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.



Problem Constraints
1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000



Input Format
First argument is vector of vector of integers representing matrix A.

Second argument is vecotor of vector of integers representing matrix B.



Output Format
You have to return a vector of vector of integers after doing required operations.



Example Input
Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]


Example Output
Output 1:

[[10, 10, 10], [10, 10, 10], [10, 10, 10]]


Example Explanation
Explanation 1:

A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
 */

/**
 * Add 2 Matrices
 * TC: O(N*M)
 * SC: O(N*M)
 * @param {Array} A 
 * @param {Array} B 
 * @returns C = A+B
 */
const addMatrices = function (A, B) {
    let C = [];
    for (let i = 0; i < A.length; i++) {
        let row = [];
        for (let j = 0; j < A[i].length; j++) {
            row.push((A[i][j] + B[i][j]));
        }
        C.push(row);
    }
    console.log(C);
    return C;
}

addMatrices([[1, 2, 3], [4, 5, 6], [7, 8, 9]],
    [[9, 8, 7], [6, 5, 4], [3, 2, 1]]);

addMatrices([[1], [2], [3], [4], [5]], [[1], [2], [3], [4], [5]]);