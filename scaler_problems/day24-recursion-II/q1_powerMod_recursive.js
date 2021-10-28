/*****
 * Implement Power Function
Problem Description

Implement pow(x, n) % d.
In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
 */

/**
 * 
 * @param {Number} A base
 * @param {Number} N power
 * @param {Number} D mode
 * @returns 
 */
const custPower = (a, n, d) => {

    // convert to BigInt
    let A = BigInt(a);
    let N = BigInt(n);
    let D = BigInt(d);

    // anything raise to 0 is 1
    if (N === 0n) {
        return BigInt(1n % D);
    }

    // if N is 1
    // if N is -ve, add mod value to make it positive
    if (N === 1n) {
        let ans = BigInt(A % D);
        if (A < 0) {
            ans = BigInt(ans % D + D);
        }
        return ans;
    }

    // call recursivce function dividing N by 2
    let ans = BigInt(custPower(A, BigInt(N / 2n), D));

    // if power value N is more than 1
    if (N > 1n) {
        if (N % 2n === 0n) {
            // if power is even
            ans = ((ans % D) * (ans % D)) % D;
        } else {
            // if power is odd
            ans = ((ans % D) * (ans % D) * (A % D)) % D;
        }
        // if answer is -ve, add mod value D to final answer
        if (ans < 0) {
            ans = (ans % D + D) % D;
        }
    }
    return ans;
}

//param A : integer
//param B : integer
//param C : integer
//return an integer
const solve = (A, N, D) => {

    return Number(custPower(A, N, D));

}

console.log(custPower(-1, 1, 20));
console.log(custPower(2, 5, 30));

console.log(custPower(2132, 0, 12));
console.log(custPower(-1, 2, 20));
console.log(custPower(71045970, 41535484, 64735492));