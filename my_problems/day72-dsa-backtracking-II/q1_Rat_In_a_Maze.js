/* Rat In a Maze */

//param A : array of array of integers
//return a array of array of integers
const solve = (A) => {
    let currPath = getNewPathArray(A.length);
    let paths = [];
    traverse(0, 0, A, currPath, paths, A.length);
    console.log(paths);
}

const getNewPathArray = (n) => {
    let arr = [];
    for (let i = 0; i < n; i++) {
        arr.push(new Array(n).fill(0));
    }
    return arr;
}

/**
 * Recursive function
 * @param {Number} i row index
 * @param {*} j column index
 * @param {*} A input 2D matrix
 * @param {*} currPath 2D matrix current path
 * @param {*} paths can store all paths
 * @param {*} n size of matrix as nxn
 * @returns path of the traversal
 */
const traverse = (i, j, A, currPath, paths, n) => {

    // base conditions
    if (i == n - 1 && j == n - 1) {
        // last position
        currPath[i][j] = A[i][j];
        // let newPath = currPath.map(x => x);
        let newPath = JSON.parse(JSON.stringify(currPath));
        paths.push(newPath);
        currPath[i][j] = 0;
        return;
    }

    if (i < 0 || j < 0 || i >= n || j >= n || A[i][j] == 2 || A[i][j] == 0) {
        // can not move to current direction
        return;
    }

    // add element in current path
    currPath[i][j] = A[i][j];

    // mark as visited
    A[i][j] = 2;

    // move to next possible position
    // traverse(i - 1, j, A, currPath, path, n);
    traverse(i + 1, j, A, currPath, paths, n);
    // traverse(i, j-1, A, currPath, path, n);
    traverse(i, j + 1, A, currPath, paths, n);

    // redo/reset the states as we are backtracking
    A[i][j] = 1;
    currPath[i][j] = 0;
}

solve([
    [1, 0],
    [1, 1]
]);

solve([
    [1, 1, 1],
    [1, 0, 1],
    [0, 0, 1]
]);