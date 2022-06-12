/**
 * Single Element in a Sorted Array
 */

const singleElementInSortedArray = (A) => {

    // binary search approach
    let n = A.length;

    // edge cases
    if (n === 1) return A[0];
    if (A[0] !== A[1]) return A[0];
    if (A[n - 1] !== A[n - 2]) return A[n - 1];

    let start = 1;
    let end = n - 2;
    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid - 1] !== A[mid] && A[mid + 1] !== A[mid]) {
            // unique element is found
            return A[mid];
        } else if (A[mid - 1] === A[mid]) {
            // move mid to first occurrence index of current duplicate element
            mid = mid - 1;
        }

        if (mid % 2 === 0) {
            // unique element is on right side of mid
            start = mid + 2;
        } else {
            // unique element is on left side of mid
            end = mid - 1;
        }
    }
    return -1;
}

console.log(singleElementInSortedArray([1, 1, 3, 3, 4, 4, 6, 6, 8, 8, 9, 10, 10]));
console.log(singleElementInSortedArray([11, 3, 3, 4, 4, 6, 6, 8, 8, 10, 10]));
console.log(singleElementInSortedArray([3, 3, 4, 4, 6, 6, 8, 8, 9, 9, 10]));
console.log(singleElementInSortedArray([3, 3, 5, 4, 4, 6, 6, 8, 8, 9, 9]));