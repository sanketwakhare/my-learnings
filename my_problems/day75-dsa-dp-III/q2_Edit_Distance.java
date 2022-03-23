import java.util.Arrays;

/* Edit Distance */

/* Problem Description

Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints
1 <= length(A), length(B) <= 450


Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.


Output Format
Return an integer, representing the minimum number of steps required.


Example Input

Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output

Output 1:
 1
Output 2:
 2

Example Explanation

Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B. */

public class q2_Edit_Distance {

    /**
     * Approach 1 - simple recursion (backtracking)
     * TC: O(n x m) - n and m are lengths of string A and B respectively.
     * SC: O(max(n, m)) recursion stack space
     */
    public int backtrack(int n, int m, String A, String B) {

        if (n < 0 || m < 0)
            return 0;

        if (A.charAt(n) == B.charAt(m)) {
            // reduce both lengths
            return backtrack(n - 1, m - 1, A, B);
        }
        // reduce length of B as a character is inserted at last to A
        int insertion = 1 + backtrack(n, m - 1, A, B);
        // reduce length of A as one character is removed from A
        int deletion = 1 + backtrack(n - 1, m, A, B);
        // reduce length of both A ans B as last character is replaced with correct
        // character
        int replacement = 1 + backtrack(n - 1, m - 1, A, B);
        // return min cost
        return Math.min(Math.min(insertion, deletion), replacement);
    }

    /**
     * Approach 2- recursion + DP
     * TC: O(n x m)
     * SC: O(n x m) + recursion stack space
     */
    public int editDistance_recursion(int n, int m, String A, String B, int[][] dp) {

        if (n < 0 && m < 0)
            return 0;

        if (n < 0)
            return 1 * (m + 1);
        if (m < 0)
            return 1 * (n + 1);

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (A.charAt(n) == B.charAt(m)) {
            // reduce both lengths
            return dp[n][m] = editDistance_recursion(n - 1, m - 1, A, B, dp);
        }
        // reduce length of B as a character is inserted at last to A
        int insertion = 1 + editDistance_recursion(n, m - 1, A, B, dp);
        // reduce length of A as one character is removed from A
        int deletion = 1 + editDistance_recursion(n - 1, m, A, B, dp);
        // reduce length of both A ans B as last character is replaced with correct
        // character
        int replacement = 1 + editDistance_recursion(n - 1, m - 1, A, B, dp);
        // return min cost
        return dp[n][m] = Math.min(Math.min(insertion, deletion), replacement);

    }

    public static void main(String[] args) {

        q2_Edit_Distance t1 = new q2_Edit_Distance();
        String A, B;
        int n, m;
        int[][] dp;

        {
            // Approach 1 - simple recursion (backtracking)
            System.out.println("Approach 1 - simple recursion (backtracking)");
            A = "Anshuman";
            B = "Antihuman";
            n = A.length();
            m = B.length();
            System.out.println(t1.backtrack(n - 1, m - 1, A, B));
        }

        {
            System.out.println("Approach 2 - recursion + DP");

            // test case 1
            A = "Anshuman";
            B = "Antihuman";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp));

            // test case 2
            A = "crossword";
            B = "hellowolrd";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp));

            // test case 3
            A = "aaa";
            B = "aa";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp));

            // test case 4
            A = "aaa";
            B = "aaaaaa";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp));
        }
    }
}
