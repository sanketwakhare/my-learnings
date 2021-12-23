/*****
 * Bubble Sort
 * 
 * Swap adjacent elements if A[i] > A[i+1]
 * Idea is to push smallest element to the start
 */

/**
 * TC: O(N^2)
 * SC: O(1)
 * no of swap : N^2
 * Stable sort
 * In place sorting: no extra space
 * @param {Array} A array of integers
 */
const bubbleSort = (A) => {

    for (let i = 0; i < A.length; i++) {
        for (let j = i + 1; j < A.length; j++) {
            if (A[i] > A[j]) {
                // swap A[i] and A[j]
                A[i] = A[i] ^ A[j];
                A[j] = A[i] ^ A[j];
                A[i] = A[i] ^ A[j];
            }
        }
    }
    console.log(A);
}

bubbleSort([2, 2, 6, 3, 1, 8, 3, 5, 4, 6]);