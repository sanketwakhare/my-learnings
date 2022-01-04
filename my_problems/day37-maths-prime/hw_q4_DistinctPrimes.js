/* Distinct Primes */
/****
 * You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.

Input Format
The first argument given is an Array A, having N integers.

Output Format
Return an Integer, i.e number of distinct prime divisors of G.

Constraints
1 <= N <= 1e5
1 <= A[i] <= 1e5

For Example
Input:
    A = [1, 2, 3, 4]
Output:
     2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
 */


/**Generate smallestPrimeFactor array and return */
const smallestPrimeFactor = (N) => {

        let spf = new Array(N + 1);
        for (let i = 1; i <= N; i++) {
            spf[i] = i;
        }

        for (let i = 2; i * i <= N; i++) {
            if (spf[i] === i) {
                // i is prime number/prime factor
                for (let j = i * i; j <= N; j = j + i) {
                    // update factors if it is not already present
                    if (spf[j] === j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
    /**Count the no of Divisors for a given number N */
const countDistinctDivisorsOfN = (N, spf, set) => {

    while (N > 1) {
        let x = spf[N];
        if (N % x === 0) {
            N = N / x;
        }
        if (!set.has(x)) {
            set.add(x);
        }
    }
}

const distinctPrimes = function(A) {

    let hashSet = new Set();
    let max = A[0];
    for (let i = 0; i < A.length; i++) {
        max = Math.max(max, A[i]);
    }
    const spf = smallestPrimeFactor(max);
    for (let i = 0; i < A.length; i++) {
        countDistinctDivisorsOfN(A[i], spf, hashSet);
    }
    console.log(A, '-->', hashSet, hashSet.size);
    return hashSet.size;

}

distinctPrimes([1, 2, 3, 4]);
distinctPrimes([10, 33, 53, 98, 7, 19]);