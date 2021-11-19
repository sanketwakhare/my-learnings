/***
 * Arithmetic Progression?
Problem Description

Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Problem Constraints
2 <= N <= 105
-109 <= A[i] <= 109

Input Format
First and only argument is an integer array A of size N.

Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0

Example Input
Input 1:
 A = [3, 5, 1]
Input 2:
 A = [2, 4, 1]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Explanation 2:
 There is no way to reorder the elements to obtain an arithmetic progression.
 */
const isArithmeticProgression = (A) => {

    // sort in ascending order
    A = A.sort((a, b) => a - b);

    // initialize diff
    let diff = A[1] - A[0];
    for (let i = 1; i < A.length - 1; i++) {
        let currentDiff = (A[i + 1] - A[i]);
        if (currentDiff !== diff) {
            return 0;
        }
    }
    return 1;
}

console.log(isArithmeticProgression([3, 5, 1]));
console.log(isArithmeticProgression([2, 4, 1]));
console.log(isArithmeticProgression([30, 55, 10, 20, 40, 80, 70, 60]));