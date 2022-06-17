/**
 * Rotated Sorted Array Search
 * single pass of binary search O(log n)
 */
 const search = (A, B) => {

    let start = 0;
    let end = A.length - 1;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (A[mid] === B) {
            return mid;
        } else if (A[mid] > A[0]) {
            // mid is on left part of rotation point
            if (B >= A[0] && B < A[mid]) {
                // move left if target is within the range 0 to mid-1
                end = mid - 1;
            } else {
                // otherwise move right
                start = mid + 1;
            }
        } else {
            // mid is on right part of rotation point
            if (B > A[mid] && B <= A[A.length - 1]) {
                // move right if target is within the range mid+1 to n-1
                start = mid + 1;
            } else {
                // otherwise move left
                end = mid - 1;
            }
        }
    }
    return -1;
}

console.log(search([24, 25, 34, 45, 46, 10, 15, 17], 15));
console.log(search([1, 2, 3], 2));
console.log(search([4, 5, 6, 7, 0, 1, 2, 3], 4));