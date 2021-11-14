/*******
 * Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.

Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000

All the alphabets of S are lower case (a - z)

Input Format
First argument is an integer A.
Second argument is a string B.

Output Format
Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.

Example Input
Input 1:
 A = 2
 B = "bbaabb"
Input 2:
 A = 1
 B = "bc"

Example Output
Output 1:
 1
Output 2:
 1

Example Explanation
Explanation 1:
 We can re-order the given string into "abbabb".
Explanation 2:
 String "bc" is already arranged.
 */


/**
 * TC: O(N)
 * SC: (1) ~ 26 length array
 * @param {Number} A no of substrings to be compared
 * @param {String} B input string B
 * @returns 
 */
const replicatingStrings = (A, B) => {
    // if we store frequencies of each character
    // all the frequencies should be completely divisible by number A

    let cntArray = new Array(26);
    cntArray.fill(0);

    // store all frequencies in count array
    for (let i = 0; i < B.length; i++) {
        const currentChar = B.charAt(i);
        // range is 97 to 122
        const charCode = currentChar.charCodeAt(0);
        cntArray[charCode - 97] = cntArray[charCode - 97] + 1;
    }

    // the string can be rearranged if each and every count is divisible by A
    for (let i = 0; i < cntArray.length; i++) {
        if (cntArray[i] % A !== 0) {
            return -1;
        }
    }

    return 1;
}