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