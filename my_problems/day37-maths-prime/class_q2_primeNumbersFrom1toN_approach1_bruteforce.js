/**
 * Iterations: sqrt(N)
 * TC: O(sqrt(N))
 * find if given number is prime or not
 * @param {Number} N integer number
 * @returns 
 */
const isPrime = (N) => {

    let isPrime = true;
    let count = 2;
    // iterate from 2 to sqrt(N)
    for (let i = 2; i * i <= N; i++) {
        if (N % i === 0) {
            count++;
            if (i !== Math.floor(N / i)) {
                // if i is a factor then N/i is also factor
                // count only when i != N/i
                count++;
            }
        }
    }
    if (count > 2 || N === 1) {
        isPrime = false;
    }
    return isPrime;
}

/**
 * TC: O(N * sqrt(N))
 * Brute force approach
 * @param {Number} N integer
 */
const primeFrom1ToN_approach1 = (N) => {

    // find prime numbers from 1 to N - Brute force approach
    let prime = [];
    for (let i = 1; i <= N; i++) {
        if (isPrime(i)) {
            prime.push(i);
        }
    }
    console.log(prime);
}

primeFrom1ToN_approach1(100);
primeFrom1ToN_approach1(300);