/*****
 * Problem Description

Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
A-1 mod B is also known as modular multiplicative inverse of A under modulo B.

Problem Constraints
1 <= A <= 10^9
1<= B <= 10^9
B is a prime number

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the modulor inverse

Example Input
Input 1:
 A = 3
 B = 5
Input 2:
 A = 6
 B = 23

Example Output
Output 1:
 2
Output 2:
 4

Example Explanation
Explanation 1:
 Let's say A-1 mod B = X, then (A * X) % B = 1.
 3 * 2 = 6, 6 % 5 = 1.
Explanation 2:
 Similarly, (6 * 4) % 23 = 1.
 */

const powerMod = (a, n, d) => {

    // convert to BigInt
    let A = BigInt(a);
    let N = BigInt(n);
    let D = BigInt(d);

    // anything raise to 0 is 1
    if (N === BigInt(0)) {
        return BigInt(BigInt(1) % D);
    }

    // if N is 1
    // if N is -ve, add mod value to make it positive
    if (N === BigInt(1)) {
        let ans = BigInt(A % D);
        if (A < 0) {
            ans = BigInt(ans % D + D);
        }
        return ans;
    }

    // call recursive function dividing N by 2
    let ans = BigInt(powerMod(A, BigInt(N / BigInt(2)), D));

    // if power value N is more than 1
    if (N > BigInt(1)) {
        if (N % BigInt(2) === BigInt(0)) {
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
//return an integer
const primeModuloInverse = (A, B) => {
    // Using Fermat's little Theorem
    // [A^(p-2) % m = A^(-1) % m] ~~~ A^(p-2) === A^(-1) mod(m)

    // here B is prime no and A < B
    let answer = Number(powerMod(A, B - 2, B));
    console.log(answer);
    return answer;
}

primeModuloInverse(3, 5);
primeModuloInverse(6, 23);
primeModuloInverse(37, 102);