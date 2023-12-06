/*
Sumonacci

Problem Description

You already know what Fibonacci number is.

It is the sequece F[1], F[2], F[3], ... such that for all i > 2, F[i] = F[i-1] + F[i-2] holds true.

Now, let S[i] denote the sum of the first i fibonacci numbers (i.e S[i] = F[1] + F[2]...F[i]), let's call this the i-th Sumonacci number.

Given the values of F[1] and F[2], your task is to find the sum of the first A Sumonacci numbers. (modulo 109+7)



Problem Constraints

1 <= A <= 10^9
0 <= F[1] <= 10^9
0 <= F[2] <= 10^9

Input Format

The first argument to the input is A.
The second to the input is B - the first Fibonacci number i.e F[1]
The third to the input is C - the second Fibonacci number i.e F[2]


Output Format

Your function should return an integer, the sum of the first A Sumonacci numbers (modulo 109+7).



Example Input

Input 1:

 A: 2
 B: 3
 C: 4
Input 2:

 A: 3
 B: 1
 C: 1


Example Output

Output 1:

 10
Output 2:

 7


Example Explanation

Explanation 1:

 S[1] = F[1] = 3
 S[2] = F[1] + F[2] = 7
 Thus, answer is 3 + 7 = 10.
Explanation 2:

 S[1] = F[1] = 1
 S[2] = F[1] + F[2] = 2
 S[3] = F[1] + F[2] + F[3] = F[1] + F[2] + (F[1] + F[2]) = 4
 Therefore, the answer is 1 + 2 + 4 = 7.
 */
public class q2_Sumonacci {

    public static void main(String[] args) {
        q2_Sumonacci t = new q2_Sumonacci();
        {
            int A = 2;
            int B = 3;
            int C = 4;
            System.out.println(t.solve(A, B, C)); // 10
        }
        {
            int A = 3;
            int B = 1;
            int C = 1;
            System.out.println(t.solve(A, B, C)); // 7
        }
        {
            int A = 5;
            int B = 3;
            int C = 3;
            System.out.println(t.solve(A, B, C)); // 78
        }
        {
            int A = 1315;
            int B = 451518149;
            int C = 205836547;
            System.out.println(t.solve(A, B, C)); // 184559342
        }
    }
    /*
    F(n) = nth Fibonacci number = F(n-1) = F(n-2)
    S(n) = sum of first n Fibonacci numbers = (nth Sumonacci number)
            = F(1) + F(2) + F(3) + ...+ F(n-1) + F(n)
                replace F(1) + F(2) + F(3) + ...+ F(n-1) with S(n-1)
            = S(n-1) + F(n)
                replace F(n) with F(n-1) + F(n-2)
            = S(n-1) + F(n-1) + F(n-2)
    SS(n) = sum of first n Sumonacci numbers
            = S(1) + S(2) + S(3) + ... + S(n-1) + S(n)
                replace S(1) + S(2) + S(3) + ... + S(n-1) with SS(n-1)
            = SS(n-1) + S(n)
                replace S(n) with S(n-1) + F(n-1) + F(n-2)
            = SS(n-1) + S(n-1) + F(n-1) + F(n-2)

     Given F(1) and F(2), we can find S(1), S(2), SS(1) amd SS(2) as below
     S(1) = F(1)
     S(2) = F(1) + F(2)
     SS(1) = S(1)
     SS(2) = S(1) + S(2)

     SS(n) = SS(n-1) + S(n-1) + F(n-1) + F(n-2)
     S(n) = S(n-1) + F(n-1) + F(n-2)
     F(n) = F(n-1) + F(n-2)

     [[SS(n)], [S(n)], [F(n)], [F(n-1)]] =  [[1, 1, 1, 1] * [[SS(n-1)], [S(n-1)], [F(n-1)], [F(n-2)]]
                                            [0, 1, 1, 1]
                                            [0, 0, 1, 1]
                                            [0, 0, 1, 0]}

                                  M(n) = x * M(n-1)
                                  M(n) = x * x * M(n-2)
                                  M(n) = x^2 * M(n-2)
                                  M(n) = x^3 * M(n-3)
                                  M(n) = x^k * M(n-k)

                                  we know M(2) = [[SS(2)], [S(2)], [F(2)], [F(1)]]

                                  n - k = 2
                                  k = n - 2

                                  replace value of k as n - 2

                                  M(n) = x^(n-2) * M(2)

      [[SS(n)], [S(n)], [F(n)], [F(n-1)]] = [[1, 1, 1, 1] ^ (n-2) * [[SS(2)], [S(2)], [F(2)], [F(1)]]
                                            [0, 1, 1, 1]
                                            [0, 0, 1, 1]
                                            [0, 0, 1, 0]}

      [[SS(n)]  = [[1, 1, 1, 1] ^ (n-2)    *  [[SS(2)],
       [S(n)]      [0, 1, 1, 1]                [S(2)],
       [F(n)]      [0, 0, 1, 1]                [F(2)],
       [F(n-1)]    [0, 0, 1, 0]}               [F(1)]]

     */

    long mod = 1000000007;

    public int solve(int n, int f1, int f2) {

        long s1 = f1;
        long s2 = f2 + f1;
        long ss1 = s1;
        long ss2 = s1 + s2;

        if (n == 1) return (int) ss1;
        if (n == 2) return (int) ss2;
        if (n < 0) return -1;

        long[][] x = {{1, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 0}};
        long[][] temp = powerMatrix(x, n - 2);
        long[][] m2 = {{ss2}, {s2}, {f2}, {f1}};
        long[][] mn = multiply(temp, m2);

        return (int) (mn[0][0] % mod);
    }

    // TC: O(log n) where n is power; 2nd parameter here + O(N*M) considering matrix multiplication
    public long[][] powerMatrix(long[][] A, int n) {

        if (n == 0) return multiply(A, getIdentityMat(A.length));
        if (n == 1) return multiply(A, getIdentityMat(A.length));

        long[][] currRes = powerMatrix(A, n / 2);

        long[][] x = multiply(currRes, currRes);
        if ((n & 1) == 0) {
            return x;
        }
        return multiply(x, A);
    }

    // TC: O(n * m)
    // SC: O(n * m)
    public long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        int p = A[0].length;
        int m = B[0].length;

        // can not multiply
        if (A[0].length != B.length) return null;

        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    long tmp = ((A[i][k] * B[k][j]) % mod);
                    res[i][j] += (tmp + mod) % mod;
                }
            }
        }
        return res;
    }

    public long[][] getIdentityMat(int n) {
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) res[i][j] = 1;
            }
        }
        return res;
    }
}
