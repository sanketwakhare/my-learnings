/**
 * Anti Diagonals
Problem Description

Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9

Input Format
First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.

Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.

Example Input
Input 1:
3
1 2 3
4 5 6
7 8 9
Input 2:
1 2
3 4

Example Output
Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:
1 0
2 3
4 0

Example Explanation
For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
For input 2:

The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
 */

/**
 * Print anti diagonals of square matrix N*N
 * @param {Array} A 
 * @returns Array of anti diagonals
 */
const printAntiDiagonals = (A) => {

    /** M+N-1 diagonals */
    let N = A.length;
    let result = [];

    for (let j = 0; j < N; j++) {
        let singleAntiDiagonal = [];
        let start = 0;
        let end = j;
        while (start < N && end >= 0) {
            singleAntiDiagonal.push(A[start][end]);
            start++;
            end--;
        }
        while (start < N) {
            singleAntiDiagonal.push(0);
            start++;
        }
        result.push(singleAntiDiagonal);
    }

    for (let i = 1; i < N; i++) {
        let singleAntiDiagonal = [];
        let start = i;
        let end = N - 1;
        while (start < N && end >= 0) {
            singleAntiDiagonal.push(A[start][end]);
            start++;
            end--;
        }
        while (end >= 0) {
            singleAntiDiagonal.push(0);
            end--;
        }
        result.push(singleAntiDiagonal);
    }

    console.log(result);
    return result;

}

printAntiDiagonals([[1, 2, 3], [4, 5, 6], [7, 8, 9]]);
printAntiDiagonals([[1, 2], [3, 4]]);