package dp.subsequences.dp_23_unbounded_knapsack;

/**
 * Unbounded Knapsack Problem
 *
 * <a href="https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029">Unbounded Knapsack Problem</a>
 */
public class UnboundedKnapsack_approach1_recursion {

    public static void main(String[] args) {

        // test 1
        int[] value1 = {7, 2, 4};
        int[] weight1 = {5, 10, 20};
        int n1 = 3;
        int maxWeight1 = 15;
        System.out.println(new UnboundedKnapsack_approach1_recursion().unboundedKnapsack(n1, maxWeight1, value1, weight1)); // 21

        // test 2
        int[] value2 = {6, 12};
        int[] weight2 = {4, 17};
        int n2 = 2;
        int maxWeight2 = 3;
        System.out.println(new UnboundedKnapsack_approach1_recursion().unboundedKnapsack(n2, maxWeight2, value2, weight2)); // 0

        // test 3
        int[] value3 = {5, 4, 3, 8};
        int[] weight3 = {4, 2, 14, 12};
        int n3 = 4;
        int maxWeight3 = 10;
        System.out.println(new UnboundedKnapsack_approach1_recursion().unboundedKnapsack(n3, maxWeight3, value3, weight3)); // 20

        // test 4
        int[] value4 = {4, 1, 10};
        int[] weight4 = {1, 3, 9};
        int n4 = 3;
        int maxWeight4 = 12;
        System.out.println(new UnboundedKnapsack_approach1_recursion().unboundedKnapsack(n4, maxWeight4, value4, weight4)); // 48
    }

    public int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return f(n - 1, w, profit, weight);
    }

    public int f(int index, int W, int[] values, int[] weights) {
        if (index == 0) {
            // same item can be picked multiple times
            return (W / weights[0]) * values[0];
        }

        int notPick = f(index - 1, W, values, weights);
        int pick = 0;
        if (weights[index] <= W) {
            // stay on the same index as same item can be picked multiple times
            pick = values[index] + f(index, W - weights[index], values, weights);
        }
        return Math.max(notPick, pick);
    }
}
