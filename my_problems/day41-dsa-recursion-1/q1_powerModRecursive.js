/*****
 * Implement Power Function
 * 
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
 * Power Mod recursive function
 * @param {Number} A base
 * @param {Number} N power
 * @param {Number} D mod value
 * @returns 
 */
const powerRec = (A, N, D) => {

    // base conditions
    if (N === BigInt(0)) {
        return BigInt(1 % D);
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

/****
 * Recursive Relation Proof:
 * TC: O(logN)
 * Proof: 
 * Assumption: T(0) = 1 and T(1) = 1 for base conditions
 * 
 * T(N) = T(N/2) + 1
 *  Use substitution method
 *  T(N/2) = T(N/4) + 1
 * 
 * T(N) = T(N/4) + 2
 * 
 *  T(N/4) = T(N/16) + 1
 * 
 * T(N) = T(N/16) + 3
 * 
 * T(N) = T(N/2^k) + k-1
 * 
 * 
 * N/2^k = 1 => N = 2^k => Take log o both side
 * 
 * logN base 2 = log 2^k base 2 = k
 * 
 * logN = K
 * 
 * T(N) = T(1) + logN = 1+ logN = logN
 * 
 * TC: O(logN)
 * 
 */
//param A : integer
//param B : integer
//param C : integer
//return an integer
const pow = (A, N, D) => {
    const a = BigInt(A);
    const n = BigInt(N);
    const d = BigInt(D);
    let ans = powerRec(a, n, d);
    // if ans is -ve, add mod d value to ans as remainder is always +ve
    if (ans < 0) {
        ans = ans + d;
    }
    console.log(A, '^', N, 'mod', D, '=', Number(ans));
    // convert final answer to number/integer and return
    return Number(ans);
};

pow(213, 231, 1);
pow(67790475, 13522204, 98794224);
pow(-1, 2, 20);
pow(2, 50, 1000000000 + 7);
pow(0, 10, 5);