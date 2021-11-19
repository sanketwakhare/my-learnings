/****
 * Reverse the String
Problem Description

Given a string A of size N.
Return the string A after reversing the string word by word.

NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

Problem Constraints
1 <= N <= 3 * 10^5

Input Format
The only argument given is string A.

Output Format
Return the string A after reversing the string word by word.

Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"  

Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"    

Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "the sky is blue".
Explanation 2:
    We reverse the string word by word so the string becomes "this is ib".
 */

/**
 * Util function
 * Reverse given sub string from given start to end position
 * @param {Array} s character array
 * @param {*} start start index
 * @param {*} end end index
 */
const reverse = (s, start, end) => {
    while (start < end) {
        let temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
}

/**
 * Reverse index string word by word
 * @param {String} A input string
 */
const reverseStringWordByWord = (A) => {
    let str = A.split('');

    // reverse entire string
    reverse(str, 0, A.length - 1);

    // reverse each word separated by space ' '
    // start and end should be same initially
    let start = 0;
    let end = 0;
    while (end < A.length) {

        // loop until end of single word
        while (str[end] != ' ' && end < A.length) {
            end++;
        }

        // reverse single word from start to end
        reverse(str, start, end - 1);

        // if there are spaces in between, increase start index until first character of word is found
        start = end + 1;
        while (str[start] === ' ') {
            start++;
        }
        // start and end should be same initially
        end = start;
    }

    console.log(str.join('').trim());
}

reverseStringWordByWord(" the sky is blue ");
reverseStringWordByWord("love hate data structures");