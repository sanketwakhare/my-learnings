/****
 * Chocolate Distribution
 * 
 * Problem Description

Given an array A of N integers where each value represents number of chocolates in a packet.
i-th can have A[i] number of chocolates.

There are B number students, the task is to distribute chocolate packets following below conditions:
1. Each student gets one packet.
2. The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.

Problem Constraints
0 <= N <= 10^5
1 <= A[i] <= 10^7
0 <= B <= 10^5

Input Format
The first argument contains an integer array A.
The second argument contains an integer B.

Output Format
Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.

Example Input
Input:
  A : [3, 4, 1, 9, 56, 7, 9, 12]
  B : 5

Example Output
Output:
  6

Example Explanation
Explanation:
  Minimum Difference is 6
  The set goes like 3,4,7,9,9 and the output is 9-3 = 6
 */

/**
 * Find min difference
 * TC: O(N logN)
 * SC: O(1)
 * @param {Array} A array of integers
 * @param {Number} B no of students/packets to distribute
 * @returns 
 */
const findMinDiff = (A, B) => {

    // sort the array in ascending order
    A.sort((a, b) => a - b);

    // find out the min difference by comparing each start and end packet value
    let minDiff = Number.POSITIVE_INFINITY;
    for (let i = 0; i <= A.length - B; i++) {
        const diff = A[i + B - 1] - A[i];
        if (diff < minDiff) {
            minDiff = diff;
        }
    }

    // edge case 1: when B=0 
    // edge case 2: when minDiff = Infinity
    if (minDiff === Infinity || B === 0) {
        console.log(0);
        return 0;
    }
    console.log(minDiff);
    return minDiff;
}

findMinDiff([3, 4, 1, 9, 56, 7, 9, 12], 5);
findMinDiff([3, 4, 1, 2], 0);
findMinDiff([33, 34, 50, 19, 25], 3);
findMinDiff([2, 2, 2, 2, 2, 2, 2, 5], 1);