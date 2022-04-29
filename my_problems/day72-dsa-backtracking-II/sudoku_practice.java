public class sudoku_practice {

    char[][] ans;

    public void solveSudoku(char[][] A) {

        ans = new char[A.length][A[0].length];
        sudokuRec(0, 0, A);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                A[i][j] = ans[i][j];
            }
        }
    }

    public void sudokuRec(int i, int j, char[][] A) {

        i = i + (j / 9);
        j = (j % 9);

        if (i == 9) {
            // base case
            System.out.println("done");
            for (int row = 0; row < A.length; row++) {
                for (int col = 0; col < A[0].length; col++) {
                    ans[row][col] = A[row][col];
                }
            }
            return;
        }

        if (A[i][j] != '.') {
            // already filled
            sudokuRec(i, j + 1, A);
        } else {

            for (char c = '1'; c <= '9'; c++) {
                if (isSafe(i, j, c, A)) {
                    A[i][j] = c;
                    sudokuRec(i, j + 1, A);
                    A[i][j] = '.';
                }
            }
        }
    }

    public boolean isSafe(int r, int c, char k, char[][] A) {

        for (int i = 0; i < 9; i++) {
            if (A[r][i] == k)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (A[i][c] == k)
                return false;
        }

        int row = r - r % 3;
        int col = c - c % 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (A[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        sudoku_practice t1 = new sudoku_practice();
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
    }
}
