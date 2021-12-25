/*****
 * Insertion Sort
 * 
 * Idea: make sure the array is sorted at every step
 * e.g.array cards while they are being inserted
 */

/**
 * TC: O(N^2)
 * SC: O(1)
 * no of swap : N
 * Stable sort
 * In place sorting: no extra space
 * @param {Array} A array of integers
 */
const insertionSort = (A) => {

    for (let i = 1; i < A.length; i++) {

        let j = i;
        while (A[j] < A[j - 1] && j >= 1) {
            // swap A[j] and A[j-1]
            A[j] = A[j] ^ A[j - 1];
            A[j - 1] = A[j] ^ A[j - 1];
            A[j] = A[j] ^ A[j - 1];
            j--;
        }
    }
    console.log(A);
}

insertionSort([2, 2, 6, 3, 1, 8, 3, 5, 4, 6]);