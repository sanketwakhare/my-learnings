/* Row to Column Zero */
public class hw_q5_rowToColumnZero {
    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        hw_q5_rowToColumnZero t = new hw_q5_rowToColumnZero();
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 0}, {9, 2, 0, 4}};
        t.solve(A);
        ArrayUtils.print2DArray(A);
    }
}
