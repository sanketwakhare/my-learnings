/****************************************************************
Concatenate Three Numbers
Problem Description
Given three 2-digit integers, A, B and C, find out the minimum number that can be obtained by concatenating them in any order.
Return the minimum result that can be obtained.

Problem Constraints
10 <= A, B, C <= 99

Input Format
The first argument of input contains an integer, A.
The second argument of input contains an integer, B.
The third argument of input contains an integer, C.

Output Format
Return an integer, representing the answer.

Example Input
Input 1:
 A = 10
 B = 20
 C = 30
Input 2:
 A = 55
 B = 43
 C = 47 

Example Output
Output 1:
 102030 
Output 2:
 434755 

Example Explanation
Explanation 1:
 10 + 20 + 30 = 102030 
Explanation 2:
 43 + 47 + 55 = 434755 
*/

const concatenateThreeNos = function (A, B, C) {

    const numA = Number(A);
    const numB = Number(B);
    const numC = Number(C);

    let min = 99;
    let max = 10;

    min = Math.min(numA, numB);
    min = Math.min(min, numC);

    max = Math.max(numA, numB);
    max = Math.max(max, numC);

    let middleNo = min;
    if (numA !== min && numA !== max) {
        middleNo = numA;
    } else if (numB !== min && numB !== max) {
        middleNo = numB;
    } else if (numC !== min && numC !== max) {
        middleNo = numC;
    }

    if (numA === min && numB === min) {
        middleNo = numB;
    } else if (numA === max && numB === max) {
        middleNo = numB;
    } else if (numB === min && numC === min) {
        middleNo = numB;
    } else if (numB === max && numC === max) {
        middleNo = numB;
    } else if (numA === min && numC === min) {
        middleNo = numA;
    } else if (numA === max && numC === max) {
        middleNo = numA;
    }

    const result = '' + min + '' + middleNo + '' + max;
    console.log(result);
    return result;
}

concatenateThreeNos(10, 20, 30);
concatenateThreeNos(55, 43, 47);