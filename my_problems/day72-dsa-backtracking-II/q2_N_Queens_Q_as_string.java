import java.util.ArrayList;
import java.util.List;

/* N Queens Problem */

/* Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.


Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints

1 <= A <= 10


Input Format

First argument is an integer n denoting the size of chessboard


Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.


Example Input

Input 1:

A = 4
Input 2:

A = 1

Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation

Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle: */

/**
 * Recursive relation: T(N) = [T(N-1) * (N-1)] + 1
 * TC: O(N!)
 * SC: O(N) - max depth of the recursion tree will be N
 */
public class q2_N_Queens_Q_as_string {

    private String[][] solveNQueens(int n) {

        // initialize required parameters for recursive function
        int[] cols = new int[n];
        int[] leftDiagonal = new int[(2 * n)];
        int[] rightDiagonal = new int[(2 * n)];
        int[][] matrix = new int[n][n];
        int index = 0;
        List<String[]> solutions = new ArrayList<String[]>();
        // call recursive function
        nQueens(index, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

        if (solutions.size() == 0) {
            return new String[0][0];
        }
        // convert list to array
        String[][] output = new String[solutions.size()][n];
        for (int i = 0; i < solutions.size(); i++) {
            String[] strArray = solutions.get(i);
            for (int j = 0; j < strArray.length; j++) {
                String row = strArray[j];
                output[i][j] = row;
            }
        }
        return output;
    }

    private void nQueens(int index, int[] cols, int[] leftDiagonal, int[] rightDiagonal, int[][] matrix, int n,
            List<String[]> solutions) {

        if (index == n) {
            // we have successfully placed the n queens
            String[] currentSolution = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        temp.append('Q');
                    } else {
                        temp.append('.');
                    }
                }
                currentSolution[i] = temp.toString();
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

        q2_N_Queens_Q_as_string t1 = new q2_N_Queens_Q_as_string();
        String[][] output = t1.solveNQueens(5);
        if (output.length != 0)
            ArrayUtils.print2DStringArray(output);
    }
}