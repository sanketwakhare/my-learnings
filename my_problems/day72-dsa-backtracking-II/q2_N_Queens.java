import java.util.ArrayList;
import java.util.List;

/* N Queens Problem */
public class q2_N_Queens {

    private int[][][] solve(int n) {

        int[] cols = new int[n];
        int[] leftDiagonal = new int[(2 * n)];
        int[] rightDiagonal = new int[(2 * n)];
        int[][] matrix = new int[n][n];
        int index = 0;
        List<int[][]> solutions = new ArrayList<int[][]>();
        nQueens(index, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

        if (solutions.size() == 0) {
            return new int[0][0][0];
        }
        // convert list to array
        int[][][] output = new int[solutions.size()][n][n];
        for (int i = 0; i < solutions.size(); i++) {
            int[][] solution = solutions.get(i);
            for (int j = 0; j < solution.length; j++) {
                int[] row = solution[j];
                for (int k = 0; k < row.length; k++) {
                    output[i][j][k] = row[k];
                }
            }
        }
        return output;
    }

    private void nQueens(int index, int[] cols, int[] leftDiagonal, int[] rightDiagonal, int[][] matrix, int n,
            List<int[][]> solutions) {

        if (index == n) {
            // we have successfully places n queens
            int[][] currentSolution = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    currentSolution[i][j] = matrix[i][j];
                }
            }

            solutions.add(currentSolution);
            return;
        }

        // each row has n possibilities to place queen
        for (int j = 0; j < cols.length; j++) {

            if (cols[j] == 1 || leftDiagonal[n + index - j] == 1 || rightDiagonal[index + j] == 1) {
                // we can no further place queens in current column, check for next available
                // column
                continue;
            }

            // mark the current column, leftDiagonal and rightDiagonal as visited
            cols[j] = 1;
            leftDiagonal[n + index - j] = 1;
            rightDiagonal[index + j] = 1;
            matrix[index][j] = 1;

            nQueens(index + 1, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

            // revert the states of current column, leftDiagonal and rightDiagonal
            cols[j] = 0;
            leftDiagonal[n + index - j] = 0;
            rightDiagonal[index + j] = 0;
            matrix[index][j] = 0;
        }
    }

    public static void main(String[] args) {

        // test case 1
        q2_N_Queens t1 = new q2_N_Queens();
        int[][][] output = t1.solve(4);
        System.out.println("total distinct solution: " + output.length);
        for (int i = 0; i < output.length; i++) {
            ArrayUtils.print2DArray(output[i]);
        }

        // test case 2
        t1 = new q2_N_Queens();
        output = t1.solve(5);
        System.out.println("total distinct solution: " + output.length);

        // test case 3
        t1 = new q2_N_Queens();
        output = t1.solve(1);
        System.out.println("total distinct solution: " + output.length);
        for (int i = 0; i < output.length; i++) {
            ArrayUtils.print2DArray(output[i]);
        }

        // test case 4
        t1 = new q2_N_Queens();
        output = t1.solve(2);
        System.out.println("total distinct solution: " + output.length);

        // test case 5
        t1 = new q2_N_Queens();
        output = t1.solve(3);
        System.out.println("total distinct solution: " + output.length);

        // test case 6
        t1 = new q2_N_Queens();
        output = t1.solve(10);
        System.out.println("total distinct solution: " + output.length);

    }

}