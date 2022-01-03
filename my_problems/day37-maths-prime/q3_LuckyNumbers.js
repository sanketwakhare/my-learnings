/**
 * Lucky Numbers
 * 
 * Problem Description

A lucky number is a number which has exactly 2 distinct prime divisors.
You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

Problem Constraints
1 <= A <= 50000

Input Format
The first and only argument is an integer A.

Output Format
Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.

Example Input
Input 1:
 A = 8
Input 2:
 A = 12

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 Between [1, 8] there is only 1 lucky number i.e 6.
 6 has 2 distinct prime factors i.e 2 and 3.
Explanation 2:
 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */

/**
 * Iteration: N/2 for outer loop + N/2+N/3+N/5... = N/2 + N(logN)
 * TC: O(N log(N))
 * Find count of lucky numbers between 1 to N such that all the lucky numbers has exactly 2 distinct prime divisors
 * @param {Number} A integer
 * @returns 
 */
const luckyNumbers = (A) => {

    // generate count array to store the no of prime divisors count
    let count = new Array(A + 1).fill(0);

    // iterate no from 2 to N/2 and find all the factors
    for (let i = 2; i <= Math.floor(A / 2); i++) {
        if (count[i] === 0) {
            // if i prime no, its multiples are divisible by i
            for (let j = i + i; j <= A; j += i) {
                count[j]++;
            }
        }
    }

    let ans = 0;
    for (let i = 1; i <= count.length; i++) {
        // get those count whose factors are exactly 2 prime numbers
        if (count[i] === 2) {
            ans++;
        }
    }
    console.log('there is/are', ans, 'lucky numbers between 1 to ', A);
    return ans;
}

luckyNumbers(8);
luckyNumbers(12);
luckyNumbers(100);
luckyNumbers(5000);