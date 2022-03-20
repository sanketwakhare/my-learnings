/* Minimum Falling Path Sum II */

/* Problem Description

Given a square grid of integers A, a falling path with non-zero shifts is a choice of exactly one element from each row of A, such that no two elements chosen in adjacent rows are in the same column.

Return the minimum sum of a falling path with non-zero shifts.


Problem Constraints

1 <= |A| == |A[i]| <= 200
-99 <= A[i][j] <= 99


Input Format

First argument is a 2D array of integers.


Output Format

Return an integer denoting the minimum sum.


Example Input

Input 1:

 A =  [ [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9] ]
Input 2:

 A =  [ [17, 14, 19],
        [12, 18, 9],
        [20, 10, 1] ]


Example Output

Output 1:

 13
Output 2:

 27


Example Explanation

Explanation 1:

 The possible falling paths are:
 [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 The falling path with the smallest sum is [1,5,7], so the answer is 13.
Explanation 2:

 The possible falling paths are:
 The falling path with the smallest sum is [14,12,1], so the answer is 27. */


//param A : array of array of integers
//return an integer
const solve = function(A) {

    // initialize required array and variables
    let n = A.length;
    let m = A[0].length;
    let dp = [];
    for (let i = 0; i < n; i++) {
        let row = new Array(m).fill(Number.MAX_SAFE_INTEGER);
        dp.push(row);
    }

    // as there are multiple start points and multiple end points, invoke function for each element in first row
    let ans = Number.MAX_SAFE_INTEGER;
    for (j = 0; j < m; j++) {
        ans = Math.min(ans, minPath(0, j, n, m, A, dp));
    }

    console.log(ans);
    return ans;
}

const minPath = (i, j, n, m, A, dp) => {

    // base condition when element goes out of boundary
    if (j < 0 || j >= m) {
        return Number.MAX_SAFE_INTEGER;
    }

    // base condition when element reaches last row
    if (i === n - 1) {
        dp[i][j] = A[i][j];
        return dp[i][j];
    }

    // if value is already calculated for a given subproblem, reuse the same
    if (dp[i][j] !== Number.MAX_SAFE_INTEGER) {
        return dp[i][j];
    }

    // consider each element from current row except jth element (which was considered in previous row)
    let currMin = Number.MAX_SAFE_INTEGER;
    for (let k = 0; k < m; k++) {
        // take minimum of all path values
        if (k !== j)
            currMin = Math.min(currMin, minPath(i + 1, k, n, m, A, dp));
    }

    // store answer in dp array and return
    dp[i][j] = A[i][j] + currMin;
    return dp[i][j];
}

solve([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]); // 13

solve([
    [17, 14, 19],
    [12, 18, 9],
    [20, 10, 1]
]); // 27