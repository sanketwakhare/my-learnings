/*  Flip Array */

/* Problem Description

Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.



Problem Constraints

1 <= length of(A) <= 100

Sum of all the elements will not exceed 10,000.



Input Format

First and only argument is an integer array A.



Output Format

Return an integer denoting the minimum number of elements whose sign needs to be flipped.



Example Input

Input 1:

 A = [15, 10, 6]
Input 2:

 A = [14, 10, 4]


Example Output

Output 1:

 1
Output 2:

 1


Example Explanation

Explanation 1:

 Here, we will flip the sign of 15 and the resultant sum will be 1.
Explanation 2:

 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum. */

public class hw_q2_Flip_Array {
    public int solve(final int[] A) {
        // find total sum
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        // initialize dp array
        int n = A.length;
        sum = sum / 2;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = 20000;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                int val = A[i - 1];
                if (j - val >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - val]);
                }
            }
        }

        while (dp[n][sum] == 20000) {
            sum--;
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        hw_q2_Flip_Array t1 = new hw_q2_Flip_Array();
        int[] A;
        {
            A = new int[] { 8, 4, 5, 7, 6, 2 };
            System.out.println(t1.solve(A));// expected output: 3
        }
    }
}
