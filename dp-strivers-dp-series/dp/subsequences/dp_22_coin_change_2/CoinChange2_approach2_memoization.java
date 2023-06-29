package dp.subsequences.dp_22_coin_change_2;

import java.util.Arrays;

/**
 * Coin Change 2 - Ways to Make Coin Change
 * Approach 1: Recursion
 * <p>
 * Link: <a href="https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471">Ways to Make Coin Change</a>
 */
public class CoinChange2_approach2_memoization {

    public static void main(String[] args) {
        // test 1
        int n = 3;
        int[] denominations = {1, 2, 3};
        int target = 4;
        System.out.println(new CoinChange2_approach2_memoization().countWaysToMakeChange(denominations, n, target)); // 4

        // test 2
        int n2 = 2;
        int[] denominations2 = new int[]{1, 2};
        int target2 = 4;
        System.out.println(new CoinChange2_approach2_memoization().countWaysToMakeChange(denominations2, n2, target2)); // 3

        // test 3
        int n3 = 4;
        int[] denominations3 = new int[]{1, 2, 3, 4};
        int target3 = 5;
        System.out.println(new CoinChange2_approach2_memoization().countWaysToMakeChange(denominations3, n3, target3)); // 6
    }

    public long countWaysToMakeChange(int[] denominations, int n, int target) {
        long[][] dp = new long[n][target + 1];
        for (long[] row : dp) Arrays.fill(row, -1L);
        return f(n - 1, target, denominations, dp);
    }

    public long f(int index, int target, int[] coins, long[][] dp) {
        if (index == 0) {
            return dp[index][target] = target % coins[0] == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        long notPick = f(index - 1, target, coins, dp);
        long pick = 0;
        if (target >= coins[index]) {
            pick = f(index, target - coins[index], coins, dp);
        }
        return dp[index][target] = notPick + pick;
    }
}
