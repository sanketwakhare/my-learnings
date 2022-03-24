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

        if (n < 0 && m < 0)
            return 0;

        if (n < 0)
            return 1 * (m + 1);
        if (m < 0)
            return 1 * (n + 1);

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
     * Approach 2 - recursion + DP
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

    /***
     * Approach 3 - editDistance tabulation method
     * TC: O(n x m)
     * SC: O(n x m) for dp array
     */
    public int editDistance_tabulation(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];

        // consider first character of row and column is empty
        dp[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j * 1; // cost of insertion
        }
        for (int i = 1; i <= n; i++) {
            int[] row = dp[i];
            Arrays.fill(row, Integer.MAX_VALUE);
            row[0] = i * 1; // cost of deletion
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    int insertion = 1 + dp[i][j - 1];
                    int deletion = 1 + dp[i - 1][j];
                    int replacement = 1 + dp[i - 1][j - 1];
                    // consider min cost of insertion replacement and deletion
                    dp[i][j] = Math.min(Math.min(insertion, deletion), replacement);
                } else {
                    // characters match, consider previous min cost
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    /***
     * Approach 4 - space optimized
     * TC: O(n x m)
     * SC: O(2 x m) for dp array
     */
    public int editDistance_space_optimized(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m + 1];

        // consider first character of row and column is empty
        dp[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j * 1; // cost of insertion
        }
        for (int i = 1; i <= 1; i++) {
            int[] row = dp[i];
            Arrays.fill(row, Integer.MAX_VALUE);
            row[0] = i * 1; // cost of deletion
        }

        for (int i = 1; i <= n; i++) {

            int prevRowNo = (i - 1) % 2;
            int rowNo = i % 2;
            dp[prevRowNo][0] = (i - 1) * 1;
            dp[rowNo][0] = i * 1;

            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    int insertion = 1 + dp[rowNo][j - 1];
                    int deletion = 1 + dp[prevRowNo][j];
                    int replacement = 1 + dp[prevRowNo][j - 1];
                    // consider min cost of insertion replacement and deletion
                    dp[rowNo][j] = Math.min(Math.min(insertion, deletion), replacement);
                } else {
                    // characters match, consider previous min cost
                    dp[rowNo][j] = dp[prevRowNo][j - 1];
                }
            }
        }
        return dp[n % 2][m];
    }

    public static void main(String[] args) {

        q2_Edit_Distance t1 = new q2_Edit_Distance();
        String A, B;
        int n, m;
        int[][] dp;

        {
            // Approach 1 - simple recursion (backtracking)
            System.out.println("Approach 1 - simple recursion (backtracking)");

            // test case 1
            A = "Anshuman";
            B = "Antihuman";
            n = A.length();
            m = B.length();
            System.out.println(t1.backtrack(n - 1, m - 1, A, B)); // 2 replacements

            // test case 2
            A = "aa";
            B = "aaaaa";
            n = A.length();
            m = B.length();
            System.out.println(t1.backtrack(n - 1, m - 1, A, B)); // 3 insertions
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
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp)); // 2 replacements

            // test case 2
            A = "crossword";
            B = "hellowolrd";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp)); // 6 [1 insertion + 5 replacements]

            // test case 3
            A = "aaa";
            B = "aa";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp)); // 1 deletion

            // test case 4
            A = "aaa";
            B = "aaaaaa";
            n = A.length();
            m = B.length();
            dp = new int[n][m];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            System.out.println(t1.editDistance_recursion(n - 1, m - 1, A, B, dp)); // 3 insertions
        }
        {
            // Approach 3 - editDistance tabulation method
            System.out.println("Approach 3 - editDistance tabulation method");

            // test case 1
            A = "Anshuman";
            B = "Antihuman";
            System.out.println(t1.editDistance_tabulation(A, B)); // 2 replacements

            // test case 2
            A = "aaa";
            B = "aa";
            System.out.println(t1.editDistance_tabulation(A, B)); // 1 deletion

            // test case 3
            A = "aaa";
            B = "aaaaaa";
            System.out.println(t1.editDistance_tabulation(A, B)); // 3 insertions

            A = "abaabbbbabaabaa";
            B = "aaaababa";
            System.out.println(t1.editDistance_tabulation(A, B)); // 7
        }
        {
            // Approach 4 - space optimized
            System.out.println("Approach 4 - space optimized");

            // test case 1
            A = "Anshuman";
            B = "Antihuman";
            System.out.println(t1.editDistance_space_optimized(A, B)); // 2 replacements

            // test case 2
            A = "aaa";
            B = "aa";
            System.out.println(t1.editDistance_space_optimized(A, B)); // 1 deletion

            // test case 3
            A = "aaa";
            B = "aaaaaa";
            System.out.println(t1.editDistance_space_optimized(A, B)); // 3 insertions

            // test case 4
            A = "abaabbbbabaabaa";
            B = "aaaababa";
            System.out.println(t1.editDistance_space_optimized(A, B)); // 3 insertions
        }
    }
}
