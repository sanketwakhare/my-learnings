/**
 * Inversion count in an array
 * 
 * Problem Description
Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Example Input
Input 1:
A = [3, 2, 1]
Input 2:
A = [1, 2, 3]

Example Output
Output 1:
3
Output 2:
0

Example Explanation
Explanation 1:
 All pairs are inversions.
Explanation 2:
 No inversions.
 */

/**
 * Find inversion count for a range [l, r]
 * @param {Array} A array of integers
 * @param {Number} l start index of first subarray
 * @param {Number} m start index of second subarray
 * @param {Number} r end index of second subarray
 * @returns this function performs the in place sorting and return the inversion count for a range
 */
const merge = (A, l, m, r) => {

    // p1 is associated with first subarray
    let p1 = l;
    // p2 is associated with second subarray
    let p2 = m;

    // p3 is associated with third subarray
    let p3 = 0;
    // size of new subarray would be r-l+1
    let temp = new Array(r - l + 1).fill(0);

    // maintain he inversion count
    let count = 0;
    while (p1 < m && p2 <= r) {
        if (A[p1] <= A[p2]) {
            temp[p3] = A[p1];
            p1++;
            p3++;
        } else {
            temp[p3] = A[p2];
            p2++;
            p3++;
            // if element pointing to p2 > element pointing to p1, increase the inversion count by m-p1
            // as all the elements between p1 and m would be greater than element pointing to p2
            count = (count + m - p1) % 1000000007;
        }
    }

    // perform for remaining elements after above conditions is met
    while (p1 < m) {
        temp[p3] = A[p1];
        p1++;
        p3++;
    }
    while (p2 <= r) {
        temp[p3] = A[p2];
        p2++;
        p3++;
        // no need to take count as at this point p1 = m and count would contribute 0 only
    }

    // push sorted temp array back to original array
    for (let i = 0; i < r - l + 1; i++) {
        A[l + i] = temp[i];
    }
    return count;

}

/**
 * Recursive function to calculate the inversion count
 * @param {Array} A array of integers
 * @param {Number} l 
 * @param {Number} r 
 * @returns returns the inversion count for a range [l,r]
 */
const inversion = (A, l, r) => {
    if (l === r) {
        return 0;
    }
    const mid = l + Math.floor((r - l) / 2);
    const x = inversion(A, l, mid);
    const y = inversion(A, mid + 1, r);
    const z = merge(A, l, mid + 1, r);
    return (x + y + z) % 1000000007;
}

/**
 * Inversion count
 * @param {Array} A array of integers
 * @returns 
 */
const inversionCountMain = (A) => {
    const ans = inversion(A, 0, A.length - 1);
    console.log(ans);
    return ans;
}


inversionCountMain([10, 3, 8, 15, 6, 12, 2, 18, 7, 1]);