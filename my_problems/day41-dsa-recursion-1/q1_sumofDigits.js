/***
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

const sumDigits = (N) => {

    // base condition
    if (N === 0) {
        return 0;
    }
    // extract last digit of number N
    const digit = N % 10;
    // divide N by 10 to process the remaining digits
    N = Math.floor(N / 10);

    // subproblem
    return sumDigits(N) + digit;
}


//param A : integer
//return an integer
/**
 * 
 * @param {Number} A input number
 * @returns 
 */
const sumOfDigitsMain = (A) => {
    // Approach: extract last digit and add to answer
    const ans = sumDigits(A);
    console.log('sum of digits of', A, 'is', ans);
    return ans;
}

sumOfDigitsMain(42342);
sumOfDigitsMain(123456);
sumOfDigitsMain(9876);
sumOfDigitsMain(9743);
sumOfDigitsMain(30);