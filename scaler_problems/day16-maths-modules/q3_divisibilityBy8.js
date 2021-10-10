/****
 * Divisibility by 8
Given a number A in the form of string. Check if the number is divisible by 8 or not.
Return 1 if it is divisible by 8 else return 0.

Input Format
The only argument given is string A.
Output Format
Return 1 if it is divisible by 8 else return 0.

Constraints
1 <= length of the String <= 100000
'0' <= A[i] <= '9'

For Example
Input 1:
    A = "16"
Output 1:
    1
Input 2:
    A = "123"
Output 2:
    0
 */

/**
 * 
 * @param {Array} A 
 * @returns return 1 if divisible by 8 else return 0
 */
const divisibilityBy8 = function (A) {

    let pow = 1;
    let ans = 0;
    for (let i = A.length - 1; i >= 0; i--) {
        ans = ans + A[i] * pow;
        ans = ans % 8;
        pow = (pow * 10) % 8;
    }
    if (ans === 0) {
        return 1;
    }
    return 0;
}