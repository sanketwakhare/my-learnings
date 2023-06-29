package dp.subsequences.dp_21_target_sum;

import java.util.Arrays;

/**
 * Target Sum
 *
 * <a href="https://www.codingninjas.com/studio/problems/target-sum_4127362">Target Sum</a>
 */
public class TargetSum_approach_using_dp18 {

    public static void main(String[] args) {

        // test 1
        int n1 = 5;
        int d1 = 3;
        int[] arr1 = {1, 1, 1, 1, 1};
        System.out.println(new TargetSum_approach_using_dp18().targetSum(n1, d1, arr1)); // 5

        // test 2
        int n2 = 4;
        int d2 = 3;
        int[] arr2 = {1, 2, 3, 1};
        System.out.println(new TargetSum_approach_using_dp18().targetSum(n2, d2, arr2)); // 2
    }

    public int targetSum(int n, int target, int[] arr) {
        return countPartitions(n, target, arr);
    }

    public int findWays(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, tar, num, dp);
    }

    public int f(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            // case for 0
            if (target == 0 && arr[0] == 0)
                return dp[index][target] = 2;
            // case when target is 0 OR array element at index 0 is equal to target
            if (target == 0 || target == arr[0])
                return dp[index][target] = 1;
            // otherwise return 0
            return dp[index][target] = 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notPick = f(index - 1, target, arr, dp);
        int pick = 0;
        if (target >= arr[index]) {
            pick = f(index - 1, target - arr[index], arr, dp);
        }
        return dp[index][target] = pick + notPick;
    }

    public int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int target = (sum - d) / 2;

        // base cases
        if ((sum + d) % 2 != 0) return 0;
        if (target < 0) return 0;

        // dp 17
        return findWays(arr, target);
    }

}
