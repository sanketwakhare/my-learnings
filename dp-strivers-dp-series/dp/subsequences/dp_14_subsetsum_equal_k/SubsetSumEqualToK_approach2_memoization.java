package dp.subsequences.dp_14_subsetsum_equal_k;

import java.util.Arrays;

/**
 * Subset Sum Equal to K
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954">Subset Sum Equal To K</a>
 */
public class SubsetSumEqualToK_approach2_memoization {

    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int k1 = 5;
        int[] arr1 = new int[]{4, 3, 2, 1};
        System.out.println(new SubsetSumEqualToK_approach2_memoization().subsetSumToK(n1, k1, arr1)); // true

        // test 2
        int n2 = 5;
        int k2 = 4;
        int[] arr2 = new int[]{2, 5, 1, 6, 7};
        System.out.println(new SubsetSumEqualToK_approach2_memoization().subsetSumToK(n2, k2, arr2)); // false
    }

    public boolean subsetSumToK(int n, int k, int[] arr) {
        Boolean[][] dp = new Boolean[n + 1][k + 1];
        for (Boolean[] row : dp)
            Arrays.fill(row, null);
        return f(n - 1, k, n, arr, dp);
    }

    public boolean f(int index, int k, int n, int[] arr, Boolean[][] dp) {

        if (k == 0) return true;
        if (index == 0) return arr[0] == k;

        if (dp[index][k] != null) return dp[index][k];

        boolean pick = false;
        if (k >= arr[index]) {
            pick = f(index - 1, k - arr[index], n, arr, dp);
        }
        boolean notPick = f(index - 1, k, n, arr, dp);
        return dp[index][k] = pick || notPick;
    }
}
