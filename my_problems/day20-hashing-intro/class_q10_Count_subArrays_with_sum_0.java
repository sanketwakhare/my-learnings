import java.util.HashMap;
import java.util.Map;

/* Count no of sub arrays with sum = 0 */

public class class_q10_Count_subArrays_with_sum_0 {

    public int countSubArrays(int[] A) {

        int n = A.length;
        int count = 0;

        // step1: generate prefix sum array
        int[] pf = new int[n];
        pf[0] = A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = A[i] + pf[i - 1];
        }

        // Build Frequency map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // edge case for 0
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            int freq = map.getOrDefault(pf[i], 0);
            map.put(pf[i], freq + 1);
        }

        System.out.println(map);

        // Apply nC2 formula for every frequency => n * (n-1) /2
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            count += (freq) * (freq - 1) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        class_q10_Count_subArrays_with_sum_0 t1 = new class_q10_Count_subArrays_with_sum_0();
        int[] A;
        {
            A = new int[] { 5, -1, -2, 3, 2, -2, -4, 4 };
            System.out.println(t1.countSubArrays(A));
        }

    }
}
