import java.util.Arrays;

public class q1_sum_the_difference {
    public static void main(String[] args) {
        q1_sum_the_difference t1 = new q1_sum_the_difference();
        System.out.println(t1.solve(new int[]{1, 4, 3, 2}));
    }

    public long powerMod(long a, long n, long m) {

        if (n == 0) {
            return 1 % m;
        }
        if (n == 1) {
            return a % m;
        }
        long ans = powerMod(a, (long) Math.floor(n / 2), m);
        long value = ((ans % m) * (ans % m)) % m;
        if (n % 2 != 0) {
            value = ((value % m) * (a % m)) % m;
        }
        return value % m;
    }

    public int solve(int[] A) {

        long m = 1000000007;
        long maxSum = 0;
        long minSum = 0;

        // sort the array
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            maxSum = (maxSum % m + (powerMod(2, i, m) % m * ((long) A[i]) % m) % m) % m;
        }

        for (int i = A.length - 1, j = 0; i >= 0; i--, j++) {
            minSum = (minSum % m + (powerMod(2, j, m) % m * ((long) A[i]) % m) % m) % m;
        }

        long ans = ((maxSum % m) - (minSum % m)) % m;

        if (ans < 0) {
            ans = ans + m;
        }

        return (int) ans;
    }
}
