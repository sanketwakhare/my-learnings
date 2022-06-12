/* Sorted Insert Position */
const searchInsert = (A, B) => {

    let start = 0;
    let end = A.length - 1;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === B) {
            return mid;
        } else if (A[mid] > B) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    // start will point to index where element can be inserted
    return start;
}

console.log(searchInsert([1, 3, 5, 6], 2));
console.log(searchInsert([1, 3, 5, 6], 5));