import java.util.Arrays;

/* Ways to send the signal */

/* Problem Description

You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.



Problem Constraints

1 <= A <= 105



Input Format

The only argument given is integer A.



Output Format

Return the ans%(109+7).



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 3
Output 2:

 5


Example Explanation

Explanation 1:

 OFF OFF
 OFF ON 
 ON OFF
All lights off is also a valid signal which probably means 'bye'

Explanation 2:

 OFF OFF OFF
 OFF OFF ON
 OFF ON OFF 
 ON OFF OFF
 ON OFF ON
  */
public class hw_q3_Ways_to_send_the_signal {

    public int solve(int A) {
        long m = 1000000007;
        long[] dp = new long[A + 1];
        Arrays.fill(dp, -1);
        return (int) sendSignal(A, m, dp);
    }

    public long sendSignal(long i, long m, long[] dp) {

        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            return 1;
        }

        if (dp[(int) i] != -1) {
            return dp[(int) i];
        }

        // pick alternate option
        long x = sendSignal(i - 1, m, dp);
        long y = sendSignal(i - 2, m, dp);
        return dp[(int) i] = ((x % m) + (y % m)) % m;
    }

    public static void main(String[] args) {

        hw_q3_Ways_to_send_the_signal t1 = new hw_q3_Ways_to_send_the_signal();
        int A;

        A = 3;
        System.out.println(t1.solve(A)); // 5

        A = 5;
        System.out.println(t1.solve(A)); // 13

        A = 10;
        System.out.println(t1.solve(A)); // 144

        A = 4312;
        System.out.println(t1.solve(A)); // 116413574

    }

}
