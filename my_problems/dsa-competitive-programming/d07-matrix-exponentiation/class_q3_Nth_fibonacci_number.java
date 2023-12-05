/*
Given F[0] = 0 and F[1] = 1, Find Nth fibonacci number using matrix exponentiation method in logN time
 */
public class class_q3_Nth_fibonacci_number {
    public static void main(String[] args) {
        class_q3_Nth_fibonacci_number t = new class_q3_Nth_fibonacci_number();
        {
            System.out.println(t.solve(20)); // 6765
            System.out.println(t.solve(2)); // 1
            System.out.println(t.solve(6)); // 8
            System.out.println(t.solve(10)); // 55
            System.out.println(t.solve(8)); // 21
        }
    }

    /*

    Converting Linear recursive relation to matrix exponential equation.

     F[n] = F[n-1] + F[n-2]

     2d matrix multiplication
     [F[n]  ]  =  [1 1]  *   [F[n-1]]
     [F[n-1]]     [1 0]      [F[n-2]]

     [F[2]] = x * [F[1]]
     [F[1]] =     [F[0]]

     x = {{1, 1}, {1, 0}}

     m1 = [F[1], F[0]] = [1, 0]
     m2 = [F[2], F[1]] = [2, 1]

     m2 = x * m1
     m3 = x * m2 = x * x * m1 = x^2 * m1
     m3 = x^2 * m1
     m4 = x * m3 = x^3 * m1
     m4 = x^3 * m1
     m^n = x^(n-1) * m1

     m^n = {{1, 1}, {1, 0}} ^ (n-1) * m1

     [F[n], F[n-1]] = {{1, 1}, {1, 0}} ^ (n-1) * [F[1], F[0]]
     [F[n], F[n-1]] = {{1, 1}, {1, 0}} ^ (n-1) * [1, 0]
    */

    public int solve(int n) {
        int[][] x = {{1, 1}, {1, 0}};
        int[][] temp = powerMatrix(x, n - 1);
        int[][] m1 = new int[][]{{1}, {0}};
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
