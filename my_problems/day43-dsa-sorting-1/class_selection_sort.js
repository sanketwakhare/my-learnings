/**
 * Selection Sort:
 * Pick minimum and sort
 * 
 */

/**
 * Selection Sort
 * TC: O(N^2)
 * SC: O(1)
 * no of swaps: N-1
 * unstable sorting
 * in place sorting: no extra space
 * @param {Array} A array of integers
 */
const selectionSort = (A) => {

    for (let i = 0; i < A.length; i++) {
        // pick minimum value
        let min = Number.MAX_VALUE;
        let minInd = -1;
        for (let j = i; j < A.length; j++) {
            if (A[j] < min) {
                min = A[j];
                minInd = j;
            }
        }
        if (i !== minInd) {
            // swap A[i] and A[minInd]
            A[i] = A[i] ^ A[minInd];
            A[minInd] = A[i] ^ A[minInd];
            A[i] = A[i] ^ A[minInd];
        }
    }
    console.log(A);

}

selectionSort([2, 2, 6, 3, 1, 8, 3, 5, 4, 6]);