/**
 * Is magic?
 * 
 * Problem Description

Given a number A, check if it is a magic number or not.
A number is said to be a magic number, if the sum of its digits are calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument is an integer A.

Output Format
Return an integer 1 if the given number is magic else return 0.

Example Input
Input 1:
 A = 83557
Input 2:
 A = 1291

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Sum of digits of (83557) = 28
 Sum of digits of (28) = 10
 Sum of digits of (10) = 1. 
 Single digit is 1, so it's a magic number. Return 1.
Explanation 2:
 Sum of digits of (1291) = 13
 Sum of digits of (13) = 4
 Single digit is not 1, so it's not a magic number. Return 0.
 */

/**
 * Recursive relation:
 * T(N) = T(N/10) + 1, T(0)=1
 * 		T(N/10) = T(N/100) + 1
 * 
 * T(N) = T(N/100) + 2 (2 here is no of digits in N)
 * 
 * T(N) = T(N/10^k) + k where k is no of digits in N
 * 
 * T(N) = T(0) + k => 1+ k=> O(k) where k is no of digits in N
 */

/**
 * Recursive function
 */
const sumDigits = (A) => {
    // base condition
    if (A === 0) {
        return 0;
    }
    // extract last digit
    const lastDigit = A % 10;
    // call recursive function with subproblem as A/10 to extract next digit
    return sumDigits(Math.floor(A / 10)) + lastDigit;
}

const isMagicMain = (A) => {

    // perform first time operation recursively
    let ans = sumDigits(A);

    // while answer is not single digit number, call recursive function
    while (ans > 9) {
        ans = sumDigits(ans);
    }

    //  if ans =1, then return 1
    if (ans === 1) {
        console.log(A, 'is a magic no');
        return 1;
    }
    // return 0 otherwise
    console.log(A, 'is not a magic no');
    return 0;

}

isMagicMain(83557);
isMagicMain(1291);
isMagicMain(451);
isMagicMain(666);
isMagicMain(9999);