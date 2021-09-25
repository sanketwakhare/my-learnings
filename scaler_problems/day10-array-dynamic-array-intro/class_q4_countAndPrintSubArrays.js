/**
 * Given an array A of size N, count total subArrays
 * counting all subArrays: time Complexity:  O(N^2)
 * printing all subArrays: time Complexity:  O(N^3)
 */
const countAndPrintSubArrays = (A) => {
    let count = 0;
    for (let i = 0; i < A.length; i++) {
        for (let j = i; j < A.length; j++) {
            count++;
            // print All subArrays
            console.log('subarray:')
            for (let k = i; k <= j; k++) {
                console.log(A[k]);
            }
        }
    }
    console.log('subarray count: ', count)
    return count;
}

// countAndPrintSubArrays([3, 5, 9, 4, 7, 2, 1]);
countAndPrintSubArrays([3, 5, 9, 4, 7]);