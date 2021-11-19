/*******
 * Sum of Digits!
Problem Description

Given a number A, we need to find sum of its digits using recursion.

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the sum of digits of the number A.

Example Input
Input 1:
 A = 46
Input 2:
 A = 11

Example Output
Output 1:
 10
Output 2:
 2

Example Explanation
Explanation 1:
 Sum of digits of 46 = 4 + 6 = 10
Explanation 2:
 Sum of digits of 11 = 1 + 1 = 2
 */

/**
 * Recursive function to calculate sum of digit
 * @param {Number} A input number
 * @returns 
 */
const digitSum = (A) => {
    if (A === 0) {
        return 0;
    }
    return A % 10 + digitSum(Math.floor(A / 10));
}

/**
 * calculate sum of digits
 * @param {Number} A input number
 * @returns 
 */
const main = (A) => {
    return digitSum(A);
}

console.log(main(46));
console.log(main(11));
console.log(main(423524));