package dp.subsequences.dp_15_partition_equal_subset_sum;

/**
 * Partition Equal Subset Sum
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980">Partition Equal Subset Sum</a>
 */
public class PartitionEqualSubsetSum_approach4_space_optimization {

    // Time: O(n*target), Space: O(target) where n is the size of array and target is the sum / 2
    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int[] arr1 = new int[]{1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum_approach4_space_optimization().canPartition(arr1, n1)); // true

        // test 2
        int n2 = 3;
        int[] arr2 = new int[]{1, 3, 5};
        System.out.println(new PartitionEqualSubsetSum_approach4_space_optimization().canPartition(arr2, n2)); // false

        // test 3
        int n3 = 33;
        int[] arr3 = new int[]{1, 42, 1, 4, 1, 23, 34, 47, 8, 7, 29, 32, 23, 2, 27, 44, 2, 9, 29, 28, 31, 17, 46, 10, 28, 24, 11, 18, 43, 50, 17, 11, 13};
        System.out.println(new PartitionEqualSubsetSum_approach4_space_optimization().canPartition(arr3, n3)); // true
    }

    public boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // if sum is odd, can not be partitioned
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] prev = new int[target + 1];

        // base case 1
        prev[0] = 1;
        // base case 2
        for (int j = 1; j <= target; j++) {
            prev[j] = arr[0] == j ? 1 : 0;
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[target + 1];
            curr[0] = 1;
            for (int k = 1; k <= target; k++) {
                int notPick = prev[k];
                int pick = 0;
                if (k - arr[index] >= 0) {
                    pick = prev[k - arr[index]];
                }
                curr[k] = (pick == 1 || notPick == 1) ? 1 : 0;
            }
            prev = curr;
        }
        return prev[target] == 1;
    }
}
