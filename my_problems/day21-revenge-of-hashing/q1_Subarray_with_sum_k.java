/*  Subarray with given sum */

/* HashMap Approach */
import java.util.HashMap;

public class q1_Subarray_with_sum_k {
    public int[] solve(int[] A, int B) {

        int n = A.length;
        // build prefix array
        long[] pf = new long[n];
        pf[0] = (long) A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (long) A[i];
        }

        // map with key as element and value as index
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        for (int i = 0; i < pf.length; i++) {
            long target = pf[i] - (long) B;
            if (map.containsKey(target)) {
                // subarray found
                int start = map.get(target) + 1;
                int end = i;
                int[] res = new int[end - start + 1];
                for (int j = 0; j < res.length; j++) {
                    res[j] = A[start++];
                }
                return res;
            }
            map.put(pf[i], i);
        }

        return new int[] { -1 };
    }
}
