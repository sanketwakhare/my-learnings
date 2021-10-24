/*******
 * Amazing Subarrays
You are given a string S, and you have to find all the amazing substrings of S.
Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input
    Only argument given is string S.
Output
    Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.

Constraints
1 <= length(S) <= 1e6
S can have special characters

Example
Input
    ABEC
Output
    6
Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */

/**
 * Idea:  if vowel is at index i, there would be (N-i) subarray
 */

const findNoOfAmazingSubArrays = function (A) {

    // initialize total subarray to 0
    let totalSubArrays = 0;
    // store set of all vowels for comparison
    let hashSet = new Set();
    hashSet.add('A');
    hashSet.add('E');
    hashSet.add('I');
    hashSet.add('O');
    hashSet.add('U');
    hashSet.add('a');
    hashSet.add('e');
    hashSet.add('i');
    hashSet.add('o');
    hashSet.add('u');

    const N = A.length;
    // iterate over string
    for (let i = 0; i < N; i++) {
        if (hashSet.has(A[i])) {
            // if vowel, then increment subarray count by [N-i]
            totalSubArrays += N - i;
        }
    }

    console.log(totalSubArrays % 10003);
    return totalSubArrays % 10003;

}

findNoOfAmazingSubArrays('pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn');