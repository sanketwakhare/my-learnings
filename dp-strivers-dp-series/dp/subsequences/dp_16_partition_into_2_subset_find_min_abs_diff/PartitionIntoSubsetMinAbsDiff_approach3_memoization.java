package dp.subsequences.dp_16_partition_into_2_subset_find_min_abs_diff;

import java.util.Arrays;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum.
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494">Partition a set into two subsets such that the difference of subset sums is minimum.</a>
 */
public class PartitionIntoSubsetMinAbsDiff_approach3_memoization {

    // Time: O(n * target), Space: O(n * target) + O(n) recursion stack space where target = sum
    public static void main(String[] args) {
        // test 1
        int n1 = 3;
        int[] arr1 = new int[]{8, 6, 5};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach3_memoization().minSubsetSumDifference(arr1, n1)); // 3

        // test 2
        int n2 = 2;
        int[] arr2 = new int[]{1, 6};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach3_memoization().minSubsetSumDifference(arr2, n2)); // 5

        // test 3
        int n3 = 2;
        int[] arr3 = new int[]{11, 12};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach3_memoization().minSubsetSumDifference(arr3, n3)); // 1

        // test 4
        int n4 = 3;
        int[] arr4 = new int[]{9, 15, 14};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach3_memoization().minSubsetSumDifference(arr4, n4)); // 8
    }

    public int minSubsetSumDifference(int[] arr, int n) {
        // take sum of the array elements a target and build dp array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int k = 0; k <= sum; k++) {
            // we need to check for every sum from 0 to sum
            f(n - 1, k, arr, dp);
        }

        // check last row of the dp array and find the minimum difference
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int s1 = i;
            int s2 = sum - s1;
            if (dp[n - 1][s1] == 1) {
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }
        return min;
    }

    public int f(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return dp[index][target] = 1;
        if (index == 0) return dp[index][target] = arr[index] == target ? 1 : 0;

        if (dp[index][target] != -1) return dp[index][target];

        int notPick = f(index - 1, target, arr, dp);
        int pick = 0;
        if (target - arr[index] >= 0) {
            pick = f(index - 1, target - arr[index], arr, dp);
        }
        return dp[index][target] = (pick == 1 || notPick == 1) ? 1 : 0;
    }
}
