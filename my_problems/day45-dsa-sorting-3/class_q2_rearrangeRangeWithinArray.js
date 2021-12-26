/**
 * Given an array of N elements, rearrange the range [l,r] within array such that
 * A[l] should go to its sorted position.
 * All the elements smaller than A[l] should go to its left and
 * all the elements greater than A[l] should go to its right
 */

/********
 * TC: O(Q *N)
 * SC: O(1)
 * /

/**
 * Rearrange range [l,r] within array
 * @param {Array} A array of integers
 * @param {*} l start index of range
 * @param {*} r end index of range
 */
const rearrangeRange = (A, l, r) => {

    const pivot = A[l];

    // initialize pointers p1 and p2
    let p1 = l + 1;
    let p2 = r;

    // while p1 and p2 does not cross
    while (p1 < p2) {

        // swap A[p1] and A[p2] if below condition is met
        if (A[p1] >= pivot && A[p2] < pivot) {
            // swap A[p1] and A[p2]
            A[p1] = A[p1] ^ A[p2];
            A[p2] = A[p1] ^ A[p2];
            A[p1] = A[p1] ^ A[p2];
        }
        if (A[p1] <= pivot) {
            // increase p1 if A[p1] is less than pivot
            p1++;
        } else if (A[p2] > pivot) {
            // decrease p2 if A[p2] is greater than pivot
            p2--;
        }
    }

    // swap pivot element and A[p1-1]
    // do not swap if p1-1 === start index of range
    if (l !== p1 - 1) {
        A[l] = A[l] ^ A[p1 - 1];
        A[p1 - 1] = A[l] ^ A[p1 - 1];
        A[l] = A[l] ^ A[p1 - 1];
    }

    console.log('rearranged array after range [', l, ',', r, ']-> ', A);

    // return sorted position: this would be used for quick sort
    return p1 - 1;
}

/**
 * rearrange range within array
 * @param {Array} A array of integers
 * @param {Array} Q 2d array with q queries
 */
const rearrangeRangeWithinArray = (A, Q) => {

    console.log('original array -> ', A);

    const totalRanges = Q.length;
    for (let i = 0; i < totalRanges; i++) {
        const l = Q[i][0];
        const r = Q[i][1];
        rearrangeRange(A, l, r);
    }
    console.log('array after rearranging -> ', A);
}

rearrangeRangeWithinArray([10, 3, 8, 15, 6, 12, 2, 18, 7, 1], [
    [2, 6],
    [5, 8],
    [0, 9]
]);