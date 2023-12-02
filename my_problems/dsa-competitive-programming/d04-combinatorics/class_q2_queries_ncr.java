/*
Given Q queries, [n and r], for each query, you need to find sum of (number of ways to select r from n and number of ways to select r/2 from n/2
 */
public class class_q2_queries_ncr {
    public static void main(String[] args) {
        int m = 1000000007;
        class_q2_queries_ncr t = new class_q2_queries_ncr();
        {
            int n = 10;
            int r = 3;
            int ans = t.ncr(n, r, m) + t.ncr(n / 2, r / 2, m);
            System.out.println(ans);
        }
        {
            int n = 20;
            int r = 5;
            int ans = t.ncr(n, r, m) + t.ncr(n / 2, r / 2, m);
            System.out.println(ans);
        }
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
