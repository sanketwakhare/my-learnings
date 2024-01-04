/* Sudoku */

/* Sudoku solver */

/* Problem Description

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.

A sudoku puzzle,

and its solution numbers marked in red.


Problem Constraints

N = 9


Input Format

First argument is an array of array of characters representing the Sudoku puzzle.


Output Format

Modify the given input to the required answer.


Example Input

Input 1:

A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]


Example Output

Output 1:

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]


Example Explanation

Explanation 1:

Look at the diagrams given in the question. */

/**
 * T(N) = T(N-1) * N*N + 1
 * TC: O(9^(NxN)):
 * SC: O(NxN): depth of recursion tree will be NxN
 */
public class q3_Sudoku {

    char[][] answer;

    public void solveSudoku(char[][] A) {

        answer = new char[9][9];
        sudokuRecursive(0, A);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                A[i][j] = answer[i][j];
            }
        }
        ArrayUtils.print2DArray(A);
    }

    private void sudokuRecursive(int index, char[][] mat) {

        // base condition when we completely solve the sudoku
        // mat.length * mat[0].length ~~ 81
        if (index == mat.length * mat[0].length) {
            // create clone of the solved sudoku
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    answer[i][j] = mat[i][j];
                }
            }
            return;
        }

        // calculate row and column index
        int r = index / 9;
        int c = index % 9;

        // if already placed
        if (mat[r][c] != '.') {
            sudokuRecursive(index + 1, mat);
            return;
        }

        // each position has 9 possibilities
        for (char k = '1'; k <= '9'; k++) {
            if (checkIfkCanBePlaced(r, c, k, mat)) {
                // place char k
                mat[r][c] = k;
                sudokuRecursive(index + 1, mat);
                // revert and check for next available characters
                mat[r][c] = '.';
            }
        }

    }

    private boolean checkIfkCanBePlaced(int r, int c, char k, char[][] mat) {

        // check if character k is present in current row and current column
        for (int i = 0; i < 9; i++) {
            if (mat[r][i] == k) {
                return false;
            }
            if (mat[i][c] == k) {
                return false;
            }
        }

        // check if character k is present in current cube
        int cubeRowStartIndex = r - r % 3;
        int cubeColumnStartIndex = c - c % 3;
        for (int i = cubeRowStartIndex; i < cubeRowStartIndex + 3; i++) {
            for (int j = cubeColumnStartIndex; j < cubeColumnStartIndex + 3; j++) {
                if (mat[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // test case 1
        q3_Sudoku t1 = new q3_Sudoku();
        char[][] A = new char[][] {
                "534.7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };
        t1.solveSudoku(A);
        /*
         * Expected answer:
         * [[5, 3, 4, 6, 7, 8, 9, 1, 2],
         * [6, 7, 2, 1, 9, 5, 3, 4, 8],
         * [1, 9, 8, 3, 4, 2, 5, 6, 7],
         * [8, 5, 9, 7, 6, 1, 4, 2, 3],
         * [4, 2, 6, 8, 5, 3, 7, 9, 1],
         * [7, 1, 3, 9, 2, 4, 8, 5, 6],
         * [9, 6, 1, 5, 3, 7, 2, 8, 4],
         * [2, 8, 7, 4, 1, 9, 6, 3, 5],
         * [3, 4, 5, 2, 8, 6, 1, 7, 9]]
         */

        // test case 1
        A = new char[][] {
                "...26.7.1".toCharArray(),
                "68..7..9.".toCharArray(),
                "19...45..".toCharArray(),
                "82.1...4.".toCharArray(),
                "..46.29..".toCharArray(),
                ".5...3.28".toCharArray(),
                "..93...74".toCharArray(),
                ".4..5..36".toCharArray(),
                "7.3.18...".toCharArray()
        };
        t1.solveSudoku(A);
        /*
         * Expected answer:
         * [[4, 3, 5, 2, 6, 9, 7, 8, 1],
         * [6, 8, 2, 5, 7, 1, 4, 9, 3],
         * [1, 9, 7, 8, 3, 4, 5, 6, 2],
         * [8, 2, 6, 1, 9, 5, 3, 4, 7],
         * [3, 7, 4, 6, 8, 2, 9, 1, 5],
         * [9, 5, 1, 7, 4, 3, 6, 2, 8],
         * [5, 1, 9, 3, 2, 6, 8, 7, 4],
         * [2, 4, 8, 9, 5, 7, 1, 3, 6],
         * [7, 6, 3, 4, 1, 8, 2, 5, 9]]
         */

        A = new char[][] {
                ".5.83.64.".toCharArray(),
                "..1.9..52".toCharArray(),
                "..9......".toCharArray(),
                "...3.4..8".toCharArray(),
                ".........".toCharArray(),
                "7..2...31".toCharArray(),
                "...6.84.5".toCharArray(),
                "82..4..1.".toCharArray(),
                "..6...9..".toCharArray()
        };
        t1.solveSudoku(A);
        /*
         * Expected answer:
         * [[2, 5, 7, 8, 3, 1, 6, 4, 9],
         *  [4, 3, 1, 7, 9, 6, 8, 5, 2],
         *  [6, 8, 9, 4, 5, 2, 1, 7, 3],
         *  [5, 1, 2, 3, 6, 4, 7, 9, 8],
         *  [3, 9, 8, 1, 7, 5, 2, 6, 4],
         *  [7, 6, 4, 2, 8, 9, 5, 3, 1],
         *  [9, 7, 3, 6, 1, 8, 4, 2, 5],
         *  [8, 2, 5, 9, 4, 7, 3, 1, 6],
         *  [1, 4, 6, 5, 2, 3, 9, 8, 7]]
         */

    }
}
