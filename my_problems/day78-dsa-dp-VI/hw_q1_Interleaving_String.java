/*  Interleaving Strings */

/* Problem Description
Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints
1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.



Output Format
Return 1 if string C is formed by interleaving of A and B else 0.



Example Input
Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
Explanation 2:

 It is not possible to get C by interleaving A and B. */

import java.util.Arrays;

public class hw_q1_Interleaving_String {
    public int isInterleave(String A, String B, String C) {
        int n = A.length();
        int m = B.length();
        int index = C.length();

        if (index != (n + m)) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return check(A, B, C, n - 1, m - 1, index - 1, dp) ? 1 : 0;
    }

    public boolean check(String A, String B, String C, int n, int m, int index, int[][] dp) {

        boolean state = false;

        // when all the strings are exhausted, return true
        if (n < 0 && m < 0 && index < 0) {
            return true;
        }

        // reuse existing answers for repeated subproblem
        if (dp[n + 1][m + 1] != -1) {
            return dp[n + 1][m + 1] == 1 ? true : false;
        }
        // one possibility is to consider character from string A
        if (index >= 0 && n >= 0) {
            char ch1 = A.charAt(n);
            char ch3 = C.charAt(index);
            if (ch3 == ch1) {
                state = check(A, B, C, n - 1, m, index - 1, dp);
            } else {
                state = false;
            }
        }
        // another possibility is to consider character from string B
        if (!state && index >= 0 && m >= 0) {
            char ch2 = B.charAt(m);
            char ch3 = C.charAt(index);
            if (ch3 == ch2) {
                state = check(A, B, C, n, m - 1, index - 1, dp);
            } else {
                state = false;
            }
        }
        // update answer in dp array ans return
        dp[n + 1][m + 1] = state ? 1 : 0;
        return state;
    }

    public static void main(String[] args) {

        hw_q1_Interleaving_String t1 = new hw_q1_Interleaving_String();
        String A, B, C;
        {
            A = "B";
            B = "e";
            C = "Be";
            System.out.println(t1.isInterleave(A, B, C)); // true
        }
        {
            A = "aabcc";
            B = "dbbca";
            C = "aadbbcbcac";
            System.out.println(t1.isInterleave(A, B, C)); // true
        }
        {
            A = "aabcc";
            B = "dbbca";
            C = "aadbbbaccc";
            System.out.println(t1.isInterleave(A, B, C)); // false
        }
        {
            A = "aabc";
            B = "abad";
            C = "aabadabc";
            System.out.println(t1.isInterleave(A, B, C)); // true
        }
        {
            A = "caacbbccccbbccbaccccc";
            B = "cababbbcaccbacbcbacbbaababa";
            C = "cabacbacbbbabcccaccccbbabccbcbcbacabbccaacbccaba";
            System.out.println(t1.isInterleave(A, B, C)); // false
        }
    }
}
