/**
 * Noble Integer
Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.

Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is found else return -1.

Example Input
Input 1:
 A = [3, 2, 1, 3]
Input 2:
 A = [1, 1, 3, 3]

Example Output
Output 1:
 1
Output 2:
 -1

Example Explanation
Explanation 1:
 For integer 2, there are 2 greater elements in the array. So, return 1.
Explanation 2:
 There is no such integer exists.
 */

const nobleInteger = (A) => {

    A = A.sort((a, b) => b - a);
    console.log(A);

    let count = 0;
    let ans = 0;
    if (A[0] === 0) {
        count = 0;
        ans++;
        return 1;
    }
    for (let i = 1; i < A.length; i++) {
        if (A[i] === A[i - 1]) {
            if (count === A[i]) {
                ans++;
                // return 1;
            }
        } else {
            count = i;
            if (count === A[i]) {
                ans++;
                // return 1;
            }
        }
    }
    console.log('ans', ans);
    return -1;
}
console.log(nobleInteger([3, 2, 1, 3]));
console.log(nobleInteger([5, 7, 8, 9, 5, 5, 5, 5, 9, 9]));