import java.util.HashSet;
import java.util.Set;

public class class_q6_subarray_with_sum_0 {
    public int solve(int[] A) {
        // step 1: generate prefix sum array
        int n = A.length;
        long[] pf = new long[n];
        pf[0] = (long) A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (long) A[i];
        }

        // Find repeating elements in prefix array
        // Handle case for 0, if there is 0, it means there is a subArray with sum 0
        // starting with index 0
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (pf[i] == 0)
                return 1;
            if (set.contains(pf[i])) {
                return 1;
            } else {
                set.add(pf[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        class_q6_subarray_with_sum_0 t1 = new class_q6_subarray_with_sum_0();
        int[] A;
        {
            A = new int[] { 1, 2, 3, 4, 5 };
            System.out.println(t1.solve(A)); // 0
        }
        {
            A = new int[] { 10, 9, -16, -3, -5, 4, 2, -1, 2, 4, 3, 3, -4, 4, -6 };
            System.out.println(t1.solve(A)); // 1
        }
        {
            A = new int[] { 1, -1 };
            System.out.println(t1.solve(A)); // 1
        }
    }
}
