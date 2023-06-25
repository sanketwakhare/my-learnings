package dp.subsequences.dp_15_partition_equal_subset_sum;

/**
 * Partition Equal Subset Sum
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980">Partition Equal Subset Sum</a>
 */
public class PartitionEqualSubsetSum_approach1_recursion {

    // Time: O(2^n), Space: O(n) as recursion stack will have at max n elements
    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int[] arr1 = new int[]{1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum_approach1_recursion().canPartition(arr1, n1)); // true

        // test 2
        int n2 = 3;
        int[] arr2 = new int[]{1, 3, 5};
        System.out.println(new PartitionEqualSubsetSum_approach1_recursion().canPartition(arr2, n2)); // false
    }

    public boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // if sum is odd, can not be partitioned
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        return f(n - 1, target, arr);
    }

    public boolean f(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;
        boolean notPick = f(index - 1, target, arr);
        boolean pick = false;
        if (target - arr[index] >= 0) {
            pick = f(index - 1, target - arr[index], arr);
        }
        return pick || notPick;
    }
}
