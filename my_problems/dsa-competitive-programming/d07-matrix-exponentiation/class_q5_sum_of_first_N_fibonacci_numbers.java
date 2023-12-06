/*
Find sum of first N fibonacci numbers in logN time using matrix polynomial equation
Given F(0) = 0 and F(1) = 1
 */
public class class_q5_sum_of_first_N_fibonacci_numbers {
    public static void main(String[] args) {
        class_q5_sum_of_first_N_fibonacci_numbers t = new class_q5_sum_of_first_N_fibonacci_numbers();
        {
            System.out.println(t.solve(2));
            System.out.println(t.solve(3));
            System.out.println(t.solve(4));
            System.out.println(t.solve(5));
            System.out.println(t.solve(6));
            System.out.println(t.solve(7));
            System.out.println(t.solve(8));
            System.out.println(t.solve(9));
            System.out.println(t.solve(10));
        }
    }

    /*
        F(n) = F(n-1) + F(n-2)

        S(n) = F(1) + F(2) + ... + F(n-1) + F(n)
        replace F(1) + F(2) + ... + F(n-1) with S(n-1)
        S(n) = S(n-1) + F(n)
        replace F(n) = F(n-1) + F(n-2)
        S(n) = S(n-1) + F(n-1) + F(n-2)

        [{S(n)}, {F(n)}, {F(n-1)}]  = x * [{S(n-1)}, {F(n-1)}, {F(n-2)}]

                                      [ {1 1 1}
        [{S(n)}, {F(n)}, {F(n-1)}]  =   {0 1 1}         *   [{S(n-1)}, {F(n-1)}, {F(n-2)}]
                                        {0 1 0} ]

        Mn = x * Mn-1
        Mn = x * x * Mn-2
        Mn = x^2 * Mn-2
        Mn = x^k * Mn-k

        As we know M2 values = F(1) + F(2) = 0 + 1 = 1 and S(1) = 0, S(2) = 1
        M2 =  [{S(n-1)}, {F(n-1)}, {F(n-2)}] = [{S(2)}, {F(2)}, {F(1)}] = [{1}, {1}, {0}]

        n - k = 2
        k = n - 2

        Mn = x^(n-2) * M2

        [{S(n)}, {F(n)}, {F(n-1)}] = x^(n-2) *  [{S(2)}, {F(2)}, {F(1)}]
        [{S(n)}, {F(n)}, {F(n-1)}] = x^(n-2) *  [{1}, {1}, {0}]
        [{S(n)}, {F(n)}, {F(n-1)}] = [ {1 1 1} ] ^(n-2) *  [{1}, {1}, {0}]
                                     [ {0 1 1} ]
                                     [ {0 1 0} ]

         Using this matrix exponential equation we can find the sum of first N fibonacci numbers
     */
    int solve(int n) {

        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n < 0) return -1;
        int[][] x = {{1, 1, 1}, {0, 1, 1}, {0, 1, 0}};
        int[][] temp = powerMatrix(x, n - 2);
//        int[][] m1 = new int[][]{{1}, {1}, {0}};
        int[][] m1 = new int[][]{{6}, {3}, {3}};
        int[][] m2 = multiply(temp, m1);

        return m2[0][0];
    }

    // TC: O(log n) where n is power; 2nd parameter here + O(N*M) considering matrix multiplication
    public int[][] powerMatrix(int[][] A, int n) {

        if (n == 0) return multiply(A, getIdentityMat(A.length));
        if (n == 1) return multiply(A, getIdentityMat(A.length));

        int[][] currRes = powerMatrix(A, n / 2);

        int[][] x = multiply(currRes, currRes);
        if ((n & 1) == 0) {
            return x;
        }
        return multiply(x, A);
    }

    // TC: O(n * m)
    // SC: O(n * m)
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int p = A[0].length;
        int m = B[0].length;

        // can not multiply
        if (A[0].length != B.length) return null;

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }

    public int[][] getIdentityMat(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) res[i][j] = 1;
            }
        }
        return res;
    }
}
