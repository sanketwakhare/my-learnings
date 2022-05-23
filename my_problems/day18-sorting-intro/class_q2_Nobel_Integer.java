import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Noble Integer when all array elements are DISTINCT */
/* Given an integer array A, find if an integer p exists in the array such that 
the number of integers greater than p in the array equals p. */

/* A = [-10 -5 1 3 4 5]
3,4 and 5 are Noble integers */
public class class_q2_Nobel_Integer {

    public static void main(String[] args) {
        // array elements are DISTINCT here
        class_q2_Nobel_Integer t1 = new class_q2_Nobel_Integer();
        int[] A;
        {
            A = new int[] { 5, 4, 3, 1, -10, -5 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
        {
            A = new int[] { -4, -3, -2, 4, 10, -5 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
    }

    private List<Integer> solve(int[] A) {

        List<Integer> nobleIntegers = new ArrayList<Integer>();
        // sort the array
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                // compare array value with indexes as this would give the no elements < current
                // element
                nobleIntegers.add(A[i]);
            }
        }
        return nobleIntegers;
    }
}
