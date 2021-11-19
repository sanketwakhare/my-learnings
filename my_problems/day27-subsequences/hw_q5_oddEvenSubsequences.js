/******
 * Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.

A subsequence is said to odd-even in the following cases:
The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

Return the maximum possible length of odd-even subsequence.

Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.


Input Format
The only argument given is the integer array A.

Output Format
Return the maximum possible length of odd-even subsequence.

Constraints
1 <= N <= 100000
1 <= A[i] <= 10^9

For Example
Input 1:
    A = [1, 2, 2, 5, 6]
Output 1:
    4
Explanation 1:
    Maximum length odd even subsequence is [1, 2, 5, 6]

Input 2:
    A = [2, 2, 2, 2, 2, 2]
Output 2:
                1
    Explanation 2:
        Maximum length odd even subsequence is [2]
 */

const oddEvenSubsequence = (A) => {
    // iterate and check if given element is even or odd
    // increment count if so
    let count = 0;
    // maintain a flag which can identify if previos element was odd/even
    let isPrevOdd;

    // odd even subsequence
    if (A[0] % 2 === 0) {
        // even
        isPrevOdd = false;
        count = 1;
    } else {
        // odd
        isPrevOdd = true;
        count = 1;
    }

    for (let i = 1; i < A.length; i++) {
        // odd even subsequence
        if (A[i] % 2 === 0) {
            // even
            if (isPrevOdd) {
                isPrevOdd = false;
                count++;
            }
        } else {
            // odd
            if (!isPrevOdd) {
                isPrevOdd = true;
                count++;
            }
        }
    }

    console.log('count: ', count);
    return count;
}

oddEvenSubsequence([1, 2, 2, 5, 6]);
oddEvenSubsequence([2, 2, 2, 2, 2, 2]);
oddEvenSubsequence([8, 9, 7, 2, 5, 4, 3]);