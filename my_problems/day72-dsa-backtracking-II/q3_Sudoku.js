const solveSudoku = function (A) {

    let board = A.map(row => row.split("").map(ele => ele === '.' ? 0 : Number(ele)));
    backtrack(board, 0);
    board = board.map(row => row.join(""));
    console.log(board);

    function backtrack(board, cellNumber) {

        if (cellNumber === 81) {
            return true;
        }

        const row = Math.floor(cellNumber / 9);
        const col = cellNumber % 9;
        if (board[row][col] !== 0) {
            return backtrack(board, cellNumber + 1);
        }
        for (let k = 1; k <= 9; k++) {
            if (check(board, row, col, k)) {
                board[row][col] = k;
                if (backtrack(board, cellNumber + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    function check(board, row, col, k) {
        // check row
        for (let j = 0; j < 9; j++) {
            if (board[row][j] === k) return false;
        }
        // check column
        for (let i = 0; i < 9; i++) {
            if (board[i][col] === k) return false;
        }
        // check submatrix/ box
        let startRow = row - (row % 3);
        let startCol = col - (col % 3);
        for (let i = startRow; i < startRow + 3; i++) {
            for (let j = startCol; j < startCol + 3; j++) {
                if (board[i][j] === k) return false;
            }
        }
        return true;
    }
}

solveSudoku([
    '53..7....', '6..195...',
    '.98....6.', '8...6...3',
    '4..8.3..1', '7...2...6',
    '.6....28.', '...419..5',
    '....8..79'
]);