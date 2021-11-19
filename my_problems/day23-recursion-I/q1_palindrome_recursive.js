/****
 * Check Palindrome
Problem Description

Write a recursive function that checks whether a string A is a palindrome or Not.
Return 1 if the string A is palindrome, else return 0.

Note: A palindrome is a string that's the same when reads forwards and backwards.

Problem Constraints
1 <= A <= 50000

String A consist only of lowercase letters.

Input Format
First and only argument is a string A.

Output Format
Return 1 if the string A is palindrome, else return 0.

Example Input
Input 1:
 A = "naman"
Input 2:
 A = "strings"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 "naman" is a palindomic string, so return 1.
Explanation 2:
 "strings" is not a palindrome, so return 0.
 */

const isPalindrome = (A, start, end) => {

    if (start >= end) {
        // base condition. This means the given string is Palindrome
        return 1;
    }
    // check start and end character
    if (A[start] === A[end]) {
        // if start and end characters are equal, increase start and decrease end and verify the subsequenct next set of characters
        return isPalindrome(A, start + 1, end - 1);
    } else {
        // if characters are not matching, the given string is not Palindrome
        return 0;
    }
}

const checkPalindromeMain = (A) => {
    const ans = isPalindrome(A, 0, A.length - 1);
    console.log(`The given string ${A} is ${ans ? 'Palindrome' : 'Not Palindrome'} `);
    return ans;
}

checkPalindromeMain("naman");
checkPalindromeMain("malayalam");
checkPalindromeMain("pushup");
checkPalindromeMain("strings");
checkPalindromeMain("abccba");
checkPalindromeMain("abcba");
checkPalindromeMain("abccaa");