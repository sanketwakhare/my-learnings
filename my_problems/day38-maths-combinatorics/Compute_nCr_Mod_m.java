/***
 * Compute nCr % m
 * 
 * Problem Description
 * Given three integers A, B and C, where A represents n, B represents r and C
 * represents m, find and return the value of nCr % m where nCr % m =
 * (n!/((n-r)!*r!))% m.
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * 
 * Problem Constraints
 * 1 <= A * B <= 10^6
 * 1 <= B <= A
 * 1 <= C <= 10^6
 * 
 * Input Format
 * The first argument given is integer A ( = n).
 * The second argument given is integer B ( = r).
 * The third argument given is integer C ( = m).
 * 
 * Output Format
 * Return the value of nCr % m.
 * 
 * Example Input
 * Input 1:
 * A = 5
 * B = 2
 * C = 13
 * Input 2:
 * A = 6
 * B = 2
 * C = 13
 * 
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * The value of 5C2 % 11 is 10.
 * Explanation 2:
 * The value of 6C2 % 13 is 2.
 */

public class Compute_nCr_Mod_m {

    /*
     * Generate 2 d matrix of Pascals triangle
     * Generate only till half
     * Use top down approach as next value depends upon previous value
     * If we use recursion, it throws stack overflow error
     */
    public static int computeNcr(int n, int r, int m) {

        int[][] mat = new int[n + 1][r + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= r; j++) {
                if (i == j) {
                    // nCn = 1
                    mat[i][j] = 1;
                } else if (j == 0) {
                    // nC0 = 1
                    mat[i][j] = 1;
                } else {
                    // nCr = (n-1)Cr + (n-1)C(r-1)
                    mat[i][j] = (mat[i - 1][j] % m + mat[i - 1][j - 1] % m) % m;
                }
            }
        }
        return mat[n][r] % m;

    }

    public static void main(String[] args) {
        System.out.println(computeNcr(5, 2, 13)); // The expected return value: 10
        System.out.println(computeNcr(6, 2, 13)); // The expected return value: 2
        System.out.println(computeNcr(41, 27, 143)); // The expected return value: 58
    }

}
