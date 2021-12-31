/****
 * Very Large Power
 * 
 * Problem Description
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
"^" means power ,
"%" means "mod", and
"!" means factorial.

Problem Constraints
1 <= A, B <= 5e5

Input Format
First argument is the integer A
Second argument is the integer B

Output Format
Return one integer, the answer to the problem

Example Input
Input 1:
A = 1
B = 1
Input 2:
A = 2
B = 2

Example Output
Output 1:
1
Output 2:
4

Example Explanation
Explanation 1:
 1! = 1. Hence 1^1 = 1.
Explanation 2:
 2! = 2. Hence 2^2 = 4.
 */

// power mod function
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

// factorial function iterative approach to avoid out of heap/memory error
const factItr = (A, d) => {
    let ans = BigInt(1);
    for (let i = 2; i <= A; i++) {
        ans = ((ans % d) * (BigInt(i) % d)) % d;
    }
    return ans;
}

//param A : integer
//param B : integer
//return an integer
const veryLargePower = (A, B) => {

    const a = BigInt(A);
    const d = BigInt(1000000007);

    // this d-1 is applicable base on some theorem for factorial
    const dMinusOne = BigInt(1000000006);
    const n = BigInt(BigInt(factItr(B, dMinusOne)));

    // modulo exponential function
    let ans = powerRec(a, n, d);
    // if ans is -ve, add mod d value to ans as remainder is always +ve
    if (ans < 0) {
        ans = ans + d;
    }

    // convert final answer to number/integer and return
    console.log(Number(ans));
    return Number(ans);
}

veryLargePower(1, 1);
veryLargePower(2, 2);
veryLargePower(6238, 9536); // should not get JavaScript heap out of memory