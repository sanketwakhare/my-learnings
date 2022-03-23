import java.util.Arrays;

/* Longest Common Subsequence */

/* 
Problem Description

Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.


Problem Constraints
1 <= Length of A, B <= 1005



Input Format
First argument is a string A.
Second argument is a string B.


Output Format
Return an integer denoting the length of the longest common subsequence.


Example Input

Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
Input 2:

 A = "aaaaaa"
 B = "ababab"


Example Output

Output 1:
 5
Output 2:
 3


Example Explanation

Explanation 1:

 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:

 The longest common subsequence is "aaa", which has a length of 3.
 */

public class q1_Longest_Common_Subsequence {

    /**
     * Approach 1 - backtracking
     * TC: O(n x m)
     * SC: O( max(n, m)) OR n + m recursion stack space
     */
    public int lcs_backtrack(int n, int m, String a, String b) {

        if (n < 0 || m < 0) {
            return 0;
        }
        if (a.charAt(n) == b.charAt(m)) {
            return 1 + lcs_backtrack(n - 1, m - 1, a, b);
        }
        int x = lcs_backtrack(n - 1, m, a, b);
        int y = lcs_backtrack(n, m - 1, a, b);
        return Math.max(x, y);
    }

    /**
     * Approach 2 - recursion + DP
     * TC: O(n x m)
     * SC: O(n x m) dp array + recursion stack space
     */
    public int lcs_recursion_dp(int n, int m, String a, String b, int[][] dp) {

        // when there are no characters left from either of strings for comparison
        if (n < 0 || m < 0) {
            return 0;
        }
        // reuse the answer already calculated for overlapping subproblem
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (a.charAt(n) == b.charAt(m)) {
            // if characters are matching, consider count in answer
            dp[n][m] = 1 + lcs_recursion_dp(n - 1, m - 1, a, b, dp);
            return dp[n][m];
        }
        int x = lcs_recursion_dp(n - 1, m, a, b, dp);
        int y = lcs_recursion_dp(n, m - 1, a, b, dp);
        dp[n][m] = Math.max(x, y);
        return dp[n][m];
    }

    /**
     * Approach 3 - tabulation (iterative + DP)
     * TC: O(n x m)
     * SC: O(n x m) for dp array
     */
    public int lcs_tabulation(String a, String b) {

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        // initialize first row and first column with 0 (considering extra row and
        // column as dummy)

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.max((1 + dp[i - 1][j - 1]), Math.max(dp[i][j - 1], dp[i - 1][j]));
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * Approach 4 - tabulation (iterative + DP) + space optimized
     * TC: O(n x m)
     * SC: (2 x m)
     */
    public int lcs_space_optimized(String a, String b) {

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

        q1_Longest_Common_Subsequence t1 = new q1_Longest_Common_Subsequence();

        String A, B;
        int n, m;
        int[][] dp;

        {
            // Approach 1 - backtracking
            System.out.println("Approach 1 - backtracking");

            // test case 1
            A = "abbcdgf";
            B = "bbadcgf";
            n = A.length();
            m = A.length();
            System.out.println(t1.lcs_backtrack(n - 1, m - 1, A, B)); // 5 [bbdgf]

            // test case 2
            A = "aaaaaa";
            B = "ababab";
            n = A.length();
            m = A.length();
            System.out.println(t1.lcs_backtrack(n - 1, m - 1, A, B)); // 3 [aaa]
        }

        {
            // Approach 2 - recursion + DP
            System.out.println("Approach 2 - recursion + DP");

            // test case 1
            A = "abbcdgf";
            B = "bbadcgf";
            n = A.length();
            m = A.length();
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            t1.lcs_recursion_dp(n - 1, m - 1, A, B, dp);
            System.out.println(dp[n - 1][m - 1]); // 5 [bbdgf]

            // test case 2
            A = "aaa";
            B = "abaab";
            n = A.length();
            m = A.length();
            dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            t1.lcs_recursion_dp(n - 1, m - 1, A, B, dp);
            System.out.println(dp[n - 1][m - 1]); // 2 [aa]

        }

        {
            // Approach 3 - tabulation (iterative + DP)
            System.out.println("Approach 3 - tabulation (iterative + DP)");

            // test case 1
            A = "abbcdgf";
            B = "bbadcgf";
            System.out.println(t1.lcs_tabulation(A, B)); // 5 [bbdgf]
        }

        {
            // Approach 4 - tabulation (iterative + DP) + space optimized
            System.out.println("Approach 4 - tabulation (iterative + DP) + space optimized");

            // test case 1
            A = "abbcdgf";
            B = "bbadcgf";
            System.out.println(t1.lcs_space_optimized(A, B)); // 5 [bbdgf]

            // test case 2
            A = "klagrip";
            B = "lgigkm";
            System.out.println(t1.lcs_space_optimized(A, B)); // 3 [lgi]
        }
    }
}
