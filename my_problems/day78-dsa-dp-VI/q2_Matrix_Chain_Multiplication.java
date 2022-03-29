import java.util.Arrays;

/* Matrix Chain Multiplication */

/* Problem Description

Given an array of integers A representing chain of 2-D matrices such that the dimensions of ith matrix is A[i-1] x A[i].

Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

Return the minimum number of multiplications needed to multiply the chain.


Problem Constraints

1 <= length of the array <= 1000
1 <= A[i] <= 100


Input Format
The only argument given is the integer array A.


Output Format
Return an integer denoting the minimum number of multiplications needed to multiply the chain.

Example Input

Input 1:
 A = [40, 20, 30, 10, 30]
Input 2:
 A = [10, 20, 30]


Example Output

Output 1:
 26000
Output 2:
 6000


Example Explanation

Explanation 1:

 Dimensions of A1 = 40 x 20
 Dimensions of A2 = 20 x 30
 Dimensions of A3 = 30 x 10
 Dimensions of A4 = 10 x 30
 First, multiply A2 and A3 ,cost = 20*30*10 = 6000
 Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
 Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
 Total Cost = 12000 + 8000 + 6000 =26000
Explanation 2:

 Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000. */
public class q2_Matrix_Chain_Multiplication {

    // Approach 1 - recursion + DP [memoization]
    public int minCost(int[] A, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], minCost(A, i, k, dp) + minCost(A, k + 1, j, dp) + (A[i - 1] * A[k] * A[j]));
        }
        return dp[i][j];
    }

    // Approach 2 - iterative approach [tabulation]
    public int tabulation_mcm(int[] A) {
        int n = A.length;
        // initialize dp array with max value as we need to find the min value
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        // start from bottom row to top row
        for (int i = n; i >= 1; i--) {
            // start from left column to right column
            for (int j = i; j < n; j++) {
                // base case
                if (i == j)
                    dp[i][j] = 0;
                // recursive relation converted to iterative code
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + (A[i - 1] * A[k] * A[j]));
                }
            }
        }
        // answer will be stored at dp[1][n-1]
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        q2_Matrix_Chain_Multiplication t1 = new q2_Matrix_Chain_Multiplication();
        int[] A;

        {
            System.out.println("Approach 1 - recursion + dp");
            int n;
            int[][] dp;

            // test case 1
            A = new int[] { 40, 20, 30, 10, 30 };
            n = A.length;
            dp = new int[n][n];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.minCost(A, 1, n - 1, dp)); // 26000

            // test case 2
            A = new int[] { 45, 17, 34, 27, 12, 22 };
            n = A.length;
            dp = new int[n][n];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.minCost(A, 1, n - 1, dp)); // 39012
        }
        {
            System.out.println("Approach 2 - tabulation + dp");
            // test case 1
            A = new int[] { 40, 20, 30, 10, 30 };
            System.out.println(t1.tabulation_mcm(A)); // 26000
            // test case 2
            A = new int[] { 45, 17, 34, 27, 12, 22 };
            System.out.println(t1.tabulation_mcm(A)); // 39012
        }

    }

}
