/* Permutations of A in B */

/* Problem Description

You are given two strings A and B of size N and M respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.

Problem Constraints
1 <= N < M <= 10^5

Input Format
Given two argument, A and B of type String.

Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.

Example Input
Input 1:
 A = "abc"
 B = "abcbacabc"
Input 2:
 A = "aca"
 B = "acaa"

Example Output
Output 1:
 5
Output 2:
 2

Example Explanation
Explanation 1:
 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:
 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
*/

/**
 * TC: O(N) => mo need to compare every element of hashMap of aMap and bMap
 * @param {String} A 
 * @param {String} B 
 * @returns {Number} count of permutations of A that are present in B as substring
 */
const permutationsOfAInB = (A, B) => {

    // create freq array/map of string A
    let aMap = new Map();
    for (let i = 0; i < A.length; i++) {
        if (aMap.has(A[i])) {
            aMap.set(A[i], aMap.get(A[i]) + 1);
        } else {
            aMap.set(A[i], 1);
        }
    }
    // initialize count and total need
    let count = 0;
    let total = A.length;

    // create freq map for first window of B, as every element is getting added, consider for only add case
    let bMap = new Map();
    for (let i = 0; i < A.length; i++) {

        const eleToAdd = B[i];

        // update freq in bMap as ith element is getting inserted
        if (bMap.has(eleToAdd)) {
            bMap.set(eleToAdd, bMap.get(eleToAdd) + 1);
        } else {
            bMap.set(eleToAdd, 1);
        }

        // get neededFreq
        let neededFreq = aMap.has(eleToAdd) ? aMap.get(eleToAdd) : 0;
        let currentFreq = bMap.has(eleToAdd) ? bMap.get(eleToAdd) : 0;

        // if currentFreq <= need total--
        if (currentFreq <= neededFreq) {
            total--;
        }
    }

    if (total === 0) {
        count++;
    }

    // now maintain hashMap for every window
    for (let i = 1; i <= B.length - A.length; i++) {

        // add frequency of new element and remove frequency of old element from bMAp
        const eleToRemove = B[i - 1];
        const eleToAdd = B[i + A.length - 1];

        if (bMap.has(eleToRemove)) {
            const currFreq = bMap.get(eleToRemove);
            if (currFreq === 1) {
                bMap.delete(eleToRemove);
            } else {
                bMap.set(eleToRemove, currFreq - 1);
            }
        }

        // get neededFreq for eleToRemove
        let neededFreq = aMap.has(eleToRemove) ? aMap.get(eleToRemove) : 0;
        let currentFreq = bMap.has(eleToRemove) ? bMap.get(eleToRemove) : 0;

        // if currentFreq < need total++
        if (currentFreq < neededFreq) {
            total++;
        }

        // update freq in bMap as ith element is getting inserted
        if (bMap.has(eleToAdd)) {
            bMap.set(eleToAdd, bMap.get(eleToAdd) + 1);
        } else {
            bMap.set(eleToAdd, 1);
        }
        // get neededFreq for eleToAdd
        neededFreq = aMap.has(eleToAdd) ? aMap.get(eleToAdd) : 0;
        currentFreq = bMap.has(eleToAdd) ? bMap.get(eleToAdd) : 0;

        // if currentFreq <= need total--
        if (bMap.get(eleToAdd) <= neededFreq) {
            total--;
        }

        // if total need becomes 0, we found the permutation
        if (total === 0) {
            count++;
        }
    }
    console.log(count);
    return count;
}

permutationsOfAInB("p", "pccdpeeooadeocdoacddapacaecb"); //expected output 3
permutationsOfAInB("abc", "abcbacabc"); //expected output 5
permutationsOfAInB("docp", "aoapeooeoapcpaocecddoocdcqqapeapccc"); //expected output 0