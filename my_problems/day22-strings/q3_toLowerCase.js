/***
 * tolower()
Problem Description

You are given a function to_lower() consisting of a character array A.
Convert each charater of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.
Return the lowercase version of the given character array.

Problem Constraints
1 <= |A| <= 10^5

Input Format
Only argument is a character array A.

Output Format
Return the lowercase version of the given character array.

Example Input
Input 1:
 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:
 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']

Example Output
Output 1:
 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
Output 2:
 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Example Explanation
Explanation 1:
 All the characters in the returned array are in lowercase alphabets.
 */

const toLowerCase = (A) => {

    // ascii range of A-Z is 65 to 90
    // iterate over character array and convert lowercase characters into uppercase characters
    for (let i = 0; i < A.length; i++) {
        const currentCharacter = A[i];
        let currentCharCode = currentCharacter.charCodeAt(0);
        if (currentCharCode >= 65 && currentCharCode <= 90) {
            // toggle
            A[i] = String.fromCharCode(currentCharCode ^ 32);
        }
    }
    console.log(A);
    return A;
}

toLowerCase(['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']);