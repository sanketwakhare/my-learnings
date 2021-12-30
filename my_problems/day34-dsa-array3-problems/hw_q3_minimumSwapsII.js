/**
 * Problem Description

Given an array of integers A of size N that is a permutation of [0, 1, 2, …, (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).
Find the minimum number of swaps required to sort the array in ascending order.

Problem Constraints
1 <= N <= 100000
0 <= A[i] < N

Input Format
The only argument given is the integer array A.

Output Format
Return the minimum number of swaps.

Example Input
Input 1:
A = [1, 2, 3, 4, 0]
Input 2:
A = [2, 0, 1, 3]

Example Output
Output 1:
4
Output 2:
2

Example Explanation
Explanation 1:
 If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
 You cannot sort it with lesser swaps.
Explanation 2:
 You cannot sort it with lesser than 2 swaps.
 */

/**
 * TC: O(N)
 * SC: O(1)
 * Max swaps for selection sort are n-1.
 * Use same idea to swap the elements to make array sorted
 * @param {Array} A array of integers
 * @returns 
 */
const minimumSwapsII = (A) => {

    // Use idea of selection sort. at max there can be N-1 swaps

    // Observation is to bring the element at its correct position at every swap
    // A[i] should be equal to i
    let count = 0;
    // iterate and find index
    let i = 0;
    while (i < A.length) {
        if (A[i] !== i) {
            // find the index at which A[i] should be present
            const index = A[i];
            // swap A[i] and A[index]
            const temp = A[i];
            A[i] = A[index];
            A[index] = temp;
            count++;
        } else {
            // if element is at correct position, check for next element in array
            i++;
        }
    }
    console.log('minimum swaps required -> ', count);
    return count;
}

minimumSwapsII([1, 2, 3, 4, 0]);
minimumSwapsII([2, 0, 1, 3]);