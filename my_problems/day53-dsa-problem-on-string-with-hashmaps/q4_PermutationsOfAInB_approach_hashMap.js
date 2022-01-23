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
 * TC: O(N * 26) => O(N)
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

    // create freq map for first window of B
    let bMap = new Map();
    for (let i = 0; i < A.length; i++) {
        if (bMap.has(B[i])) {
            bMap.set(B[i], bMap.get(B[i]) + 1);
        } else {
            bMap.set(B[i], 1);
        }
    }

    // check if hashmap entries are matching both in a and b maps, and update count if required
    let count = 0;
    if (aMap.size === bMap.size) {
        let isFound = true;
        for (let [aKey, aVal] of aMap) {
            if (bMap.has(aKey)) {
                if (aVal !== bMap.get(aKey)) {
                    isFound = false;
                    break;
                }
            } else {
                isFound = false;
                break;
            }
        }
        if (isFound) {
            count++;
        }
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

        if (bMap.has(eleToAdd)) {
            bMap.set(eleToAdd, bMap.get(eleToAdd) + 1);
        } else {
            bMap.set(eleToAdd, 1);
        }

        // compare frequencies and update count
        if (aMap.size === bMap.size) {
            let isFound = true;
            for (let [aKey, aVal] of aMap) {
                if (bMap.has(aKey)) {
                    if (aVal !== bMap.get(aKey)) {
                        isFound = false;
                        break;
                    }
                } else {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                count++;
            }
        }

    }
    console.log(count);
    return count;
}

permutationsOfAInB("p", "pccdpeeooadeocdoacddapacaecb"); //expected output 3
permutationsOfAInB("abc", "abcbacabc"); //expected output 5