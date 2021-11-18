const convertInputToGrid = (A) => {
    let grid = [];

    for (let i = 0; i < A.length; i++) {
        const rowElements = A[i].split('');
        let row = [];
        for (let j = 0; j < rowElements.length; j++) {
            if (rowElements[j] === '.') {
                row.push(0);
            } else {
                row.push(Number(rowElements[j]));
            }
        }
        grid.push(row);
    }
    return grid;
}

const validateRows = (grid) => {
    // N represents no of rows
    const N = grid.length;
    // M represents no of columns
    const M = grid[0].length;
    // iterate each row and push elements in set and validte if there is any repeating element
    for (let i = 0; i < N; i++) {
        // maintan set
        let hashSet = new Set();
        for (let j = 0; j < M; j++) {
            const currentElement = grid[i][j];
            if (currentElement > 0 && currentElement < 10) {
                if (hashSet.has(currentElement)) {
                    // invalid sudoku
                    return false;
                } else {
                    hashSet.add(currentElement);
                }
            } else if (currentElement === 0) {
                // ignore that element as empty space
            } else {
                // invalid sudoku
                // if any other element is present apart from 1 to 9
                return false;
            }
        }
    }
    return true;
}

const validateColumns = (grid) => {
    // N represents no of rows
    const N = grid.length;
    // M represents no of columns
    const M = grid[0].length;
    // iterate each columns and push elements of each column in set to check uniquness
    for (let j = 0; j < M; j++) {
        // maintain set
        let hashSet = new Set();
        for (let i = 0; i < M; i++) {
            const currentElement = grid[i][j];
            if (currentElement > 0 && currentElement < 10) {
                if (hashSet.has(currentElement)) {
                    // invalid sudoku
                    return false;
                } else {
                    hashSet.add(currentElement);
                }
            } else if (currentElement === 0) {
                // ignore that element as empty space
            } else {
                // invalid sudoku
                // if any other element is present apart from 1 to 9
                return false;
            }
        }
    }
    return true;
}

const validateBoxes = (grid) => {
    // N represents no of rows
    const N = grid.length;
    // M represents no of columns
    const M = grid[0].length;

    for (let i = 0; i < N; i = i + 3) {
        for (let j = 0; j < M; j = j + 3) {
            let hashSet = new Set();
            for (let k = i; k < i + 3; k++) {
                for (let l = j; l < j + 3; l++) {
                    const currentElement = grid[k][l];
                    if (currentElement > 0 && currentElement < 10) {
                        if (hashSet.has(currentElement)) {
                            // invalid sudoku
                            return false;
                        } else {
                            hashSet.add(currentElement);
                        }
                    } else if (currentElement === 0) {
                        // ignore that element as empty space
                    } else {
                        // invalid sudoku
                        // if any other element is present apart from 1 to 9
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

//param A : array of strings
//return an integer
const isValidSudoku = function (A) {

    // build grid
    let grid = convertInputToGrid(A);

    // validate each row
    const areRowsValid = validateRows(grid);

    // validate each column
    const areColumnsValid = validateColumns(grid);

    // validate each box
    const areBoxesValid = validateBoxes(grid);

    if (areRowsValid && areColumnsValid && areBoxesValid) {
        return 1;
    }
    return 0;

}

console.log(isValidSudoku(["....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"]));
