/*****
 * Count Sort
 */

/***
 * Count sort
 * TC: O(N + K)
 * SC: O(K) to store the frequency array
 */
const countSort = (A) => {

    console.log(`input array`, A);
    let freq = new Array(10).fill(0);
    for (let i = 0; i < A.length; i++) {
        freq[A[i] - 1] = freq[A[i] - 1] + 1;
    }

    let p = 0;
    for (let i = 0; i < freq.length; i++) {
        while (freq[i] > 0) {
            // console.log(i + 1);
            A[p++] = i + 1;
            freq[i]--;
        }
    }

    console.log(`sorted array:`, A);
}

countSort([1, 2, 3, 9, 5, 3, 3, 2, 1, 10, 6, 5, 4, 5, 5, 6, 6, 10, 7, 8, 7, 6, 5, 4, 3, 4, 5, 10, 10, 6, 3, 2, 1, 9]);
countSort([4, 5, 7, 6, 5, 4, 7, 8, 6, 5, 2, 3, 1, 10, 5, 10, 1, 4, 3, 10, 9, 3, 9, 4, 8, 9, 2, 10]);