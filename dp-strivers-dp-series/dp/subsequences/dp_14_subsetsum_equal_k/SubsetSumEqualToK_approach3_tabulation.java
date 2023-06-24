package dp.subsequences.dp_14_subsetsum_equal_k;

import java.util.Arrays;

/**
 * Subset Sum Equal to K
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954">Subset Sum Equal To K</a>
 */
public class SubsetSumEqualToK_approach3_tabulation {

    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int k1 = 5;
        int[] arr1 = new int[]{4, 3, 2, 1};
        System.out.println(new SubsetSumEqualToK_approach3_tabulation().subsetSumToK(n1, k1, arr1)); // true

        // test 2
        int n2 = 5;
        int k2 = 4;
        int[] arr2 = new int[]{2, 5, 1, 6, 7};
        System.out.println(new SubsetSumEqualToK_approach3_tabulation().subsetSumToK(n2, k2, arr2)); // false
    }

    public boolean subsetSumToK(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];

        // base case 1: if k == 0, then we can always make a subset with sum 0
        for(int i=0; i<n; i++) {
            dp[i][0] = 1;
        }

        // base case 2: if we have only one element in the array, then we can make a subset with sum equal to that element only
        for (int j = 1; j <= k; j++) {
            dp[0][j] = arr[0] == j ? 1: 0;
        }

        // choice diagram
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                // for each index, we have two choices: pick or not pick
                // if we pick, then we have to check if we can make a subset with sum equal to (target - arr[index])
                int pick = 0;
                if (target >= arr[index]) {
                    pick = dp[index - 1][target - arr[index]];
                }
                // if we don't pick, then we have to check if we can make a subset with sum equal to target
                int notPick = dp[index - 1][target];
                // if either of the above two choices is true, then we can make a subset with sum equal to target
                dp[index][target] = (pick == 1 || notPick == 1) ? 1 : 0;
            }
        }
        // return the last cell of the dp table
        return dp[n-1][k] == 1;
    }

    public boolean subsetSumToKWithBoolean(int n, int k, int[] arr) {
        Boolean[][] dp = new Boolean[n][k + 1];
        for (Boolean[] row : dp)
            Arrays.fill(row, null);

        // base case 1: if k == 0, then we can always make a subset with sum 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // base case 2: if we have only one element in the array, then we can make a subset with sum equal to that element only
        for (int j = 1; j <= k; j++) {
            dp[0][j] = arr[0] == j;
        }

        // choice diagram
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                // for each index, we have two choices: pick or not pick
                // if we pick, then we have to check if we can make a subset with sum equal to (target - arr[index])
                boolean pick = false;
                if (target >= arr[index]) {
                    pick = dp[index - 1][target - arr[index]];
                }
                // if we don't pick, then we have to check if we can make a subset with sum equal to target
                boolean notPick = dp[index - 1][target];
                // if either of the above two choices is true, then we can make a subset with sum equal to target
                dp[index][target] = pick || notPick;
            }
        }
        // return the last cell of the dp table
        return dp[n - 1][k];
    }
}
