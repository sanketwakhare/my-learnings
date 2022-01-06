/**
 * Ath Magical Number
 * 
 * Problem Description
 * 
 * Given three positive integers A, B and C.
 * 
 * Any positive integer is magical if it is divisible by either B or C.
 * 
 * Return the Ath magical number. Since the answer may be very large, return it
 * modulo 109 + 7.
 * 
 * Problem Constraints
 * 1 <= A <= 10^9
 * 2 <= B, C <= 40000
 * 
 * 
 * Input Format
 * The first argument given is an integer A.
 * The second argument given is an integer B.
 * The third argument given is an integer C.
 * 
 * Output Format
 * Return the Ath magical number. Since the answer may be very large, return it
 * modulo 109 + 7.
 * 
 * Example Input
 * Input 1:
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * A = 4
 * B = 2
 * C = 3
 * 
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 6
 * 
 * Example Explanation
 * Explanation 1:
 * 1st magical number is 2.
 * Explanation 2:
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */

/**
 * Use formula to find the multiples of a or b till Nth number
 * count of multiples till x = (x/a) + (x/b) - (x/lcm(a,b))
 * lcm(a,b) * gcd(a,b) = a*b
 * 
 * Then apply Binary search on possible values
 */
public class q4_AthMagicalNumber {

    // custom function to calculate the GCD
    public static long gcd(long a, long b) {

        // make sure to maintain the value of a < b
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        // repeat while a becomes 0
        while (a > 0) {
            // make to maintain a < b
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            // update value of a and b
            long temp = a;
            a = b % a;
            b = temp;
        }
        // return final answer
        return b;
    }

    public static long getCountOfMultiplesTillN(long N, long A, long B) {
        long x = N;
        long a = A;
        long b = B;
        // find Ath number multiple of either B or C
        long mult = a * b;
        long lcm = mult / (long) gcd(A, B);

        long ans = (x / a) + (x / b) - (x / lcm);
        return ans;
    }

    public static long AthMagicalNumber(long N, long A, long B) {

        // define search space
        long l = Math.min(A, B);
        long r = l * N;

        long ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long count = getCountOfMultiplesTillN(mid, A, B);
            if (count == N) {
                // update answer and check for better answer on left
                ans = mid;
                r = mid - 1;
            } else if (count < N) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans % 1000000007);
        return ans % 1000000007;
    }

    public static void main(String[] args) {

        AthMagicalNumber(10, 2, 3);
        AthMagicalNumber(2, 2, 3);
        AthMagicalNumber(4, 2, 3);
        AthMagicalNumber(6, 5, 7);
        AthMagicalNumber(807414236, 3788, 38141); // expected result 238134151
        AthMagicalNumber(426344489, 36067, 29025); // expected result 807466633
        AthMagicalNumber(827802315, 12423, 7916); // expected result 678065970
    }

}
