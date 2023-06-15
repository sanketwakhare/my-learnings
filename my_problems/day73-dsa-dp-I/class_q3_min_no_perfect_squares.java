import java.util.Arrays;

/* Minimum Number of Squares */

public class class_q3_min_no_perfect_squares {

    // Approach 1 - recursion - TLE (Time Limit Exceeded)
    public int minSquares(int n) {

        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, minSquares(n - i * i));
        }
        return min + 1;
    }

    /*
     * Approach 2- recursion with dp
     * TC: O(n)
     * SC: O(n)
     */
    public int minSquares_dp(int n, int[] dp) {

        // if already present in dp array, reuse
        if (dp[n] != -1) {
            return dp[n];
        }
        // base condition for 0
        if (n == 0) {
            dp[0] = 0;
            return dp[0];
        }
        // consider possibility by subtracting every square less than <=n, and take
        // maximum no of steps required to form n
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, minSquares_dp(n - i * i, dp));
        }
        // store answer in dp array and return
        dp[n] = min + 1;
        return dp[n];
    }

    public boolean isPerfectSquare(int n) {
        double x = Math.sqrt(n);
        if (x - Math.ceil(x) != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // Approach 1 - TLE
        class_q3_min_no_perfect_squares t1 = new class_q3_min_no_perfect_squares();
        System.out.println(t1.minSquares(16));

        // Approach 2 - correct - dp array
        int n = 467;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(t1.minSquares_dp(n, dp));

    }
}
