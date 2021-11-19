/**
 * Distinct Numbers in Window
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

Input Format
First argument is an integer array A
Second argument is an integer B.

Output Format
Return an integer array.

Example Input
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:
 A = [1, 1, 2, 2]
 B = 1

Example Output
Output 1:
 [2, 3, 3, 2]
Output 2:
 [1, 1, 1, 1]

Example Explanation
Explanation 1:
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:
 Window size is 1, so the output array is [1, 1, 1, 1].
 */

/**
 * Sliding window and hashMap
 * TC: O(N)
 * SC: O(N)
 * @param {Array} A array
 * @param {Number} K window size
 */
const countDistinctElementsInWindow = (A, K) => {

    const N = A.length;
    let result = [];
    // maintain hashMap of <element, frequency> for the current window
    let hashMap = new Map();

    //  insert all elements from window 1
    for (let i = 0; i < K; i++) {
        if (hashMap.has(A[i])) {
            let currentFrequency = hashMap.get(A[i]);
            hashMap.set(A[i], currentFrequency + 1);
        } else {
            hashMap.set(A[i], 1);
        }
    }
    result.push(hashMap.size);
    console.log(hashMap);

    // for subsequent windows, remove i-1th element from hashMap and add last index element of window into the hashMap
    for (let i = 1; i <= N - K; i++) {

        // increase frequency of element/ add element
        const elementToAdd = A[i + K - 1];
        if (hashMap.has(elementToAdd)) {
            const currentFrequency = hashMap.get(elementToAdd);
            hashMap.set(elementToAdd, currentFrequency + 1);
        } else {
            // if element is not present in hashMap, add element with frequency count as 1
            hashMap.set(elementToAdd, 1);
        }

        // decrease frequency of element/ remove element
        const elementToRemove = A[i - 1];
        if (hashMap.has(elementToRemove)) {
            const currentFrequency = hashMap.get(elementToRemove);
            hashMap.set(elementToRemove, currentFrequency - 1);
            if (hashMap.get(elementToRemove) === 0) {
                hashMap.delete(elementToRemove);
            }
        }
        result.push(hashMap.size);
        console.log(hashMap);
    }

    console.log(result);


}

countDistinctElementsInWindow([1, 2, 1, 3, 4, 3], 3);
countDistinctElementsInWindow([1, 1, 2, 2], 1);
