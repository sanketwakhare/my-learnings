package dp.subsequences.dp_17_count_subset_with_sum_k;

/**
 * Count the number of subsets with a sum K.
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532">Count the number of subsets with a sum K.</a>
 */
public class CountSubsetWithSumK_approach3_tabulation {

    // TC: O(n * tar) & SC: O(n * tar)
    public static void main(String[] args) {
        // test 1
        int k1 = 5;
        int[] arr1 = new int[]{4, 3, 2, 1};
        System.out.println(new CountSubsetWithSumK_approach3_tabulation().findWays(arr1, k1)); // 2

        // test 2
        int k2 = 4;
        int[] arr2 = new int[]{2, 5, 1, 6, 7};
        System.out.println(new CountSubsetWithSumK_approach3_tabulation().findWays(arr2, k2)); // 2

        // test 3
        int k3 = 5;
        int[] arr3 = new int[]{1, 4, 4, 5};
        System.out.println(new CountSubsetWithSumK_approach3_tabulation().findWays(arr3, k3)); // 3

        // test 4
        int k4 = 53;
        int[] arr4 = new int[]{7, 7, 7, 9, 1, 4, 4, 7, 8, 2, 10, 3, 9, 8, 1, 9, 7, 1, 2, 8, 7, 3, 5, 3, 9, 8, 9, 7, 8, 3, 2, 4, 2, 6, 10, 1, 6, 4, 10, 5, 3, 7, 1, 6, 5, 6, 1, 8, 6, 7, 5, 1, 2, 3, 5, 2, 9, 10, 3, 1, 2, 10, 5, 7, 10, 2, 7, 9, 3, 4, 2, 8, 10, 5};
        System.out.println(new CountSubsetWithSumK_approach3_tabulation().findWays(arr4, k4)); // 728567579 as per code studio

        // test 5
        int k5 = 31;
        int[] arr5 = new int[]{9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        System.out.println(new CountSubsetWithSumK_approach3_tabulation().findWays(arr5, k5)); // 1
    }

    public int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (num[0] <= tar) dp[0][num[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= tar; target++) {
                int notPick = dp[index - 1][target];
                int pick = 0;
                if (target >= num[index]) {
                    pick = dp[index - 1][target - num[index]];
                }
                dp[index][target] = pick + notPick;
            }
        }
        return dp[n - 1][tar];
    }

    public int f(int index, int target, int[] arr, int[][] dp) {

        if (target == 0) return 1;
        if (index == 0) {
            return arr[0] == target ? 1 : 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notPick = f(index - 1, target, arr, dp);
        int pick = 0;
        if (target >= arr[index]) {
            pick = f(index - 1, target - arr[index], arr, dp);
        }
        return dp[index][target] = pick + notPick;
    }
}
