/***
 * Problem Description

You are given a 2D integer matrix A having N rows and M columns.
You have to return a 2D matrix containing only even elements in every row.i.e. You have to remove all the odd elements in every row and return the resulting matrix.
NOTE: You are allowed to use extra memory.


Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j] <= 10^9

Input Format
First and only argument is a 2D integer matrix.

Output Format
Return a 2D integer matrix.

Example Input
Input 1:
 [ [1, 2, 3, 4],
   [4, 5, 6, 7],
   [8, 9, 10, 11],
   [13, 15, 17, 19] ]
Input 2:
 [ [5, 17, 1],
   [2, 2, 6] ]

Example Output
Output 1:
 [ [2, 4],
   [4, 6],
   [8, 10],
   [] ]
Output 2:
 [ [],
   [2, 2, 6] ]

Example Explanation

Explanation 1:
 In row 1, Values 1 and 3 are removed.
 In row 2, Values 5 and 7 are removed.
 In row 3, Values 9 and 11 are removed.
 In row 4, all the values are removed.
Explanation 2:
 In row 1, all the values are removed.
 In row 2, no values are removed.
 */

/**
 * 2D matrix array problem.
 * @param {Array} A input array
 * @returns 
 */
const oddRemoved = (A) => {
    const N = A.length;
    const M = A[0].length;
    let result = [];
    for (let i = 0; i < N; i++) {
        let innerArray = [];
        for (let j = 0; j < M; j++) {
            const currentElement = A[i][j];
            if (currentElement % 2 === 0) {
                innerArray.push(A[i][j]);
            }
        }
        result.push(innerArray);
    }

    return result;
}