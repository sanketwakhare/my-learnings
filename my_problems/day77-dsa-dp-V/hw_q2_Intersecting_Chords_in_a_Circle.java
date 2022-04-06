/* Intersecting Chords in a Circle */
/* Problem Description
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 109 + 7.



Problem Constraints
1 <= A <= 103



Input Format
The first and the only argument contains the integer A.



Output Format
Return an integer answering the query as described in the problem statement.



Example Input
Input 1:

 A = 1
Input 2:

 A = 2


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are: {(1-2)} only. So, we return 1.
Explanation 2:

 If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
 So, we return 2. */

/* Idea: Find Catalan no from 0 to A */
public class hw_q2_Intersecting_Chords_in_a_Circle {

    // Catalan number
    public int chordCnt(int A) {

        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        long m = 1000000007;

        for (int i = 2; i <= A; i++) {
            for (int j = 0; j < i; j++) {
                long value = (((long) dp[j] % m) * ((long) dp[i - j - 1] % m)) % m;
                dp[i] = (int) ((((long) dp[i] % m) + ((long) value % m)) % m);
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {

        hw_q2_Intersecting_Chords_in_a_Circle t1 = new hw_q2_Intersecting_Chords_in_a_Circle();

        System.out.println(t1.chordCnt(1));// 1
        System.out.println(t1.chordCnt(2));// 2
        System.out.println(t1.chordCnt(3));// 5
        System.out.println(t1.chordCnt(5));// 42
    }

}
