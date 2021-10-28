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
const custPower = (A, N, D) => {

    if (N === 0) {
        return 1 % D;
    }

    let ans = custPower(A, Math.floor(N / 2), D);

    if (N % 2 === 0) {
        ans = ((ans % D) * (ans % D)) % D;
    } else {
        ans = ((ans % D) * (ans % D) * (A % D)) % D;
    }
    if (ans < 0) {
        ans = (ans % D + D) % D;
    }
    return ans;
}

const pow = (A, N, D) => {
    return custPower(A, N, D);
}


console.log(custPower(-1, 1, 20));
console.log(custPower(2, 5, 30));

console.log(custPower(2132, 0, 12));
console.log(custPower(-1, 2, 20));
console.log(custPower(71045970, 41535484, 64735492));