/* Dragon and Princess/Prince */

/* q5) Dragon and Princes-> find min energy required for prince to reach to Princess.

The negative values represents dragon is sitting in those cells and prince has to pay that cost/energy if he has to go through the dragon cells.
The positive values represents energy drinks which prince can consume to increase the energy.

Allowed directions-> RIGHT and DOWN */

/**
 * TC: O(n x m)
 * SC: O(n x m)
 */
public class class_q5_Dragon_and_Princess {

    public int calculateMinimumHP(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int dp[][] = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // base case for last cell
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = Math.max(1, 1 - A[i][j]);
                } else {
                    if (i == n - 1) {
                        // for last row, the value is dependent upon right cell
                        dp[i][j] = Math.max(dp[i][j + 1] - A[i][j], 1);
                    } else if (j == m - 1) {
                        // for last column, the value is dependent upon down cell
                        dp[i][j] = Math.max(dp[i + 1][j] - A[i][j], 1);
                    } else {
                        // for middle cells, the value is dependent upon right and down cell
                        dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - A[i][j]);
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

        class_q5_Dragon_and_Princess t1 = new class_q5_Dragon_and_Princess();

        // test case 1
        int[][] A = new int[][] {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 }
        };
        System.out.println(t1.calculateMinimumHP(A)); // 7

        // test case 2
        A = new int[][] {
                { 1, -1, 0 },
                { -1, 1, -1 },
                { 1, 0, -1 }
        };
        System.out.println(t1.calculateMinimumHP(A)); // 1

    }

}
