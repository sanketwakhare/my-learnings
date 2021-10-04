/**
 * Rotate Matrix
Problem Description
You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.

Problem Constraints
1 <= n <= 1000

Input Format
First argument is a 2D matrix A of integers

Output Format
Return the 2D rotated matrix.

Example Input
Input 1:
 [
    [1, 2],
    [3, 4]
 ]
Input 2:
 [
    [1]
 ]

Example Output
Output 1:
 [
    [3, 1],
    [4, 2]
 ]
Output 2:
 [
    [1]
 ]

Example Explanation
Explanation 1:
 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:
 2D array remains the same as there is only element.
 */

/**
 * Rotate 2 D matrix by 90 degrees clockwise direction.
 * TC: O(N^2)
 * SC: O(1)
 * @param {Array} A 
 * @returns rotated matrix after 90 degrees to clockwise
 */
const rotate2DArrayBy90Degrees = (A) => {
   // do not use extra space. SC should be: O(1)

   // rotate matrix by 90 deg clockwise

   const N = A.length;
   for (let i = 0; i < N / 2; i++) {
      for (let j = i; j < N - i - 1; j++) {
         let temp = A[i][j];
         A[i][j] = A[N - 1 - j][i];
         A[N - 1 - j][i] = A[N - 1 - i][N - 1 - j];
         A[N - 1 - i][N - 1 - j] = A[j][N - 1 - i];
         A[j][N - 1 - i] = temp;
      }
   }
   console.log(A);
   return A;
}

rotate2DArrayBy90Degrees([[1]]);
rotate2DArrayBy90Degrees([[1, 2],
[3, 4]]);
rotate2DArrayBy90Degrees([[1, 2, 3], [4, 5, 6], [7, 8, 9]]);
rotate2DArrayBy90Degrees([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]);
