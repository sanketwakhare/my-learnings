import java.util.HashMap;
import java.util.Map;

/* Largest Subarray with Sum = 0 */

/**
 * Idea: Generate prefix sum
 * 1) find if there are any repeated elements in prefix sum array
 * 2) find if there is any 0 in prefix sum array
 * If either of 1 or 2 is true, find length of such longest subarray
 * Iterations: N + N + N
 * TC: (N)
 * SC: O(N)
 */
public class class_q7_Largest_Subarray_sum_0 {

    public int[] lszero(int[] A) {

        // generate prefix sum array
        int n = A.length;
        long[] pf = new long[n];
        pf[0] = (long) A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (long) A[i];
        }

        // store answer
        int answer = 0;
        int start = -1;
        int end = -1;

        // store fist occurrence of elements as value
        Map<Long, Integer> map = new HashMap<>();
        // handle when element is 0
        map.put((long) 0, -1);
        for (int i = 0; i < n; i++) {
            long ele = pf[i];
            if (map.containsKey(ele)) {
                // calculate answer
                if ((i - map.get(ele)) > answer) {
                    start = map.get(ele) + 1;
                    end = i;
                    answer = end - start + 1;
                }
            } else {
                map.put(pf[i], i);
            }
        }

        // return empty array if no subarray with sum 0
        if (start == -1 || end == -1)
            return new int[] {};

        // build output array
        int[] output = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            output[j] = A[i];
            j++;
        }
        return output;
    }

    public static void main(String[] args) {
        class_q7_Largest_Subarray_sum_0 t1 = new class_q7_Largest_Subarray_sum_0();
        int[] A, out;
        {
            A = new int[] { 8, -19, 8, 2, -8, 19, 5, -2, -23 };
            out = t1.lszero(A);
            ArrayUtils.printArray(out); // empty array
        }
        {
            A = new int[] { 1, 2, -2, 4, -4 };
            out = t1.lszero(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 3, 3, 4, -5, -2, 2, 1, -3, 3, -1, 5, -4, -1 };
            out = t1.lszero(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 4, -3, -1, 2, -2 };
            out = t1.lszero(A);
            ArrayUtils.printArray(out);
        }
    }
}
