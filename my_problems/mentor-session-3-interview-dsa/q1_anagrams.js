/***
 * Problem Description

Given an array A of N strings, return all groups of strings that are anagrams.

Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.

NOTE: Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'.



Problem Constraints
1 <= N <= 10^4

1 <= |A[i]| <= 10^4

Each string consists only of lowercase characters.

Sum of length of all the strings doesn't exceed 10^7



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



//param A : array of strings
//return a array of array of integers
const anagrams = function (A) {

    let hashMap = new Map();

    // [cat, dog, god, tca]
    const N = A.length;
    for (let i = 0; i < N - 1; i++) {

        const str1 = A[i].split("").sort().join("");

        for (let j = i + 1; j < N; j++) {

            const str2 = A[j].split("").sort().join("");

            if (str1 === str2) {
                // anagram
                if (hashMap.has(str1)) {
                    let currentValues = hashMap.get(str1);
                    if (!currentValues.includes(j + 1)) {
                        currentValues.push(j + 1);
                        hashMap.set(str1, currentValues);
                    }
                } else {
                    hashMap.set(str1, [i + 1, j + 1]);
                }
            }
        }
    }

    let output = [];
    // iterate over hashMap and create 2 D array and return
    for (let key of hashMap.keys()) {
        output.push(hashMap.get(key));
    }

    console.log(output);
    return output;

}

anagrams(['cat', 'dog', 'god', 'tca']);
anagrams(['rat', 'art', 'tar']);


