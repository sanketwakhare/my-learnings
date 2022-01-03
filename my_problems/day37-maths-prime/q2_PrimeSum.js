/**
 * Prime Sum
 * 
Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
If there are more than one solutions possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.

Problem Constraints
4 <= A <= 2*10^7

Input Format
First and only argument of input is an even number A.

Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.

Example Input
 4

Example Output
 [2, 2]

Example Explanation
 There is only 1 solution for A = 4.
 */

/**
 * TC: O(sqrt(N))
 * is prime function to identify if given number is prime or not
 * Count no of factors till sqrt(N).
 * Observations : there will be exactly 2 factors for prime numbers between 1 to sqrt(N)
 * @param {Number} N integer
 * @returns boolean
 */
const isPrime = (N) => {
    let count = 2;
    for (let i = 2; i * i <= N; i++) {
        if (N % i === 0) {
            count++;
            if (i != N / i) {
                count++;
            }
        }
    }
    if (count > 2) {
        return false;
    }
    return true;
}

/**
 * Iteration: N/2 for outer loop * sqrt(N) for isPrime function
 * TC: O(N sqrt(N))
 * SC: O(1)
 * Find two prime numbers whose sum is given number A
 * It is guaranteed to have sum as per Gold bach's conjecture
 * @param {Number} A integer
 * @returns array of 2 prime numbers with sum A
 */
const primeSum = (A) => {
    let output = [];
    // if i is prime, then A-i must be prime to satisfy the condition
    for (let i = 2; i <= Math.floor(A / 2); i++) {
        if (isPrime(i)) {
            const j = A - i;
            if (isPrime(j)) {
                output = [i, j];
                break;
            }
        }
    }
    console.log(A, '->', output);
    return output;
}

primeSum(4);
primeSum(8);
primeSum(100);
primeSum(500);
primeSum(334);