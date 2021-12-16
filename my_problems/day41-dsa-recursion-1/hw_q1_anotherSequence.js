/*******
 * Another sequence problem
 * 
 * Problem Description

Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
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
 * 
 */

/**
 * Recursive Function
 */
const findSequence = (A) => {

    // base conditions
    // f(0) = 1
    if (A === 0) {
        return 1;
    }
    // f(1) = 1
    if (A === 1) {
        return 1;
    }
    // f(2) = 2
    if (A === 2) {
        return 2;
    }

    // main logic- subproblem
    return findSequence(A - 3) + findSequence(A - 2) + findSequence(A - 1) + A;
}

//param A : integer
//return an integer
/**
 * Find f(A)th term
 * @param {Number} A integer number
 * @returns 
 */
const anotherSequenceMain = (A) => {
    // call to recursive function
    let ans = findSequence(A);
    console.log(`${A} th term= ${ans}`);
    return ans;
}

anotherSequenceMain(5);
anotherSequenceMain(7);
anotherSequenceMain(2);
anotherSequenceMain(3);
anotherSequenceMain(1);
anotherSequenceMain(0);
anotherSequenceMain(10);
anotherSequenceMain(20);
anotherSequenceMain(24);
/**
 * Recursive Relation calculations
 * 
 * Assumption:
 * T(N) = T(N-3) + T(N-2) + T(N-1) + 1
 * 
 * Known Complexities:
 * T(0) = T(1) = T(2) = 1
 * 
 * 		T(N-1) = T(N-4) + T(N-3) + T(N-2) + 1
 * 		T(N-2) = T(N-5) + T(N-4) + T(N-3) + 1
 * 		T(N-3) = T(N-6) + T(N-5) + T(N-4) + 1
 * 
 * T(N) = T(N-6) + 2 T(N-5) + 3 T(N-4) + 2 T(N-3) + T(N-2) + 4
 */