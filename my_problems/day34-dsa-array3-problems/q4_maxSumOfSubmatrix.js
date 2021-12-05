/*******
 * Maximum Sum Square SubMatrix

Problem Description
Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.

Problem Constraints
1 <= N <= 10^3.
1 <= B <= N
-10^2 <= A[i][j] <= 10^2.

Input Format
First argument is an 2D integer matrix A.
Second argument is an integer B.

Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.

Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2

Example Output
Output 1:
 48
Output 2:
 8

Example Explanation
Explanation 1:
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:
 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
 */

/**
 * TC: O(N^2 * M) or O(N * M^2)
 * SC: O(N * M) for prefix array
 * @param {Array} A input 2d matrix
 * @param {Number} B size of target submatrix for which sum to be found
 * @returns 
 */

const maxSum = (A, B) => {

    const N = A.length;
    const M = A[0].length;

    let ans = Number.MIN_SAFE_INTEGER;

    // find prefix sum column wise

    // initialize prefix array
    let pfColumnWise = Array.from({ length: N }, () =>
        Array.from({ length: M }, () => Number(0))
    );
    // generate column wise prefix array matrix
    for (let j = 0; j < M; j++) {
        for (let i = 0; i < N; i++) {
            if (i === 0) {
                pfColumnWise[i][j] = A[i][j];
            } else {
                pfColumnWise[i][j] = pfColumnWise[i - 1][j] + A[i][j];
            }
        }
    }

    // B = height and width of matrix

    for (let topRow = 0, bottomRow = topRow + B - 1; topRow <= N - B, bottomRow < M; topRow++, bottomRow++) {

        for (let j = 0; j <= M - B; j++) {
            // Apply Kadene's algorithm for each submatrix of size BxB
            let sum = 0;
            for (let k = 0; k < B; k++) {
                sum += pfColumnWise[bottomRow][j + k];
                if (topRow > 0) {
                    sum -= pfColumnWise[topRow - 1][j + k];
                }
            }
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
    }
    console.log(ans)
    return ans;
}

maxSum([
    [2, 2],
    [2, 2]
], 2);

maxSum([
    [1, 1, 1, 1, 1],
    [2, 2, 2, 2, 2],
    [3, 8, 6, 7, 3],
    [4, 4, 4, 4, 4],
    [5, 5, 5, 5, 5]
], 3)