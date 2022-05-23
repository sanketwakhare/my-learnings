/* Find a Missing and a Duplicate Number from array [range = 1 - N] */
public class hw_q1_Repeat_and_Missing {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        // find xor value of array elements and 1-n elements combined
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
            xor = xor ^ (i + 1);
        }
        // find one of the set bit position from xor value
        int setBitPos = 0;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) {
                setBitPos = i;
                break;
            }
        }
        // divide the numbers from array and 1-n based on set bit position
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (isSetBit(A[i], setBitPos)) {
                val1 = val1 ^ A[i];
            } else {
                val2 = val2 ^ A[i];
            }
            if (isSetBit(i + 1, setBitPos)) {
                val1 = val1 ^ (i + 1);
            } else {
                val2 = val2 ^ (i + 1);
            }
        }

        // find actual duplicate and missing number
        int freq1 = 0;
        int freq2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (val1 == A[i])
                freq1++;
            if (val2 == A[i])
                freq2++;
        }
        int[] arr = (freq1 > freq2) ? new int[] { val1, val2 } : new int[] { val2, val1 };
        return arr;
    }

    // set bit function
    private boolean isSetBit(int n, int index) {
        if (((n >> index) & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        hw_q1_Repeat_and_Missing t1 = new hw_q1_Repeat_and_Missing();
        int[] A, out;
        {
            A = new int[] { 3, 1, 2, 5, 3 };
            out = t1.repeatedNumber(A);
            ArrayUtils.printArray(out);
        }
        {
            A = new int[] { 2, 5, 4, 5, 3 };
            out = t1.repeatedNumber(A);
            ArrayUtils.printArray(out);
        }
    }
}
