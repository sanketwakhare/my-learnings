/**
* Problem Description

Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.

A-1 mod B is also known as modular multiplicative inverse of A under modulo B.



Problem Constraints

1 <= A <= 109
1<= B <= 109
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

public class Solution {
    public long myPower(long a,long n, long m) {
        if(n==0) {
            return 1 % m;
        }
        if(n==1) {
            return a % m;
        }
        long p = myPower(a,n/2,m);
        long value = ((p%m) * (p%m))%m;

        if(n%2 != 0) {
            value = ((value % m) * (a % m)) % m;
        }
        return value % m;
    }

    public int solve(int A, int B) {

        // Using Fermat's little Theorem
        // [A^(p-2) % m = A^(-1) % m] ~~~ A^(p-2) === A^(-1) mod(m)

        // here B is prime no
        int ans =  (int)myPower(A,B-2,B);
        if(ans < 0) {
            ans = ans + B;
        }
        return ans;
        
    }
}
