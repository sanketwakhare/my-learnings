/* Find min sum subarray of any size */
public class Kadence_min_sum_subarray {

    public int[] solve(int[] A) {

        // initialization block
        int temp_start = 0;
        int temp_end = 0;
        int start = 0;
        int end = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum < minSum) {
                // if we found the better answer, update the start and end index and answer
                minSum = sum;
                temp_end = i;
                start = temp_start;
                end = temp_end;
            }
            if (sum > 0) {
                // if subarray(s) ending with i can no more contribute to answer, reset sum and
                // indexes
                sum = 0;
                temp_start = i + 1;
                temp_end = i + 1;
            }
        }

        // return min sum, start index and end index of subarray
        return new int[] { minSum, start, end };
    }

    public static void main(String[] args) {

        Kadence_min_sum_subarray t1 = new Kadence_min_sum_subarray();
        int[] A, output;
        {
            A = new int[] { 8, 5, -3, 2, -5, -6, 7, 3, 2 };
            output = t1.solve(A);
            ArrayUtils.printArray(output);
        }
        {
            A = new int[] { 8, 15, 13, 12, -2, -16, 17, -50, 12 };
            output = t1.solve(A);
            ArrayUtils.printArray(output);
        }
    }
}
