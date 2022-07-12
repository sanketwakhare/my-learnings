/* K Occurrences */

import java.util.HashMap;
import java.util.Map;

public class hw_q1_K_Occurrence_sum {

    public int getSum(int A, int B, int[] C) {

        // build map with frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: C) {
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele) + 1);
            } else
                map.put(ele, 1);
        }

        // find sum of elements with frequency B
        long sum = 0;
        long m = 1000000007;
        boolean isOccurrencePresent = false;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == B) {
                sum += entry.getKey() % m;
                isOccurrencePresent = true;
            }
        }
        sum = (sum % m);
        return isOccurrencePresent ? (int)sum : -1;
    }
}
