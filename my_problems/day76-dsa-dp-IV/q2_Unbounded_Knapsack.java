import java.util.Arrays;

/* Unbounded Knapsack */

/* Problem Description

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000


Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C


Output Format

Return the maximum value that fills the knapsack completely


Example Input

Input 1:

A = 10
B = [5]
C = [10]
Input 2:

A = 10
B = [6, 7]
C = [5, 5]


Example Output

Output 1:

 5
Output 2:

14


Example Explanation

Explanation 1:

Only valid possibility is to take the given item.
Explanation 2:

Take the second item twice. */
public class q2_Unbounded_Knapsack {

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
                    y = values[i - 1] + dp[currRow][j - weights[i - 1]];
                }
                dp[currRow][j] = Math.max(x, y);
            }
        }
        return dp[n % 2][target];
    }

    public static void main(String[] args) {

        q2_Unbounded_Knapsack t1 = new q2_Unbounded_Knapsack();
        int[] A, B;
        int C, n;
        {
            // Approach 4 - space optimized solution + DP
            System.out.println("*** Approach 4 - space optimized solution + DP");

            // test case 1
            A = new int[] { 60, 100, 120 };
            B = new int[] { 10, 20, 30 };
            C = 50;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 300

            // test case 2
            A = new int[] { 10, 20, 30, 40 };
            B = new int[] { 12, 13, 15, 19 };
            C = 10;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 0

            // test case 3
            A = new int[] { 468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828,
                    437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36,
                    895, 704, 812, 323 };
            B = new int[] { 4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1,
                    10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7 };
            C = 841;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 649252

            // test case 4
            A = new int[] { 12, 20, 15, 6, 10 };
            B = new int[] { 3, 6, 5, 2, 4 };
            C = 8;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 30

            // test case 5
            A = new int[] { 5 };
            B = new int[] { 10 };
            C = 10;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 5

            // test case 6
            A = new int[] { 6, 7 };
            B = new int[] { 5, 5 };
            C = 10;
            n = A.length;
            System.out.println(t1.space_optimized(n, C, A, B)); // 14
        }
    }

}
