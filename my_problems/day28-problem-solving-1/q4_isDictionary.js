/**
 * Problem Description

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

const isDictionary = (A, B) => {
    let hashMap = new Map();
    hashMap.set('', -1);

    for (let i = 0; i < B.length; i++) {
        hashMap.set(B.charAt(i), i);
    }

    let areStringsSorted = 1;
    for (let i = 0; i < A.length - 1; i++) {

        const str1 = A[i];
        const str2 = A[i + 1];

        const maxLength = Math.max(str1.length, str2.length);
        for (let j = 0; j < maxLength; j++) {
            const c1 = hashMap.get(str1.charAt(j));
            const c2 = hashMap.get(str2.charAt(j));

            if (c1 < c2) {
                break;
            }
            if (c1 > c2) {
                areStringsSorted = 0;
                break;
            }
        }
    }
    console.log(areStringsSorted);
    return areStringsSorted;
}

isDictionary(["hello", "scaler", "interviewbit"], 'adhbcfegskjlponmirqtxwuvzy');
isDictionary(["fine", "none", "no"], 'qwertyuiopasdfghjklzxcvbnm');
isDictionary(["fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"], "zkgwaverfimqxbnctdplsjyohu");
