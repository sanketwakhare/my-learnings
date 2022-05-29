import java.util.LinkedHashMap;
import java.util.Map;

/* Find First Non Repeating Element in array */
/* TC: O(N)
SC: O(N) */
public class class_q2_find_first_non_repeating_element {

    public int firstNonRepeating(int[] A) {

        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int ele : A) {
            int freq = map.getOrDefault(ele, 0);
            map.put(ele, freq + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // element found
                return entry.getKey();
            }
        }

        // if not found, or if there is no element with freq 1
        return -1;
    }

    public static void main(String[] args) {
        class_q2_find_first_non_repeating_element t1 = new class_q2_find_first_non_repeating_element();
        int[] A;
        {
            A = new int[] { 1, 3, 6, 3, 5, 4, 2, 1, 2, 4, 1, 2, 4, 4, 6 };
            int ele = t1.firstNonRepeating(A);
            System.out.println(ele); // 5
        }
    }
}
