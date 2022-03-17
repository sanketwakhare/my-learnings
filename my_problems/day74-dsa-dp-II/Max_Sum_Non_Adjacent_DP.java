/* Maximum sum of non-adjacent elements
https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=0 */

import java.util.ArrayList;
import java.util.Arrays;

public class Max_Sum_Non_Adjacent_DP {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.

        System.out.println(nums);
        int n = nums.size();
        ArrayList<Integer> dp = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            dp.add(-1);
        }
        int res = maxSum_dp(n - 1, nums, dp);
        System.out.println(res);
        return res;
    }

    public static int maxSum_dp(int index, ArrayList<Integer> nums, ArrayList<Integer> dp) {

        if (index == 0)
            return nums.get(index);
        if (index < 0)
            return 0;

        if (dp.get(index) != -1) {
            return dp.get(index);
        }

        int x = nums.get(index);
        if (index > 1) {
            x += maxSum_dp(index - 2, nums, dp);
        }
        int y = maxSum_dp(index - 1, nums, dp);

        dp.set(index, Math.max(x, y));
        return dp.get(index);

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 1, 2, 3, 5, 4 };
        maximumNonAdjacentSum(new ArrayList<Integer>(Arrays.asList(a))); // 8

        a = new Integer[] { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        maximumNonAdjacentSum(new ArrayList<Integer>(Arrays.asList(a))); // 24

    }
}