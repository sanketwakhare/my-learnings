/* Common Elements */

/*********
 * Problem Description

Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Problem Constraints
1 <= N, M <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer array denoting the common elements.

Example Input
Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]

Example Output

Output 1:
 [1, 2, 2]
Output 2:
 [2, 10]

Example Explanation
Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explanation 2:
 Elements (2, 10) appears in both the array.
 */

/**
 * find common elements
 * TC: O(N+M)
 * SC: O(N) where N > M
 * @param {Array} A array of integers
 * @param {Array} B array of integers
 * @returns {Array} output array of integers
 */
const commonElements = (A, B) => {

    let map = new Map();

    // populate map with array elements of A and its frequencies
    for (let i = 0; i < A.length; i++) {
        if (map.has(A[i])) {
            map.set(A[i], map.get(A[i]) + 1);
        } else {
            map.set(A[i], 1);
        }
    }

    let output = [];
    // compare each element from array B and check if frequency if > 0 in map
    // if frequency > 0 then the element is common
    // update the frequency once the element is counted
    for (let i = 0; i < B.length; i++) {
        if (map.has(B[i]) && map.get(B[i]) > 0) {
            output.push(B[i]);
            // decrease frequency oafter element is considered as common
            map.set(B[i], map.get(B[i]) - 1);
        }
    }
    console.log('common elements -> ', output);
    return output;
}

commonElements([1, 2, 2, 1], [2, 3, 1, 2]);
commonElements([2, 1, 4, 10], [3, 6, 2, 10, 10]);