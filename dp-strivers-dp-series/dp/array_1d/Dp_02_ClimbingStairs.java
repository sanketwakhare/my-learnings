package dp.array_1d;

/**
 * Climbing Stairs
 * <p>
 * <a href="https://leetcode.com/problems/climbing-stairs/">Climbing Stairs</a>
 */
public class Dp_02_ClimbingStairs {

    public static void main(String[] args) {
        Dp_02_ClimbingStairs t1 = new Dp_02_ClimbingStairs();
        {
            int result = t1.climbStairs(2);
            System.out.println(result); // 2
        }
        {
            int result = t1.climbStairs(3);
            System.out.println(result); // 3
        }
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
