import java.util.Arrays;

/* q1_Lets_Party */
/* Problem Description

In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.

Problem Constraints
1 <= A <= 10^5


Input Format
Given only argument A of type Integer, number of people in Danceland.


Output Format
Return an integer denoting the number of ways people of Danceland can party.


Example Input

Input 1:

 A = 3
Input 2:

 A = 5


Example Output

Output 1:
 4
Output 2:
 26


Example Explanation
Explanation 1:

 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4.
 
Explanation 2:

 Number of ways they can party are: 26. */
public class q1_Lets_Party {

    public int solve(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }

    // Recursive relation: dp[n] = dp[n-1] + (n-1) * dp[n-2];
    public int count(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        int m = 10003;
        for (int i = 3; i <= n; i++) {
            int x = dp[i - 1] % m;
            int y = ((i - 1 % m) * (dp[i - 2] % m)) % m;
            dp[i] = ((x) % m + (y) % m) % m;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        q1_Lets_Party t1 = new q1_Lets_Party();
        System.out.println(t1.solve(3)); // 4
        System.out.println(t1.solve(4)); // 10
        System.out.println(t1.solve(5)); // 26
        System.out.println(t1.solve(6)); // 76
    }
}
