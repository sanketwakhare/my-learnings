import java.util.Arrays;

/*
    If F(n) and G(n) are related
    given equations
     F(n) = 4 F(n-1) + 2 G(n-1)
     G(n) = 3 G(n-1) + 2^(n-1)

    Find nth term as [F(n), G(n), 2^n]

    [[F(n)], [G(n)], [2^n]] = T * [[F(n-1)], [G(n-1)], [2^(n-1)]]

    [[F(n)], [G(n)], [2^n]] = [[4,2,0], [0,3,1], [0,0,2]] * [[F(n-1)], [G(n-1)], [2^(n-1)]]

    Mn = T^n-1 * M1

 */
public class class_q6_rel_between_different_funs {

    public static void main(String[] args) {
        class_q6_rel_between_different_funs t = new class_q6_rel_between_different_funs();
        {
            System.out.println(Arrays.toString(t.solve(1, 2, 3)));
            System.out.println(Arrays.toString(t.solve(2, 2, 3)));
            System.out.println(Arrays.toString(t.solve(3, 2, 3)));
            System.out.println(Arrays.toString(t.solve(5, 2, 3)));
            System.out.println(Arrays.toString(t.solve(10, 2, 3)));
        }
    }

    long mod = 1000000007;

    public long[] solve(int n, int f1, int g1) {

        if (n == 1) return new long[]{f1, g1, 2};
        if (n < 1) return new long[]{-1, -1, -1};

        long[][] x = {{4, 2, 0}, {0, 3, 1}, {0, 0, 2}};
        long[][] temp = powerMatrix(x, n - 1);
        long[][] m1 = {{f1}, {g1}, {2}};
        long[][] mn = multiply(temp, m1);

        return new long[]{mn[0][0], mn[1][0], mn[2][0]};
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
                    long tmp = (((A[i][k] % mod) * (B[k][j] % mod)) % mod);
                    res[i][j] += (tmp + mod) % mod;
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
