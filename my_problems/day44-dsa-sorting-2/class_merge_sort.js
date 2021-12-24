/*****
 * Merge Sort
 * 
 * Idea: divide and conquer
 * Use recursive approach to merge back the the sorted arrays
 */

/**
 * Merge two sorted sub arrays
 * SC: O(r-l+1) => O(N)
 * @param {Array} A array of integers
 * @param {Number} l starting index of first subarray
 * @param {Number} m starting index of second subarray
 * @param {Number} r end index os second subarray
 */
const merge = (A, l, m, r) => {
    // p1 is associated with first sub array starting with l
    let p1 = l;
    // p2 is associated with second sub array starting with m
    let p2 = m;
    // p3 is associated with temp array
    let p3 = 0;
    let temp = new Array(r - l + 1).fill(0);

    // copy array elements tyo temp array
    while (p1 < m && p2 <= r) {
        if (A[p1] <= A[p2]) {
            temp[p3] = A[p1];
            p3++;
            p1++;
        } else {
            temp[p3] = A[p2];
            p3++;
            p2++;
        }
    }

    // copy remaining elements to temp array
    while (p1 < m) {
        temp[p3] = A[p1];
        p3++;
        p1++;
    }
    while (p2 <= r) {
        temp[p3] = A[p2];
        p3++;
        p2++;
    }

    // copy back sorted array into original array
    for (let i = 0; i < r - l + 1; i++) {
        A[i + l] = temp[i];
    }

}

/**
 * Merge sort recursive function to break the original array
 * @param {Array} A array of integers
 * @param {Number} l starting index of first subarray
 * @param {Number} r end index os second subarray
 * @returns 
 */
const mergeSort = (A, l, r) => {
    if (l === r) {
        return;
    }
    // find middle element
    let mid = l + Math.floor((r - l) / 2);
    // call recursive function l to mid
    mergeSort(A, l, mid);
    // call recursive function mid+1 to r
    mergeSort(A, mid + 1, r);

    // merge l to r subarray to original array
    merge(A, l, mid + 1, r);
}

/**
 * TC: O(N logN)
 * SC: O(N) - uses auxiliary space
 * Merge sort main function
 * @param {Array} A array of integers
 */
const mergeSortMain = (A) => {
    mergeSort(A, 0, A.length - 1);
    console.log(A);
}

mergeSortMain([3, 10, 6, 8, 15, 2, 12, 18, 1, 7]);
mergeSortMain([2, 2, 6, 3, 1, 8, 3, 5, 4, 6]);