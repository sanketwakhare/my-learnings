/* Stairs */

import java.util.Arrays;

public class class_q2_climb_stairs {

    /*
     * Approach 1 - recursion
     * TC: O(2^n) - as each step can take 2 steps further
     * SC: O(n)
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        int x = climbStairs(n - 1);
        int y = 0;
        if (n > 1)
            y = climbStairs(n - 2);
        return x + y;
    }

    /**
     * Approach 2- recursion with dp array
     * TC: O(n)
     * SC: O(n) - for stack space
     */
    public int climbStairs_dp(int n, int[] dp) {

        if (dp[n] != -1) {
            return dp[n];
        }
        if (n <= 1) {
            dp[n] = 1;
            return dp[n];
        }
        dp[n - 1] = climbStairs_dp(n - 1, dp);
        dp[n - 2] = climbStairs_dp(n - 2, dp);
        return dp[n - 1] + dp[n - 2];
    }

    /*
     * Approach 3- Tabulation method - iterative solution
     * TC: O(n)
     * SC: O(n)
     */
    public int climbStairs_tabulation(int n) {

        // initialize dp array
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // add base cases
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    /*
     * Approach 4 - Iterative with space optimized
     * TC: O(n)
     * SC: (1)
     */
    public int climbStairs_iterative(int n) {

        // instead of dp array, use 2 variables
        int prev1 = 1;
        int prev2 = 1;
        int curr;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {

        class_q2_climb_stairs t1 = new class_q2_climb_stairs();

        int n;

        {
            // Approach 1 - recursion
            System.out.println("Approach 1 - recursion");
            System.out.println(t1.climbStairs(10));
            System.out.println(t1.climbStairs(4));
            System.out.println(t1.climbStairs(3));
            System.out.println(t1.climbStairs(2));
        }
        {
            // Approach 2 - dp with recursion
            System.out.println("Approach 2 - dp with recursion");
            n = 10;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(t1.climbStairs_dp(n, dp));
            n = 4;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(t1.climbStairs_dp(n, dp));
        }
        {
            // Approach 3 - dp with iterative - tabulation method
            System.out.println("Approach 3 - dp with iterative - tabulation method");
            n = 10;
            System.out.println(t1.climbStairs_tabulation(n));
            n = 4;
            System.out.println(t1.climbStairs_tabulation(n));
        }
        {
            // Approach 4 - dp with iterative - space optimized
            System.out.println("Approach 4 - dp with iterative - space optimized");
            System.out.println(t1.climbStairs_iterative(10));
            System.out.println(t1.climbStairs_iterative(8));
        }

    }
}
