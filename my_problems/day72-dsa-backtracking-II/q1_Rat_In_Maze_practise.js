/* Rat In a Maze */

//param A : array of array of integers
//return a array of array of integers
const ratInMaze = function (A) {
    // 0 - blocks
    // 1 - traversable cell
    // 2 - visited cell

    let n = A.length;
    backtrack(A, 0, 0, n);
    return A.map(row => row.map(cell => cell === 2 ? 1 : 0));

    function backtrack(A, i, j, n) {
        if (i === n - 1 && j === n - 1) {
            // reached destination
            A[i][j] = 2;
            return true;
        }

        // invalid cell
        if (i >= n || j >= n || A[i][j] === 0 || A[i][j] === 2) return false;

        // mark visited
        A[i][j] = 2;
        if (backtrack(A, i + 1, j, n) || backtrack(A, i, j + 1, n)) {
            return true;
        }
        // mark unvisited
        A[i][j] = 1;
        return false;
    }
}

console.log(ratInMaze([[1, 1, 1], [1, 0, 1], [0, 0, 1]]));
console.log(ratInMaze([[1, 0], [1, 1]]));
console.log(ratInMaze([[1, 1, 0, 1], [1, 1, 1, 0], [0, 0, 1, 1], [0, 0, 1, 1]]));
