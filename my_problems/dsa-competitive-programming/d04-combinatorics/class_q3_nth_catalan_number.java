/*
No of valid parenthesis sequences of length 2N = Nth catalan number
Nth catalan number = [1 / (n+1)] * (2n C n)

Given N x N matrix, find number of ways to reach from top-left cell to bottom-right cell,
Conditions:
1. only Down and Right movement is allowed from a cell
2. the movement ca either be carried out in upeer part of the main diagonal or lower part of the main diagonal
3. if movement happens in lower part of main diagonal, at any point in time, the Right moves can not be > Down moves

Answer = Nth Catalan number = [1 / (n+1)] * (2n C n)
 */
public class class_q3_nth_catalan_number {
    public static void main(String[] args) {
        int m = 1000000007;
        class_q3_nth_catalan_number t = new class_q3_nth_catalan_number();
        {
            int n = 4;
            int answer = t.nthCatalan(n, m);
            System.out.println(answer);
        }
        {
            int n = 1;
            int answer = t.nthCatalan(n, m);
            System.out.println(answer); // 1 [DR]
        }
        {
            int n = 2;
            int answer = t.nthCatalan(n, m);
            System.out.println(answer); // 2 [DDRR and DRDR]
        }
    }

    public int nthCatalan(int n, int m) {
        int x = ncr(2 * n, n, m);
        int y = power(n + 1, m - 2, m);
        int answer = (int) ((((long) x % m) * ((long) y % m)) % m);
        if (answer < 0) {
            answer = (int) (((long) answer + m) % m);
        }
        return answer;
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
