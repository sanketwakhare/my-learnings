/**
 * Prime Subsequences
 * 
Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.

A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.

Input Format
The first argument given is an Array A, having N integers.
Output Format
Return an integer X, i.e number of Prime subsequences. 
As X can be very large print X % (1000000007), here % is modulus operator.

Constraints
1 <= N <= 1e3
1 <= A[i] <= 1e6

For Example
Input:
    A = [1, 2, 3]
Output:
     3

Explanation:
    no. Subsequences      Prime subsequences
    1.  [1]                     No
    2.  [1, 2]                  No
    3.  [1, 3]                  No
    4.  [1, 2, 3]               No
    5.  [2]                     Yes
    6.  [2, 3]                  Yes
    7.  [3]                     Yes
    8.  []                      No

    here we have 3 subsequences(5, 6, 7) those have only prime number(s). 
 */

/** Power Mod function */
const powerRec = (A, N, D) => {

    // base conditions
    if (N === BigInt(0)) {
        return BigInt(BigInt(1) % D);
    }
    if (N === BigInt(1)) {
        return BigInt(A % D);
    }

    // calculate A^N/2 only once and reuse 
    const p = powerRec(BigInt(A), BigInt(N / BigInt(2)), BigInt(D));

    let ans = BigInt(BigInt(p % D) * BigInt(p % D)) % D;

    // calculate answer based on power N if that is even or odd
    if (N % BigInt(2) === BigInt(0)) {
        // even power
        return BigInt(ans % D);
    } else {
        // odd power
        ans = BigInt(BigInt(A % D) * BigInt(ans % D)) % D;
    }
    return BigInt(ans % D);
};

/**
 * Find count of prime subsequences of A
 * @param {Array} A array of integers
 * @returns integer
 */
const primeSubsequence = function(A) {

    // find no of prime numbers from 1 to N = p

    // find max element from array
    let max = A[0];
    for (let i = 0; i < A.length; i++) {
        max = Math.max(max, A[i]);
    }

    let N = max;
    let prime = new Array(N + 1).fill(1);
    prime[0] = 0;
    prime[1] = 0;
    for (let i = 2; i * i <= N; i++) {
        if (prime[i] === 1) {
            // i is prime number
            for (let j = i * i; j <= N; j = j + i) {
                // mark prime[j] = false
                prime[j] = 0;
            }
        }
    }
    // find the count of prime numbers from array = p
    let count = 0;
    for (let i = 0; i < A.length; i++) {
        if (prime[A[i]] === 1) {
            count++;
        }
    }

    // answer would be (2^p) - 1 subsequences
    let d = BigInt(1000000007);
    let ans = powerRec(BigInt(2), BigInt(count), d) - BigInt(1);
    // if ans is -ve, add mod d value to ans as remainder is always +ve
    if (ans < 0) {
        ans = ans + d;
    }
    console.log(Number(ans));
    return Number(ans);

}

primeSubsequence([1, 2, 3]);
primeSubsequence([4, 17, 5, 3, 2, 11]);