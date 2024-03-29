/****
 * Prime Addition
 * 
 * You are given an even number N and you need to represent the given number as the sum of primes. The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.
You need to determine the minimum number of prime numbers needed to represent the given number.

Input
The first argument contains an integer N,the number you need to represent (3<=N<=10^9).

Output
Return an integer which is the minimum number of prime numbers needed to represent the given number N.

Examples
Input
26
Output
2

Explanation
Test case 1-
You can represent 26 as: 13+13
So we require minimum of 2 prime numbers to represent the number 26.
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

/*
References
https://www.geeksforgeeks.org/minimum-number-of-primes-required-such-that-their-sum-is-equal-to-n/
*/

/**
 * Return minimum distinct prime numbers by which the A is sum
 * e.g. 13+13 = 26
 * e.g. 2+0 = 1
 * e.g. 7+11 = 18
 * @param {Number} A integer
 * @returns integer - count of distinct prime numbers with sum = A
 */
const primeAddition = (A) => {
    // if A is prime, return 1
    if (isPrime(A)) {
        answer = 1;
    } else if(A % 2 === 0) {
        answer = 2;
    } else  if(isPrime(A -2)) {
        answer = 2;
    } else {
        answer = 3;
    }
    console.log(answer);
    return answer;
}

primeAddition(26);
primeAddition(27);
primeAddition(2);
primeAddition(10004);
primeAddition(14448);