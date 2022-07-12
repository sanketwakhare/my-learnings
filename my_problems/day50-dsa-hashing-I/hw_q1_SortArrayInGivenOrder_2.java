/* Sort Array in given Order */
import java.util.Map;
import java.util.TreeMap;

public class hw_q1_SortArrayInGivenOrder_2 {

    public int[] solve(int[] A, int[] B) {

        // build treemap
        Map<Integer, Integer> map = new TreeMap<>();
        for(int ele: A) {
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele) + 1);
            } else {
                map.put(ele, 1);
            }
        }

        int[] result = new int[A.length];
        int index = 0;
        for(int ele: B) {
            if(map.containsKey(ele)) {
                // put all occurrences of current element into result
                int value = map.get(ele);
                while(value > 0) {
                    result[index++] = ele;
                    value--;
                }
                map.remove(ele);
            }
        }
        // put all remaining elements from map into result
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            while(value > 0) {
                result[index++] = key;
                value--;
            }
        }
        return result;
    }
}
