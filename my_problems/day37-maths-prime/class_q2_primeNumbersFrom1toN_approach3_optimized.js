/**
 * Find prime numbers from 1 to N
 * Iteration: < 2logN => more optimized as compared to approach 2
 * TC: O(log(N))
 * SC: O(N)
 * @param {Number} N integer
 */
const primeFrom1ToN_approach3 = (N) => {

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
            // observation: teh multiples are already considered/cancelled till sqr(N)
            for (let j = i * i; j <= N; j = j + i) {
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

primeFrom1ToN_approach3(100);
primeFrom1ToN_approach3(300);