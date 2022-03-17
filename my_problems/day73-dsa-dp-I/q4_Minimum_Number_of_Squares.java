import java.util.Arrays;

/* Minimum Number of Squares */

/* Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.


Problem Constraints
1 <= A <= 10^5


Input Format
First and only argument is an inetegr A.


Output Format
Return an integer denoting the minimum count.


Example Input

Input 1:

 A = 6
Input 2:

 A = 5


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3. 
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5 */
public class q4_Minimum_Number_of_Squares {

    // recursive approach with dp array
    public int countMinSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minSquares_dp(n, dp);
    }

    /*
     * recursion with dp
     * TC: O(n)
     * SC: O(n)
     */
    public int minSquares_dp(int n, int[] dp) {

        // if already present in dp array, reuse
        if (dp[n] != -1) {
            return dp[n];
        }
        // base condition for 0
        if (n == 0) {
            dp[0] = 0;
            return dp[0];
        }
        // consider possibility by subtracting every square less than <=n, and take
        // maximum no of steps required to form n
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, minSquares_dp(n - i * i, dp));
        }
        // store answer in dp array and return
        dp[n] = min + 1;
        return dp[n];
    }

    public static void main(String[] args) {
        q4_Minimum_Number_of_Squares t1 = new q4_Minimum_Number_of_Squares();

        System.out.println(t1.countMinSquares(6)); // 3 [4 + 1 + 1]
        System.out.println(t1.countMinSquares(5)); // 2 [4 + 1]
        System.out.println(t1.countMinSquares(15)); // 4 [9 + 4 + 1 + 1]
        System.out.println(t1.countMinSquares(103)); // 4 [100 + 1 + 1 + 1]
        System.out.println(t1.countMinSquares(12)); // 3 [4 + 4 + 4]
        System.out.println(t1.countMinSquares(84)); // 3 [64 + 16 + 4]

    }

}
