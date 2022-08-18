//param A : integer
//return a array of array of integers
const solveNQueens = function (A) {
    // create board
    let board = [];
    for (let i = 0; i < A; i++) {
        board.push(new Array(A).fill("."));
    }

    // initialize columns and diagonal arrays
    const n = A;
    let columns = new Array(n).fill(0);
    let leftDiag = new Array((2 * n) - 1).fill(0);
    let rightDiag = new Array((2 * n) - 1).fill(0);

    // call backtracking function
    let result = [];
    backtrack(board, n, 0, columns, leftDiag, rightDiag, result);
    console.log(result.length);
    return result;

    function backtrack(board, n, row, columns, leftDiag, rightDiag, result) {

        // base case
        if (row === n) {
            // insert at front
            result.unshift(Array.from(board.map(row => row.join("")).map(JSON.stringify), JSON.parse));
        }

        // each row has N possibilties for each column
        for (let col = 0; col < n; col++) {
            if (check(n, row, col, columns, leftDiag, rightDiag)) {

                // perform changes
                let leftDiagIndex = n - 1 - (col - row);
                let rightDiagIndex = row + col;
                board[row][col] = "Q";
                columns[col] = 1;
                leftDiag[leftDiagIndex] = 1;
                rightDiag[rightDiagIndex] = 1;

                backtrack(board, n, row + 1, columns, leftDiag, rightDiag, result);

                // revert changes
                board[row][col] = ".";
                columns[col] = 0;
                leftDiag[leftDiagIndex] = 0;
                rightDiag[rightDiagIndex] = 0;
            }
        }
    }

    /**
     * return true if Queen can be placed
     * return false otherwise
     * */
    function check(n, row, col, columns, leftDiag, rightDiag) {
        // check columns array
        if (columns[col] === 1) return false;
        // check left diagonal
        let leftDiagIndex = n - 1 - (col - row);
        if (leftDiag[leftDiagIndex] === 1) return false;
        // check right diagonal
        let rightDiagIndex = row + col;
        return rightDiag[rightDiagIndex] !== 1;
    }
}

console.log(solveNQueens(4));
console.log(solveNQueens(1));
console.log(solveNQueens(5));
console.log(solveNQueens(8));