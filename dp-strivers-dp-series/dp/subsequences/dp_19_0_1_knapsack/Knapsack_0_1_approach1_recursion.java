package dp.subsequences.dp_19_0_1_knapsack;

// f(n-1, W) = represents the maximum value that can be obtained with capacity W using items up to index n-1
// f(n-1, W) = max(f(n-1, W), f(n-1, W-w[n-1]) + v[n-1])

/**
 * 0/1 Knapsack Problem
 *
 * <a href="https://www.codingninjas.com/studio/problems/0-1-knapsack_920542">0/1 Knapsack Problem</a>
 */
public class Knapsack_0_1_approach1_recursion {

    // Time complexity: O(2^n) and Space complexity: O(n) for recursion stack (Auxiliary Stack Space) - where n is the size of the array
    public static void main(String[] args) {
        // test 1
        int[] weight = {6, 5, 1, 5, 6, 5, 9};
        int[] value = {5, 3, 4, 9, 6, 1, 1};
        int n = 7;
        int maxWeight = 63;
        System.out.println(new Knapsack_0_1_approach1_recursion().knapsack(weight, value, n, maxWeight)); // 29

        // test 2
        int[] weight2 = {1, 5, 6, 9, 7, 9, 7};
        int[] value2 = {1, 7, 1, 5, 1, 7, 7};
        int n2 = 7;
        int maxWeight2 = 37;
        System.out.println(new Knapsack_0_1_approach1_recursion().knapsack(weight2, value2, n2, maxWeight2)); // 28

        // test 3
        int[] weight3 = {3};
        int[] value3 = {4};
        int n3 = 1;
        int maxWeight3 = 13;
        System.out.println(new Knapsack_0_1_approach1_recursion().knapsack(weight3, value3, n3, maxWeight3)); // 4

        // test 4
        int[] weight4 = {7};
        int[] value4 = {1};
        int n4 = 1;
        int maxWeight4 = 1;
        System.out.println(new Knapsack_0_1_approach1_recursion().knapsack(weight4, value4, n4, maxWeight4)); // 0
    }

    public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return f(n - 1, maxWeight, weight, value);
    }

    public int f(int index, int W, int[] wt, int[] val) {
        if (index == 0) {
            if (W - wt[0] >= 0) {
                // only single option is to pick to get max value
                return val[0];
            }
            // can't fill in the bag then return 0
            return 0;
        }
        // not pick the item
        int notPick = f(index - 1, W, wt, val);
        // pick the item
        int pick = Integer.MIN_VALUE;
        if (W - wt[index] >= 0) {
            // if we can pick the item then only we will pick
            pick = val[index] + f(index - 1, W - wt[index], wt, val);
        }
        // return the max of both
        return Math.max(notPick, pick);
    }
}
