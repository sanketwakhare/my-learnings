/****
 * Pairs With Given Xor
Problem Description

Given an 1D integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
NOTE:
Pair (a, b) and (b, a) is considered to be same and should be counted once.

Problem Constraints
1 <= N <= 10^5
1 <= A[i], B <= 10^7

Input Format
First argument is an 1D integer array A.
Second argument is an integer B.

Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.

Example Input
Input 1:
 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:
 A = [3, 6, 8, 10, 15, 50]
 B = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 (10 ^ 15) = 5
Explanation 2:
 (3 ^ 6) = 5 and (10 ^ 15) = 5 
 */

const findPairWithGivenXOR = (A, K) => {

    const N = A.length;
    // store all elements in hashSet
    let hashSet = new Set();
    for (let i = 0; i < N; i++) {
        hashSet.add(A[i]);
    }

    let count = 0;
    // iterate over array and find out if xor is matching K
    for (let i = 0; i < N; i++) {
        let a = A[i];
        let b = a ^ K;
        if (a !== b) {
            if (hashSet.has(b)) {
                count++;
            }
        }
    }

    // observation is that the a and b pairs are repeating. So divide the final output by 2
    const ans = Math.floor(count / 2);
    console.log(ans);
    return ans;
}

findPairWithGivenXOR([5, 4, 10, 15, 7, 6], 5);
findPairWithGivenXOR([3, 6, 8, 10, 15, 50], 5);
findPairWithGivenXOR([17, 18, 5, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3], 9);
findPairWithGivenXOR([24, 27, 1, 4, 6, 14, 2, 12, 13, 0, 5, 15, 3, 7, 15, 10], 9);