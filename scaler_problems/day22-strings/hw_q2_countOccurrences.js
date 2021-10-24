/***
 * Count Occurrences
Problem Description
Find number of occurrences of bob in the string A consisting of lowercase english alphabets.

Problem Constraints
1 <= |A| <= 1000

Input Format
The first and only argument contains the string A consisting of lowercase english alphabets.

Output Format
Return an integer containing the answer.

Example Input
Input 1:
  "abobc"
Input 2:
  "bobob"

Example Output
Output 1:
  1
Output 2:
  2

Example Explanation
Explanation 1:
  The only occurrence is at second position.
Explanation 2:
  Bob occures at first and third position.
 */

/**
 * Find no of occurrences of string 'bob'
 * @param {String} A input string
 * @returns 
 */
const countOccurrences = (A) => {
    let count = 0;
    const N = A.length;
    const subString = 'bob';
    const subStringLength = subString.length;

    // iterate will N- subStringLength
    for (let i = 0; i <= N - subStringLength; i++) {
        // is A[i] can be start of bob
        if (A[i] === 'b') {
            let j = i;
            let k = 0;
            let isSubStringMatching = false;
            // compare current substring with target substring
            while (A[j] === subString[k] && k < subStringLength) {
                j++;
                k++;
            }
            // verify if current substring is matching with target substring
            if (j - i === subStringLength) {
                isSubStringMatching = true;
                count++;
            }
        }
    }
    console.log(count);
    return count;
}

countOccurrences("bobob");
countOccurrences("bobabtbobl");
