import java.util.Arrays;

/**
 * Factorial Array
 * <p>
 * https://www.scaler.com/academy/mentee-dashboard/class/23245/assignment/problems/2206/?navref=cl_pb_nv_tb
 */
public class ext_q3_FactorialArray {
    public static void main(String[] args) {
        ext_q3_FactorialArray t = new ext_q3_FactorialArray();
        int[] A = new int[]{2, 3, 4, 5, 6};
        System.out.println(t.solve(A)); // 7
    }

    public int solve(int[] A) {
        long p = 1000000007;
        int max = 1000001;
        long[] fact = new long[max];
        fact[0] = (long) 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = ((fact[i - 1] % p) * ((long) i % p)) % p;
        }

        System.out.println(Arrays.toString(fact));

        return 0;

    }
}
