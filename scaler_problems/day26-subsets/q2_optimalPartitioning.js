/*******
 * Problem Description

You are given an array A having N integers.
You have to divide / split the array into 2 subsequence partitions such that:

a) Both the partitions are non-empty.
b) Each integer A[i] in the array belongs to exactly one of the two partitions.
c) Absolute difference between the maximum of first partition and the minimum of second partition is minimum possible.
If B and C represent the two partitions, then size(B) >= 1, size(C) >= 1 and |max(B) - min(C)| is minimum possible. You have to find such a splitting and tell the minimum value of |max(B) - max(C)|.



Problem Constraints
2 <= N <= 105
-10^9 <= A[i] <= 10^9

Input Format
First and only argument is an integer array A.

Output Format
Return a single integer denoting the absolute difference.

Example Input
Input 1:
 A = [3, 1, 2, 6, 4]
Input 2:
 A = [2, 1, 3, 2, 4, 3]

Example Output
Output 1:
 1 
Output 2:
 0 

Example Explanation

Explanation 1:
 B = [1, 2, 4]
 C = [3, 6]
 max(B) = 4, min(C) = 3
 abs(max(B) - min(C)) = abs(4 - 3) = abs(1) = 1 

 Explanation 2:
 B = [2, 1]
 C = [3, 2, 4, 3]
 max(B) = 2, min(C) = 2
 abs(max(B) - min(C)) = abs(2 - 2) = abs(0) = 0 
 */

//param A : array of integers
//return an integer
const optimalPartitioning = (A) => {

    // sort the array elements
    A = A.sort((a, b) => a - b);

    // initialize minDiff to max safe integer element
    let minDiff = Number.MAX_SAFE_INTEGER;

    // iterate over sorted array and compare two adjacent elements.
    // Observation here is that the ans can be minimum difference between two adjacent elements of sorted array
    // if minDiff = A[j] - A[j], then A[j] can be part of one subsequence and A[i] can be part of another subsequence
    for (let i = 0; i < A.length - 1; i++) {
        let j = i + 1;
        const currentMin = Math.abs(A[j] - A[i]);
        if (currentMin < minDiff) {
            minDiff = currentMin;
        }
    }
    return minDiff;
}
