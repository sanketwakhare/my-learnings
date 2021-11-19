/***
*Isalnum()
Problem Description

You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format
Only argument is a character array A.

Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.

Example Input
Input 1:
 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:
 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 All the characters are alphanumeric.
Explanation 2:
 All the characters are NOT alphabets i.e ('#').
*/

/**
 * Find if given character array is alphanumeric or not.
 * @param {Array} A 
 * @returns 
 */
const isAlphaNumeric = (A) => {

    let isArrayAlphaNumeric = 1;
    // ascii range of capital letters is 65 to 90
    // ascii range of small letters is 97 to 122
    // ascii range of 0-9 is 48 to 57
    for (let i = 0; i < A.length; i++) {
        const currentElement = A[i].charCodeAt(0);
        if (!((currentElement >= 65 && currentElement <= 90) || (currentElement >= 97 && currentElement <= 122) || (currentElement >= 48 && currentElement <= 57))) {
            isArrayAlphaNumeric = 0;
        }
    }
    return isArrayAlphaNumeric;
}


console.log(isAlphaNumeric(['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']));
console.log(isAlphaNumeric(['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']));