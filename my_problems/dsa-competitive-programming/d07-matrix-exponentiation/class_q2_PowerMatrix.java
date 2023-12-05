import java.util.Arrays;

/*
Find value of A^n for the matrix A
 */
public class class_q2_PowerMatrix {
    public static void main(String[] args) {
        class_q2_PowerMatrix t = new class_q2_PowerMatrix();
        {
            int[][] A = {{1, 2}, {3, 4}};
            int n = 10;
            System.out.println(Arrays.deepToString(t.solve(A, n))); // [[4783807, 6972050], [10458075, 15241882]]
        }
        {
            int[][] A = {{1, 2, 3}, {3, 4, 2}, {1, 1, 2}};
            int n = 5;
            System.out.println(Arrays.deepToString(t.solve(A, n))); // [[2557, 3502, 3329], [4513, 6182, 5870], [1603, 2195, 2088]]
        }
    }

    // TC: O(log n) where n is power; 2nd parameter here + O(N*M) considering matrix multiplication
    public int[][] solve(int[][] A, int n) {

        if (n == 0) return multiply(A, getIdentityMat(A.length));
        if (n == 1) return multiply(A, getIdentityMat(A.length));

        int[][] currRes = solve(A, n / 2);

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
