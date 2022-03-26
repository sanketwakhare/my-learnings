import java.util.Arrays;

/* Tushar's Birthday Party */

/* Problem Description
As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.


Problem Constraints
|A| <= 1000
|B| <= 1000
|C| <= 1000


Input Format
First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost


Output Format
Return a single integer, the answer to the problem


Example Input
Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]

Example Output
Output 1:
12
Output 2:
4

Example Explanation
Explanation 1:

First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:

Only way is to take 2 dishes of cost 2, hence 4. */

public class hw_q2_Tushars_Birthday_Party {

    public int solve(final int[] A, final int[] B, final int[] C) {

        int ans = 0;
        int target = 0;
        int n = B.length;
        long[][] dp = zero_infinity_knapsack_space_optimized(n, 1001, C, B);
        for (int i = 0; i < A.length; i++) {
            target = A[i];
            ans += (int) dp[n][target];
        }
        return ans;
    }

    // build dp array for n x target values
    public long[][] zero_infinity_knapsack_space_optimized(int n, int target, int[] values, int[] weights) {

        // initialize base cases. first row and first column with 0
        long[][] dp = new long[n + 1][1001];
        for (long[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int prevRow = (i - 1);
            int currRow = i;
            for (int j = 1; j < 1001; j++) {
                // do not pick
                long x = dp[prevRow][j];
                // pick
                long y = 0;
                if (j - weights[i - 1] >= 0) {
                    y = (long) values[i - 1] + dp[currRow][j - weights[i - 1]];
                } else {
                    y = Integer.MAX_VALUE;
                }
                dp[currRow][j] = Math.min(x, y);
            }
        }
        return dp;
    }

    public static void main(String[] args) {

        hw_q2_Tushars_Birthday_Party t1 = new hw_q2_Tushars_Birthday_Party();
        int[] A, B, C;

        // test case 1
        A = new int[] { 2, 4, 6 };
        B = new int[] { 2, 1, 3 };
        C = new int[] { 2, 5, 3 };
        System.out.println(t1.solve(A, B, C)); // 12

        // test case 2
        A = new int[] { 2 };
        B = new int[] { 1 };
        C = new int[] { 2 };
        System.out.println(t1.solve(A, B, C)); // 4
    }

}
