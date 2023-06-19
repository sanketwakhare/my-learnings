package dp.array_1d;

public class Dp_01_Fibonacci {

        public static void main(String[] args) {
            Dp_01_Fibonacci t1 = new Dp_01_Fibonacci();
            {
                System.out.println(t1.fib(10));
                System.out.println(t1.fib(20));
            }
            {
                System.out.println(t1.fib_2(10));
                System.out.println(t1.fib_2(20));
                System.out.println(t1.fib_2(0));
                System.out.println(t1.fib_2(7));
            }
        }

    // tabulation
    public int fib_2(int A) {
        int[] dp = new int[A + 2];
        dp[0] = 0;
        dp[1] = 1;

        if (A == 0) return 0;
        if (A == 1) return 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[A];
    }

    public long fib(int n) {
        long[] dp = new long[n + 1];
        return fib(n, dp);
    }

    private long fib(int n, long[] dp) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
}
