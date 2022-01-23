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
 * TC: O(N logN)
 * Binary Search Approach failing for larger input size
 */

const check = (A, mid) => {

    let areUniqueElePresentWithLengthMid = false;
    // check all substrings of length mid
    for (let i = 0; i <= A.length - mid; i++) {

        let hashSet = new Set();
        for (let j = i; j < i + mid; j++) {
            if (hashSet.has(A[j])) {
                areUniqueElePresentWithLengthMid = false;
                break;
            } else {
                hashSet.add(A[j]);
            }
        }
        if (hashSet.size === mid) {
            areUniqueElePresentWithLengthMid = true;
            break;
        }
    }
    return areUniqueElePresentWithLengthMid;
}

const lengthOfLongestSubstring = (A) => {

    // Using Binary Search Approach over length

    let answer = 0;
    // create search space
    let l = 0;
    let r = A.length;
    let mid;

    while (l <= r) {

        mid = l + Math.floor((r - l) / 2);

        if (check(A, mid)) {
            // update answer
            answer = mid;
            // search on right for better answer
            l = mid + 1;
        } else {
            // search on left
            r = mid - 1;
        }
    }
    console.log(answer);
    return answer;
}

let A = "abcabcbb";
lengthOfLongestSubstring(A);
A = "AaaA";
lengthOfLongestSubstring(A);