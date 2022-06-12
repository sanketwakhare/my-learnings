/**
 * Matrix Search - zig zag traversal O(n+m)
 */

const searchMatrix = (A, B) => {
    // zig zag traversal - TC - O(n+m)

    let n = A.length;
    let m = A[0].length;

    //start from top right corner
    let row = 0;
    let col = m - 1;

    while (row < n && col >= 0) {
        if (A[row][col] === B) {
            return 1;
        } else if (A[row][col] < B) {
            // search next rows
            row++;
        } else {
            // search previous columns
            col--;
        }
    }
    return 0;
}

console.log(searchMatrix([[1]], 1));
console.log(searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3));
console.log(searchMatrix([[5, 17, 100, 111], [119, 120, 127, 131]], 3))