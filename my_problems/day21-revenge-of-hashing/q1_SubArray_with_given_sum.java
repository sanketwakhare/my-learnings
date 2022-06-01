/* Subarray with given sum */
public class q1_SubArray_with_given_sum {
    public int[] solve(int[] A, int B) {

        /* 2 Pointers Approach - Expand and Shrink the Window */

        // initialization block
        int i = 0;
        int j = 0;
        int sum = 0;
        boolean isSumFound = false;

        // find is sum B is present by expanding and shrinking the window
        while (i <= j && i < A.length && j < A.length) {
            while (sum < B && j < A.length) {
                sum = sum + A[j];
                j++;
            }
            while (sum > B && i < A.length) {
                sum = sum - A[i];
                i++;
            }
            if (sum == B) {
                // subarray found
                // traverse from start to end
                isSumFound = true;
                break;
            }
        }

        if (isSumFound) {
            // return subarray from i to j, if sum is present
            int outputLength = j - i;
            int[] output = new int[outputLength];
            for (int start = 0; start < outputLength; start++) {
                output[start] = A[i + start];
            }
            return output;
        }
        return new int[] { -1 };
    }

    public static void main(String[] args) {
        q1_SubArray_with_given_sum t1 = new q1_SubArray_with_given_sum();
        int[] A, out;
        int B;

        {
            A = new int[] { 1, 1000000000 };
            B = 1000000000;
            out = t1.solve(A, B);
            ArrayUtils.printArray(out); // [ 1000000000 ]
        }
        {
            A = new int[] { 15, 2, 5, 6, 9 };
            B = 7;
            out = t1.solve(A, B);
            ArrayUtils.printArray(out); // [2, 5]
        }
        {
            A = new int[] { 1, 2, 3, 4, 5 };
            B = 5;
            out = t1.solve(A, B);
            ArrayUtils.printArray(out); // [2, 3]
        }
        {
            A = new int[] { 15, 2, 48, 19, 28, 22, 44, 2, 32, 46, 46, 24, 1, 23, 49, 26, 23, 17, 17, 46, 4, 30, 40, 36,
                    20, 5 };
            B = 82;
            out = t1.solve(A, B);
            ArrayUtils.printArray(out); // [-1]
        }
    }
}
