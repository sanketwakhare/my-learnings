/* Min Sum Path in Matrix */

/* Problem Description

Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.


Problem Constraints

1 <= M, N <= 2000
-1000 <= A[i][j] <= 1000


Input Format
First and only argument is a 2-D grid A.


Output Format
Return an integer denoting the minimum sum of the path.



Example Input

Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output

Output 1:
 8
Output 2:
 -1


Example Explanation

Explanation 1:

 The path will be: 1 -> 3 -> 2 -> 1 -> 1.
Input 2:

 The path will be: 1 -> -3 -> 5 -> -5 -> 1. */

public class q4_Min_Sum_Path_in_Matrix {

    public int minPathSum(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[1][m];

        // update matrix elements
        // fill dp array with first row prefix array
        for (int j = 0; j < m; j++) {
            if (j > 0) {
                dp[0][j] = A[0][j] + dp[0][j - 1];
            } else {
                dp[0][j] = A[0][j];
            }
        }
        // fill remaining elements
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    dp[0][j] = A[i][j] + Math.min(dp[0][j], dp[0][j - 1]);
                } else {
                    dp[0][j] = A[i][j] + dp[0][j];
                }
            }
        }

        // return final answer
        return dp[0][m - 1];
    }

    public static void main(String[] args) {

        q4_Min_Sum_Path_in_Matrix t1 = new q4_Min_Sum_Path_in_Matrix();
        int[][] A;

        {
            A = new int[][] {
                    { 1, 3, 2 },
                    { 4, 3, 1 },
                    { 5, 6, 1 }
            };
            System.out.println(t1.minPathSum(A)); // 8
            A = new int[][] {
                    { 1, -3, 2 },
                    { 2, 5, 10 },
                    { 5, -5, 1 }
            };
            System.out.println(t1.minPathSum(A)); // -1
        }
    }

}
