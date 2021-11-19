
/********
 * Excel Column Number
Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.

Problem Constraints
1 <= length of the column title <= 5

Input Format
Input a string which represents the column title in excel sheet.

Output Format
Return a single integer which represents the corresponding column number.

Example Input
Input 1:
 AB
Input 2:
 ABCD

Example Output
Output 1:
 28
Output 2:
 19010

Example Explanation
Explanation 1:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */

/**
 * Find Column Number
 * 
 * @param {Array} A 
 * @returns columnNumber
 */
const titleToNumber = (A) => {
    // initial pow is 26^0 = 1
    let pow = 1;
    let columnNumber = 0;
    for (let i = A.length - 1; i >= 0; i--) {

        // A.charCodeAt(i) = ASCII value
        columnNumber += (A.charCodeAt(i) - 64) * pow;

        // subsequent pow = pow * 26
        pow = pow * 26;
    }
    return columnNumber;
}