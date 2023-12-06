/*
    Binary Grids

    Problem Description

Consider a grid of size 2 x N.

You need to find the number of colorings of the grid using only 2 colors such that:

There does not exist any square of size 2 x 2 having all cells colored the same.
Since the answer can be large, return it modulo 109+7.


Problem Constraints
1 ≤ N ≤ 10^9

Input Format
The input line contains a single argument A = N.


Output Format
Return a single integer, the number of colorings modulo 109+7.

Example Input
Input 1:
 N = 1
Input 2:
 N = 2

Example Output
Output 1:
 4
Output 2:
 14

Example Explanation

Explanation 1:
 Since no 2 x 2 square is possible for N = 1, all colorings are valid. Total colorings = 22*1 = 4.
Explanation 2:
 There are 2 invalid colorings:
 [1 1]
 [1 1]
 and
 [0 0]
 [0 0]
 So total valid colorings are 22*2 - 2 = 14.
 */
public class q2_BinaryGrids {

    /*
    Finding Recurrence relation
    Cnt[n][00] = represents no of ways to color n columns using [{0}, {0}] color
    Cnt[n][11] = represents no of ways to color n columns using [{1}, {1}] color

    || Cnt[n][00] = Cnt[n-1][01] + Cnt[n-1][10] + Cnt[n-1][11] - (I) ||
    || Cnt[n][11] = Cnt[n-1][01] + Cnt[n-1][10] + Cnt[n-1][00] - (II} ||
    || Cnt[n][01] = Cnt[n-1][01] + Cnt[n-1][10] + Cnt[n-1][00] + Cnt[n-1][11] - (III) ||
    || Cnt[n][10] = Cnt[n-1][01] + Cnt[n-1][10] + Cnt[n-1][00] + Cnt[n-1][11] - (IV) ||

    observations from equation I, II, III and IV

    f(n) = Cnt[n][00] = Cnt[n][11]
    g(n) = Cnt[n][01] = Cnt[n][10]

    using eq (I)
    f(n) = g(n-1) + g(n-1) + f(n-1)
    || f(n) = f(n-1) + 2 * g(n-1) - (V) ||

    using eq (III)
    g(n) = g(n-1) + g(n-1) + f(n-1) + f(n-1)
    || g(n) = 2 f(n-1) + 2 g(n-1) = (VI)||

    perform (VI) - (V)

    g(n) - f(n) = 2 f(n-1) + 2 g(n-1) - [f(n-1) + 2 g(n-1)]
    g(n) - f(n) = 2 f(n-1) + 2 g(n-1) - f(n-1) - 2g(n-1)
    g(n) - f(n) = f(n-1)
    || g(n) = f(n) + f(n-1) - (VII) ||

    put eq (VII) into eq (V)

    f(n) = f(n-1) + 2 g(n-1)
         = f(n-1) + 2 [ f(n-1) + f(n-2)]
         = f(n-1) + 2 f(n-1) + 2 f(n-2)

    || f(n) = 3 f(n-1) + 2 f(n-2) - recurrence relation ||

    we know f(1) = 4 na f(2) = 14

    [[F(n)], [F(n-1)]] = T . [[F(n-1)], [F(n-2)]]
                       = [[3, 2], [1, 0]] * [[F(n-1)], [F(n-2)]]

                    Mn = T . Mn-1
                    Mn = T . T . Mn-2
                    Mn = T^2 . Mn-2
                    Mn = T^k . Mn-k

                    we know M2 = [[f(2}], [f(1)]] = [[14], [4]]

                    n-k = 2
                    k = n-2

                    Mn = T^(n-2) . M2

    [[F(n)], [F(n-1)]] = T^(n-2) . [[F(2)], [F(1)]]

    [[F(n)], [F(n-1)]] = [[3, 2], [1, 0]]^(n-2) * [[F(2)], [F(1)]]

    [[F(n)], [F(n-1)]] = [[3, 2], [1, 0]]^(n-2) * [[14], [4]]
     */

    // TC: O(logN)
    // SC: (1) as matrix space is negligible
    public static void main(String[] args) {
        q2_BinaryGrids t = new q2_BinaryGrids();
        {
            System.out.println(t.solve(1)); // 4
            System.out.println(t.solve(2)); // 14
            System.out.println(t.solve(3)); // 50
            System.out.println(t.solve(4)); // 178
            System.out.println(t.solve(5)); // 634
            System.out.println(t.solve(19)); // 499369187
            System.out.println(t.solve(18)); // 405832499
            System.out.println(t.solve(100000065)); // 709377718
        }
    }

    long mod = 1000000007;

    public int solve(int n) {
        // base cases
        long f1 = 4;
        long f2 = 14;
        if (n == 1) return (int) f1;
        if (n == 2) return (int) f2;
        if (n < 0) return -1;

        long[][] x = {{3, 2}, {1, 0}};
        long[][] temp = powerMatrix(x, n - 2);
        long[][] m2 = {{f2}, {f1}};
        long[][] mn = multiply(temp, m2);

        long fn = mn[0][0] % mod;

        return (int) (fn % mod);
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
