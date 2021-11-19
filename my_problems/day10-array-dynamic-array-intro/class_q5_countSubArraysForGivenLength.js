/**
 * Given an array A of size N, count total subArrays of given length T
 * counting all subArrays: time Complexity:  O(N^2)
 * 
 * In general, count of subArrays of T length are
 * count = N-T+1
 */
const countSubArraysOfGivenLength = (A, T) => {
    let count = 0;
    for (let i = 0; i < A.length; i++) {
        for (let j = i; j < A.length; j++) {
            if (j - i + 1 === T) {
                count++;
            }
        }
    }
    console.log('subarray count of length', T, ': ', count)
    return count;
}

countSubArraysOfGivenLength([3, 5, 9, 4, 7, 2, 1], 2);
countSubArraysOfGivenLength([3, 5, 9, 4, 7], 1);
countSubArraysOfGivenLength([3, 5, 9, 4, 7], 2);