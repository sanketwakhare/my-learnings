/***
 * Problem Description

Given an array A of N strings, return all groups of strings that are anagrams.
Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
NOTE: Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'.

Problem Constraints
1 <= N <= 10^4

1 <= |A[i]| <= 10^4
Each string consists only of lowercase characters.
Sum of length of all the strings doesn't exceed 107

Input Format
Single Argument A which is an array of strings.

Output Format
Return a two-dimensional array where each row describes a group.

Note:
Ordering of the result :
You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.

Example Input
Input 1:
 A = [cat, dog, god, tca]
Input 2:
 A = [rat, tar, art]

Example Output
Output 1:
 [ [1, 4],
   [2, 3] ]
Output 2:
 [ [1, 2, 3] ]

Example Explanation
Explanation 1:
 "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).
Explanation 2:
 All three strings are anagrams.
 */

/**
 * Sort each string and store in hashMap.
 * use custom sort for strings
 * @param {Array} A input array of strings
 * @returns 
 */
const anagrams = (A) => {

    // insert in hashMap
    let hashMap = new Map();

    for (let i = 0; i < A.length; i++) {
        // sort each string in array
        let str = A[i];
        str = str.split('').sort((a, b) => {
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
            return 0;
        });
        str = str.join('');

        if (!hashMap.has(str)) {
            hashMap.set(str, [i + 1]);
        } else {
            let arrayIndexes = hashMap.get(str);
            arrayIndexes.push(i + 1);
            hashMap.set(str, arrayIndexes);
        }
    }

    let result = [];
    const keys = hashMap.keys();
    for (let i = 0; i < hashMap.size; i++) {
        const str = keys.next(i).value;
        const value = hashMap.get(str);
        result.push(value);
    }

    console.log(result);
    return result;

}

anagrams(['cat', 'dog', 'god', 'tca']);