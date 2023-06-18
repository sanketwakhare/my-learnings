import java.util.Arrays;

/* Max Sum Without Adjacent Elements */

/* Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.


Problem Constraints
1 <= N <= 20000
1 <= A[i] <= 2000


Input Format
The first and the only argument of input contains a 2d matrix, A.


Output Format
Return an integer, representing the maximum possible sum.


Example Input
Input 1:
 A = [   
        [1]
        [2]    
     ]
Input 2:
 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]

Example Output

Output 1:
 2
Output 2:
 8

Example Explanation
Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5. */
/**
 * TC: O(n)
 * SC: O(n) for dp array + O(n) for recursive stack space
 */
public class hw_q2_Max_Sum_Without_Adjacent_Elements {

    public int adjacent(int[][] A) {

        // Idea : create new array with only max from each column and apply the max sum
        // adjacent on 1D array
        int[] arr = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            arr[i] = Math.max(A[0][i], A[1][i]);
        }
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return maxSum(arr.length - 1, arr, dp);
    }

    public int maxSum(int i, int[] arr, int[] dp) {

        if (i == 0)
            return arr[0];
        if (i < 0)
            return 0;

        // if already calculated, reuse
        if (dp[i] != -1)
            return dp[i];

        int x = arr[i];
        if (i > 1)
            x += maxSum(i - 2, arr, dp);

        int y = maxSum(i - 1, arr, dp);
        dp[i] = Math.max(x, y);
        return dp[i];
    }

    public static void main(String[] args) {

        hw_q2_Max_Sum_Without_Adjacent_Elements t1 = new hw_q2_Max_Sum_Without_Adjacent_Elements();

        int[][] A = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{2, 3, 4, 5}
        };
        System.out.println(t1.adjacent(A)); // 8
        System.out.println(t1.adjacent2(A)); // 8

        A = new int[][]{
                new int[]{1},
                new int[]{2}
        };
        System.out.println(t1.adjacent(A)); // 2
        System.out.println(t1.adjacent2(A)); // 2
    }


    /**
     * Tabulation solution
     */
    public int adjacent2(int[][] A) {
        int[] input = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            input[i] = Math.max(A[0][i], A[1][i]);
        }
        return maxSum2(input);
    }

    public int maxSum2(int[] input) {

        int n = input.length;
        int[] dp = new int[n + 1];
        dp[1] = input[0];

        for (int i = 2; i <= n; i++) {
            int pick = input[i - 1] + dp[i - 2];
            int dontPick = dp[i - 1];
            dp[i] = Math.max(pick, dontPick);
        }
        return dp[n];
    }


}
