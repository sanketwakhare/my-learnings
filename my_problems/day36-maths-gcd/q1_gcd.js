/*******
 * Greatest Common Divisor
 * 
Problem Description

Given 2 non negative integers A and B, find gcd(A, B)
GCD of 2 integers A and B is defined as the greatest integer g such that g is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.

Note: DO NOT USE LIBRARY FUNCTIONS.

Problem Constraints
0 <= A, B <= 10^9

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the gcd(A, B).

Example Input
Input 1:
A = 4
B = 6
Input 2:
A = 6
B = 7

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 2 divides both 4 and 6
Explanation 2:
 1 divides both 6 and 7
 */

/**
 * Find GCD of 2 numbers
 * TC: O(log(max(A,B)))
 * SC: O(1)
 * @param {Number} A integer A
 * @param {Number} B integer B
 * @returns GCD of A and B
 */
const gcd = (A, B) => {

    const a = A;
    const b = B;

    // Consider B> A for all the cases
    if (A > B) {
        // swap A and B
        const temp = A;
        A = B;
        B = temp;
    }

    // GCD can be written as [gcd(A,B) = gcd(A, B - A) where B > A],
    // (B-A) % A = B % A are nothing but the same

    // GCD can also be simplified as [gcd (A,B) = gcd(A, B % A) where B > A]
    while (A > 0) {
        const temp = A;
        A = B % A;
        B = temp;
    }
    console.log(`GCD of ${a} and ${b} is ${B}`);
    return B;
}