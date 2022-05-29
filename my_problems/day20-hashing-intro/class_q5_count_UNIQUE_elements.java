import java.util.HashMap;
import java.util.Map;

/* Count no of UNIQUE/non repeating elements in array. */
/**
 * TC: O(N)
 * SC: O(N)
 */
public class class_q5_count_UNIQUE_elements {

    // count elements with freq = 1
    public int countNonRepeating(int[] A) {
        int count = 0;

        // Build Map with frequency
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int element : A) {
            int freq = map.getOrDefault(element, 0);
            map.put(element, freq + 1);
        }

        // Iterate map and count elem with frequency = 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                count++;
        }
        System.out.println(map);

        return count;
    }

    public static void main(String[] args) {
        class_q5_count_UNIQUE_elements t1 = new class_q5_count_UNIQUE_elements();
        int[] A;
        {
            A = new int[] { 1, 3, 6, 3, 5, 4, 2, 1, 2, 4, 1, 2, 4, 4, 6 }; // 1, only 5 is non repeating/ UNIQUE
            System.out.println(t1.countNonRepeating(A));
        }
        {
            A = new int[] { 10, 9, 16, 3, 5, 4, 2, 1, 2, 4, 3, 2, 4, 4, 6 }; // 6, [16,1,5,6,9,10] are non repeating
            System.out.println(t1.countNonRepeating(A));
        }
    }
}
