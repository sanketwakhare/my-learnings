/**
 * Check Palindrome!
Problem Description

Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 10^5
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Example Input
Input 1:
 A = "abcde"
Input 2:
 A = "abbaee"

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */

/**
 * TC: O(N)
 * SC: O(N)
 * @param {String} A String with lowercase letters
 */
const checkIfPalindromeCanBeFormed = (A) => {

    // To be valid palindrome, each character should occur in multiple of 2 except one in middle
    // Approach: find frequency iof each character within string

    const array = A.split("");

    // build hashMap of <Character, frequency>
    // hashMap<String, Integer> => <Character, frequency>
    let hashMap = new Map();
    for (let i = 0; i < array.length; i++) {
        if (hashMap.has(array[i])) {
            let currentFrequency = hashMap.get(array[i]);
            hashMap.set(array[i], currentFrequency + 1);
        } else {
            hashMap.set(array[i], 1);
        }
    }

    //  only single odd frequency is allowed
    let oddFrequencyCount = 0
    const keys = hashMap.keys();
    for (let key of keys) {
        // odd frequency
        if (hashMap.get(key) & 1 === 1) {
            oddFrequencyCount++;
            if (oddFrequencyCount > 1) {
                break;
            }
        }
    }

    if (oddFrequencyCount > 1) {
        return 0;
    }
    return 1;

}

checkIfPalindromeCanBeFormed("abcde");
checkIfPalindromeCanBeFormed("abbaee");