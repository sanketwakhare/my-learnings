/*  Longest Palindromic Subsequence */

/* Problem Description

Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.


Problem Constraints
1 <= length of(A) <= 10^3


Input Format
First and only integer is a string A.



Output Format
Return an integer denoting the length of longest palindromic subsequence.


Example Input
Input 1:
 A = "bebeeed"
Input 2:
 A = "aedsead"


Example Output
Output 1:
 4
Output 2:
 5

Example Explanation
Explanation 1:
 The longest palindromic subsequence is "eeee", which has a length of 4.
Explanation 2:
 The longest palindromic subsequence is "aedea", which has a length of 5. */

public class q1_Longest_Palindromic_Subsequence {

    // Idea : find longest common subsequence between string and its reverse
    public int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        sb.reverse();
        String rev = sb.toString();
        return lcs(A, rev);
    }

    // TC: O(n x m)
    // SC: O(n x 2)
    public int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[2][m + 1];

        // initialize first row and first column with 0 (considering extra row and
        // column as dummy)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int currRow = (i) % 2;
                int prevRow = (i - 1) % 2;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[currRow][j] = Math.max((1 + dp[prevRow][j - 1]), Math.max(dp[currRow][j - 1], dp[prevRow][j]));
                } else {
                    dp[currRow][j] = Math.max(dp[currRow][j - 1], dp[prevRow][j]);
                }
            }
        }
        return dp[n % 2][m];
    }

    public static void main(String[] args) {

        q1_Longest_Palindromic_Subsequence t1 = new q1_Longest_Palindromic_Subsequence();
        String A;

        A = "bebeeed";
        System.out.println(t1.solve(A)); // [e-e-e-e]
        A = "aedsead";
        System.out.println(t1.solve(A)); // [a-e-d-e-a]

    }
}
