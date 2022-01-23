/******
 * Longest Substring Without Repeat
 * 
 * Problem Description
Given a string A, find the length of the longest substring without repeating characters.
Note: Users are expected to solve in O(N) time complexity.

Problem Constraints
1 <= size(A) <= 10^6
String consists of lowerCase,upperCase characters and digits are also present in the string A.

Input Format
Single Argument representing string A.

Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.

Example Input
Input 1:
 A = "abcabcbb"
Input 2:
 A = "AaaA"

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:
 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */

/***
 * TC: O(N)
 * SC: O(N) for set
 * find longest string using hashSet
 */

const lengthOfLongestSubstring = (A) => {

    // initialize answer with 0
    let answer = 0;

    // start index of answer substring
    let l = 0;

    // hashSet to store the distinct characters
    let hashSet = new Set();

    // iterate each character
    for (let i = 0; i < A.length; i++) {

        // if current char is present in hashSet, the update answer and remove all elements from hashSet till current existing
        if (hashSet.has(A[i])) {
            // update answer
            answer = Math.max(answer, i - l);
            while (A[l] !== A[i]) {
                hashSet.delete(A[l]);
                l++;
            }
            // we are not removing the current ith element from set instead keeping the element in set
            // the start length will start from next element after repeated character found
            l++;
        } else {
            // add element to hashSet
            hashSet.add(A[i]);
            // edge case whjen all elements are distinct
            answer = Math.max(answer, i - l + 1);
        }
    }

    console.log(answer);
    return answer;
}

let A = "abcabcbb";
lengthOfLongestSubstring(A);
A = "AaaA";
lengthOfLongestSubstring(A);
A = "aebcabgeb@#gbkdb#";
lengthOfLongestSubstring(A);