/*****
 * Merge Two Sorted Arrays
 * 
 * Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

Problem Constraints
-10^10 <= A[i],B[i] <= 10^10

Input Format
First Argument is a 1-D array representing A.
Second Argument is also a 1-D array representing B.

Output Format
Return a 1-D vector which you got after merging A and B.

Example Input
Input 1:
A = [4, 7, 9 ]
B = [2 ,11, 19 ]
Input 2:
A = [1]
B = [2]

Example Output
Output 1:
[2, 4, 7, 9, 11, 19]
Output 2:
[1, 2]

Example Explanation
Explanation 1:
Merging A and B produces the output as described above.
Explanation 2:
 Merging A and B produces the output as described above.
 */

//param A : array of integers
//param B : array of integers
//return a array of integers

/**
 * merge 2 sorted arrays
 * TC: O(N + M)
 * SC: O(N + M)
 * @param {Array} A array A
 * @param {Array} B array B
 * @returns 
 */
const merge = (A, B) => {

    // p1 associated with array A
    let p1 = 0;
    // p2 associated with array B
    let p2 = 0;
    // p3 associated with array C
    let p3 = 0;

    // initialize array C
    let C = new Array(A.length + B.length).fill(0);

    // compare A and B and push to array C
    while (p1 < A.length && p2 < B.length) {
        if (A[p1] <= B[p2]) {
            C[p3++] = A[p1++];
        } else {
            C[p3++] = B[p2++];
        }
    }

    // push remaining elements from array A or array B to array C
    while (p1 < A.length) {
        C[p3++] = A[p1++];
    }
    while (p2 < B.length) {
        C[p3++] = B[p2++];
    }
    console.log(C);
    return C;
}

merge([4, 7, 9], [2, 11, 19]);
merge([1], [2]);
merge([5], [2]);
merge([5, 7, 14, 19, 23], [2, 3, 8]);