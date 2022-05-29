import java.util.HashMap;
import java.util.Map;

public class class_q1_find_frequency_of_elements {

    public void findFreq(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int ele : A) {
            int freq = map.getOrDefault(ele, 0);
            map.put(ele, ++freq);
        }
        System.out.println(map);
    }

    public static void main(String[] args) {

        class_q1_find_frequency_of_elements t1 = new class_q1_find_frequency_of_elements();
        int[] A;
        {
            A = new int[] { 1, 3, 3, 4, 2, 1, 2, 4, 1, 2, 4, 4 };
            t1.findFreq(A);
        }
    }
}
