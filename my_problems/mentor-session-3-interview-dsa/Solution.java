import java.util.Arrays;

/* House Robber Problem solution */
public class Solution {

    public int getMax(int n, int[] nums, int[] dp) {

        if (n < 0)
            return 0;

        // reuse values for repeating subproblem
        if (dp[n] != -1) {
            return dp[n];
        }

        int x = nums[n] + getMax(n - 2, nums, dp);
        int y = getMax(n - 1, nums, dp);

        dp[n] = Math.max(x, y);
        return dp[n];
    }

    // n
    // pick not pick
    // n-2 n-1
    // n-4 n-3 n-3 n-2

    public static void main(String[] args) {

        Solution o = new Solution();

        {
            int[] nums = new int[] { 1, 2, 3, 1 };
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, -1);
            int ans = o.getMax(nums.length - 1, nums, dp);
            System.out.println(ans);
        }

        {
            int[] nums = new int[] { 2, 7, 9, 3, 1 };
            int[] dp = new int[nums.length + 1];
            Arrays.fill(dp, -1);
            int ans = o.getMax(nums.length - 1, nums, dp);
            System.out.println(ans);
        }
    }
}