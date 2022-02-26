/* Shortest Unique Prefix */

/* Problem Description

Given a list of N words. Find shortest unique prefix to represent each word in the list.

NOTE: Assume that no word is prefix of another. In other words, the representation is always possible



Problem Constraints

1 <= Sum of length of all words <= 106



Input Format

First and only argument is a string array of size N.



Output Format

Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.



Example Input

Input 1:

 A = ["zebra", "dog", "duck", "dove"]
Input 2:

A = ["apple", "ball", "cat"]


Example Output

Output 1:

 ["z", "dog", "du", "dov"]
Output 2:

 ["a", "b", "c"]


Example Explanation

Explanation 1:

 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:

 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */

// TrieNode structure
function TrieNode(value) {
    this.data = value;
    this.children = new Array(26).fill(null, 0, 25);
    this.isEnd = false;
    this.freq = 1;
    return this;
}

//param A : array of strings
//return a array of strings
const shortestUniquePrefix = (A) => {

    // prepare Trie for all words/dictionary
    let trie = new TrieNode(null);
    for (let i = 0; i < A.length; i++) {
        let temp = trie;
        let currentWord = A[i];
        let ind = -1;
        for (let j = 0; j < currentWord.length; j++) {
            ind = currentWord[j].charCodeAt(0) - 'a'.charCodeAt(0);
            if (temp.children[ind] == null) {
                temp.children[ind] = new TrieNode(currentWord[j]);
            } else {
                temp.children[ind].freq++;
            }
            temp = temp.children[ind];
        }
        temp.isEnd = true;
    }

    // check for each word presence of array B in Trie
    let output = [];
    for (let i = 0; i < A.length; i++) {
        let temp = trie;
        let currentWord = A[i];
        let ind = -1;
        let currentPref = '';
        for (let j = 0; j < currentWord.length; j++) {
            ind = currentWord[j].charCodeAt(0) - 'a'.charCodeAt(0);
            temp = temp.children[ind];
            if (temp.data === currentWord[j] && temp.freq === 1) {
                currentPref += currentWord[j];
                break;
            } else {
                currentPref += currentWord[j];
            }
        }
        output[i] = currentPref;
    }
    console.log(output);
    return output;
}

let A = ["zebra", "dog", "duck", "dove"];
shortestUniquePrefix(A);
A = ["apple", "ball", "cat"];
shortestUniquePrefix(A);