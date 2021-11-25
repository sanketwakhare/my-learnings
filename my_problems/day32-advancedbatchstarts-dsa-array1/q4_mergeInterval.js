/******
 * Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 10^5

Input Format
First argument is the vector of intervals
second argument is the new interval to be merged

Output Format
Return the vector of intervals after merging

Example Input
Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

Example Output
Output 1:
 [ [1, 5], [6, 9] ]
Output 2:
 [ [1, 9] ]

Example Explanation
Explanation 1:
(2,5) does not completely merge the given intervals
Explanation 2:
(2,6) completely merges the given intervals
 */

const mergeIntervals = (A, B) => {

    // sort the new interval B. make sure it is sorted.
    // this is done because one of the case was failing on submission
    B.sort((a, b) => a - b);

    const N = A.length;
    let result = [];
    let newIntervalStart = B[0];
    let newIntervalEnd = B[1];
    let i = 0;
    for (; i < N; i++) {
        const currentInterval = A[i];
        const currentIntervalStart = currentInterval[0];
        const currentIntervalEnd = currentInterval[1];

        if (newIntervalEnd < currentIntervalStart) {
            // find if newInterval can be inserted before currentInterval
            // insert before
            break;
        }
        else if (!(newIntervalStart > currentIntervalEnd)) {
            // overlapping intervals, form new interval range
            newIntervalStart = Math.min(currentIntervalStart, newIntervalStart);
            newIntervalEnd = Math.max(currentIntervalEnd, newIntervalEnd);

        } else {
            result.push(currentInterval);
        }
    }
    result.push([newIntervalStart, newIntervalEnd]);

    for (let k = i; k < N; k++) {
        result.push(A[k]);
    }

    console.log(result);
    return result;
}

mergeIntervals([[1, 3], [5, 9], [10, 11], [13, 16], [17, 20]], [7, 12]);
mergeIntervals([[1, 3], [6, 9]], [2, 5]);
mergeIntervals([[1, 10], [15, 25], [25, 35], [35, 45], [45, 50], [65, 80], [80, 90]], [30, 100]);