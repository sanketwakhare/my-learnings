/******
 * A, B and Modulo
 * 
Problem Description

Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.

Problem Constraints
1 <= A, B <= 10^9
A != B

Input Format
The first argument given is the integer, A.
The second argument given is the integer, B.

Output Format
Return an integer denoting greatest possible positive M.

Example Input
Input 1:
A = 1
B = 2
Input 2:
A = 5
B = 10

Example Output
Output 1:
1
Output 2:
5

Example Explanation
Explanation 1:
1 is the largest value of M such that A % M == B % M.
Explanation 2:
For M = 5, A % M = 0 and B % M = 0.

No value greater than M = 5, satisfies the condition.
 * 
 */

/**
 * Return max possible M such that A % M == B % M.
 * O(1)
 * @param {Number} A integer number
 * @param {Number} B integer number
 * @returns 
 */
const a_b_modulo = (A, B) => {

    // A % M = B % M can be written as A % M - B % M = 0
    // A % M - B % M = 0 => (A % M - B % M) % M = 0
    // so the largest no divisible by A-B is A-B itself
    const answer = Math.abs(A - B);
    console.log(answer);
    return answer;

}

gcd(17, 33);
gcd(6816621, 8157697);
gcd(106978, 4487506);
gcd(3800202, 8834747);