/* Boring substring */
/***
 * Problem Description

Given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format
The only argument given is string A.

Output Format
Return 1 if it possible to rearrange the letters of A such that there are no boring substring in A, else return 0.

Example Input
Input 1:
 A ="abcd"
Input 2:
 A = "aab"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:
 No arrangement of string A can make it free of boring substrings.
 */

/**
 * TC: O(N) to traverse entire string
 * SC: O(N) -to store the sets
 * Check if BORING substring can be rearranged
 * @param {Array} A array of integers
 * @returns 
 */
const boringSubstring = function (A) {

    // maintain sets for all evens and odds seperately
    let odds = new Set();
    let evens = new Set();

    let minOdd = Number.MAX_SAFE_INTEGER;
    let maxOdd = Number.MIN_SAFE_INTEGER;
    let minEven = Number.MAX_SAFE_INTEGER;
    let maxEven = Number.MIN_SAFE_INTEGER;

    for (let i = 0; i < A.length; i++) {
        const asciiValue = A.charCodeAt(i);
        if (asciiValue % 2 === 0) {
            evens.add(A[i]);
            minEven = Math.min(asciiValue, minEven);
            maxEven = Math.max(asciiValue, maxEven);
        } else {
            odds.add(A[i]);
            minOdd = Math.min(asciiValue, minOdd);
            maxOdd = Math.max(asciiValue, maxOdd);
        }
    }
    // console.log('odds->', odds);
    // console.log('evens->', evens);
    // console.log('minOdd->', minOdd);
    // console.log('maxOdd->', maxOdd);
    // console.log('minEven->', minEven);
    // console.log('maxEven->', maxEven);

    // compare minOdd with minEven and maxEven, if diff is > 1 then we can rearrange the boring sub-string
    if (Math.abs(minOdd - minEven) > 1) {
        return 1;
    }
    if (Math.abs(minOdd - maxEven) > 1) {
        return 1;
    }

    // compare maxOdd with minEven and maxEven, if diff is > 1 then we can rearrange the boring sub-string
    if (Math.abs(maxOdd - minEven) > 1) {
        return 1;
    }
    if (Math.abs(maxOdd - maxEven) > 1) {
        return 1;
    }

    return 0;

}

console.log(boringSubstring("abcd"));
console.log(boringSubstring("aab"));