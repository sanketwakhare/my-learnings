/**
 * Arithmetic Progression?
Problem Description

Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Problem Constraints
2 <= N <= 10^5
-10^9 <= A[i] <= 10^9

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

/**
 * Time Complexity: O(N logN) + O(N)
 * @param {Array} A 
 */
const isArithmeticProgression = (A) => {
    //sort O(N * log(N))
    A = A.sort((a, b) => a - b);

    // maintain prev and i as next and make sure that the diff is same throughout the prev and next elements
    let prev = A[0];
    let diff = A[1] - A[0];
    let isGP = 1;
    for (let i = 1; i < A.length; i++) {
        if ((A[i] - prev) !== diff) {
            isGP = 0;
            break;
        }
        prev = A[i];
    }
    console.log(isGP);
}

isArithmeticProgression([3, 5, 1]);
isArithmeticProgression([-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395]);
isArithmeticProgression([3, 6, 1]);