package dp.subsequences.dp_20_minimum_coins;

/**
 * Minimum Coins / Minimum Elements
 *
 * <a href="https://www.codingninjas.com/studio/problems/minimum-elements_3843091">Minimum Coins / Minimum Elements</a>
 */
public class MinimumCoins_approach3_tabulation {

    public static void main(String[] args) {

        // test 1
        int nums[] = {1, 2, 3};
        int target = 11;
        int ans = new MinimumCoins_approach3_tabulation().minimumElements(nums, target);
        System.out.println(ans); // 4

        // test 2
        int nums2[] = {21, 12, 19, 14, 1, 15, 9, 24, 16, 18, 3, 4};
        int target2 = 1;
        int ans2 = new MinimumCoins_approach3_tabulation().minimumElements(nums2, target2);
        System.out.println(ans2); // 1

        // test 3
        int nums3[] = {17, 10, 5};
        int target3 = 6;
        int ans3 = new MinimumCoins_approach3_tabulation().minimumElements(nums3, target3);
        System.out.println(ans3); // -1

    }

    public int minimumElements(int nums[], int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int t = 0; t <= target; t++) {
            if (t % nums[0] == 0) {
                dp[0][t] = t / nums[0];
            } else {
                dp[0][t] = 1000000007;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int T = 0; T <= target; T++) {
                // do not pick
                int notPick = dp[index - 1][T];
                // pick
                int pick = Integer.MAX_VALUE;
                if (nums[index] <= T) {
                    // pick only when nums[index] <= target
                    pick = 1 + dp[index][T - nums[index]];
                }
                // min of notPick and pick
                dp[index][T] = Math.min(notPick, pick);
            }
        }

        int ans = dp[n - 1][target];
        return ans >= 1000000007 ? -1 : ans;
    }
}
