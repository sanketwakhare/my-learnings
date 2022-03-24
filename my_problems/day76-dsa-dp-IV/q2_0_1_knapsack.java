import java.util.Arrays;

/* 0-1 Knapsack */

/* Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints

1 <= N <= 10^3
1 <= C <= 10^3
1 <= A[i], B[i] <= 10^3



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 220
Output 2:

 0


Example Explanation

Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0. */

public class q2_0_1_knapsack {

    /**
     * Approach 1 - backtrack
     * TC: O(2^n)
     * SC: recursion stack space = O(n)
     * 
     * @param n       no of items
     * @param target  capacity of bag
     * @param values  values array
     * @param weights weights array
     * @return max value of items which can be filled in bag
     */
    public int backtrack(int n, int target, int[] values, int[] weights) {

        // either there are no more items to pick or target weight is 0/capacity is full
        if (n == 0 || target == 0) {
            return 0;
        }

        // do not pick
        int x = backtrack(n - 1, target, values, weights);
        // pick
        int y = 0;
        if (target - weights[n - 1] >= 0) {
            y = values[n - 1] + backtrack(n - 1, target - weights[n - 1], values, weights);
        }

        return Math.max(x, y);
    }

    /**
     * Approach 2 - recursion + DP
     * TC: O(n x target)
     * SC: O(n x target) + recursion stack space
     */
    public int recursion_dp(int n, int target, int[] values, int[] weights, int[][] dp) {

        if (n == 0 || target == 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        // do not pick
        int x = recursion_dp(n - 1, target, values, weights, dp);
        // pick
        int y = 0;
        if (target - weights[n - 1] >= 0) {
            y = values[n - 1] + recursion_dp(n - 1, target - weights[n - 1], values, weights, dp);
        }

        return dp[n][target] = Math.max(x, y);
    }

    /**
     * Approach 3 - tabulation + DP
     * TC: O(n x target)
     * SC: O(n x target) for dp array
     */
    public int tabulation_dp(int n, int target, int[] values, int[] weights) {

        // initialize base cases. first row and first column with 0
        int[][] dp = new int[n + 1][target + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= n; i++) {
            int[] row = dp[i];
            Arrays.fill(row, -1);
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // do not pick
                int x = dp[i - 1][j];
                // pick
                int y = 0;
                if (j - weights[i - 1] >= 0) {
                    y = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {

        q2_0_1_knapsack t1 = new q2_0_1_knapsack();
        int[] A, B;
        int C, n;
        int[][] dp;

        {
            // Approach 1 - backtrack
            System.out.println("Approach 1 - backtrack");

            // test case 1
            A = new int[] { 60, 100, 120 };
            B = new int[] { 10, 20, 30 };
            C = 50;
            n = A.length;
            System.out.println(t1.backtrack(n, C, A, B)); // 220

            // test case 2
            A = new int[] { 10, 20, 30, 40 };
            B = new int[] { 12, 13, 15, 19 };
            C = 10;
            n = A.length;
            System.out.println(t1.backtrack(n, C, A, B)); // 0
        }
        {
            // Approach 2 - recursion + DP
            System.out.println("Approach 2 - recursion  + DP");

            // test case 1
            A = new int[] { 60, 100, 120 };
            B = new int[] { 10, 20, 30 };
            C = 50;
            n = A.length;
            dp = new int[n + 1][C + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.recursion_dp(n, C, A, B, dp)); // 220

            // test case 2
            A = new int[] { 10, 20, 30, 40 };
            B = new int[] { 12, 13, 15, 19 };
            C = 10;
            n = A.length;
            dp = new int[n + 1][C + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.recursion_dp(n, C, A, B, dp)); // 0

            // test case 3
            A = new int[] { 468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828,
                    437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36,
                    895, 704, 812, 323 };
            B = new int[] { 4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1,
                    10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7 };
            C = 841;
            n = A.length;
            dp = new int[n + 1][C + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(t1.recursion_dp(n, C, A, B, dp)); // 24576
        }
        {
            // Approach 3 - tabulation + DP
            System.out.println("Approach 3 - tabulation + DP");

            // test case 1
            A = new int[] { 60, 100, 120 };
            B = new int[] { 10, 20, 30 };
            C = 50;
            n = A.length;
            System.out.println(t1.tabulation_dp(n, C, A, B)); // 220

            // test case 2
            A = new int[] { 10, 20, 30, 40 };
            B = new int[] { 12, 13, 15, 19 };
            C = 10;
            n = A.length;
            System.out.println(t1.tabulation_dp(n, C, A, B)); // 0

            // test case 3
            A = new int[] { 468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828,
                    437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36,
                    895, 704, 812, 323 };
            B = new int[] { 4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1,
                    10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7 };
            C = 841;
            n = A.length;
            System.out.println(t1.tabulation_dp(n, C, A, B)); // 24576

        }
    }

}
