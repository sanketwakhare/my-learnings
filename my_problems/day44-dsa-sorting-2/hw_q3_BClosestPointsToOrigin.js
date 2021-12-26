/****
 * B Closest Points to Origin
 * 
 * Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000

Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.

Example Input
Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1

Example Output
Output 1:
 [ [-2, 2] ]
Output 2:
 [ [1, -1] ]

Example Explanation
Explanation 1:
 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */

/**
 * Find B closest point to origin (0,0)
 * Idea: Use custom sorting to calculate the distance
 * TC: O(N logN)
 * Space: B * 2 as 2d array
 * SC: O(B) => O(N)
 * @param {Array} A array of integers
 * @param {Number} B integer
 * @returns B closest points
 */
const BClosestPointsToOrigin = (A, B) => {

    // custom sort function to sort the array based on given formula
    A.sort((a, b) => {
        // point p1 coordinates
        const x1 = Math.abs(a[0]);
        const y1 = Math.abs(a[1]);
        // point p2 coordinates
        const x2 = Math.abs(b[0]);
        const y2 = Math.abs(b[1]);

        // find p1 and p2 values base on coordinates
        const p1 = Math.sqrt((x1 * x1) + (y1 * y1));
        const p2 = Math.sqrt((x2 * x2) + (y2 * y2));

        // sort in ascending order
        return p1 - p2;
    });

    // prepare output array of size B
    let output = [];
    for (let i = 0; i < B; i++) {
        output.push(A[i]);
    }
    console.log(output);
    return output;
}

BClosestPointsToOrigin([
    [1, 3],
    [-2, 2]
], 1);

BClosestPointsToOrigin([
    [1, -1],
    [2, -1]
], 1);