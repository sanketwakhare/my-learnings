/***
 * Compute nCr % p
 * 
 * Problem Description
 * 
 * Given three integers A, B and C, where A represents n, B represents r and C
 * represents p and p is a prime number greater than equal to n, find and return
 * the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * NOTE: For this problem, we are considering 1 as a prime.
 * 
 * Problem Constraints
 * 1 <= A <= 106
 * 1 <= B <= A
 * A <= C <= 109+7
 * 
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 * 
 * Output Format
 * Return the value of nCr % p.
 * 
 * Example Input
 * Input 1:
 * A = 5
 * B = 2
 * C = 13
 * Input 2:
 * A = 6
 * B = 2
 * C = 13
 * 
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * nCr( n=5 and r=2) = 10.
 * p=13. Therefore, nCr%p = 10.
 */

public class Compute_nCr_Mod_prime {

    /**
     * Power Mod function
     * TC: O(logN)
     * SC: O(logN) => recursive stack space
     */
    public static int powerMod(int a, int n, int m) {
        if (n == 0) {
            return 1 % m;
        }
        if (n == 1) {
            return a % m;
        }

        long p = powerMod(a, n / 2, m);
        long ans = ((p % m) * (p % m)) % m;

        if (n % 2 != 0) {
            ans = ((ans % m) * (a % m)) % m;
        }
        if (ans < 0) {
            ans = ans + m;
        }

        return (int) ans;
    }

    /**
     * TC: O(N)
     * 
     * @param n integer
     * @param m integer mod value
     * @return factorial % m
     */
    public static int fact(int n, int m) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans = (ans % m * i % m) % m;
        }
        if (ans < 0) {
            ans = ans + m;
        }
        return (int) ans;
    }

    /**
     * Iteration: logN + N + R + (N-R) => logN + 2N iterations
     * TC: O(N)
     * SC: O(logN) => recursive stack space
     * 
     * @param n
     * @param r
     * @param m
     * @return
     */
    public static int computeNcrRec(int n, int r, int m) {
        /*
         * using powerMod function
         * nCr = n! / ((n-r)! * r!)
         * This can be written as => (n!) * ((n-r)!)^-1 * (r!)^-1
         * Optimized Formula => (n!) * ((n-r)!)^(p-2) * (r!)^-(p-2)
         * Using Fermat's Little theorem => a^-1%p can be written as a^(p-2) where p is
         * prime number > a
         */
        int nFact = fact(n, m);
        int rFact = fact(r, m);
        int nMinusR = fact(n - r, m);

        // apply mod multiplications
        long ans = (((long) nFact % m) * ((long) powerMod(rFact, m - 2, m) % m)) % m;
        ans = (((long) ans % m) * ((long) powerMod(nMinusR, m - 2, m) % m)) % m;

        // if ans is -ve, add mod value to ans
        if (ans < 0) {
            ans = ans + m;
        }
        return (int) (ans % m);
    }

    public static void main(String[] args) {
        System.out.println(computeNcrRec(5, 2, 13)); // The expected return value: 10
        System.out.println(computeNcrRec(6, 2, 13)); // The expected return value: 2
        System.out.println(computeNcrRec(149, 12, 48157)); // The expected return value: 32102
        System.out.println(computeNcrRec(778, 578, 10007)); // The expected return value: 3624
    }
}
