/*****
 * Single Number II
 * 
 * Problem Description

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints

2 <= A <= 5*106

0 <= A <= INTMAX



Input Format

First and only argument of input contains an integer array A.



Output Format

Return a single integer.



Example Input

Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.
 * Find that number
 * TC: O(32 * N)
 * @param {Array} A 
 * @returns 
 */
const singleNumberII = (A) => {
    // Approach: find contribution of set bits for all array elements
    // in the final contribution, if the contribution of set bit %3 is non zero , that means that element is not repeating thrice

    let ans = 0;
    // for every bit position, find the total contribution for all array elements
    for (let i = 0; i < 32; i++) {

        let contributionOfIthBit = 0;
        for (let j = 0; j < A.length; j++) {
            // count if ith bit is set
            if (A[j] & (1 << i)) {
                contributionOfIthBit++;
            }
        }
        if ((contributionOfIthBit % 3) > 0) {
            // that means, ith bit will be set in answer element
            ans = ans | (1 << i);
        }
    }
    console.log(ans);
    return ans;

}

singleNumberII([1, 2, 4, 3, 3, 2, 2, 3, 1, 1]);
singleNumberII([4, 4, 3, 3, 2, 5, 6, 5, 6, 5, 6, 3, 2, 2]);