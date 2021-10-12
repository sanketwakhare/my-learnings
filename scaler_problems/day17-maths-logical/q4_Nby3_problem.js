/********
 * N/3 Repeat Number
Problem Description

You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example:

Input: [1 2 3 1 1]
Output: 1 
1 occurs 3 times which is more than 5/3 times.
 */

/***
 * TC: O(N)
 * SC: O(1)
 * > N/3 element
 * @param {Array} A 
 * @returns 
 */
const findGreaterThanNBy3Element = function (A) {
    // N/3 elements means take 3-1 = 2 bags and 1 dustbin

    // for each bag, maintain element and frequency

    // initialize bag1
    let x = A[0];
    let ele1 = x;
    let freq1 = 1;
    let ele2;
    let freq2 = 0;

    for (let i = 1; i < A.length; i++) {
        x = A[i];
        if (x === ele1 || x === ele2) {
            // if x is already present in one of the bags
            if (x === ele1) {
                freq1++;
            } else {
                freq2++;
            }
        } else if (freq1 === 0 || freq2 === 0) {
            // if bag is empty
            if (freq1 === 0) {
                ele1 = x;
                freq1++;
            } else {
                ele2 = x;
                freq2++;
            }
        } else {
            // else remove 1 element from each bag
            freq1--;
            freq2--;
        }
    }

    // now find, if there is any element from either of the bag which is repeated >? N/3 times
    let count1 = 0;
    let count2 = 0;
    for (let i = 0; i < A.length; i++) {
        if (A[i] === ele1) {
            count1++;
        } else if (A[i] === ele2) {
            count2++;
        }
    }

    if (count1 > Math.floor(A.length / 3)) {
        return ele1;
    } else if (count2 > Math.floor(A.length / 3)) {
        return ele2;
    }

    return -1;

}