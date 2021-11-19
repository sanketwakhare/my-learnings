/**
 * Least Common Multiple
Problem Description

You are given two non-negative integers A and B, find the value of Least Common Multiple (LCM) of A and B.
LCM of two integers is the smallest positive integer that is divisible by both.

Problem Constraints
1 <= A, B <= 1000

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer.

Example Input
Input 1:
 A = 2
 B = 3 
Input 2:
 A = 9
 B = 6
Input 3:
 A = 2
 B = 6

Example Output
Output 1:
 6 
Input 2:
 18 
Input 3:
 6 

Example Explanation
Explanation 1:
 6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 3 (3 * 2 = 6).
Explanation 2:
 18 is the smallest positive integer which is divisible by both 9 (9 * 2 = 18) and 6 (6 * 3 = 18).
Explanation 3:
 6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 6 (6 * 1 = 6).
 */

/**
 * Find LCM
 * 
 * @param {Integer} A 
 * @param {Integer} B 
 * @returns 
 */
const LCM = function (A, B) {

    const min = Math.min(A, B);
    const max = Math.max(A, B);

    for (let i = max; i <= (min * max); i++) {
        if (i % A === 0 && i % B === 0) {
            console.log(i);
            return i;
        }
    }

    console.log(min * max);
    return min * max;

}

LCM(9, 6);
LCM(2, 6);