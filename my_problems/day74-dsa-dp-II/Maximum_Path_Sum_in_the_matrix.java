/* Maximum Path Sum in the matrix */

// https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

import java.util.Arrays;

public class Maximum_Path_Sum_in_the_matrix {

    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            ans = Math.max(ans, backtrack(0, j, n, m, matrix, dp));
        }
        return ans;
    }

    public static int backtrack(int i, int j, int n, int m, int[][] matrix, int[][] dp) {

        if (j < 0 || j >= m) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            dp[i][j] = matrix[i][j];
            return dp[i][j];
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int ld = backtrack(i + 1, j - 1, n, m, matrix, dp);
        int dd = backtrack(i + 1, j, n, m, matrix, dp);
        int rd = backtrack(i + 1, j + 1, n, m, matrix, dp);

        dp[i][j] = matrix[i][j] + Math.max(Math.max(ld, dd), rd);
        return dp[i][j];
    }

    public static void main(String[] args) {

        int[][] A;

        A = new int[][] {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 } };
        System.out.println(getMaxPathSum(A)); // 105

        A = new int[][] {
                { 10, 2, 3 },
                { 3, 7, 2 },
                { 8, 1, 5 }
        };
        System.out.println(getMaxPathSum(A)); // 25

    }
}
