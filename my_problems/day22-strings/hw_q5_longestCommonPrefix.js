/**
 * Longest Common Prefix
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Problem Constraints
0 <= sum of length of all strings <= 1000000

Input Format
The only argument given is an array of strings A.

Output Format
Return the longest common prefix of all strings in A.

Example Input
Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];

Example Output
Output 1:
"a"
Output 2:
"ab"

Example Explanation
Explanation 1:
Longest common prefix of all the strings is "a".
Explanation 2:
Longest common prefix of all the strings is "ab".
 */

/**
 * Find longest common prefix of all the strings.
 * TC: O(N)
 * SC: O(1)
 * Idea: compare two strings at a given time and update the final answer if length is less than longest common prefix.
 * @param {Array} A array of N strings
 * @returns longest common prefix of all the strings
 */
const longestCommonPrefix = (A) => {

    // initialize longest common prefix with first string in array
    //  longest common prefix can no exceed more than smallest string length in array
    let longestCommonPrefix = A[0];
    const N = A.length;
    for (let i = 1; i < N; i++) {

        // compare two string at a given time
        let s1 = longestCommonPrefix;
        let s2 = A[i];

        let j = 0;
        // local variable to store the longest common prefix of s1 and s2
        let currentCommonPrefix = '';
        while (j < s1.length && j < s2.length) {
            if (s1[j] === s2[j]) {
                // if both the characters at index j are equal, add them in current common prefix
                currentCommonPrefix += s1[j];
                // go to next character in string
                j++;
            } else {
                // stop comparing 2 string
                break;
            }
        }
        // if current common prefix is less than longestCommonPrefix, update longestCommonPrefix with currentCommonPrefix
        if (currentCommonPrefix.length < longestCommonPrefix.length) {
            longestCommonPrefix = currentCommonPrefix;
        }
    }
    console.log(longestCommonPrefix);
    return longestCommonPrefix;
}

longestCommonPrefix(["abcdefgh", "aefghijk", "abcefgh"]);
longestCommonPrefix(["prashant", "pratik", "pratiksha", "prachi"]);