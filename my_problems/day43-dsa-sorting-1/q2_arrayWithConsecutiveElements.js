/*****
 * Array with consecutive elements
 * 
 * Problem Description

Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return 1 if the array elements are consecutive else return 0.

Example Input
Input 1:
 A = [3, 2, 1, 4, 5]
Input 2:
 A = [1, 3, 2, 5]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 As you can see all the elements are consecutive, so we return 1.
Explanation 2:
 Element 4 is missing, so we return 0.
 */

const isArrayWithConsecutiveElements = (A) => {
    A.sort((a, b) => a - b);
    let isConsecutive = 1;
    for (let i = 0; i < A.length - 1; i++) {
        // check difference between elements is 1
        if (A[i + 1] - A[i] !== 1) {
            isConsecutive = 0;
        }
    }
    console.log('isArrayWithConsecutiveElements: ' + isConsecutive);
    return isConsecutive;
}

isArrayWithConsecutiveElements([3, 2, 1, 4, 5]);
isArrayWithConsecutiveElements([1, 3, 2, 5]);
isArrayWithConsecutiveElements([6, 4, 3, 5]);
isArrayWithConsecutiveElements([15, 13, 12, 14]);
isArrayWithConsecutiveElements([157, 156, 158]);