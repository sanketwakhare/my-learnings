/****
 * Valid Sudoku
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

/**
 * convert input to grid
 * @param {Array} A 
 * @returns grid 2d matrix
 */
const convertBoardToGrid = (A) => {
    let grid = [];
    for (let i = 0; i < A.length; i++) {
        const row = A[i].split('');
        let gridRow = [];
        for (let j = 0; j < row.length; j++) {
            if (row[j] === '.') {
                gridRow.push(0);
            } else {
                gridRow.push(Number(row[j]));
            }
        }
        grid.push(gridRow);
    }
    return grid;
}

/**
 * validate if row elements are distinct
 * @param {Array} grid 
 * @returns 
 */
const validateRows = (grid) => {
    for (let i = 0; i < grid.length; i++) {
        const row = grid[i];
        let hashSet = new Set();
        for (let j = 0; j < row.length; j++) {
            if (row[j] > 0 && row[j] <= 9) {
                if (!hashSet.has(row[j])) {
                    hashSet.add(row[j]);
                } else {
                    // invalid board
                    return false;
                }
            } else if (row[j] !== 0) {
                // invalid board
                return false;
            }
        }
    }
    return true;
}

/**
 * validate if column elements are distinct
 * @param {Array} grid 
 * @returns 
 */
const validateColumns = (grid) => {
    for (let j = 0; j < grid[0].length; j++) {
        let hashSet = new Set();
        for (let i = 0; i < grid.length; i++) {
            // iterate over columns
            const currentElement = grid[i][j];
            if (currentElement > 0 && currentElement <= 9) {
                if (!hashSet.has(currentElement)) {
                    hashSet.add(currentElement);
                } else {
                    // invalid board
                    return false;
                }
            } else if (currentElement !== 0) {
                // invalid board
                return false;
            }
        }
    }
    return true;
}

/**
 * validate if sub square elements are distinct
 * @param {Array} grid 
 * @returns 
 */
const validateSubSquares = (grid) => {
    const noOfRows = grid.length;
    const noOfCols = grid[0].length;
    for (let i = 0; i < noOfRows; i = i + 3) {
        for (let j = 0; j < noOfCols; j = j + 3) {
            // print sub-square
            let hashSet = new Set();
            for (let p = i; p < i + 3; p++) {
                for (let q = j; q < j + 3; q++) {
                    const currentElement = grid[p][q];
                    if (currentElement > 0 && currentElement <= 9) {
                        if (!hashSet.has(currentElement)) {
                            hashSet.add(currentElement);
                        } else {
                            // invalid board
                            return false;
                        }
                    } else if (currentElement !== 0) {
                        // invalid board
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

const isValidSudoku = (A) => {

    const grid = convertBoardToGrid(A);
    // console.log('validateRows: ', validateRows(grid));
    // console.log('validateColumns: ', validateColumns(grid));
    // console.log('validateSubSquares', validateSubSquares(grid));

    console.log(grid);
    if (validateRows(grid) && validateColumns(grid) && validateSubSquares(grid)) {
        console.log('valid sudoku board')
        return true;
    }
    console.log('inValid sudoku board');
    return false;

}

isValidSudoku(["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]);
isValidSudoku(["53987.65.", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]);