/********
 * Row to Column Zero
Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
0 <= A[i][j] <= 103

Input Format
First argument is a vector of vector of integers.(2D matrix).

Output Format
Return a vector of vector after doing required operations.

Example Input
Input 1:
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

Example Output
Output 1:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

Example Explanation
Explanation 1:
A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */

/**
 * TC: O(N*N)
 * SC: O(1)
 * @param {Array} A 
 * @returns Array with row and column elements 0 when there was already a ith and jth element is 0
 */
const rowToColumnZero = (A) => {
    const N = A.length;
    const M = A[0].length;

    let rowIndexesToMakeZero = [];
    let columnIndexesToMakeZero = [];

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (A[i][j] === 0) {
                if (!rowIndexesToMakeZero.includes(i)) {
                    rowIndexesToMakeZero.push(i);
                }
                if (!columnIndexesToMakeZero.includes(j)) {
                    columnIndexesToMakeZero.push(j);
                }
            }
        }
    }

    console.log('rowIndexesToMakeZero', rowIndexesToMakeZero);
    console.log('columnIndexesToMakeZero', columnIndexesToMakeZero);

    for (let i = 0; i < rowIndexesToMakeZero.length; i++) {
        const rowIndex = rowIndexesToMakeZero[i];
        for (let j = 0; j < M; j++) {
            A[rowIndex][j] = 0;
        }
    }

    for (let j = 0; j < columnIndexesToMakeZero.length; j++) {
        const columnIndex = columnIndexesToMakeZero[j];
        for (let i = 0; i < N; i++) {
            A[i][columnIndex] = 0;
        }
    }
    console.log(A);
    return A;
}

rowToColumnZero([[1, 2, 3, 4],
[5, 6, 7, 0],
[9, 2, 0, 4]]);