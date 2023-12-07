/*
Bits Please

Problem Description

Count the number of arrays X of length A with non-negative elements strictly less than 2B such that:

(X1 AND X2) OR (X2 AND X3) OR . . . . OR (XA-1 AND XA) = C

Since the answer can be very large, return it modulo D.



Problem Constraints

2 ≤ A ≤ 109
1 ≤ B ≤ 30
0 ≤ C < 2B
1 ≤ D ≤ 109


Input Format

The line of argument contains 4 integers A, B, C and D respectively.



Output Format

Return a single integer, the number of arrays modulo D.



Example Input

Input 1:

 A = 2
 B = 2
 C = 1
 D = 10
Input 2:

 A = 2
 B = 1
 C = 1
 D = 3


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanantion 1:

 The valid arrays are:
 [1, 1]
 [3, 1]
 [1, 3]
Explanantion 2:

 The valid arrays are:
 [1, 1]
 */
public class q3_BitsPlease {
    public static void main(String[] args) {
        q3_BitsPlease t = new q3_BitsPlease();
        {
            int A = 2;
            int B = 2;
            int C = 1;
            int D = 10;
            System.out.println(t.solve(A, B, C, D));
        }
        {
            int A = 4;
            int B = 3;
            int C = 7;
            int D = 3;
            System.out.println(t.solve(A, B, C, D));
        }
        {
            int A = 2;
            int B = 1;
            int C = 1;
            int D = 3;
            System.out.println(t.solve(A, B, C, D));
        }
    }

    // F(1) = 2
    // F(2) = 3
    int mod = 0;

    public int solve(int A, int B, int C, int D) {
        mod = D;
        // find ((2^A) % D)
        int total = power(2, A, D);
        // find Ath fib term F(A) = F(A-1) + F(A-2)
        // find F(A) % D
        // F(1) = 2
        // F(2) = 3
        int f_a = nthFib(A, 2, 3);

        long ans = 1;
        // System.out.println(total + " " + f_a);
        for (int i = 0; i < B; i++) {
            if ((C & (1 << i)) > 0) {
                // ith bit is set
                ans = ((ans % D) * ((total - f_a + D) % D)) % D;
            } else {
                // ith bit is unset
                ans = ((ans % D) * (f_a % D)) % D;
            }
        }

        return (int) ans % D;
    }

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

    public int nthFib(int n, int f1, int f2) {
        long[][] x = {{1, 1}, {1, 0}};
        long[][] temp = powerMatrix(x, n - 2);
        long[][] m1 = new long[][]{{f2}, {f1}};
        long[][] m2 = multiply(temp, m1);

        return (int) m2[0][0];
    }

    // TC: O(log n) where n is power; 2nd parameter here + O(N*M) considering matrix multiplication
    public long[][] powerMatrix(long[][] A, int n) {

        if (n == 0) return multiply(A, getIdentityMat(A.length));
        if (n == 1) return multiply(A, getIdentityMat(A.length));

        long[][] currRes = powerMatrix(A, n / 2);

        long[][] x = multiply(currRes, currRes);
        if ((n & 1) == 0) {
            return x;
        }
        return multiply(x, A);
    }

    // TC: O(n * m)
    // SC: O(n * m)
    public long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        int p = A[0].length;
        int m = B[0].length;

        // can not multiply
        if (A[0].length != B.length) return null;

        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    long tmp = ((A[i][k] * B[k][j])) % mod;
                    res[i][j] += (tmp);
                    res[i][j] = res[i][j] % mod;
                }
            }
        }
        return res;
    }

    public long[][] getIdentityMat(int n) {
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) res[i][j] = 1;
            }
        }
        return res;
    }

}
