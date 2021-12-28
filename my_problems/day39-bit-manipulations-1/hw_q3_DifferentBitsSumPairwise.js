/*****
 * Problem Description

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 2^31 - 1

Input Format
First and only argument of input contains a single integer array A.

Output Format
Return a single integer denoting the sum.

Example Input
Input 1:
 A = [1, 3, 5]
Input 2:
 A = [2, 3]

Example Output
Output 1:
 8
Output 2:
 2

Example Explanation
Explanation 1:
 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:
 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
 */

/**
 * Link: https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/
 * Efficient Solution – 
 * An Efficient Solution can solve this problem in O(n) time 
 * using the fact that all numbers are represented using 32 bits (or some fixed number of bits). 
 * The idea is to count differences at individual bit positions. 
 * We traverse from 0 to 31 and count numbers with i’th bit set. 
 * Let this count be ‘count’. There would be “n-count” numbers with i’th bit not set. 
 * So count of differences at i’th bit would be “count * (n-count) * 2”, 
 * the reason for this formula is as every pair having one element which has set bit at i’th position 
 * and second element having unset bit at i’th position contributes exactly 1 to sum, 
 * therefore total permutation count will be count*(n-count) 
 * and multiply by 2 is due to one more repetition of all this type of pair as per given condition for making pair 1<=i, j<=N.
 * 
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A array of integers
 * @returns 
 */
const differentBitsSumPairWise = (A) => {

    const N = A.length;
    const M = 1000000007;
    let answer = 0;

    for (let i = 0; i < 32; i++) {

        // count ith set bits for each element in array
        let count = 0;
        for (let j = 0; j < A.length; j++) {
            if (A[j] & (1 << i)) {
                count++;
            }
        }

        // calculate the contribution of ith bit
        const contribution = count * (N - count) * 2;
        // add contribution value to answer
        answer = ((answer % M) + (contribution % M)) % M;

    }
    console.log(answer);
    return answer;

}

/**
 * Test case 1: [1, 3, 5], expected output => 8
 * Test case 2: [2, 3], expected output => 2
 * Test case 3: [2, 6, 5, 4, 8], expected output => 40
 * Test case 4: [9], expected output => 0
 */
differentBitsSumPairWise([1, 3, 5]);
differentBitsSumPairWise([2, 3]);
differentBitsSumPairWise([2, 6, 5, 4, 8]);
differentBitsSumPairWise([9]);