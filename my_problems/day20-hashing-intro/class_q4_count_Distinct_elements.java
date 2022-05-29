import java.util.HashSet;
import java.util.Set;

/* Count DISTINCT elements in array */
/**
 * Use HashSet and return size() of set
 * TC: O(N)
 * SC: O(N)
 */
public class class_q4_count_Distinct_elements {

    public int countDistinct(int[] A) {

        int count = 0;

        // build hashSet and return size of set
        Set<Integer> set = new HashSet<>();
        for (int element : A) {
            set.add(element);
        }
        System.out.println(set);
        count = set.size();
        return count;
    }

    public static void main(String[] args) {
        class_q4_count_Distinct_elements t1 = new class_q4_count_Distinct_elements();
        int[] A;
        {
            A = new int[] { 1, 3, 6, 3, 5, 4, 2, 1, 2, 4, 1, 2, 4, 4, 6 }; // 6
            System.out.println(t1.countDistinct(A));
        }
        {
            A = new int[] { 10, 9, 16, 3, 5, 4, 2, 1, 2, 4, 3, 2, 4, 4, 6 }; // 9
            System.out.println(t1.countDistinct(A));
        }
    }

}
