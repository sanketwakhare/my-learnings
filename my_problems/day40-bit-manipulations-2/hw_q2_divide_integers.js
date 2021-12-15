/*****
 * Divide Integers
 * 
 * Problem Description

Divide two integers without using multiplication, division and mod operator.
Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
NOTE: INT_MAX = 2^31 - 1

Problem Constraints
-2^31 <= A, B <= 2^31-1
B!= 0

Input Format
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.

Output Format
Return an integer denoting the floor value of the division.

Example Input
Input 1:
 A = 5
 B = 2
Input 2:
 A = 7
 B = 1

Example Output
Output 1:
 2
Output 2:
 7

Example Explanation
Explanation 1:
 floor(5/2) = 2
 */

/**
 * Perform A/B without using multiplication ,division or mod
 * @param {Number} A dividend
 * @param {Number} B divisor
 * @returns 
 */
const divideIntegers = (A, B) => {

    // edge case, when A=0 , answer would be 0 always
    if (A === 0) {
        return 0;
    }
    // calculate final sign of the answer
    // 1 = +ve, -1 = -ve
    let sign = 1;
    if (A >= 0 && B >= 0) {
        sign = 1;
    } else if (A >= 0 && B < 0) {
        sign = -1;
    } else if (A < 0 && B >= 0) {
        sign = -1;
    } else {
        sign = 1;
    }

    // take absolute values before calculating the answer
    A = Math.abs(A);
    B = Math.abs(B);

    let t = BigInt(0);
    let q = BigInt(0);
    // for every bit, check if the answer can be formed
    // 3/15 is 5. It can be represented as [2 * 2^2 + 2 * 2^0]
    for (let i = 31; i >= 0; i--) {
        if ((t + (BigInt(B) << BigInt(i))) <= A) {
            q = q | (BigInt(1) << BigInt(i));
            t = t + (BigInt(B) << BigInt(i));
        }
    }
    if (sign === -1) {
        return Number(0) - Number(q);
    }
    // if answer is greater than max integer, return max integer
    if (q > 2147483647) {
        return 2147483647;
    }
    return Number(q);
}

divideIntegers(10, 3);
divideIntegers(0, 1);
divideIntegers(-2147483648, -1);