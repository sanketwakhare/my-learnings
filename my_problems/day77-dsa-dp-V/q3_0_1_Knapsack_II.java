import java.util.Arrays;

/* 0-1 Knapsack II */

/* Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 22
Output 2:

 0


Example Explanation

Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0. */

public class q3_0_1_Knapsack_II {

    public int space_optimized(int n, int target, int[] values, int[] weights) {

        // initialize base cases. first row and first column with 0
        int[][] dp = new int[2][target + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= 1; i++) {
            int[] row = dp[i];
            Arrays.fill(row, -1);
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int prevRow = (i - 1) % 2;
            int currRow = i % 2;
            for (int j = 1; j <= target; j++) {
                // do not pick
                int x = dp[prevRow][j];
                // pick
                int y = 0;
                if (j - weights[i - 1] >= 0) {
                    y = values[i - 1] + dp[prevRow][j - weights[i - 1]];
                }
                dp[currRow][j] = Math.max(x, y);
            }
        }
        return dp[n % 2][target];
    }

    public int solve(int[] A, int[] B, int C) {

        int n = A.length;
        return space_optimized(n, C, A, B);
    }

    public static void main(String[] args) {
        q3_0_1_Knapsack_II t1 = new q3_0_1_Knapsack_II();
        int[] A, B;
        int C;

        A = new int[] { 6, 10, 12 };
        B = new int[] { 10, 20, 30 };
        C = 50;
        System.out.println(t1.solve(A, B, C)); // 22

        A = new int[] { 1, 3, 2, 4 };
        B = new int[] { 12, 13, 15, 19 };
        C = 10;
        System.out.println(t1.solve(A, B, C)); // 0

    }
}
