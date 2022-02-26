/* Spelling Checker */

/* Problem Description
Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.



Problem Constraints
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000



Input Format
First argument is array of strings A.

First argument is array of strings B.



Output Format
Return the binary array of integers according to the given format.



Example Input
Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output
Output 1:

[1, 0]
Output 2:

[0, 0]


Example Explanation
Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.
 */

// TrieNode structure
function TrieNode(value) {
    this.data = value;
    this.children = new Array(26).fill(null, 0, 25);
    this.isEnd = false;
    return this;
}

const spellChecker = (A, B) => {
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
            }
            temp = temp.children[ind];
        }
        temp.isEnd = true;
    }

    // check for each word presence of array B in Trie
    let output = [];
    for (let i = 0; i < B.length; i++) {
        let temp = trie;
        let currentWord = B[i];
        let ind = -1;
        for (let j = 0; j < currentWord.length; j++) {
            ind = currentWord[j].charCodeAt(0) - 'a'.charCodeAt(0);
            temp = temp.children[ind];
            if (temp == null) {
                output[i] = 0;
                break;
            } else if (temp.data === currentWord[j] && temp.isEnd === true) {
                output[i] = 1;
            } else {
                output[i] = 0;
            }
        }
    }

    console.log(output);
    return output;
}

let A = ["hat", "cat", "rat"];
let B = ["cat", "ball"];
spellChecker(A, B);

A = ["tape", "bcci"]
B = ["table", "cci"]
spellChecker(A, B);