/**
 * Count Total Set Bits
Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.

Example Input
Input 1:
 A = 3
Input 2:
 A = 1

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4

Explanation 2:
 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1
 */

/**
 * count set bit function
 */
const countSetBits = (a) => {
    let count = 0;
    for (let i = 0; i <= 31; i++) {
        if (a & (1 << i)) {
            count++;
        }
    }
    return count;
}

//param A : integer
//return an integer
/**
 * 
 * @param {Number} A integer number
 * @returns 
 */
const countTotalSetBits = (A) => {
    /**
     * Brute Force Approach
     */
    // const M = 1000000000 + 7;
    // let cnt = 0;

    // for (let i = 1; i <= A; i++) {
    //     cnt = ((cnt % M) + (countSetBits(i) % M)) % M;
    // }
    // return cnt;

    // Approach 2: Count bits horizontally form 0 to A or 1 to A + 1
    const M = 1000000000 + 7;
    let cnt = 0;
    const input = A + 1;

    let groupSize = Math.pow(2, 0);
    let i = 0;
    while (groupSize <= input) {

        let noOfGroups = Math.floor(input / groupSize);
        let onesGroupCount = Math.floor(noOfGroups / 2);

        let noOfOnes = onesGroupCount * groupSize;

        // consider only when noOfGroups are odd
        if ((noOfGroups % 2 !== 0) && (input % groupSize) > 0) {
            noOfOnes += input % groupSize;
        }
        cnt += noOfOnes;
        i = i + 1;
        groupSize = Math.pow(2, i);
    }

    return cnt % M;

}

countTotalSetBits(3);
countTotalSetBits(1);
countTotalSetBits(21);
countTotalSetBits(15);
countTotalSetBits(64);