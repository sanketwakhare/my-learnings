/**
 * Lower Triangular Matrix
Problem Description
You are given a N X N integer matrix A. You have to tell whether it is a lower triangular matrix or not.
A square matrix is called lower triangular if all the entries above the main diagonal are zero. For any matrix P if elements P[i, j] = 0 (where j > i (1-based)).


Problem Constraints
2 <= N <= 10^3
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2D integer matrix A.

Output Format
Return 1 if A is a lower triangular matrix, else return 0.

Example Input
Input 1:
 A = [[1, 0, 0],
      [0, 0, 0],
      [-7, -8, 9]]
Input 2:
 A = [[0, 2],
      [0, 0]]

Example Output
Output 1:
 1 
Output 2:
 0 

Example Explanation
Explanation 1:
 As A[1][2], A[1][3] and A[2][3] are zero, it is a lower triangular matrix.
Explanation 2:
 As A[1][2] is not equal to zero, it is not a lower triangular matrix.
 */
const isLowerTriangularMatrix = (A) => {
  let isLowerTriangularMatrix = 1;
  // iterate over outer array
  for (let i = 0; i < A.length; i++) {
    // iterate only upper right triangular matrix anad check if every elemnt is non 0
    for (let j = i + 1; j < A.length; j++) {
      if (A[i][j] !== 0) {
        isLowerTriangularMatrix = 0;
        i = A.length;
        break;
      }
    }
  }
  console.log(isLowerTriangularMatrix);
  return isLowerTriangularMatrix;
};

isLowerTriangularMatrix([
  [1, 111, 222],
  [0, 0, 333],
  [-7, -8, 9],
]);
isLowerTriangularMatrix([
  [1, 0, 0],
  [0, 0, 0],
  [-7, -8, 9],
]);
isLowerTriangularMatrix([
  [285, -982],
  [931, -482],
]);
