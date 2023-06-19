package dp.array_1d;

public class Dp_01_Fibonacci {

        public static void main(String[] args) {
            Dp_01_Fibonacci t1 = new Dp_01_Fibonacci();
            System.out.println(t1.fib(10));
            System.out.println(t1.fib(20));
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
