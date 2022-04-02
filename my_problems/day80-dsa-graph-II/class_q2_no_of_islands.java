public class class_q2_no_of_islands {

    // allowed directions - top, let, right and bottom
    // final static int[] rows = { -1, 0, 0, 1 };
    // final static int[] cols = { 0, -1, 1, 0 };

    // allowed directions - top, let, right and bottom and all 4 diagonals
    final static int[] rows = { -1, -1, -1, 0, 0, 1, 1, 1 };
    final static int[] cols = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public int solve(int[][] A) {
        return countIslands(A);
    }

    public void dfsTraversal(int i, int j, int n, int m, int[][] A) {
        if (i < 0 || j < 0 || i >= n || j >= m || A[i][j] == 0) {
            return;
        }
        if (A[i][j] == 1) {
            A[i][j] = 0;
            for (int k = 0; k < cols.length; k++) {
                dfsTraversal(i + rows[k], j + cols[k], n, m, A);
            }
        }
    }

    public int countIslands(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    count++;
                    dfsTraversal(i, j, n, m, A);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        class_q2_no_of_islands t1 = new class_q2_no_of_islands();
        int[][] A;

        A = new int[][] {
                { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 1, 1, 1, 0, 1 }
        };
        System.out.println(t1.solve(A)); // 2

        A = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 }
        };
        System.out.println(t1.solve(A)); // 2

        A = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        System.out.println(t1.solve(A)); // 5
    }

}
