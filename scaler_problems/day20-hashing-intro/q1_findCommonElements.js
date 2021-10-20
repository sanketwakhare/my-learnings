/********
 * Common Elements
Problem Description

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

const findCommonElements = (A, B) => {

    let output = [];
    // iterate over A and put all the elements in hashmap with frequency
    let hashMap = new Map();
    for (let i = 0; i < A.length; i++) {
        if (hashMap.has(A[i])) {
            let currentFrequency = hashMap.get(A[i]);
            hashMap.set(A[i], currentFrequency + 1);
        } else {
            hashMap.set(A[i], 1);
        }
    }

    // iterate over B and if element is found put into result array and remove the frequency from hashmap by 1
    for (let i = 0; i < B.length; i++) {
        if (hashMap.has(B[i])) {
            output.push(B[i]);
            let currentFrequency = hashMap.get(B[i]);
            if (currentFrequency === 1) {
                hashMap.delete(B[i]);
            } else {
                hashMap.set(B[i], currentFrequency - 1);
            }
        }
    }

    return output;

}

findCommonElements([1, 2, 2, 1], [2, 3, 1, 2]);