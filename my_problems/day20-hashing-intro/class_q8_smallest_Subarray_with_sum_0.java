import java.util.HashMap;
import java.util.Map;

/* Find Smallest length subarray with sum = 0 */
public class class_q8_smallest_Subarray_with_sum_0 {

    public int[] smallestSubArraySumZero(int[] A) {

        // Generate prefix array
        int n = A.length;
        int[] pf = new int[n];
        pf[0] = A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        // Build hashMap with value as latest occurrence of element
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(pf[i])) {
                // if element is already present
                // first calculate answer and update if this is better answer
                if ((i - map.get(pf[i])) < minLength) {
                    int currLength = i - map.get(pf[i]);
                    minLength = currLength;
                    start = map.get(pf[i]) + 1;
                    end = i;
                }
            } else {
                // store latest occurrence till now
                map.put(pf[i], i);
            }
        }

        // return empty array if subarray not present
        if (minLength == Integer.MAX_VALUE) {
            return new int[] {};
        }

        // build output array
        int[] output = new int[minLength];
        int j = 0;
        for (int i = start; i <= end; i++) {
            output[j++] = A[i];
        }
        return output;
    }

    public static void main(String[] args) {

        class_q8_smallest_Subarray_with_sum_0 t1 = new class_q8_smallest_Subarray_with_sum_0();
        int[] A, out;
        {
            A = new int[] { 8, -19, 8, 2, -8, 19, 5, -2, -23 };
            out = t1.smallestSubArraySumZero(A);
            ArrayUtils.printArray(out); // empty array
        }
        {
            A = new int[] { 1, 2, -2, 4, -4 };
            out = t1.smallestSubArraySumZero(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 3, 3, 4, -5, -2, 2, 1, -3, 3, -1, 5, -4, -1 };
            out = t1.smallestSubArraySumZero(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 4, -3, -1, 2, -2 };
            out = t1.smallestSubArraySumZero(A);
            ArrayUtils.printArray(out);
        }
    }
}
