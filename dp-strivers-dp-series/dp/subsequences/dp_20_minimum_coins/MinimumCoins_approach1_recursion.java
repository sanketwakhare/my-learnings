package dp.subsequences.dp_20_minimum_coins;

/**
 * Minimum Coins / Minimum Elements
 *
 * <a href="https://www.codingninjas.com/studio/problems/minimum-elements_3843091">Minimum Coins / Minimum Elements</a>
 */
public class MinimumCoins_approach1_recursion {

    public static void main(String[] args) {

        // test 1
        int nums[] = {1, 2, 3};
        int target = 11;
        int ans = new MinimumCoins_approach1_recursion().minimumElements(nums, target);
        System.out.println(ans); // 4
    }

    public int minimumElements(int nums[], int target) {
        int n = nums.length;
        int ans = f(n - 1, target, nums);
        return ans >= 1000000007 ? -1 : ans;
    }

    public int f(int index, int target, int[] nums) {

        // base case
        if (index == 0) {
            // if target is divisible by nums[0] then return target / nums[0]
            if (target % nums[0] == 0) {
                return target / nums[0];
            }
            // else return 1000000007 to avoid integer overflow
            return 1000000007;
        }

        // do not pick
        int notPick = f(index - 1, target, nums);
        // pick
        int pick = Integer.MAX_VALUE;
        if (nums[index] <= target) {
            // pick only when nums[index] <= target
            pick = 1 + f(index, target - nums[index], nums);
        }
        // return min of notPick and pick
        return Math.min(notPick, pick);
    }
}
