public class class_q3_min_Path_Sum {

    /*
     * Approach 1- simple recursion - TLE
     * TC: O(2^(n x m)) each element can traverse to RIGHT and DOWN
     * SC: O(n x m) recursion stack space
     */
    public int minPathRecursion(int n, int m, int[][] A) {

        if (n >= A.length || m >= A[0].length) {
            return Integer.MAX_VALUE;
        }

        int x = minPathRecursion(n + 1, m, A);
        int y = minPathRecursion(n, m + 1, A);
        // when both dependent element value is MAX, then consider 0
        if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
            x = 0;
            y = 0;
        }
        return A[n][m] + Math.min(x, y);
    }

    /*
     * Approach 2- DP + recursion
     * TC: O(n x m)
     * SC: O(n x m) for dp array + O(max(n,m)) - recursion stack space
     */
    public int minPath_DP_Recursion(int n, int m, int[][] A, int[][] dp) {

        if (n >= A.length || m >= A[0].length) {
            return Integer.MAX_VALUE;
        }

        // reuse value from dp array
        if (dp[n][m] != Integer.MAX_VALUE) {
            return dp[n][m];
        }

        int x = minPath_DP_Recursion(n + 1, m, A, dp);
        int y = minPath_DP_Recursion(n, m + 1, A, dp);
        // when both dependent element value is MAX, then consider 0
        if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
            x = 0;
            y = 0;
        }
        // store value - current element + min from either subtrees
        dp[n][m] = A[n][m] + Math.min(x, y);
        return dp[n][m];
    }

    /*
     * Approach 3- DP + tabulation method
     * TC: O(n x m)
     * SC: O(n x m) - for dp array - here using same input array but if input arrays
     * is allowed to modify, take dp array
     */
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        // update matrix elements
        // fill 1st row
        for (int j = 1; j < m; j++) {
            A[0][j] = A[0][j] + A[0][j - 1];
        }
        // fill 1st column
        for (int i = 1; i < n; i++) {
            A[i][0] = A[i][0] + A[i - 1][0];
        }
        // fill remaining elements
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                A[i][j] = A[i][j] + Math.min(A[i - 1][j], A[i][j - 1]);
            }
        }

        // return final answer
        return A[n - 1][m - 1];
    }

    /*
     * Approach 4- DP + iterative + space optimized
     * TC: O(n x m)
     * SC: O(1 x m) - for dp array
     */
    public int minPathSum_optimized(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[1][m];

        // update matrix elements
        // fill 1st row

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

        class_q3_min_Path_Sum t1 = new class_q3_min_Path_Sum();
        int[][] A;
        int n = 0;
        int m = 0;

        {
            // Approach 1 - simple recursion
            System.out.println("Approach 1 - simple recursion");

            // test case 1
            A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            n = A.length;
            m = A[0].length;
            System.out.println(t1.minPathRecursion(0, 0, A)); // 21 [1->2->3->6->9]

            // test case 2
            A = new int[][] {
                    { 20, 29, 84, 4, 32, 60, 86, 8, 7, 37 },
                    { 77, 69, 85, 83, 81, 78, 22, 45, 43, 63 },
                    { 60, 21, 0, 94, 59, 88, 9, 54, 30, 80 },
                    { 40, 78, 52, 58, 26, 84, 47, 0, 24, 60 },
                    { 40, 17, 69, 5, 38, 5, 75, 59, 35, 26 },
                    { 64, 41, 85, 22, 44, 25, 3, 63, 33, 13 },
                    { 2, 21, 39, 51, 75, 70, 76, 57, 56, 22 },
                    { 31, 45, 47, 100, 65, 10, 94, 96, 81, 14 }
            };
            n = A.length;
            m = A[0].length;
            System.out.println(t1.minPathRecursion(0, 0, A));
        }

        {
            // Approach 2 - Recursion + DP array
            System.out.println("Approach 2 - Recursion + DP array");

            // test case 1
            A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            n = A.length;
            m = A[0].length;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println(t1.minPath_DP_Recursion(0, 0, A, dp)); // 21 [1->2->3->6->9]

            // test case 2
            A = new int[][] { { 1, 3, 2 }, { 4, 3, 1 }, { 5, 6, 1 } };
            n = A.length;
            m = A[0].length;
            dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println(t1.minPath_DP_Recursion(0, 0, A, dp)); // 8 [1->3->2->1->1]

        }
        {
            // Approach 3 - DP + iterative (tabulation)
            System.out.println("Approach 3 - DP + iterative (tabulation)");

            // test case 1
            A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            System.out.println(t1.minPathSum(A)); // 21 [1->2->3->6->9]

            // test case 2
            A = new int[][] {
                    { 20, 29, 84, 4, 32, 60, 86, 8, 7, 37 },
                    { 77, 69, 85, 83, 81, 78, 22, 45, 43, 63 },
                    { 60, 21, 0, 94, 59, 88, 9, 54, 30, 80 },
                    { 40, 78, 52, 58, 26, 84, 47, 0, 24, 60 },
                    { 40, 17, 69, 5, 38, 5, 75, 59, 35, 26 },
                    { 64, 41, 85, 22, 44, 25, 3, 63, 33, 13 },
                    { 2, 21, 39, 51, 75, 70, 76, 57, 56, 22 },
                    { 31, 45, 47, 100, 65, 10, 94, 96, 81, 14 }
            };
            System.out.println(t1.minPathSum(A)); // 470
        }

        {

            // Approach 4- DP + iterative + space optimized
            System.out.println("Approach 4- DP + iterative + space optimized");

            // test case 1
            A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
            System.out.println(t1.minPathSum_optimized(A)); // 21 [1->2->3->6->9]
        }
    }
}
