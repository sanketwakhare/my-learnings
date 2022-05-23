import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* Noble Integer when array elements can be Duplicate */
/* Given an integer array A, find if an integer p exists in the array such that 
the number of integers greater than p in the array equals p. */

public class class_q3_Nobel_Integers_Duplicate {

    private List<Integer> solve(int[] A) {
        List<Integer> output = new ArrayList<Integer>();

        // step1: sort the array
        Arrays.sort(A);

        int count = 0;
        if (A[A.length - 1] == 0)
            output.add(A[A.length - 1]);
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] != A[i]) {
                // duplicate element
                // do not increase the count
                count = A.length - 1 - i;
            }
            if (A[i] == count) {
                output.add(A[i]);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        class_q3_Nobel_Integers_Duplicate t1 = new class_q3_Nobel_Integers_Duplicate();
        int[] A;
        {
            A = new int[] { 5, 6, 2 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
        {
            A = new int[] { 5, -10, 5, 1, 4, 1, 1 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
        {
            A = new int[] { 3, 2, 1, 3 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
        {
            A = new int[] { 5, 7, 8, 9, 5, 5, 5, 5, 9, 9 };
            List<Integer> output = t1.solve(A);
            System.out.println(output);
        }
    }
}
