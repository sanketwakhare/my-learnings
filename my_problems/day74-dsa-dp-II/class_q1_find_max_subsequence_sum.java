import java.util.Arrays;

/* Given an array A of size N, find maximum subsequence sum of non-adjacent elements */

public class class_q1_find_max_subsequence_sum {

    /*
     * Approach: Simple Recursion
     * TC: O(2^n)
     * SC: O(n) - stack space
     * slower - will give TLE for large inputs
     */
    public int maxSum_recursive(int index, int[] A) {

        if (index == 0)
            return A[index];
        if (index < 0)
            return 0;

        int x = A[index] + maxSum_recursive(index - 2, A);
        int y = maxSum_recursive(index - 1, A);
        return Math.max(x, y);
    }

    /*
     * Approach: DP + Recursion
     * TC: O(n)
     * SC: O(n) - stack space
     * Better than approach 1
     */
    public int maxSum_recursive_dp(int index, int[] A, int[] dp) {

        if (index == 0)
            return A[index];
        if (index < 0)
            return 0;

        // if value for f(index) already exist, reuse the same
        if (dp[index] != Integer.MIN_VALUE)
            return dp[index];

        int x = A[index] + maxSum_recursive_dp(index - 2, A, dp);
        int y = maxSum_recursive_dp(index - 1, A, dp);

        dp[index] = Math.max(x, y);
        return dp[index];
    }

    /**
     * Approach 3 - tabulation
     * TC: O(n)
     * SC: O(n) for dp array
     */
    public int maxSum_tabulation(int[] A) {

        if (A.length == 0)
            return 0;

        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = A[0];

        for (int i = 1; i < n; i++) {
            int x = A[i];
            if (i > 1) {
                x += dp[i - 2];
            }
            int y = dp[i - 1];
            dp[i] = Math.max(x, y);
        }

        return dp[n - 1];
    }

    /**
     * Approach 4 - iterative + space optimized
     * TC: O(n)
     * SC: O(1)
     */
    public int maxSum_tabulation_optimized(int[] A) {

        if (A.length == 0)
            return 0;

        int n = A.length;
        int prev2 = 0;
        int prev1 = A[0];

        for (int i = 1; i < n; i++) {
            int x = A[i];
            if (i > 1) {
                x += prev2;
            }
            int y = prev1;

            int curr = Math.max(x, y);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        class_q1_find_max_subsequence_sum t1 = new class_q1_find_max_subsequence_sum();

        // Approach 1 - simple recursion
        int[] A = new int[] { 9, 4, 13, 24 };
        int n = A.length;
        System.out.println(t1.maxSum_recursive(n - 1, A));

        // Approach 2 - simple recursion
        A = new int[] { 9, 4, 13, 24 };
        n = A.length;
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        System.out.println(t1.maxSum_recursive_dp(n - 1, A, dp));

        // Approach 3 - tabulation - iterative approach
        A = new int[] { 9, 4, 13, 24 };
        System.out.println(t1.maxSum_tabulation(A));
        A = new int[] { 6, 5, 10, 8, 2 };
        System.out.println(t1.maxSum_tabulation(A)); // 18

        // Approach 4- iterative - maxSum_tabulation_optimized
        A = new int[] { 9, 4, 13, 24 };
        System.out.println(t1.maxSum_tabulation_optimized(A));
        A = new int[] { 6, 5, 10, 8, 2, 4, 2, 9 };
        System.out.println(t1.maxSum_tabulation_optimized(A)); // 29

    }

}
