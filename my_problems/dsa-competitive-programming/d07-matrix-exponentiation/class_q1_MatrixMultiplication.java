import java.util.Arrays;

/*
Matrix Multiplication
 */
public class class_q1_MatrixMultiplication {
    public static void main(String[] args) {
        class_q1_MatrixMultiplication t = new class_q1_MatrixMultiplication();
        {
            int[][] A = {{1, 2}, {3, 4}};
            int[][] B = {{2, 1}, {5, 3}};
            System.out.println(Arrays.deepToString(t.solve(A, B)));
        }
        {
            int[][] A = {{1, 2}, {3, 4}};
            int[][] B = {{1, 0}, {0, 1}};
            System.out.println(Arrays.deepToString(t.solve(A, B)));
        }
    }

    // TC: O(n * m)
    // SC: O(n * m)
    public int[][] solve(int[][] A, int[][] B) {
        int n = A.length;
        int p = A[0].length;
        int m = B[0].length;

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
}
