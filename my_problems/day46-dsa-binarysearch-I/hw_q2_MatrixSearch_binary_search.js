/**
 * Matrix Search - binary search O(log(n*m))
 */

const searchMatrix = (A, B) => {
    // TC: O(log (n * m))

    let n = A.length;
    let m = A[0].length;

    // apply binary search on range
    let start = 1;
    let end = n * m;

    while (start <= end) {
        // find mid-cell
        let mid = start + Math.floor((end - start) / 2);

        // find row and col from cell number
        let row = Math.floor((mid - 1) / m);
        let col = (mid - 1) % m;

        // compare the target with mid-element
        if (A[row][col] === B) {
            return 1;
        } else if (A[row][col] > B) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return 0;
}

console.log(searchMatrix([[1]], 1));
console.log(searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3));
console.log(searchMatrix([[5, 17, 100, 111], [119, 120, 127, 131]], 3));
console.log(searchMatrix([[2, 9, 12, 13, 16, 18, 18, 19, 20, 22], [29, 59, 62, 66, 71, 75, 77, 79, 97, 99]], 45));
console.log(searchMatrix([[2, 9, 12, 13, 16, 18, 18, 19, 20, 22], [29, 59, 62, 66, 71, 75, 77, 79, 97, 99]], 59));


