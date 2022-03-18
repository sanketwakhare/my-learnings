import java.util.Arrays;

/* No of ways to travel from [0,0] to [n,m] bottom cell in Matrix 

Note: We can travel in only right and Down directions

*/

public class class_q2_Total_Unique_Paths {

    /*
     * Approach 1: Simple recursion
     * TC: O(n x m)
     * SC: O(max(n, m)) recursion stack space
     */
    public int ways_backtrack_recursion(int n, int m) {

        if (n == 0 || m == 0) {
            return 1;
        }
        // collect ways from top and left
        return ways_backtrack_recursion(n - 1, m) + ways_backtrack_recursion(n, m - 1);
    }

    /*
     * Approach 2- Recursion + dp
     * TC: O(n x m)
     */
    public int ways_recursion_dp(int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return 1;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // collect ways from top and left
        dp[n - 1][m] = ways_recursion_dp(n - 1, m, dp);
        dp[n][m - 1] = ways_recursion_dp(n, m - 1, dp);
        dp[n][m] = dp[n - 1][m] + dp[n][m - 1];
        return dp[n][m];
    }

    /*
     * Approach 3: tabulation
     * TC: O(n x m)
     * SC: O(n x m) - for dp array
     */
    public int ways_tabulation(int n, int m) {

        int[][] dp = new int[n][m];

        /**
         * Step 1:
         * fill first row and first column with value 1 as there can be only 1 way to
         * reach those cells.
         * either from right or down
         */
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        /* Step 2: */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

    /*
     * Approach 4: iterative space optimized
     * Idea: at a given time, we are dependent only on one row above and one column
     * to left
     * TC: O(n x m)
     * SC: O(1) using dp array of size of m - only single row
     */
    public int ways_iterative_optimized(int n, int m) {

        int[][] dp = new int[1][m];

        /**
         * Step 1:
         * fill first row and first column with value 1 as there can be only 1 way to
         * reach those cells.
         */
        for (int i = 0; i < 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        /* Step 2: */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // take same element + left element
                dp[0][j] = dp[0][j] + dp[0][j - 1];
            }
        }

        return dp[0][m - 1];
    }

    public static void main(String[] args) {

        class_q2_Total_Unique_Paths t1 = new class_q2_Total_Unique_Paths();

        int n;
        int m;

        /* Approach 1 - simple recursion */
        System.out.println("Approach 1 - simple recursion");
        n = 4;
        m = 4;
        System.out.println(t1.ways_backtrack_recursion(n - 1, m - 1)); // 20
        n = 5;
        m = 6;
        System.out.println(t1.ways_backtrack_recursion(n - 1, m - 1)); // 126

        /* Approach 2 - recursion + DP */
        System.out.println("Approach 2 - recursion + DP");
        n = 4;
        m = 4;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(t1.ways_recursion_dp(n - 1, m - 1, dp)); // 20

        /* Approach 3 - tabulation method - iterative */
        System.out.println("Approach 3 - tabulation method");
        // test case 1
        n = 4;
        m = 4;
        System.out.println(t1.ways_tabulation(n, m)); // 20
        // test case 2
        n = 4;
        m = 5;
        System.out.println(t1.ways_tabulation(n, m)); // 35

        /* Approach 4 - iterative method + space optimized */
        System.out.println("Approach 4 - iterative space optimized method");
        // test case 1
        n = 4;
        m = 4;
        System.out.println(t1.ways_iterative_optimized(n, m)); // 20
        // test case 2
        n = 4;
        m = 5;
        System.out.println(t1.ways_iterative_optimized(n, m)); // 35

    }

}