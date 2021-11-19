/******
 * Given two strings A and B, find if A is a subsequence of B.

Return "YES" if A is a subsequence of B, else return "NO".

Input Format
The first argument given is the string A.
The second argument given is the string B.

Output Format
Return "YES" if A is a subsequence of B, else return "NO".

Constraints
1 <= length(A), length(B) <= 100000
'a' <= A[i], B[i] <= 'z'

For Example
Input 1:
    A = "bit"
    B = "dfbkjijgbbiihbmmt"
Output 1:
    YES

Input 2:
    A = "apple"
    B = "appel"
Output 2:
    "NO"
 */

/**
 * Find if there exist a matching subsequence A in string B
 * @param {String} A input string A
 * @param {String} B input string B
 * @returns 
 */
const isSubSequenceExist = (A, B) => {
    // iterate over array A and also on array B
    // compare and find if every character in A exist in B in order

    let subSequenceFound = 'NO';
    let i = 0;
    for (let j = 0; j < B.length; j++) {

        if (A.charAt(i) === B.charAt(j)) {
            i++;
        }
        // if all the elements of A are iterated, it means subsequence is found
        if (i >= A.length) {
            subSequenceFound = 'YES';
            break;
        }
    }

    return subSequenceFound;
}

isSubSequenceExist('bit', 'dfbkjijgbbiihbmmt');