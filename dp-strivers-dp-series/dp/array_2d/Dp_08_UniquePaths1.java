package dp.array_2d;

import java.util.Arrays;

/**
 * Unique Paths
 * <p>
 * Given two values M and N, which represent a matrix[M][N].
 * We need to find the total unique paths from the top-left cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470">Unique Paths</a>
 * <a href="https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/">Take U Forward Link</a>
 */
public class Dp_08_UniquePaths1 {

    public static void main(String[] args) {
        Dp_08_UniquePaths1 t1 = new Dp_08_UniquePaths1();
        int m = 15, n = 15;
        t1.uniquePaths(m, n);
    }

    public void uniquePaths(int n, int m) {
        {
            // approach 1: recursion
            long start = System.nanoTime();
            int answer = uniquePaths_1(m, n);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.print("Total unique paths: " + answer);
            System.out.println(" [time: " + elapsedTime + " ms]");
        }
        {
            // approach 2: recursion + memoization
            long start = System.nanoTime();
            int answer = uniquePaths_2(m, n);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.print("Total unique paths: " + answer);
            System.out.println(" [time: " + elapsedTime + " ms]");
        }
        {
            // approach 3: iterative tabulation
            long start = System.nanoTime();
            int answer = uniquePaths_3(m, n);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.print("Total unique paths: " + answer);
            System.out.println(" [time: " + elapsedTime + " ms]");
        }
        {
            // approach 4: iterative tabulation + space optimized
            long start = System.nanoTime();
            int answer = uniquePaths_4(m, n);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.print("Total unique paths: " + answer);
            System.out.println(" [time: " + elapsedTime + " ms]");
        }
    }

    // approach 1: recursion
    // TC: O(2^(n+m))
    // SC: O(n*m) -> recursion stack space
    public int uniquePaths_1(int n, int m) {
        if (n == 1 && m == 1) return 1;
        if (n < 0 || m < 0) return 0;
        return uniquePaths_1(n - 1, m) + uniquePaths_1(n, m - 1);
    }

    // approach 2: recursion + memoization
    // TC: O(n*m)
    // SC: O(n*m) dp array + recursion stack space O(n*m)
    public int uniquePaths_2(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        return f2(n, m, dp);
    }

    public int f2(int n, int m, int[][] dp) {
        if (n == 1 && m == 1) return 1;
        if (n < 0 || m < 0) return 0;
        if (dp[n][m] != 0) return dp[n][m];
        return dp[n][m] = f2(n - 1, m, dp) + f2(n, m - 1, dp);
    }

    // approach 3: iterative tabulation
    // TC: O(n*m)
    // SC: O(n*m) -> dp array
    public int uniquePaths_3(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        // initialize first row and first column as 1 as there is only one way to reach those cells
        Arrays.fill(dp[1], 1);
        for (int i = 0; i <= n; i++) dp[i][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

    // approach 4: iterative tabulation + space optimized
    // TC: O(n*m)
    // SC: O(n) -> dp array
    private int uniquePaths_4(int m, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= m; i++) {
            int prev = dp[1];
            for (int j = 2; j <= n; j++) {
                dp[j] = dp[j] + prev;
                prev = dp[j];
            }
        }
        return dp[n];
    }
}
