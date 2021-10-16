/**
 * Largest Number
Problem Description
Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9

Input Format
First argument is an array of integers.

Output Format
Return a string representing the largest number.

Example Input
Input 1:
 A = [3, 30, 34, 5, 9]
Input 2:
 A = [2, 3, 9, 0]

Example Output
Output 1:
 "9534330"
Output 2:
 "9320"

Example Explanation
Explanation 1:
 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:
 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */

const formLargestNumber = (A) => {

    console.log('input', A);
    // sort the numbers by dividing them by 10
    A = A.sort((a, b) => {
        // custom sorting
        let s1 = String(a);
        let s2 = String(b);
        return (s2 + s1) - (s1 + s2);
    });

    console.log('sorted', A);
    //  combine entire string as ans
    let ans = '';
    for (let i = 0; i < A.length; i++) {
        ans = ans + A[i];
    }

    let position = 0;
    while (ans[position] === '0' && position + 1 < ans.length) {
        position++;
    }

    let result = ans.substr(position, ans.length);
    console.log(result);
    return result;
}

// formLargestNumber([3, 30, 34, 5, 9]);
// formLargestNumber([2, 3, 9, 0]);
// formLargestNumber([0, 0, 3, 0]);
// formLargestNumber([0, 0, 0, 0]);
formLargestNumber([8, 89]);