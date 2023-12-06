/*
Find nth value of this equation F(n) = F(n-1) + 3 F(n-2) + 2 F(n-3) given F(0) = 1, F(1) = 2 F(2) = 3
 */
public class class_q4_equation_to_matrix_example {
    public static void main(String[] args) {
        class_q4_equation_to_matrix_example t = new class_q4_equation_to_matrix_example();
        {
            System.out.println(t.solve(10));
            System.out.println(t.solve(9));
            System.out.println(t.solve(8));
            System.out.println(t.solve(7));
            System.out.println(t.solve(6));
            System.out.println(t.solve(5));
            System.out.println(t.solve(4));
            System.out.println(t.solve(3));
            System.out.println(t.solve(2));
            System.out.println(t.solve(1));
            System.out.println(t.solve(0));
        }
    }

    public int solve(int n) {
        /*
        F(n) = F(n-1) + 3 F(n-2) + 2 F(n-3)

        [Fn         [ [1 3 2]           [Fn-1
        Fn-1    =    [1 0 0]    *       Fn-2
        Fn-2]        [0 1 0] ]          Fn-3]

        Mn = x * Mn-1

        Mn = x * x * Mn-2 = x^2 * Mn-2
        Mn = x^k * Mn-k

        we know F(0) = 1, F(1) = 2 F(2) = 3
        M2 = [[F(2)], [F(1)], [F(0)]] = [{3}, {2}, {1}]

        n - k = 2
        k = n - 2

        Mn = x^(n-2) * M2

        [{F(n)}, {F(n-1)}, {F(n-2}] = x^(n-2) *  [{3}, {2}, {1}]
        [{F(n)}, {F(n-1)}, {F(n-2}] = [{1,3,2}, {1,0,0}, {0,1,0}]^(n-2) *  [{3}, {2}, {1}]

        this ways we can find the value of F(n) using F(0), F(1) ,F(2) amd matrix exponentiation
         */
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 3;
        if (n < 2) {
            return 0;
        }

        int[][] x = {{1, 3, 2}, {1, 0, 0}, {0, 1, 0}};
        int[][] temp = powerMatrix(x, n - 2);
        int[][] m1 = new int[][]{{3}, {2}, {1}};
        int[][] m2 = multiply(temp, m1);

        return m2[0][0];
    }

    // TC: O(log n) where n is power; 2nd parameter here + O(N*M) considering matrix multiplication
    public int[][] powerMatrix(int[][] A, int n) {

        if (n == 0) return multiply(A, getIdentityMat(A.length));
        if (n == 1) return multiply(A, getIdentityMat(A.length));

        int[][] currRes = powerMatrix(A, n / 2);

        int[][] x = multiply(currRes, currRes);
        if ((n & 1) == 0) {
            return x;
        }
        return multiply(x, A);
    }

    // TC: O(n * m)
    // SC: O(n * m)
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int p = A[0].length;
        int m = B[0].length;

        // can not multiply
        if (A[0].length != B.length) return null;

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }

    public int[][] getIdentityMat(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) res[i][j] = 1;
            }
        }
        return res;
    }

}
