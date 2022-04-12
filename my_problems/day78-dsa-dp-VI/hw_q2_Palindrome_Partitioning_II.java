import java.util.Arrays;

/* Palindrome Partitioning II */

/* Problem Description
Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.


Problem Constraints
1 <= length(A) <= 501


Input Format
The first and the only argument contains the string A.


Output Format
Return an integer, representing the minimum cuts needed.


Example Input
Input 1:

 A = "aba"
Input 2:

 A = "aab"


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 "aba" is already a palindrome, so no cuts are needed.
Explanation 2:

 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. */
public class hw_q2_Palindrome_Partitioning_II {

    public int minCut(String A) {

        int N = A.length();
        // worst case answer if all characters are different
        int minCuts = N - 1;

        boolean isPalindrome[][] = new boolean[N][N];
        for (boolean[] row : isPalindrome)
            Arrays.fill(row, true);
        int[][] dp = new int[N][N];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        // prepare isPalindrome boolean 2d array
        for (int col = 0; col < N; col++) {
            int j = col;
            for (int i = 0; i < N - col; i++, j++) {
                if (i == j) {
                    isPalindrome[i][i] = true;
                } else {
                    if (isPalindrome[i + 1][j - 1] == true && A.charAt(i) == A.charAt(j)) {
                        isPalindrome[i][i] = true;
                    } else {
                        isPalindrome[i][j] = false;
                    }
                }
            }
        }

        // traverse diagonals
        for (int col = 1; col < N; col++) {
            int j = col;
            for (int i = 0; i < N - col; i++, j++) {
                int cuts = N;
                int x = i + 1;

                // for a cell [i,j] -> traverse all cells to left of [i,j] and below [i,j]
                for (int y = i; y < j; y++, x++) {
                    cuts = Math.min(cuts, dp[i][y] + dp[x][j]);
                }

                // if string is palindrome, cuts would be 0
                if (isPalindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = cuts + 1;
                }
            }
        }

        minCuts = dp[0][N - 1];
        System.out.println("min cuts for string " + A + " are " + minCuts);
        return minCuts;
    }

    public static void main(String[] args) {

        hw_q2_Palindrome_Partitioning_II obj = new hw_q2_Palindrome_Partitioning_II();

        obj.minCut("abccbc"); // 2
        obj.minCut("cbcdecbc"); // 3

    }

}
