import java.util.Arrays;

/* Distinct Subsequences */

/* Problem Description

Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).


Problem Constraints
1 <= length(A), length(B) <= 700



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.


Output Format
Return an integer representing the answer as described in the problem statement.


Example Input

Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit" 
 B = "rabbit" 


Example Output

Output 1:
 1
Output 2:
 3


Example Explanation

Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit" 
    => A = "rab_bit" 
    => A = "rabb_it"

 Note: "_" marks the removed character. */

public class hw_q1_Distinct_Subsequences {

    /*
     * Approach 1 - Memoization (recursion +dp array)
     * TC: O(n x m)
     * SC: O(n x m) + recursive stack space O(n + m)
     */
    public int numDistinct_memoization(String A, String B) {
        // initialization block
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // start comparing from last
        return distinct_rec(n - 1, m - 1, A, B, dp);
    }

    /* Approach 1 - recursion function */
    public int distinct_rec(int i, int j, String A, String B, int[][] dp) {

        // if string B is exhausted
        if (j < 0)
            return 1;
        // if string A is exhausted and string B still has some characters left
        if (i < 0)
            return 0;

        // use existing calculated values for overlapping subproblem
        if (dp[i][j] != -1)
            return dp[i][j];

        if (A.charAt(i) == B.charAt(j)) {
            // pick
            int x = distinct_rec(i - 1, j - 1, A, B, dp);
            // do not pick
            int y = distinct_rec(i - 1, j, A, B, dp);
            return dp[i][j] = x + y;
        }

        // if characters do not match, do not pick and search in remaining string A
        return dp[i][j] = distinct_rec(i - 1, j, A, B, dp);
    }

    /**
     * Approach 2 - tabulation
     * TC: O(n x m)
     * SC: O(n x m) for dp array
     */
    public int numDistinct_tabulation(String A, String B) {

        // initialization block
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // pick
                    int x = dp[i - 1][j - 1];
                    // do not pick
                    int y = dp[i - 1][j];
                    dp[i][j] = x + y;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    /* Approach 3 - Space optimized with 2 rows */
    public int numDistinct_space_2rows(String A, String B) {

        // initialization block
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i % 2][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            int prevRow = (i - 1) % 2;
            int currRow = i % 2;
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // pick
                    int x = dp[prevRow][j - 1];
                    // do not pick
                    int y = dp[prevRow][j];
                    dp[currRow][j] = x + y;
                } else {
                    dp[currRow][j] = dp[prevRow][j];
                }
            }
        }
        return dp[n % 2][m];
    }

    /*
     * Approach 4 - Space optimized with single row
     * Observation: the dp[i][j] depends upon only on previous row and left values
     * TC: O(n x m)
     * SC: O(m) for 1d dp array
     */
    public int numDistinct_space__single_rows(String A, String B) {

        // initialization block
        int n = A.length();
        int m = B.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // start from last column (right to left) as current value is dependent upon
            // previous value
            for (int j = m; j >= 1; j--) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // pick
                    int x = dp[j - 1];
                    // do not pick
                    int y = dp[j];
                    dp[j] = x + y;
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {

        hw_q1_Distinct_Subsequences t1 = new hw_q1_Distinct_Subsequences();
        String A, B;

        {
            System.out.println("Approach 1- Memoization");
            // test case 1
            A = "rabbbit";
            B = "rabbit";
            System.out.println(t1.numDistinct_memoization(A, B)); // 3

            // test case 2
            A = "abc";
            B = "abc";
            System.out.println(t1.numDistinct_memoization(A, B)); // 1

            // test case 3
            A = "aaaababbababbaabbaaababaaabbbaaabbb";
            B = "bbababa";
            System.out.println(t1.numDistinct_memoization(A, B)); // 22113
        }
        {
            System.out.println("Approach 2- Tabulation");
            // test case 1
            A = "rabbbit";
            B = "rabbit";
            System.out.println(t1.numDistinct_tabulation(A, B)); // 3

            // test case 2
            A = "abc";
            B = "abc";
            System.out.println(t1.numDistinct_tabulation(A, B)); // 1

            // test case 3
            A = "aaaababbababbaabbaaababaaabbbaaabbb";
            B = "bbababa";
            System.out.println(t1.numDistinct_tabulation(A, B)); // 22113

        }
        {
            System.out.println("Approach 3 - Tabulation space optimized till 2 rows");
            // test case 1
            A = "rabbbit";
            B = "rabbit";
            System.out.println(t1.numDistinct_space_2rows(A, B)); // 3

            // test case 2
            A = "abc";
            B = "abc";
            System.out.println(t1.numDistinct_space_2rows(A, B)); // 1

            // test case 3
            A = "aaaababbababbaabbaaababaaabbbaaabbb";
            B = "bbababa";
            System.out.println(t1.numDistinct_space_2rows(A, B)); // 22113

        }
        {
            System.out.println("Approach 4 - Tabulation space optimized to single row");
            // test case 1
            A = "rabbbit";
            B = "rabbit";
            System.out.println(t1.numDistinct_space__single_rows(A, B)); // 3

            // test case 2
            A = "abc";
            B = "abc";
            System.out.println(t1.numDistinct_space__single_rows(A, B)); // 1

            // test case 3
            A = "aaaababbababbaabbaaababaaabbbaaabbb";
            B = "bbababa";
            System.out.println(t1.numDistinct_space__single_rows(A, B)); // 22113

        }
    }
}
