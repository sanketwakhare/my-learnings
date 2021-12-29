/**
 * Problem Description
Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].

Problem Constraints
1 <= N <= 1000000
-10^9 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the maximum value of j - i.

Example Input
Input 1:
A = [3, 5, 4, 2]

Example Output
Output 1:
2

Example Explanation
Explanation 1:
For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 
 */

/**
 * Test case 1:  A = [11, 5, 12, 4, 9, 2], expected output = 3
 * Test case 2:  A = [3, 5, 4, 2], expected output = 2
 * Test case 3:  A = [1, 5, 12, 4, 9], expected output = 4
 */

/**
 * Approach 2: Using prefix Min (LMin) and suffix Max (RMax)
 * TC: O(N)
 * SC: O(N) => for pf and sf arrays
 * @param {Array} A array of integers
 * @returns 
 */
const maximumGapApproach2 = (A) => {

    console.log('A -> ', A);
    const N = A.length;

    // Generate Prefix Min array
    let prefixMin = new Array(A.length).fill(0);
    prefixMin[0] = A[0];
    for (let i = 1; i < N; i++) {
        if (A[i] < prefixMin[i - 1]) {
            prefixMin[i] = A[i];
        } else {
            prefixMin[i] = prefixMin[i - 1];
        }
    }
    console.log('LMin -> ', prefixMin);

    // Generate suffix Max array
    let suffixMax = new Array(A.length).fill(0);
    suffixMax[N - 1] = A[N - 1];
    for (let i = N - 2; i >= 0; i--) {
        if (A[i] > suffixMax[i + 1]) {
            suffixMax[i] = A[i];
        } else {
            suffixMax[i] = suffixMax[i + 1];
        }
    }
    console.log('RMax -> ', suffixMax);

    // iterate both LMin(i) and RMax(j) and find the max (j-i)
    let i = 0;
    let j = 0;
    // Initialize maxDistance, as maxDistance can not be less than 0
    let maxDistance = 0;
    while (i < N && j < N) {
        // if condition is met, find the diff and increment j by 1
        if (prefixMin[i] <= suffixMax[j]) {
            diff = j - i;
            maxDistance = Math.max(diff, maxDistance);
            j++;
        } else {
            // else increment i by 1
            i++;
        }
    }

    console.log('MaxDistance (j-i) -> ', maxDistance);
    return maxDistance;

}

/**
 * Test Case 1: A = [11, 5, 12, 4, 9, 2], expected output = 3
 * Test Case 2: A = [3, 5, 4, 2], expected output = 2
 * Test Case 3: A = [1, 5, 12, 4, 9], expected output = 4
 * Test Case 4: A = [1, 5, 12, 9, 5, 4, 9], expected output = 6
 */
maximumGapApproach2([11, 5, 12, 4, 9, 2]);
maximumGapApproach2([3, 5, 4, 2]);
maximumGapApproach2([1, 5, 12, 4, 9]);
maximumGapApproach2([1, 5, 12, 9, 5, 4, 9]);