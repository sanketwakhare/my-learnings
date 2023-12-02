/*
Given an array A of length N, Find no of ways to pick K even numbers
 */
public class class_q4_ways_to_pick_K_even_numbers {
    public static void main(String[] args) {
        int m = 1000000007;
        class_q4_ways_to_pick_K_even_numbers t = new class_q4_ways_to_pick_K_even_numbers();
        {
            int[] A = {1, 10, 3, 4, 5, 6};
            int K = 2;
            System.out.println(t.solve(A, K, m)); // 3C2 = 3
        }
        {
            int[] A = {19, 20, 13, 14, 25, 36, 44, 33, 22, 54, 65, 76};
            int K = 3;
            System.out.println(t.solve(A, K, m)); // 7C3 = 35
        }
    }

    public int solve(int[] A, int K, int m) {
        // find no of even numbers first
        int countEven = 0;
        for (int temp : A) {
            if ((temp & 1) == 0) countEven++;
        }
        return ncr(countEven, K, m);
    }

    // TC: O(n log M)
    // SC: O(n)
    public int ncr(int n, int r, int m) {
        int[] fact = populateFactorials(n, m);
        int[] invFact = populateInverseFactorial(n, m, fact);

        int ans = fact[n];
        ans = (int) (((((long) (ans % m) * (invFact[r] % m)) % m) + m) % m);
        ans = (int) (((((long) (ans % m) * (invFact[n - r] % m)) % m) + m) % m);
        return ans;
    }

    // TC: O(n)
    // SC: O(n)
    public int[] populateFactorials(int n, int m) {
        int[] fact = new int[n + 1];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (int) ((((((long) fact[i - 1] % m) * (i % m)) % m) + m) % m);
        }
        return fact;
    }

    // TC: O(logN)
    // SC: O(logN)
    public static int power(int a, int n, int m) {
        if (n == 0) {
            return 1 % m;
        }
        if (n == 1) {
            return a % m;
        }

        long p = power(a, n / 2, m);
        long ans = ((p % m) * (p % m)) % m;

        if (n % 2 != 0) {
            ans = ((ans % m) * (a % m)) % m;
        }
        if (ans < 0) {
            ans = ans + m;
        }

        return (int) ans;
    }

    // TC: (n logM)
    // SC: O(n)
    // Using Fermat's Theorem
    // x^(-1) % m = x^(m-2) % m
    public int[] populateInverseFactorial(int n, int m, int[] fact) {
        int[] invFact = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            invFact[i] = power(fact[i], m - 2, m);
        }
        return invFact;
    }
}
