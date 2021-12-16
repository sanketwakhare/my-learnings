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
    console.log('a^n mod d', '', A, N, D, 'is', Number(ans));
    // convert final answer to number/integer and return
    return Number(ans);
};

pow(213, 231, 1);
pow(67790475, 13522204, 98794224);
pow(-1, 2, 20);
pow(2, 50, 1000000000 + 7);