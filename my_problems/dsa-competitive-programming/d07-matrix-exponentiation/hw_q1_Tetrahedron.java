/*

Problem Description
Consider a tetrahedron with vertices 1, 2, 3 and 4. You need to count the number of different cyclic paths with the length of A from vertex 1 to itself.

As the number can be quite large, you should return it modulo 109+7.

Problem Constraints
1 ≤ A ≤ 10^9

Input Format
The only line of argument contains a single integer A.

Output Format
Return a single integer, the number of cyclic paths modulo 109+7.

Example Input
Input 1:
 A = 2
Input 2:
 A = 3

Example Output
Output 1:
 3
Output 2:
 6

Example Explanation
Explanation 1:
 Possible paths are :
 1 - 2 - 1
 1 - 3 - 1
 1 - 4 - 1
Explanation 2:
 Possible paths are :
 1 - 2 - 3 - 1
 1 - 2 - 4 - 1
 1 - 3 - 4 - 1
 1 - 3 - 2 - 1
 1 - 4 - 2 - 1
 1 - 4 - 3 - 1
 */
public class hw_q1_Tetrahedron {

    public static void main(String[] args) {
        hw_q1_Tetrahedron t = new hw_q1_Tetrahedron();
        {
            System.out.println(t.solve(1)); // 0
            System.out.println(t.solve(2)); // 3
            System.out.println(t.solve(3)); // 6
            System.out.println(t.solve(4)); // 21
            System.out.println(t.solve(5)); // 0
            System.out.println(t.solve(10)); // 14763
            System.out.println(t.solve(1315)); // 285210267
            System.out.println(t.solve(754646)); // 330902139
            System.out.println(t.solve(899)); // 98356027
            System.out.println(t.solve(1000000000)); // 58984912
        }
    }

    /*
    Explanation: Finding Recursive relation and converting into matrix exponential equation

    Fv(n) = no of ways to react vertex 1 from vertex v in n moves
    F1(n) = no of ways to react vertex 1 from n moves

    // Base cases
    F1(0) = no moves left, and we are already at vertex 1 = 1 way
    F2(0) = no moves left = 0
    F3(0) = no moves left = 0
    F4(0) = no moves left = 0

    F1(n) = F2(n-1) + F3(n-1) + F4(n-1)
    F2(n) = F1(n-1) + F3(n-1) + F4(n-1)
    F3(n) = F1(n-1) + F2(n-1) + F4(n-1)
    F4(n) = F1(n-1) + F2(n-1) + F3(n-1)

    Find F1(n) as answer

    [[F1(n)],                  [[F1(n-1)],
    [F2(n)],        = T *       [F2(n-1)],
    [F3(n)],                    [F3(n-1)],
    [F4(n)]]                    [F4(n-1)]]

    [[F1(n)],         [[0, 1, 1, 1]         [[F1(n-1)],
    [F2(n)],        =  [1, 0, 1, 1]  *       [F2(n-1)],
    [F3(n)],           [1, 1, 0, 1]          [F3(n-1)],
    [F4(n)]]           [1, 1, 1, 0]]         [F4(n-1)]]

            Mn = T * Mn-1
            Mn = T^2 * Mn-2
            Mn = T^k * Mn-k

            we know value of F1(0), F2(0)m F3(0) and F4(0)

            n-k = 0
            n = k

            replace k=n in above equation
            Mn = T^n * M0
    [[F1(n)],         [[0, 1, 1, 1] ^ n         [[F1(0)],
    [F2(n)],        =  [1, 0, 1, 1]     *        [F2(0)],
    [F3(n)],           [1, 1, 0, 1]              [F3(0)],
    [F4(n)]]           [1, 1, 1, 0]]             [F4(0)]]

    [[F1(n)],         [[0, 1, 1, 1] ^ n         [[1],
    [F2(n)],        =  [1, 0, 1, 1]       *      [0],
    [F3(n)],           [1, 1, 0, 1]              [0],
    [F4(n)]]           [1, 1, 1, 0]]             [0]]

     */

    long mod = 1000000007;

    public int solve(int n) {

        long f1_0 = 1;
        long f2_0 = 0;
        long f3_0 = 0;
        long f4_0 = 0;

        if (n == 0) return (int) f1_0;
        if (n < 0) return -1;

        long[][] x = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
        long[][] temp = powerMatrix(x, n);
        long[][] m2 = {{f1_0}, {f2_0}, {f3_0}, {f4_0}};
        long[][] mn = multiply(temp, m2);

        return (int) ((mn[0][0]) % mod);
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
                    long tmp = (((A[i][k] % mod) * (B[k][j] % mod)) % mod);
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
