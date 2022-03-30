import java.util.Arrays;

public class q1_Rod_Cutting {

    public int rec(int n, int[] A) {

        if (n <= 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, rec(n - i - 1, A) + A[i]);
        }
        return max;
    }

    public int memo(int n, int[] A, int[] dp) {

        if (n <= 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, memo(n - i - 1, A, dp) + A[i]);
        }

        return dp[n] = max;
    }

    public int tabulation(int[] A) {
        // TODO: complete tabulation approach
        return -1;
    }

    public static void main(String[] args) {

        q1_Rod_Cutting t1 = new q1_Rod_Cutting();

        int n;
        int[] dp, A;
        // 1419

        {
            // approach 1 - Backtracking
            System.out.println("Approach 1 - Backtracking");
            A = new int[] { 33, 53, 25, 37, 27, 60, 30, 6, 45, 35, 52, 21, 11, 39, 12, 49, 9, 16, 88, 13, 114, 4, 122,
                    138, 4, 81, 102, 48, 24, 1, 158, 168, 1, 44, 136, 125, 26, 79, 67, 193, 77, 105, 2 };
            // System.out.println(t1.rec(A.length, A)); / TLE
        }
        {
            // approach 2 - memoization
            System.out.println("Approach 2 - Memoization - (recursion + DP)");
            A = new int[] { 33, 53, 25, 37, 27, 60, 30, 6, 45, 35, 52, 21, 11, 39, 12, 49, 9, 16, 88, 13, 114, 4, 122,
                    138, 4, 81, 102, 48, 24, 1, 158, 168, 1, 44, 136, 125, 26, 79, 67, 193, 77, 105, 2 };
            n = A.length;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(t1.memo(A.length, A, dp)); // 1419

            // test case 2
            A = new int[] { 3, 4, 1, 6, 2 };
            n = A.length;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(t1.memo(A.length, A, dp)); // 15
        }
        {
            // approach - tabulation
            System.out.println("Approach 3 - Tabulation - (iterative approach + DP)");
            A = new int[] { 33, 53, 25, 37, 27, 60, 30, 6, 45, 35, 52, 21, 11, 39, 12, 49, 9, 16, 88, 13, 114, 4, 122,
                    138, 4, 81, 102, 48, 24, 1, 158, 168, 1, 44, 136, 125, 26, 79, 67, 193, 77, 105, 2 };
            n = A.length;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            // System.out.println(t1.tabulation(A)); // 1419

            // test case 2
            A = new int[] { 3, 4, 1, 6, 2 };
            n = A.length;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            // System.out.println(t1.tabulation(A)); // 15
        }
    }

}
