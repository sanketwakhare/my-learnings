/*
Approach 1

Using Pascal's Formula
nCr = n-1 C r = n-1 C r-1
 */

public class class_q1_ncr_approach1 {
    public static void main(String[] args) {
        class_q1_ncr_approach1 t = new class_q1_ncr_approach1();
        System.out.println(t.ncr(5, 2, 1000000007));
        System.out.println(t.ncr(10, 5, 1000000007));
        System.out.println(t.ncr(100, 5, 1000000007));
    }

    public int ncr(int n, int r, int m) {
        int[][] ncr = new int[n + 1][r + 1];
        // nC0 = 1
        for (int i = 0; i <= n; i++) {
            ncr[i][0] = 1;
        }
        // using Pascal's formula
        // nCr = n-1 C r + n-1 C r-1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                ncr[i][j] = (ncr[i - 1][j - 1] % m + ncr[i - 1][j] % m) % m;
            }
        }
        return ncr[n][r] % m;
    }
}
