/**
 * Largest Number
 * 

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

/**
 * Find Largest Number
 * @param {Number} A array of integers
 * @returns Largest number in string format
 */
const largestNumber = function(A) {

    // custom sort function to sort the strings in descending order
    A.sort((a, b) => {
        const s1 = String(a);
        const s2 = String(b);
        return (s2 + s1) - (s1 + s2);
    });

    // remove undefined/empty elements
    A = A.filter((item) => {
        if (item !== undefined) {
            return item;
        }
    });

    // concatenate string from sorted array
    let ans = '';
    for (let i = 0; i < A.length; i++) {
        ans += A[i];
    }

    // count 0s from start which arenot required in final answer
    let count = 0;
    for (let i = 0; i < ans.length; i++) {
        if (ans.charAt(i) === '0') {
            count++;
        } else {
            break;
        }
    }

    // remove 0s from start
    ans = ans.substr(count);
    if (ans === '') {
        ans = '0';
    }
    console.log(ans);
    return ans;

}

largestNumber([0, 0, 0, 0, 0, 0]);
largestNumber([0, 0, 3, 20, 4, 50, 0, ]);
largestNumber([232, 674, 12, 756, , 12, , 80, 902, 80210]);
largestNumber([44, 33, 22, 55]);
largestNumber([90, 40, 50, 806]);