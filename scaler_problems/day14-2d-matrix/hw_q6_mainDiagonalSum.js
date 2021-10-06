/**
 * Main Diagonal Sum
Problem Description

You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.

Problem Constraints
1 <= N <= 103
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2D integer matrix A.

Output Format
Return an integer denoting the sum of main diagonal elements.

Example Input
Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
Input 2:
 A = [[3, 2],
      [2, 3]]

Example Output
Output 1:
 15 
Output 2:
 6 

Example Explanation
Explanation 1:
 A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15
Explanation 2:
 A[1][1] + A[2][2] = 3 + 3 = 6
 */

/**
 * Calculate main diagonal sum
 * TC: O(N^2)
 * SC: O(1)
 * @param {Array} A 
 * @returns principal/main diagonal sum
 */
const mainDiagonalSum = (A) => {
    const N = A.length;
    const M = A[0].length;

    let sum = 0;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (i === j) {
                sum += A[i][j];
            }
        }
    }
    console.log(sum);
    return sum;
}

mainDiagonalSum(
    [
        [11, 32, 73],
        [42, 51, 6],
        [73, 84, 92]
    ]);
mainDiagonalSum(
    [
        [1, -2, -3],
        [-4, 5, -6],
        [-7, -8, 9]
    ]);
mainDiagonalSum(
    [
        [3, 2],
        [2, 3]
    ]);