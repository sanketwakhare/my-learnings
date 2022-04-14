import java.util.ArrayList;
import java.util.List;

public class hw_q1_Add_One_To_Digits {

    public int[] plusOne(int[] A) {

        // take dynamic list as size of the final array can vary based on input
        List<Integer> list = new ArrayList<Integer>();
        int carry = 1;

        // perform addition from last
        for (int i = A.length - 1; i >= 0; i--) {

            int sum = A[i] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            list.add(digit);
        }
        // add extra carry if any
        if (carry == 1) {
            list.add(carry);
        }

        // list will contain the answer in reverse direction
        // remove 0s from last [leading 0's in answer]
        int ind = list.size() - 1;
        while (list.get(ind) == 0) {
            list.remove(ind);
            ind--;
        }

        // build answer array from list
        int[] result = new int[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            result[j] = list.get(i);
            j++;
        }
        return result;
    }

    public static void main(String[] args) {

        hw_q1_Add_One_To_Digits t1 = new hw_q1_Add_One_To_Digits();
        int[] A, answer;

        A = new int[] { 0, 0, 0, 9, 9, 9 };
        answer = t1.plusOne(A);
        ArrayUtils.printArray(answer);

        A = new int[] { 1, 0, 0, 9, 9, 9 };
        answer = t1.plusOne(A);
        ArrayUtils.printArray(answer);

        A = new int[] { 0 };
        answer = t1.plusOne(A);
        ArrayUtils.printArray(answer);

        A = new int[] { 0, 0, 4, 9, 0, 0, 2, 4, 4, 9, 9 };
        answer = t1.plusOne(A);
        ArrayUtils.printArray(answer);

        A = new int[] { 9, 9 };
        answer = t1.plusOne(A);
        ArrayUtils.printArray(answer);

    }
}
