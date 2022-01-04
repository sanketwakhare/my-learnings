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
    console.log(N, 'is Prime? -->', isPrime);
    return isPrime;
}


isPrime(3);
isPrime(1);
isPrime(2);
isPrime(100);
isPrime(101);
isPrime(1);
isPrime(80);
isPrime(17);
isPrime(61);