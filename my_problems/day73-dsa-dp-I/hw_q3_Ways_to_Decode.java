/* Ways to Decode */

/* Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints
1 <= length(A) <= 105



Input Format
The first and the only argument is a string A.



Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input
Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2. */

public class hw_q3_Ways_to_Decode {

    public int waysToDecode_dp(String A) {

        long[] dp = new long[A.length() + 1];
        long m = 1000000007;

        // edge case
        if (A.charAt(0) == '0') {
            return 0;
        }
        if (A.equals("")) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A.length(); i++) {
            int singleDigit = Integer.valueOf(A.substring(i - 1, i));
            int doubleDigit = Integer.valueOf(A.substring(i - 2, i));

            if (singleDigit > 0 && singleDigit < 10) {
                dp[i] = ((dp[i] % m) + (dp[i - 1] % m)) % m;
            }
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] = ((dp[i] % m) + (dp[i - 2] % m)) % m;
            }
        }

        return (int) dp[dp.length - 1];
    }

    public static void main(String[] args) {

        hw_q3_Ways_to_Decode o = new hw_q3_Ways_to_Decode();
        {
            System.out.println(o.waysToDecode_dp("1234"));
            System.out.println(o.waysToDecode_dp("0799733"));
            System.out.println(o.waysToDecode_dp("0"));
            System.out.println(o.waysToDecode_dp("103421"));
            System.out.println(o.waysToDecode_dp("42342103242"));
        }

    }

}
