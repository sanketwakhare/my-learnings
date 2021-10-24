/**
 * Longest Palindromic Substring

Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).

Problem Constraints
1 <= N <= 10000

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the longest palindromic substring of string A.

Example Input
A = "aaaabaaa"

Example Output
"aaabaaa"

Example Explanation
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */

const expand = (S, start, end) => {
    while (start >= 0 && end < S.length && S[start] === S[end]) {
        start--;
        end++;
    }
    let subString = '';
    for (let i = start + 1; i < end; i++) {
        subString += S[i];
    }
    return subString;
    // const lengthOfPalindromicSubString = end - start - 1;
    // return length of substring
    // return lengthOfPalindromicSubString;
}

/**
 * Use expand at center approach
 * Find longest palindromic substring
 * @param {String} A input string.
 */
const findLongestPalindromeSubString = (A) => {

    let ans = A[0];
    // max odd length palindrome
    for (let i = 0; i < A.length; i++) {
        const subString = expand(A, i, i);
        if (subString.length > ans.length) {
            ans = subString;
        }
    }

    // max odd length palindrome
    for (let i = 0; i < A.length - 1; i++) {
        const subString = expand(A, i, i + 1);
        if (subString.length > ans.length) {
            ans = subString;
        }
    }

    console.log('ans', ans);

}

findLongestPalindromeSubString('xbdyzzydbdyzydz');