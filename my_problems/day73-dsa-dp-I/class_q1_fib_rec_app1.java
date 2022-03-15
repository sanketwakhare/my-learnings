/* Fibonacci Number */

import java.util.Arrays;

public class class_q1_fib_rec_app1 {

    /*
     * TC: O(2^n) -> each number has 2 subproblem to solve
     * SC: O(N) - stack space
     */
    int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * TC: O(N)
     * SC: O(N) - stack space and O(N) - dp array
     * 
     */
    int fib_dp(int n, int[] dp) {

        if (dp[n] != -1) {
            // if value already calculated, use it
            return dp[n];
        }
        // base conditions
        if (n <= 1) {
            dp[n] = n;
            return n;
        }
        // store result in array
        dp[n] = fib_dp(n - 1, dp) + fib_dp(n - 2, dp);
        return dp[n];
    }

    /**
     * TC: O(N)
     * SC: O(N) - for dp array
     */
    int fib_tabulation_iterative(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // base conditions
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    int fib_iterative_optimized(int n) {

        if (n <= 1) {
            return n;
        }
        int prev2 = 0;
        int prev1 = 1;
        int curr;

        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {

        class_q1_fib_rec_app1 t1 = new class_q1_fib_rec_app1();

        // approach1- recursion
        int n = 6;
        int ans = t1.fib(n);
        System.out.println(ans);

        // approach2- dp array with recursion
        n = 9;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(t1.fib_dp(n, dp));

        // approach 3- tabulation iterative
        n = 12;
        System.out.println(t1.fib_tabulation_iterative(n));

        // approach 4- space optimized
        n = 10;
        System.out.println(t1.fib_iterative_optimized(n));
    }
}