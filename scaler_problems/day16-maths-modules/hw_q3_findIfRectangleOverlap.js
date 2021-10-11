/****************************************************************
 * Find if two rectangles overlap
Problem Description

Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).

Find and return whether the two rectangles overlap or not.



Problem Constraints
-10000 <= A < C <= 10000
-10000 <= B < D <= 10000
-10000 <= E < G <= 10000
-10000 <= F < H <= 10000

Input Format
The eight arguments given are the integers A, B, C, D, E, F, G and H.

Output Format
Return 1 if the two rectangles overlap else return 0.

Example Input
Input 1:
A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 6   H = 6
Input 2:
A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 3   H = 3

Example Output
Output 1:
1
Output 2:
1

Example Explanation
Explanation 1:
rectangle with bottom left (2,2) and top right (4,4) is overlapping.
Explanation 2:

overlapping rectangles can be found
 */

/**
 *  
 * @param {*} A 
 * @param {*} B 
 * @param {*} C 
 * @param {*} D 
 * @param {*} E 
 * @param {*} F 
 * @param {*} G 
 * @param {*} H 
 * @returns 
 */
const findIfRectangleOverlapping = (A, B, C, D, E, F, G, H) => {

    // conditions for which rectangles are not overlapping.
    if (C <= E || D <= F || G <= A || H <= B) {
        console.log('not overlapping');
        return 0;
    }
    // else return 1
    console.log('overlapping');
    return 1;
}

findIfRectangleOverlapping(0, 0, 4, 4, 2, 2, 6, 6);
findIfRectangleOverlapping(0, 0, 4, 4, 2, 2, 3, 3);
findIfRectangleOverlapping(0, 0, 4, 4, 5, 5, 7, 7);
findIfRectangleOverlapping(0, 0, 4, 4, 2, 3, 7, 7);