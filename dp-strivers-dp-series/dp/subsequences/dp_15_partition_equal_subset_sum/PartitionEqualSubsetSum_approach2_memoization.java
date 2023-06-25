package dp.subsequences.dp_15_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * Partition Equal Subset Sum
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980">Partition Equal Subset Sum</a>
 */
public class PartitionEqualSubsetSum_approach2_memoization {

    // Time: O(n * target), Space: O(n * target) + O(n) recursion stack space where target = sum / 2
    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int[] arr1 = new int[]{1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum_approach2_memoization().canPartition(arr1, n1)); // true

        // test 2
        int n2 = 3;
        int[] arr2 = new int[]{1, 3, 5};
        System.out.println(new PartitionEqualSubsetSum_approach2_memoization().canPartition(arr2, n2)); // false

        // test 3
        int n3 = 33;
        int[] arr3 = new int[]{1, 42, 1, 4, 1, 23, 34, 47, 8, 7, 29,
                32, 23, 2, 27, 44, 2, 9, 29, 28, 31, 17, 46, 10, 28,
                24, 11, 18, 43, 50, 17, 11, 13};
        System.out.println(new PartitionEqualSubsetSum_approach2_memoization().canPartition(arr3, n3)); // true
    }

    public boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // if sum is odd, can not be partitioned
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, arr, dp) == 1;
    }

    public int f(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return 1;
        if (index == 0) return arr[index] == target ? 1 : 0;

        if (dp[index][target] != -1) return dp[index][target];

        int notPick = f(index - 1, target, arr, dp);
        int pick = 0;
        if (target - arr[index] >= 0) {
            pick = f(index - 1, target - arr[index], arr, dp);
        }
        return dp[index][target] = (pick == 1 || notPick == 1) ? 1 : 0;
    }
}
