/**
 * Is Dictionary?
Problem Description
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.

Problem Constraints
1 <= N, length of each word <= 105
Sum of length of all words <= 2 * 106

Input Format
First argument is a string array A of size N.
Second argument is a string B of size 26 denoting the order.

Output Format
Return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.

Example Input
Input 1:
 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:
 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:
 "none" should be present after "no". Return 0.
 */

/**
 * check if given dictionary is sorted
 * @param {Array} A 
 * @param {Number} B 
 */
const isDictionarySorted = (A, B) => {

    // store all characters of B into hashMap
    let hashMap = new Map();
    // edge case, add -1 for blank character.. this will come for end of string
    hashMap.set('', -1);
    const b = B.split('');
    for (let i = 0; i < b.length; i++) {
        hashMap.set(b[i], i);
    }
    console.log(hashMap);

    let areGivenStringsSorted = 1;

    for (let i = 1; i < A.length; i++) {
        // compare two string at a time
        const str1 = A[i - 1];
        const str2 = A[i];
        // max length out of two string
        const maxLength = Math.max(str1.length, str2.length);
        for (let j = 0; j < maxLength; j++) {
            // compare str1 and str2
            const s1 = hashMap.get(str1.charAt(j));
            const s2 = hashMap.get(str2.charAt(j));
            if (s1 < s2) {
                // if char at str1 is less, compare next set of characters in string
                break;
            }
            if (s1 > s2) {
                // if char at str1 is greater, the given string are not sorted
                areGivenStringsSorted = 0;
                break;
            }
        }
    }

    console.log(areGivenStringsSorted);
    return areGivenStringsSorted;

}

isDictionarySorted(["hello", "scaler", "interviewbit"], "adhbcfegskjlponmirqtxwuvzy");
isDictionarySorted(["fine", "none", "no"], "qwertyuiopasdfghjklzxcvbnm");