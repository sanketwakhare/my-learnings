/*******
 * Longest Consecutive Sequence
Problem Description
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from the array A.

Problem Constraints
1 <= N <= 10^6
-10^6 <= A[i] <= 10^6

Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.

Example Input
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:
 The set of consecutive elements will be [1, 2].
 */

/**
 * Find length of longest Consecutive Sequence
 * @param {Array} A input array
 * @returns find length of longest consecutive sequence
 */
const longestConsecutiveSequence = (A) => {

    const N = A.length;
    // prepare hashSet
    let hashSet = new Set();
    for (let i = 0; i < N; i++) {
        hashSet.add(A[i]);
    }
    // initialize answer as 1
    let maxLength = 1;

    //iterate over HashSet and check if current element can be start of sequence
    for (let key of hashSet.keys()) {

        let count = 1;
        let previousElement = key - 1;
        // check if current element can be start of sequence
        if (!hashSet.has(previousElement)) {
            // current element key can be start of sequence
            // count the consecutive element
            let nextElement = key + 1;
            while (hashSet.has(nextElement)) {
                nextElement++;
                count++;
            }
        }
        maxLength = Math.max(maxLength, count);
    }
    console.log(maxLength);
    return maxLength;

}

longestConsecutiveSequence([100, 4, 200, 1, 3, 2]);
longestConsecutiveSequence([2, 1]);
longestConsecutiveSequence([-1, 8, 2, 3, 7, 1, 4, 9]);