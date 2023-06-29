package dp.subsequences.dp_19_0_1_knapsack;

// f(n-1, W) = represents the maximum value that can be obtained with capacity W using items up to index n-1
// f(n-1, W) = max(f(n-1, W), f(n-1, W-w[n-1]) + v[n-1])

import java.util.Arrays;

/**
 * 0/1 Knapsack Problem - Memoization
 *
 * <a href="https://www.codingninjas.com/studio/problems/0-1-knapsack_920542">0/1 Knapsack Problem</a>
 */
public class Knapsack_0_1_approach2_memoization {

    // Time complexity: O(n*W) and Space complexity: O(n*W) + O(n) recursion stack (Auxiliary Stack Space)
    // - where n is the size of the array and W is the maxWeight
    public static void main(String[] args) {
        // test 1
        int[] weight = {6, 5, 1, 5, 6, 5, 9};
        int[] value = {5, 3, 4, 9, 6, 1, 1};
        int n = 7;
        int maxWeight = 63;
        System.out.println(new Knapsack_0_1_approach2_memoization().knapsack(weight, value, n, maxWeight)); // 29

        // test 2
        int[] weight2 = {1, 5, 6, 9, 7, 9, 7};
        int[] value2 = {1, 7, 1, 5, 1, 7, 7};
        int n2 = 7;
        int maxWeight2 = 37;
        System.out.println(new Knapsack_0_1_approach2_memoization().knapsack(weight2, value2, n2, maxWeight2)); // 28

        // test 3
        int[] weight3 = {3};
        int[] value3 = {4};
        int n3 = 1;
        int maxWeight3 = 13;
        System.out.println(new Knapsack_0_1_approach2_memoization().knapsack(weight3, value3, n3, maxWeight3)); // 4

        // test 4
        int[] weight4 = {7};
        int[] value4 = {1};
        int n4 = 1;
        int maxWeight4 = 1;
        System.out.println(new Knapsack_0_1_approach2_memoization().knapsack(weight4, value4, n4, maxWeight4)); // 0

        // test 5
        int[] weight5 = {25, 4, 25, 49, 9, 11, 31, 5, 37, 7, 11, 47, 37, 1, 33, 25, 29, 11, 1, 41, 19, 14, 43, 21, 1, 21, 23, 37, 12, 11, 45, 13, 36, 11, 17};
        int[] value5 = {86, 55, 17, 31, 88, 82, 27, 57, 18, 1, 61, 56, 36, 82, 51, 85, 55, 21, 11, 76, 91, 36, 85, 32, 99, 43, 41, 61, 41, 28, 83, 27, 35, 61, 16};
        int n5 = 35;
        int maxWeight5 = 869;
        System.out.println(new Knapsack_0_1_approach2_memoization().knapsack(weight5, value5, n5, maxWeight5)); // 1775
    }

    public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return f(n-1, maxWeight, weight, value, dp);
    }

    public int f(int index, int W, int[] wt, int[] val, int[][] dp) {
        if(index == 0) {
            if(W - wt[index] >= 0) {
                return dp[index][W] = val[0];
            }
            return dp[index][W] = 0;
        }

        if(dp[index][W] != -1) return dp[index][W];

        int notPick = f(index - 1, W, wt, val, dp);
        int pick = Integer.MIN_VALUE;
        if(W - wt[index] >= 0) {
            pick = val[index] + f(index - 1, W - wt[index], wt, val, dp);
        }
        return dp[index][W] = Math.max(notPick, pick);
    }
}
