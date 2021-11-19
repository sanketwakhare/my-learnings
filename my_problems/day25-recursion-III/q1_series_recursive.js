/***
 * Another sequence problem
 * 
 * Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.

Given f(0)=1; f(1)=1; f(2)=2;

Problem Constraints
0<=n<=20

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the Ath term of the sequence.

Example Input
Input 1:
 3
Input 2:
 2

Example Output
Output 1:
 7
Output 2:
 2

Example Explanation
Explanation 1:

 f(3) = 2+1+1+3 = 7
Explanation 2:

 f(2) = 2 as given.
 */

/**
 * As constraints are less, find the sequence
 * @param {Number} A number
 * @returns 
 */
const f = (A) => {
    if (A === 0) {
        return 1;
    }
    if (A === 1) {
        return 1;
    }
    if (A === 2) {
        return 2;
    }
    return f(A - 1) + f(A - 2) + f(A - 3) + A;
}

const solve = (A) => {
    return f(A);
}

console.log(f(0));
console.log(f(1));
console.log(f(2));
console.log(f(3));
console.log(f(4));
console.log(f(5));
