/* Primal Power */

import java.util.Arrays;

/* TC: O(n log n + n)

SC: O(max(array elements)) */
public class hw_q2_Primal_Power_Sieve_of_Eratosthenes {
    public int solve(int[] A) {

        // find max number from array and eliminate -ve numbers from array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                max = Math.max(A[i], max);
            }
        }

        // apply sieve of Eratosthenes

        // initialize prime array from 1 to N with true (assumption)
        int n = max;
        boolean prime[] = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        // mark all numbers which are multiples of any of the previous numbers
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j = j + i) {
                if (prime[j] == true) {
                    prime[j] = false;
                }
            }
        }

        // find the final count of prime numbers within an array
        int primeCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (prime[A[i]]) {
                    primeCount++;
                }
            }
        }
        return primeCount;
    }

    public static void main(String[] args) {

        hw_q2_Primal_Power_Sieve_of_Eratosthenes t1 = new hw_q2_Primal_Power_Sieve_of_Eratosthenes();
        int[] A;
        {
            A = new int[] { -11, 7, 8, 9, 10, 11 };
            System.out.println(t1.solve(A)); // 2 [7,11]
        }
        {
            A = new int[] { 5, 8, 7, 3, 9, 77, 55, 53, 31, 80 };
            System.out.println(t1.solve(A)); // 5 [5,6,3,53,31]
        }
    }
}
