/****
 * Problem Description

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
 * 
 * @param {String} A input string A
 * @param {String} B input string B
 * @returns 
 */
const findPermutationsOfAinB = (A, B) => {

    const N = A.length;
    const M = B.length;
    let count = 0;

    // store frequencey of each char in strin A hashMapA
    let hashMapA = new Map();
    for (let i = 0; i < N; i++) {
        const currentChar = A.charAt(i);
        if (!hashMapA.has(currentChar)) {
            hashMapA.set(currentChar, 1);
        } else {
            hashMapA.set(currentChar, hashMapA.get(currentChar) + 1)
        }
    }

    //  store all elements of first window in hashMapB
    let hashMapB = new Map();
    for (let j = 0; j < N; j++) {
        const currentChar = B.charAt(j);
        if (!hashMapB.has(currentChar)) {
            hashMapB.set(currentChar, 1);
        } else {
            hashMapB.set(currentChar, hashMapB.get(currentChar) + 1);
        }
    }

    // now compare the frequencies of A and window B 
    let isCombinationPresent = true;
    if (hashMapA.size === hashMapB.size) {
        const mapAKeys = hashMapA.keys();
        let value = mapAKeys.next().value;
        while (value !== undefined) {
            const freqA = hashMapA.get(value);
            const freqB = hashMapB.get(value);
            if (freqA !== freqB) {
                isCombinationPresent = false;
                break;
            }
            value = mapAKeys.next().value;
        }
        //  increase count if all frequencies of A and window of B matches
        if (isCombinationPresent) {
            count++;
        }
    }

    // take each window from 2nd window of size A from string B
    for (let i = 1; i < M - N + 1; i++) {

        // remove frequency of character i-1 from hashMap B 
        const prevChar = B.charAt(i - 1);
        if (hashMapB.has(prevChar)) {
            let currFreq = hashMapB.get(prevChar);
            currFreq = currFreq - 1;
            if (currFreq > 0) {
                hashMapB.set(prevChar, currFreq);
            }
            else {
                hashMapB.delete(prevChar);
            }
        }

        // add freq of last char of window i hashMapB
        const lastChar = B.charAt(i + N - 1);
        if (!hashMapB.has(lastChar)) {
            hashMapB.set(lastChar, 1);
        } else {
            hashMapB.set(lastChar, hashMapB.get(lastChar) + 1);
        }

        // now compare the frequencies of A and window B 
        isCombinationPresent = true;
        if (hashMapA.size === hashMapB.size) {
            const mapAKeys = hashMapA.keys();
            let value = mapAKeys.next().value;
            while (value !== undefined) {
                const freqA = hashMapA.get(value);
                const freqB = hashMapB.get(value);
                if (freqA !== freqB) {
                    isCombinationPresent = false;
                    break;
                }
                value = mapAKeys.next().value;
            }
            //  increase count if all frequencies of A and window of B matches
            if (isCombinationPresent) {
                count++;
            }
        }
    }
    return count;
}

findPermutationsOfAinB('ebbp', 'qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc');
