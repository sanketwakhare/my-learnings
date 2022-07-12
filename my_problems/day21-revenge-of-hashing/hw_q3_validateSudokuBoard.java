import java.util.HashSet;
import java.util.Set;

public class hw_q3_validateSudokuBoard {

    public static void main(String[] args) {
        hw_q3_validateSudokuBoard t1 = new hw_q3_validateSudokuBoard();

        String[] A = new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        System.out.println(t1.isValidSudoku(A));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {

        int[][] grid = new int[9][9];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                if (A[i].charAt(j) == '.') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = A[i].charAt(j) - '0';
                }
            }
        }


        // check each row
        for (int[] row : grid) {
            Set<Integer> set = new HashSet<>();
            for (int cell : row) {
                if (cell != 0) {
                    if (set.contains(cell)) {
                        return 0;
                    }
                    set.add(cell);
                }
            }
        }

        // check each column
        for (int i = 0; i < grid.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] != 0) {
                    if (set.contains(grid[j][i])) {
                        return 0;
                    }
                    set.add(grid[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                Set<Integer> set = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (grid[row][col] != 0) {
                            if (set.contains(grid[row][col])) {
                                return 0;
                            }
                            set.add(grid[row][col]);
                        }
                    }
                }
            }
        }

        return 1;

    }
}

// cellCount = 0 -> 81

// cell = 4, 25, 39

// row = 4/9 = 0, 2, 4
// col = 4%9 = 4, 7, 3

// row = 2 -> row - row % 3 = 0, 3
// col = 7 -> col - col % 3 = 6, 3