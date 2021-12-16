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

/**
 * recursive function to find sum of digits
 * TC: Recursive Relation calculations
 * Assumption: T(N) = T(N/10) + 1 
 * Known TC: T(0) = 1
 * 
 * Use substitution method
 * T(N/10) = T(N/100) + 1
 * T(N/100) = T(N/1000) + 1
 * T(N/100) = T(N/10^k) + 1
 * where k=no of digits in number N
 * 
 * T(N) = T(N/10^k) + k
 * 
 * if N=94362 and k=5 no of digits, then N/10^5 = 94362/10000 will become 0
 * as T(0) = 1
 * 
 * T(N) = 1 + k ~ TC will be O(k) = no of digits = no of iteration
 * 
 * @param {Number} N 
 * @returns 
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

    // subproblem/main logic
    return sumDigits(N) + digit;
}


//param A : integer
//return an integer
/**
 * Sum of digits of number N
 * @param {Number} N input number
 * @returns 
 */
const sumOfDigitsMain = (N) => {
    // Approach: extract last digit and add to answer
    const ans = sumDigits(N);
    console.log('sum of digits of', N, 'is', ans);
    return ans;
}

sumOfDigitsMain(42342);
sumOfDigitsMain(123456);
sumOfDigitsMain(9876);
sumOfDigitsMain(9743);
sumOfDigitsMain(30);