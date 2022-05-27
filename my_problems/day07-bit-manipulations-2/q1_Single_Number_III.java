import java.util.Arrays;

/* Single Number III */
/* Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once */
public class q1_Single_Number_III {
    public int[] solve(int[] A) {

        // calculate xor of all array elements
        int xor_all = 0;
        for (int i = 0; i < A.length; i++) {
            xor_all ^= A[i];
        }

        // find any of the set bit in xor value
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(xor_all, i)) {
                pos = i;
                break;
            }
        }

        // form 1 groups based on set bit at pos
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (checkBit(A[i], pos)) {
                val1 ^= A[i];
            } else {
                val2 ^= A[i];
            }
        }
        int[] arr = new int[] { val1, val2 };
        Arrays.sort(arr);
        return arr;
    }

    private boolean checkBit(int n, int pos) {
        if (((n >> pos) & 1) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        q1_Single_Number_III t1 = new q1_Single_Number_III();
        int[] A, out;
        {
            A = new int[] { 1, 2, 3, 1, 2, 4 };
            out = t1.solve(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 1, 2 };
            out = t1.solve(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 186, 256, 102, 377, 186, 377 };
            out = t1.solve(A);
            ArrayUtils.printArray(out);
        }
    }
}
