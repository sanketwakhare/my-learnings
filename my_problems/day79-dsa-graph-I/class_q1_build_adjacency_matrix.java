public class class_q1_build_adjacency_matrix {

    public void buildAdjMatrix(int n, int[][] B) {

        int[][] mat = new int[n + 1][n + 1];

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            mat[u][v] = 1;
            mat[v][u] = 1;
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        class_q1_build_adjacency_matrix t1 = new class_q1_build_adjacency_matrix();
        // test case 1
        int n = 5;
        // undirected graph - the direction exist from both sides
        int[][] B = new int[][] { { 1, 4 },
                { 2, 1 }, { 4, 3 }, { 4, 5 }, { 2, 3 }, { 2, 4 }, { 1, 5 }, { 5, 3 },
                { 2, 5 }, { 5, 1 }, { 4, 2 }, { 3, 1 }, { 5, 4 }, { 3, 4 }, { 1, 3 }, { 4, 1 }, { 3, 5 }, { 3, 2 },
                { 5, 2 } };
        t1.buildAdjMatrix(n, B);
    }
}
