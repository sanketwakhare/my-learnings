/*
 Find Magic Numbers!

 Problem Description
Consider the decimal presentation of an integer. Let's call a number D - magic if digit D appears in decimal presentation of the number on all even positions and nowhere else.

For example, the numbers 1727374, 17, 1 are 7 - magic but 77, 7, 123, 34, 71 are not 7 - magic.

On the other hand the number 7 is 0 - magic, 123 is 2 - magic, 34 is 4 - magic and 71 is 1 - magic.

Find the number of D - magic numbers in the segment [L, R] that are multiple of C. Because the answer can be very huge you should only find its value modulo 109 + 7 (so you should find the remainder after dividing by 109 + 7).


Problem Constraints
1 <= C <= 2000
0 <= D <= 9
It is guaranteed that A <= B, the number of digits in A and B are the same and don't exceed 2000.

Input Format
First argument is a numeric string A denoting the positive integer L. (Without Leading Zeroes).
Second argument is a numeric string B denoting the positive integer R. (Without Leading Zeroes).
Third argument is an integer C.
Fourth argument is an integer D.


Output Format
Return an integer denoting the number of D - magic numbers in the segment [L, R] that are multiple of C. Because the answer can be very huge you should only find its value modulo 109 + 7 (so you should find the remainder after dividing by 109 + 7).


Example Input
Input 1:
 A = "10"
 B = "99"
 C = 2
 D = 6
Input 2:
 A = "1000"
 B = "9999"
 C = 19
 D = 7


Example Output
Output 1:
 8
Output 2:
 6


Example Explanation
Explanation 1:
 The numbers from the answer of the first example are 16, 26, 36, 46, 56, 76, 86 and 96.
Explanation 2:
 The numbers from the answer of the second example are 1767, 2717, 5757, 6707, 8797 and 9747.
 */

import java.math.BigInteger;
import java.util.Arrays;

public class q1_Find_Magic_Numbers {

    public static void main(String[] args) {
        q1_Find_Magic_Numbers t = new q1_Find_Magic_Numbers();
        {
            System.out.println(t.solve("10", "99", 2, 6)); // 8
            System.out.println(t.solve("1000", "9999", 19, 7)); // 6
            System.out.println(t.solve("12", "12", 2, 2)); // 1
            System.out.println(t.solve("6372451659957700362854162843720623142601337360014410221724168092176479911659703538545016668832338549",
                    "7969973326176891147525183958122002014921396842270051000646823226374743898663307171214245111949604186",
                    2, 2)); // 98449079
            System.out.println(t.solve("113548484131315415454546546467913135484841313154154",
                    "895458414564646646487131313118761454584145646466464", 1, 2)); // 970729981
        }
    }

    final int mod = 1000000007;

    // Iterations: 2 * 2 * D * logN * 2
    // TC: D is negligible as it ranges from 0 to 9 = 9 * logN ~ O(logN)
    public int solve(String A, String B, int C, int D) {
        // dp[position][isSmaller][isDMagic][numModC]
        int[][][][] dp;

        // find [0, B]
        int[] numB = toDigitArray(B);
        dp = new int[numB.length][2][2][C];
        fillDpArray(dp, -1);
        int f1 = f(0, 0, 1, 0, numB, dp, D, C);

        // 0 padding to the left of A-1 string to match the length of B
        String AMinus1 = subtract(A, "1");
        StringBuilder sb = new StringBuilder(AMinus1);
        sb.reverse();
        int len = B.length();
        while (sb.length() < len) {
            sb.append('0');
        }
        sb.reverse();
        AMinus1 = sb.toString();

        // find [0, A-1]
        int[] numA = toDigitArray(AMinus1);
        dp = new int[numA.length][2][2][C];
        fillDpArray(dp, -1);
        int f2 = f(0, 0, 1, 0, numA, dp, D, C);

        // subtract [0,A-1]
        return (f1 - f2 + mod) % mod;
    }

    int f(int position, int isSmaller, int isDMagic, int numModC, int[] num, int[][][][] dp, int D, int C) {
        // base cases
        // 1. is number is not magic, do not proceed further
        if (isDMagic == 0) return 0;
        // 2. if we reach the end and number is magic and multiple of C, return 1 otherwise return 0
        if (position == num.length) {
            if (numModC == 0 && isDMagic == 1) return 1;
            return 0;
        }

        // memoization
        if (dp[position][isSmaller][isDMagic][numModC] != -1) {
            return dp[position][isSmaller][isDMagic][numModC];
        }

        long answer = 0;

        // update maxDigit
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        for (int i = 0; i <= maxDigit; i++) {

            // considering position as 0-based indexing, position = 0 is odd position.
            // if position+1 is even, check if digit is matching with D, if yes, it is D-magic.
            // if position+1 is odd, check if digit is not matching with D, if not matching, it is D-magic.
            int tmpIsDMagic = (position + 1) % 2 == 0 ? (i == D ? 1 : 0) : (i == D ? 0 : 1);

            // check if new digit is smaller
            int tmpIsSmaller = isSmaller;
            if (i < maxDigit) {
                tmpIsSmaller = 1;
            }

            // update num mod C value
            long tmpNumModC = (numModC * 10L) + i;
            tmpNumModC %= C;

            answer = answer + f(position + 1, tmpIsSmaller, tmpIsDMagic, (int) tmpNumModC, num, dp, D, C);
            answer = (answer + mod) % mod;
        }
        return dp[position][isSmaller][isDMagic][numModC] = (int) answer;
    }

    // convert digits String to num array
    public int[] toDigitArray(String s) {
        int[] num = new int[s.length()];
        int i = 0;
        for (char ch : s.toCharArray()) {
            num[i++] = ch - 48;
        }
        return num;
    }

    // init dp array
    public void fillDpArray(int[][][][] dp, int val) {
        for (int[][][] p : dp) {
            for (int[][] q : p) {
                for (int[] r : q) {
                    Arrays.fill(r, val);
                }
            }
        }
    }

    // subtract 2 digit strings
    public String subtract(String a, String b) {

        // Create BigInteger objects from strings
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        // Perform subtraction
        BigInteger result = num1.subtract(num2);

        // Convert result back to a string
        return result.toString();
    }
}
