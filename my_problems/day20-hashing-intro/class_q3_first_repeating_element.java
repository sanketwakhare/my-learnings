import java.util.LinkedHashMap;
import java.util.Map;

/* First Repeating Element */
/**
 * Idea: Find first element with freq > 1
 * LinkedHashMap maintains the insertion order
 * TC: O(N)
 * SC: O(N)
 */
public class class_q3_first_repeating_element {

    public int firstRepeating(int[] A) {

        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int element : A) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }

        System.out.println(map);
        // iterate LinkedHashMap as it is ordered
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        // if not found
        return -1;
    }

    public static void main(String[] args) {
        class_q3_first_repeating_element t1 = new class_q3_first_repeating_element();
        int[] A;
        {
            A = new int[] { 1, 3, 6, 3, 5, 4, 2, 1, 2, 4, 1, 2, 4, 4, 6 }; // 1
            System.out.println(t1.firstRepeating(A));
        }
        {
            A = new int[] { 10, 9, 16, 3, 5, 4, 2, 1, 2, 4, 3, 2, 4, 4, 6 }; // 3
            System.out.println(t1.firstRepeating(A));
        }
    }
}
