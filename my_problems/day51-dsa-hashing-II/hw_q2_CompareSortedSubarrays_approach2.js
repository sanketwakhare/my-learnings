/* Compare Sorted Subarray */
/* 
Problem Description

Given an array A of length N. You have to answer Q queries.

Each query will contain 4 integers l1, r1, l2 and r2. If sorted segment from [l1, r1] is same as sorted segment from [l2 r2] then answer is 1 else 0.

NOTE The queries are 0-indexed.

Problem Constraints
0 <= A[i] <= 100000
1 <= N <= 100000
1 <= Q <= 100000

Input Format
First argument is an array A.
Second will be 2-D array B denoting queries with dimension Q * 4.
Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].

Output Format
Return an array of length Q with answer of the queries in the same order in input.

Example Input
Input 1:
 A = [1, 7, 11, 8, 11, 7, 1]
 B = [ 
       [0, 2, 4, 6]
     ]
Input 2:
 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ] 

Example Output
Output 1:
 [1]
Output 2:
 [0]

Example Explanation
Explanation 1:
 (0, 2) -> [1, 7, 11]
 (4, 6) -> [11, 7, 1]
 Both are same when sorted hence 1.
Explanation 2:
 (0, 1) -> [1, 3]
 (1, 2) -> [3, 2] 
 Both are different when sorted hence -1.
 */

const compareSortedSubarray_approach2 = (A, B) => {

    // Idea: for each query, maintain a hashMap
    // insert elements n hashMap with frequencies for l1 to r1
    // and remove elements from hashMap for l2 to r2
    // if hashMap is empty then elements are matching -> return 1
    // otherwise return 0

    let output = [];

    for (let i = 0; i < B.length; i++) {

        const l1 = B[i][0];
        const r1 = B[i][1];
        const l2 = B[i][2];
        const r2 = B[i][3];

        const hashMap = new Map();

        const size1 = r1 - l1 + 1;
        const size2 = r2 - l2 + 1;
        if (size1 !== size2) {
            output.push(0);
            continue;
        }

        // for l1 to r2, insert into hashMap
        for (let j = 0; j < size1; j++) {
            // insert elements in hashMap and update frequencies
            if (hashMap.has(A[l1 + j])) {
                hashMap.set(A[l1 + j], hashMap.get(A[l1 + j]) + 1);
            } else {
                hashMap.set(A[l1 + j], 1);
            }

            if (hashMap.has(A[l2 + j])) {
                hashMap.set(A[l2 + j], hashMap.get(A[l2 + j]) - 1);
            } else {
                hashMap.set(A[l2 + j], -1);
            }
        }

        for (let [key, value] of hashMap.entries()) {
            if (value === 0) {
                hashMap.delete(key);
            }
        }

        if (hashMap.size === 0) {
            output.push(1);
        } else {
            output.push(0);
        }
    }
    console.log(output);
    return output;

}

let A = [1, 7, 11, 8, 11, 7, 1]
let B = [
    [0, 2, 4, 6]
];
compareSortedSubarray_approach2(A, B); // expected output [1]

A = [1, 3, 2]
B = [
    [0, 1, 1, 2]
]
compareSortedSubarray_approach2(A, B); // expected output [0]

A = [0, 100000]
B = [
    [0, 0, 0, 0],
    [1, 1, 1, 1],
    [0, 1, 0, 1]
];
compareSortedSubarray_approach2(A, B); // expected output [1,1,1]

A = [100000, 100000, 100000, 100000, 100000];
B = [
    [0, 3, 1, 4],
    [0, 1, 2, 3],
    [4, 4, 1, 1],
    [1, 3, 0, 0],
    [2, 4, 1, 1]
];
compareSortedSubarray_approach2(A, B); // expected output [1, 1, 1, 0, 0 ]