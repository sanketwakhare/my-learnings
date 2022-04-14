/* Max Non Negative SubArray */

/**
 * TC: O(N)
 * SC: O(1)
 */
public class hw_q2_Max_Non_Negative_SubArray {

    public int[] maxset(int[] A) {

        // initialize final start index, end index and sum
        int answer_start_index = 0;
        int answer_end_index = 0;
        // take long as sum can overflow
        long sum = 0;

        // initialize temp start index, end index and sum
        int temp_start = 0;
        int temp_end = 0;
        long temp_sum = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < 0) {
                // if A[i] is -ve, reset the sum and temp indexes
                temp_sum = 0;
                temp_start = i + 1;
                temp_end = i + 1;
            } else {
                // if A[i] is +ve, include this in current temp sum
                temp_sum = temp_sum + (long) A[i];
                // increase end index
                temp_end = i;

                if (temp_sum > sum
                        || (temp_sum == sum && temp_end - temp_start > answer_end_index - answer_start_index)) {
                    // if we got the better answer, update the answer variables
                    answer_start_index = temp_start;
                    answer_end_index = temp_end;
                    sum = temp_sum;
                }
            }
        }

        // extract the subarray from indexes and return final array
        System.out.println();
        int[] answer = new int[answer_end_index - answer_start_index + 1];
        int j = 0;
        for (int i = answer_start_index; i <= answer_end_index; i++) {
            answer[j++] = A[i];
        }

        if (answer[0] < 0) {
            answer = new int[] {};
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
        return answer;
    }

    public static void main(String[] args) {
        hw_q2_Max_Non_Negative_SubArray t1 = new hw_q2_Max_Non_Negative_SubArray();
        int[] A;

        {
            A = new int[] { 1, 2, 5, -7, 3, 4 };
            t1.maxset(A);

            A = new int[] { 0, 0, -7, 0 };
            t1.maxset(A);

            A = new int[] { -542342, -42342, 7, -4234234 };
            t1.maxset(A);

            A = new int[] { 1967513926, 1540383426, -1303455736, -521595368 };
            t1.maxset(A);

            A = new int[] { -1, -1, -1, -1 };
            t1.maxset(A);

            A = new int[] { 1, 2, 5, -100, 2, 1, 1, 2, 2 };
            t1.maxset(A);

            A = new int[] { 10, -1, 2, 3, -4, 100 };
            t1.maxset(A);
        }
    }
}
