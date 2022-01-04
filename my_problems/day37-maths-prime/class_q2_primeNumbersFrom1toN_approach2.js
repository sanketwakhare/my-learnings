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
 * Find prime numbers from 1 to N
 * Iteration: N/2+N/3... + N/2+N/3... => logN + logN = 2 logN
 * TC: O(log(N))
 * SC: O(N)
 * @param {Number} N integer
 */
const primeFrom1ToN_approach2 = (N) => {

    // find prime numbers from 1 to N

    // initially consider all the numbers as prime
    let prime = new Array(N + 1).fill(true);

    // edge cases just to make the array consistent and correct
    prime[0] = false;
    // 1 is neither prime nor composite
    prime[1] = false;

    for (let i = 2; i * i <= N; i++) {
        if (prime[i] === true) {
            // i is prime here
            // now make i's multiples as non prime
            for (let j = i + i; j <= N; j = j + i) {
                prime[j] = false;
            }
        }
    }
    console.log(prime);

    let out = [];
    for (let i = 1; i <= N; i++) {
        if (prime[i]) {
            out.push(i);
        }
    }
    console.log(out);
}

primeFrom1ToN_approach2(100);
primeFrom1ToN_approach2(300);