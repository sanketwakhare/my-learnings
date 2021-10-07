/********
 * Row with maximum number of ones
 * 
 * Problem Description  
 * 
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

NOTE:
If two rows have the maximum number of 1 then return the row which has a lower index.
Rows are numbered from top to bottom and columns are numbered from left to right.
Assume 0-based indexing.
Assume each row to be sorted by values.
Expected time complexity is O(rows).

Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 1

Input Format
The only argument given is the integer matrix A.

Output Format
Return the row with the maximum number of 1.

Example Input
Input 1:
 A = [   [0, 1, 1]
         [0, 0, 1]
         [0, 1, 1]   ]
Input 2:
 A = [   [0, 0, 0, 0]
         [0, 1, 1, 1]    ]

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 Row 0 has maximum number of 1s.
Explanation 2:
 Row 1 has maximum number of 1s.
 */

/**
 * Zig-Zag traversal
 * TC: O(N + M)
 * SC: O(1)
 * 
 * @param {Array} A 
 * @returns row with max no of 1s
 */
const rowWithMaxNoOfOnes = (A) => {
    const N = A.length;
    const M = A[0].length;

    let count = 0;
    let i = 0;
    let j = M - 1;
    while (i < N && j >= 0) {
        if (A[i][j] === 1) {
            // exclude columns
            j--;
            count++;
        } else {
            // exclude rows
            i++;
        }
    }
    // if count is 0, return 0
    if (count === 0) {
        return 0;
    }
    console.log(count);
    const columnIndexToIterate = M - count;

    // iterate column with columnIndexToIterate
    for (i = 0; i < N; i++) {
        if (A[i][columnIndexToIterate] === 1) {
            break;
        }
    }

    console.log('row no with max no of 1s', i);
    // i will have lowest index at the end of above for loop
    return i;
}

rowWithMaxNoOfOnes([[0, 1, 1],
[0, 0, 1],
[0, 1, 1]]);

rowWithMaxNoOfOnes([[0, 0, 0, 0],
[0, 1, 1, 1]]);

rowWithMaxNoOfOnes([[0, 1, 1, 1, 1],
[0, 0, 1, 1, 1]]);