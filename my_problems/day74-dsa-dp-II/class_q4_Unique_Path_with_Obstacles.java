import java.util.Arrays;

/* Unique Paths with Obstacles */

/* Count total ways to reach from top to bottom in 2d matrix when obstacles are present
Allowed directions-> RIGHT and DOWN */

public class class_q4_Unique_Path_with_Obstacles {

    /**
     * Approach 1: Recursion- backtracking
     * TC: O(2^n)
     * SC: O(n) recursion stack space
     */
    public int backtrack(int i, int j, int n, int m, int[][] A) {

        if (i >= n || j >= m || A[i][j] == 1) {
            // if obstacle or out of boundary
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            // base condition if last cell
            return 1;
        }

        // go to DOWN
        int x = backtrack(i + 1, j, n, m, A);
        // go to RIGHT
        int y = backtrack(i, j + 1, n, m, A);

        return x + y;
    }

    /**
     * Approach 2 - recursion + DP
     * TC: O(n x m)
     * SC: O(n x m) for sp array + stack space
     * 
     * @param i  current row index
     * @param j  current column index
     * @param n  total rows
     * @param m  total columns
     * @param A  input array/grid
     * @param dp dp array
     * @return total no of ways to reach form top to bottom cell
     */
    public int backtrack_with_dp(int i, int j, int n, int m, int[][] A, int[][] dp) {

        if (i >= n || j >= m || A[i][j] == 1) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int x = backtrack_with_dp(i + 1, j, n, m, A, dp);
        int y = backtrack_with_dp(i, j + 1, n, m, A, dp);

        return dp[i][j] = x + y;
    }

    /*
     * Approach 3 - DP + iterative (tabulation)
     * Idea: generate prefix sum for 2d dp array, consider sum = 0 if obstacle is
     * found in path
     * TC: O(n x m)
     * SC: O(n x m) for sp array
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

    /**
     * Approach 4 - Dp + iterative - space optimized
     * TC: O(n x m)
     * SC: O(m) - dp array of size m [1d array]
     */
    public int uniquePath_with_obstacles_optimized(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[] dp = new int[m];

        // build initial dp array with first row of input grid
        dp[0] = A[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < m; j++) {
            if (A[0][j] == 1)
                dp[j] = 0;
            else
                dp[j] = dp[j] + dp[j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if obstacles
                if (A[i][j] == 1)
                    dp[j] = 0;
                // for every start element in row, the value depends upon previous row's same
                // column
                else if (j == 0)
                    dp[j] = dp[j];
                // the remaining values depend upon up form previous row and left value from
                // same row
                else
                    dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {

        class_q4_Unique_Path_with_Obstacles t1 = new class_q4_Unique_Path_with_Obstacles();
        int[][] A, dp;
        int n, m;

        {
            System.out.println("Approach 1: Recursion + backtracking");

            // test case 1
            A = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            System.out.println(t1.backtrack(0, 0, n, m, A)); // 2

            // test case 2
            A = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            System.out.println(t1.backtrack(0, 0, n, m, A)); // 6

            // test case 3
            A = new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            System.out.println(t1.backtrack(0, 0, n, m, A)); // 3
        }

        {
            System.out.println("Approach 2 - Recursion + DP");

            // test case 1
            A = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.backtrack_with_dp(0, 0, n, m, A, dp)); // 2

            // test case 2
            A = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.backtrack_with_dp(0, 0, n, m, A, dp)); // 6

            // test case 3
            A = new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
            n = A.length;
            m = A[0].length;
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.backtrack_with_dp(0, 0, n, m, A, dp)); // 3
        }

        {
            // Approach - DP + iterative (tabulation)
            System.out.println("Approach 3 - DP + iterative (tabulation)");

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

            A = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 6
        }

        {
            // Approach 4 - Dp + iterative - space optimized
            System.out.println("Approach 4 - Dp + iterative - space optimized");

            A = new int[][] { { 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 1

            A = new int[][] { { 1, 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 0

            A = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 2

            A = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 1

            A = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 2

            A = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
            System.out.println(t1.uniquePath_with_obstacles_optimized(A)); // 6

        }
    }

}
