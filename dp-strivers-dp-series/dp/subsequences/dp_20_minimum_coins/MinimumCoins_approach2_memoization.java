package dp.subsequences.dp_20_minimum_coins;

import java.util.Arrays;

/**
 * Minimum Coins / Minimum Elements
 *
 * <a href="https://www.codingninjas.com/studio/problems/minimum-elements_3843091">Minimum Coins / Minimum Elements</a>
 */
public class MinimumCoins_approach2_memoization {

    public static void main(String[] args) {

        // test 1
        int nums[] = {1, 2, 3};
        int target = 11;
        int ans = new MinimumCoins_approach2_memoization().minimumElements(nums, target);
        System.out.println(ans); // 4

        // test 2
        int nums2[] = {21, 12, 19, 14, 1, 15, 9, 24, 16, 18, 3, 4};
        int target2 = 1;
        int ans2 = new MinimumCoins_approach2_memoization().minimumElements(nums2, target2);
        System.out.println(ans2); // 1

        // test 3
        int nums3[] = {17, 10, 5};
        int target3 = 6;
        int ans3 = new MinimumCoins_approach2_memoization().minimumElements(nums3, target3);
        System.out.println(ans3); // -1

    }

    public int minimumElements(int nums[], int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = f(n - 1, target, nums, dp);
        return ans >= 1000000007 ? -1 : ans;
    }

    public int f(int index, int target, int[] nums, int[][] dp) {

        // base case
        if (index == 0) {
            // if target is divisible by nums[0] then return target / nums[0]
            if (target % nums[0] == 0) {
                return dp[index][target] = target / nums[0];
            }
            // else return 1000000007 to avoid integer overflow
            return dp[index][target] = 1000000007;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // do not pick
        int notPick = f(index - 1, target, nums, dp);
        // pick
        int pick = Integer.MAX_VALUE;
        if (nums[index] <= target) {
            // pick only when nums[index] <= target
            pick = 1 + f(index, target - nums[index], nums, dp);
        }
        // return min of notPick and pick
        return dp[index][target] = Math.min(notPick, pick);
    }
}
