/**
 * Problem Description
 * <p>
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 * Find the maximum value of GCD.
 * <p>
 * Problem Constraints
 * 2 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * Output Format
 * Return an integer denoting the maximum value of GCD.
 * <p>
 * Example Input
 * Input 1:
 * A = [12, 15, 18]
 * Input 2:
 * A = [5, 15, 30]
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 15
 * <p>
 * Example Explanation
 * Explanation 1:
 * If you delete 12, gcd will be 3.
 * If you delete 15, gcd will be 6.
 * If you delete 18, gcd will 3.
 * Maximum value of gcd is 6.
 * <p>
 * Explanation 2:
 * If you delete 5, gcd will be 15.
 * If you delete 15, gcd will be 5.
 * If you delete 30, gcd will be 5.
 */

public class q2_DeleteOne {

    public int myGcd(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a > 0) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public int solve(int[] A) {

        int N = A.length;

        // generate prefix gcd array
        int[] prefixGcd = new int[N];
        // gcd(x,0) = x
        prefixGcd[0] = myGcd(0, A[0]);
        for (int i = 1; i < N; i++) {
            prefixGcd[i] = myGcd(prefixGcd[i - 1], A[i]);
        }

        // generate suffix gcd array
        int[] suffixGcd = new int[N];
        // gcd(x,0) = x
        suffixGcd[N - 1] = myGcd(0, A[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            suffixGcd[i] = myGcd(suffixGcd[i + 1], A[i]);
        }

        // find max gcd
        int maxGcd = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int currentGcd = Integer.MIN_VALUE;
            // edge case 1
            if (i == 0) {
                currentGcd = myGcd(suffixGcd[i + 1], 0);
            }
            // edge case 2
            else if (i == N - 1) {
                currentGcd = myGcd(prefixGcd[i - 1], 0);
            } else {
                currentGcd = myGcd(prefixGcd[i - 1], suffixGcd[i + 1]);
            }
            // update maxGcd if currentGcd is > maxGcd
            if (currentGcd > maxGcd) {
                maxGcd = currentGcd;
            }
        }

        return maxGcd;
    }
}
