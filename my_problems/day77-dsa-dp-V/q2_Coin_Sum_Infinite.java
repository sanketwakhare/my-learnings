/* Coin Sum Infinite */

/* Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.



Example Input

Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3} 
Explanation 2:

 There is only 1 way to make sum 10. */
public class q2_Coin_Sum_Infinite {

    public int coin_change2_space_optimized(int[] values, int target) {

        // initialize base cases. first row and first column with 0
        int n = values.length;
        long[][] dp = new long[2][target + 1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        long m = 1000007;

        for (int i = 1; i <= n; i++) {
            int prevRow = (i - 1) % 2;
            int currRow = i % 2;
            for (int j = 1; j <= target; j++) {
                // do not pick
                long x = dp[prevRow][j];
                // pick
                long y = 0;
                if (j - values[i - 1] >= 0) {
                    y = dp[currRow][j - values[i - 1]];
                }
                dp[currRow][j] = ((x % m) + (y % m)) % m;
            }
        }
        return (int) (dp[n % 2][target] % m);
    }

    public static void main(String[] args) {

        q2_Coin_Sum_Infinite t1 = new q2_Coin_Sum_Infinite();

        // test case 2
        int[] A = new int[] { 1, 2, 3 };
        int targetSum = 4;
        System.out.println(t1.coin_change2_space_optimized(A, targetSum)); // 4

        // test case 2
        A = new int[] { 18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 };
        targetSum = 458;
        System.out.println(t1.coin_change2_space_optimized(A, targetSum)); // 867621
    }

}
