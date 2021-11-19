/*******
 * Isalpha()
Problem Description

You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format
Only argument is a character array A.

Output Format
Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.

Example Input
Input 1:
 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']
Input 2:
 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 All the characters are alphabets.
Explanation 2:
 All the characters are NOT alphabets i.e ('#', '2', '0', '2', '0').
 */

/**
 * Check if given array is alphabetical.
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A 
 * @returns 1 if array elements are alphabetical / return 0 if not alphabetical
 */
const isArrayAlphabetic = (A) => {

    let isArrayAlphabetic = 1;
    // ascii range of capital letters is 65 to 90
    // ascii range of small letters is 97 to 122
    for (let i = 0; i < A.length; i++) {
        const currentElement = A[i].charCodeAt(0);
        if (!((currentElement >= 65 && currentElement <= 90) || (currentElement >= 97 && currentElement <= 122))) {
            isArrayAlphabetic = 0;
        }
    }
    return isArrayAlphabetic;
}