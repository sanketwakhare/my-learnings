package dp.subsequences.dp_23_unbounded_knapsack;

/**
 * Unbounded Knapsack Problem
 *
 * <a href="https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029">Unbounded Knapsack Problem</a>
 */
public class UnboundedKnapsack_approach4_space_optimization_1_row {

    public static void main(String[] args) {

        // test 1
        int[] value1 = {7, 2, 4};
        int[] weight1 = {5, 10, 20};
        int n1 = 3;
        int maxWeight1 = 15;
        System.out.println(new UnboundedKnapsack_approach4_space_optimization_1_row().unboundedKnapsack(n1, maxWeight1, value1, weight1)); // 21

        // test 2
        int[] value2 = {6, 12};
        int[] weight2 = {4, 17};
        int n2 = 2;
        int maxWeight2 = 3;
        System.out.println(new UnboundedKnapsack_approach4_space_optimization_1_row().unboundedKnapsack(n2, maxWeight2, value2, weight2)); // 0

        // test 3
        int[] value3 = {5, 4, 3, 8};
        int[] weight3 = {4, 2, 14, 12};
        int n3 = 4;
        int maxWeight3 = 10;
        System.out.println(new UnboundedKnapsack_approach4_space_optimization_1_row().unboundedKnapsack(n3, maxWeight3, value3, weight3)); // 20

        // test 4
        int[] value4 = {4, 1, 10};
        int[] weight4 = {1, 3, 9};
        int n4 = 3;
        int maxWeight4 = 12;
        System.out.println(new UnboundedKnapsack_approach4_space_optimization_1_row().unboundedKnapsack(n4, maxWeight4, value4, weight4)); // 48
    }

    public int unboundedKnapsack(int n, int w, int[] values, int[] weights) {
        int[] prev = new int[w + 1];
        // base case when only one item is present,
        // try to pick the same item multiple times until bag can fit the item
        for (int W = 0; W <= w; W++) {
            prev[W] = (W / weights[0]) * values[0];
        }
        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= w; W++) {
                int notPick = prev[W];
                int pick = 0;
                if (weights[index] <= W) {
                    // as values depend on previous row and cells of previous columns of current row
                    pick = values[index] + prev[W - weights[index]];
                }
                prev[W] = Math.max(notPick, pick);
            }
        }
        return prev[w];
    }
}
