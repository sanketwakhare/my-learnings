/* Unique Paths with Obstacles */

/* Count total ways to reach from top to bottom in 2d matrix when obstacles are present
Allowed directions-> RIGHT and DOWN */

public class class_q4_Unique_Path_with_Obstacles {

    /*
     * Approach - DP + iterative (tabulation)
     * Idea: generate prefix sum for 2d dp array, consider sum = 0 if obstacle is
     * found in path
     * TC: O(n x m)
     * SC: O(n x m)
     */
    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        // initialize dp first row
        for (int j = 0; j < m; j++) {
            if (A[0][j] == 1) {
                // obstacle
                dp[0][j] = 0;
            } else {
                if (j == 0) {
                    dp[0][j] = 1;
                } else if (j > 0) {
                    dp[0][j] += dp[0][j - 1];
                }
            }
        }
        // initialize dp first column - as first element is already considered in first
        // row, start with second row
        for (int i = 1; i < n; i++) {
            if (A[i][0] == 1) {
                // obstacle
                dp[i][0] = 0;
            } else {
                if (i > 0) {
                    dp[i][0] += dp[i - 1][0];
                }
            }
        }

        // update dp array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] == 1) {
                    // obstacle
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {

        class_q4_Unique_Path_with_Obstacles t1 = new class_q4_Unique_Path_with_Obstacles();
        int[][] A;

        {
            // Approach - DP + iterative (tabulation)
            System.out.println("Approach - DP + iterative (tabulation)");

            A = new int[][] { { 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 1

            A = new int[][] { { 1, 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 0

            A = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 2

            A = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 1

            A = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 2
        }
    }

}
