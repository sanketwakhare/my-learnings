package dp.subsequences.dp_16_partition_into_2_subset_find_min_abs_diff;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum.
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494">Partition a set into two subsets such that the difference of subset sums is minimum.</a>
 */
public class PartitionIntoSubsetMinAbsDiff_approach2_space_optimization {

    // Time: O(n*target), Space: O(target) as dp array is of size target where target is sum of all elements in array
    public static void main(String[] args) {
        // test 1
        int n1 = 3;
        int[] arr1 = new int[]{8, 6, 5};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach2_space_optimization().minSubsetSumDifference(arr1, n1)); // 3

        // test 2
        int n2 = 2;
        int[] arr2 = new int[]{1, 6};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach2_space_optimization().minSubsetSumDifference(arr2, n2)); // 5

        // test 3
        int n3 = 2;
        int[] arr3 = new int[]{11, 12};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach2_space_optimization().minSubsetSumDifference(arr3, n3)); // 1

        // test 4
        int n4 = 3;
        int[] arr4 = new int[]{9, 15, 14};
        System.out.println(new PartitionIntoSubsetMinAbsDiff_approach2_space_optimization().minSubsetSumDifference(arr4, n4)); // 8
    }

    public int minSubsetSumDifference(int[] arr, int n) {
        // take sum of the array elements a target and build dp array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int[] prev = new int[sum + 1];
        // case 1: if we do not pick any element, sum 0 can be achieved
        prev[0] = 1;
        // case 2: if first element in array equals target, dp[0][target] = 1
        if (arr[0] <= sum) prev[arr[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] curr = new int[sum + 1];
            curr[0] = 1;
            for (int target = 1; target <= sum; target++) {
                int pick = 0;
                if (target - arr[index] >= 0) {
                    pick = prev[target - arr[index]];
                }
                int notPick = prev[target];
                curr[target] = (pick == 1 || notPick == 1) ? 1 : 0;
            }
            prev = curr;
        }

        // check last row
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int s1 = i;
            int s2 = sum - s1;
            if(prev[s1] == 1) {
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }
        return min;
    }
}
