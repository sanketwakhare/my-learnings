/***
 * Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
1 <= size of the array <= 1000000

Input Format
First argument is an array of digits.

Output Format
Return the array of digits after adding one.

Example Input
Input 1:
[1, 2, 3]

Example Output
Output 1:
[1, 2, 4]

Example Explanation
Explanation 1:
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */

/**
 * Add 1 to array of digits
 * TC: O(N)
 * @param {Array} A 
 * @returns updated array after adding 1 to array
 */
const addOneToDigits = (A) => {
    const N = A.length;
    let isElementUpdatedWithRemainder = false;
    // start from reverse direction
    for (let i = N - 1; i >= 0; i--) {
        // add 1 to the current element at index i
        let currentEle = A[i];
        let no = currentEle + 1;

        // calculate remainder
        const rem = no % 10;

        // if remainder is not 0, add 1 to the current element A[i]
        if (rem !== 0) {
            // update current digit with rem value
            A[i] = rem;
            isElementUpdatedWithRemainder = true;
            break;
        } else {
            // update current digit with rem value
            A[i] = rem;
        }
        // otherwise continue iterating next elements, carry would always be 1 if remainder of n%10 is 0
    }
    if (!isElementUpdatedWithRemainder) {
        // add digit 1 to start if carry is still present
        A.unshift(1);
    }
    // remove all 0s from start
    while (A[0] === 0) {
        A.shift();
    }

    console.log(A);
    return A;
}

addOneToDigits([1, 0, 0, 0, 0, 0]);
addOneToDigits([2, 0, 0, 9, 9]);
addOneToDigits([2, 0, 0, 0, 0]);
addOneToDigits([9, 9, 9, 9, 9]);
addOneToDigits([0, 3, 7, 6, 4, 0, 5, 5, 5]);
addOneToDigits([0, 0, 0, 3, 8, 9, 1, 3, 4]);
addOneToDigits([1, 0, 0, 3, 8, 9, 1, 3, 4]);
addOneToDigits([0, 0, 0]);
