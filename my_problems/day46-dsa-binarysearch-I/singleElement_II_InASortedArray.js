/**
 * Single Element II in a Sorted Array
 * every element repeats thrice except 1, find the unique element
 */

const singleElement_II_inSortedArray = (A) => {

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
        } else if (A[mid - 1] === A[mid] && A[mid + 1] === A[mid]) {
            // move mid to first occurrence index of current duplicate element
            mid = mid - 1;
        } else if (A[mid - 1] === A[mid] && A[mid + 1] !== A[mid]) {
            // move mid to first occurrence index of current duplicate element
            mid = mid - 2;
        }

        if (mid % 3 === 0) {
            // unique element is on right side of mid
            start = mid + 3;
        } else {
            // unique element is on left side of mid
            end = mid - 1;
        }
    }
    return -1;
}

console.log(singleElement_II_inSortedArray([1, 1, 1, 3, 3, 3, 4, 4, 4, 6, 6, 6, 8, 8, 8, 9, 10, 10, 10]));
console.log(singleElement_II_inSortedArray([11, 3, 3, 3, 4, 4, 4, 6, 6, 6, 8, 8, 8, 10, 10, 10]));
console.log(singleElement_II_inSortedArray([3, 3, 3, 4, 4, 4, 6, 6, 6, 8, 8, 8, 9, 9, 9, 10]));
console.log(singleElement_II_inSortedArray([3, 3, 3, 5, 4, 4, 4, 6, 6, 6, 8, 8, 8, 9, 9, 9]));