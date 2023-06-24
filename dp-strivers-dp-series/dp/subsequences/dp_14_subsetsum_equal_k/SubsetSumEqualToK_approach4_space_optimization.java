package dp.subsequences.dp_14_subsetsum_equal_k;

/**
 * Subset Sum Equal to K
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954">Subset Sum Equal To K</a>
 */
public class SubsetSumEqualToK_approach4_space_optimization {

    // Time: O(n*k), Space: O(k)
    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int k1 = 5;
        int[] arr1 = new int[]{4, 3, 2, 1};
        System.out.println(new SubsetSumEqualToK_approach4_space_optimization().subsetSumToK(n1, k1, arr1)); // true

        // test 2
        int n2 = 5;
        int k2 = 4;
        int[] arr2 = new int[]{2, 5, 1, 6, 7};
        System.out.println(new SubsetSumEqualToK_approach4_space_optimization().subsetSumToK(n2, k2, arr2)); // false
    }

    public boolean subsetSumToK(int n, int k, int[] arr) {
        int[] prev = new int[k + 1];

        prev[0] = 1;

        if (arr[0] <= k)
            prev[arr[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] curr = new int[k + 1];
            curr[0] = 1;
            for (int target = 1; target <= k; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (arr[index] <= target)
                    taken = prev[target - arr[index]];

                curr[target] = (notTaken == 1 || taken == 1) ? 1 : 0;
            }
            prev = curr;
        }

        return prev[k] == 1;
    }

}
