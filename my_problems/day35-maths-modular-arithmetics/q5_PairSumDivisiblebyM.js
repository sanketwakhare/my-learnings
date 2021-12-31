/*****
 * Pair Sum divisible by M
 * 
 * Problem Description

Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (10^9 + 7).

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:
 A = [5, 17, 100, 11]
 B = 28

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
 */

/**
 * TC: (N+M)
 * Find (no of pairs divisible by M) % 10^9+7
 * @param {Array} A array of integers
 * @param {Number} M integer mod value
 * @returns 
 */
const countPairSumDivisibleByM = (A, M) => {

    let N = A.length;
    const p = BigInt(1000000007);

    // create frequency map
    let freq = new Array(M).fill(BigInt(0));

    // populate frequency map/array
    for (let i = 0; i < N; i++) {
        const value = BigInt(A[i] % M);
        freq[value] = freq[value] + BigInt(1);
    }

    let answer = BigInt(0);

    // add contribution of 0 index - nC2
    let contribution = freq[0] * (freq[0] - BigInt(1)) / BigInt(2);
    answer = (answer % p + contribution % p) % p;

    // add contribution of M/2 index if M is even - nC2
    if (M % 2 === 0) {
        let contribution = freq[M / 2] * (freq[M / 2] - BigInt(1)) / BigInt(2);
        answer = (answer % p + contribution % p) % p;
    }

    // add contribution of i and M-i indexes together - freq[i] * freq[j]
    let i = 1;
    let j = freq.length - 1;
    while (i < j) {
        let contribution = ((freq[i]) % p * (freq[j]) % p) % p;
        answer = (answer % p + contribution % p) % p;
        i++;
        j--;
    }

    console.log('answer -> ', answer);
    return Number(answer);

}

countPairSumDivisibleByM([5, 17, 100, 11], 28);
countPairSumDivisibleByM([13, 14, 22, 3, 32, 19, 16], 4);
countPairSumDivisibleByM([4, 7, 6, 5, 5, 3], 3);