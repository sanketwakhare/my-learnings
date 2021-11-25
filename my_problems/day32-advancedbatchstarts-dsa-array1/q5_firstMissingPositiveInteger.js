/*****
 * Problem Description

Given an unsorted integer array A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-10^9 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the first missing positive integer.

Example Input
Input 1:
[1, 2, 0]
Input 2:
[3, 4, -1, 1]
Input 3:
[-8, -7, -6]


Example Output
Output 1:
3
Output 2:
2
Output 3:
1

Example Explanation
Explanation 1:
A = [1, 2, 0]
First positive integer missing from the array is 3.
 */

/**
 * Expected SC: O(1) and TC: O(N)
 * @param {Array} A integer array
 */
const findFirstMissingPositiveInteger = (A) => {

    // as the expected SC is O(1), modify the existing input array
    // swap the elements in the array
    const N = A.length;
    let i = 0;
    while (i < N) {
        const currentElement = A[i];
        // if currentElement is out of range 1 to N, ignore the element
        if (currentElement < 1 || currentElement > N) {
            i++;
        } else {
            // the right position of the element is (A[i] - 1)
            let rightPosition = A[i] - 1;
            // check if currentElement is already at right position
            if (A[rightPosition] !== A[i]) {
                // swap if currentElement is not at right position
                let temp = A[rightPosition];
                A[rightPosition] = A[i];
                A[i] = temp;
            } else {
                //  move to next element if currentElement is already at right position
                i++;
            }
        }
    }

    // iterate and find teh missing element
    console.log(`array after swapping: ${A}`);
    for (let i = 0; i < A.length; i++) {
        if (A[i] !== i + 1) {
            console.log(i + 1);
            return i + 1;
        }
    }
    // for edge case when all the elements from i to N are present in array
    return N + 1;

}

findFirstMissingPositiveInteger([-8, 1, 6, 4, 5, -10, 2, 9]);
findFirstMissingPositiveInteger([1, 2, 0]);
findFirstMissingPositiveInteger([3, 4, -1, 1]);
findFirstMissingPositiveInteger([-8, -7, -6]);
findFirstMissingPositiveInteger([2, 3, 4, 1, 2, -10, 7]);
findFirstMissingPositiveInteger([2, 3, 4, 1, 2, 6, 5, 7]);