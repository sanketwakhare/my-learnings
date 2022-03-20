import java.util.Arrays;

public class hw_q1_Min_Sum_Path_in_Triangle {

    /**
     * Approach 1 - simple recursion (backtrack)
     * TC: O(2^(n x m))
     * SC: O(n) recursion stack space
     * 
     * @param i
     * @param j
     * @param triangle
     * @param n
     * @return
     */
    public int backtrack(int i, int j, int[][] triangle, int n) {

        if (i == n - 1) {
            return triangle[i][j];
        }

        int down = backtrack(i + 1, j, triangle, n);
        int diagonal = backtrack(i + 1, j + 1, triangle, n);
        return triangle[i][j] + Math.min(down, diagonal);
    }

    /**
     * Approach 2 - recursion + dp 2d array
     * TC: O(n x m)
     * SC: O(n x m) + stack space O(n)
     * 
     * @param triangle
     * @param n
     * @return
     */
    public int rec_dp_approach2(int[][] triangle) {
        int n = triangle.length;
        int dp[][] = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minSum_rec_dp(0, 0, triangle, dp, n);
    }

    public int minSum_rec_dp(int i, int j, int[][] triangle, int[][] dp, int n) {

        if (i == n - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = minSum_rec_dp(i + 1, j, triangle, dp, n);
        int diagonal = minSum_rec_dp(i + 1, j + 1, triangle, dp, n);
        return dp[i][j] = triangle[i][j] + Math.min(down, diagonal);
    }

    /**
     * Approach 3 - tabulation method [iterative + dp 2d array]
     * TC: O(n x m)
     * SC: O(n x m)
     * 
     * @param triangle
     * @param n
     * @return
     */
    public int tabulation_dp(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int ans = dp[n - 1][0];
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }

    /**
     * Approach 4 - space optimized + tabulation method [iterative + dp 1d array]
     * TC: O(n x m)
     * SC: O(n)
     * 
     * @param triangle
     * @param n
     * @return
     */
    public int minimumPathSum_space_optimized(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = triangle[i][j] + dp[j];
                } else {
                    dp[j] = triangle[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        int ans = dp[0];
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[j]);
        }
        return ans;
    }

    public static void main(String[] args) {

        hw_q1_Min_Sum_Path_in_Triangle t1 = new hw_q1_Min_Sum_Path_in_Triangle();
        int[][] A;

        {
            // Approach 1 - simple recursion (backtrack)
            System.out.println("Approach 1 - simple recursion (backtrack)");
            A = new int[][] {
                    { -2 },
                    { -52, -81 },
                    { -75, 67, 15 },
                    { -51, -75, 13, -57 },
                    { 64, 11, -9, -79, -18 },
                    { -77, 86, -30, -24, -41, -43 },
                    { 54, -89, -22, -34, 26, -58, 33 }
            };
            System.out.println(t1.backtrack(0, 0, A, A.length)); // -303

            A = new int[][] {
                    { 2 },
                    { 3, 4 },
                    { 6, 5, 7 },
                    { 4, 1, 8, 3 }
            };
            System.out.println(t1.backtrack(0, 0, A, A.length)); // 11
        }

        {
            // Approach 2 - recursion + dp 2d array
            System.out.println("Approach 2 - recursion + dp 2d array");
            A = new int[][] {
                    { -2 },
                    { -52, -81 },
                    { -75, 67, 15 },
                    { -51, -75, 13, -57 },
                    { 64, 11, -9, -79, -18 },
                    { -77, 86, -30, -24, -41, -43 },
                    { 54, -89, -22, -34, 26, -58, 33 }
            };
            System.out.println(t1.rec_dp_approach2(A)); // -303

            A = new int[][] {
                    { 2 },
                    { 3, 4 },
                    { 6, 5, 7 },
                    { 4, 1, 8, 3 }
            };
            System.out.println(t1.rec_dp_approach2(A)); // 11
        }

        {
            // Approach 3 - tabulation method [iterative + dp 2d array]
            System.out.println("Approach 3 - tabulation method [iterative + dp 2d array]");
            A = new int[][] {
                    { -2 },
                    { -52, -81 },
                    { -75, 67, 15 },
                    { -51, -75, 13, -57 },
                    { 64, 11, -9, -79, -18 },
                    { -77, 86, -30, -24, -41, -43 },
                    { 54, -89, -22, -34, 26, -58, 33 }
            };
            System.out.println(t1.tabulation_dp(A)); // -303

            A = new int[][] {
                    { 2 },
                    { 3, 4 },
                    { 6, 5, 7 },
                    { 4, 1, 8, 3 }
            };
            System.out.println(t1.tabulation_dp(A)); // 11
        }

        {
            // Approach 4 - space optimized + tabulation method [iterative + dp 2d array]
            System.out.println("Approach 4 - space optimized + tabulation method [iterative + dp 2d array]");
            A = new int[][] {
                    { -2 },
                    { -52, -81 },
                    { -75, 67, 15 },
                    { -51, -75, 13, -57 },
                    { 64, 11, -9, -79, -18 },
                    { -77, 86, -30, -24, -41, -43 },
                    { 54, -89, -22, -34, 26, -58, 33 }
            };
            System.out.println(t1.minimumPathSum_space_optimized(A)); // -303

            A = new int[][] {
                    { 2 },
                    { 3, 4 },
                    { 6, 5, 7 },
                    { 4, 1, 8, 3 }
            };
            System.out.println(t1.minimumPathSum_space_optimized(A)); // 11
        }
    }
}
