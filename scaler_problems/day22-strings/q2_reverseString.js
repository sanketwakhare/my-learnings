/**
 * Simple Reverse

Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.

Problem Constraints
1 <= |A| <= 10^5

String A consist only of lowercase characters.

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the reversed string.

Example Input
Input 1:
 A = "scaler"
Input 2:
 A = "academy"

Example Output
Output 1:
 "relacs"
Output 2:
 "ymedaca"

Example Explanation
Explanation 1:
 Reverse the given string.
 */

/**
 * Reverse the given string
 * @param {String} A 
 */
const reverse = (A) => {

    let reversedString = A.split('');
    let start = 0;
    let end = A.length - 1;
    while (start < end) {
        // swap start and end characters
        let temp = reversedString[start];
        reversedString[start] = reversedString[end];
        reversedString[end] = temp;
        start++;
        end--;
    }
    console.log(reversedString);

    let output = '';
    for (let i = 0; i < reversedString.length; i++) {
        output += reversedString[i];
    }

    console.log(output);

}
reverse("scaler");
reverse("love javascript")