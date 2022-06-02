/* Common Elements */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hw_q3_CommonElements {
    public int[] solve(int[] A, int[] B) {

        // build map with array A elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int freq = map.getOrDefault(A[i], 0);
            map.put(A[i], freq + 1);
        }

        // check every elements in array B and find if present in map
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int eleToSearch = B[i];
            if (map.containsKey(eleToSearch)) {
                int freq = map.get(eleToSearch);
                if (freq == 1) {
                    map.remove(eleToSearch);
                } else {
                    map.put(eleToSearch, freq - 1);
                }
                result.add(B[i]);
            }
        }

        // convert array list to array
        int[] res = new int[result.size()];
        int count = 0;
        for (int val : result)
            res[count++] = val;
        return res;
    }
}
