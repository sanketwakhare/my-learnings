import java.util.Deque;
import java.util.LinkedList;

/* Sliding Window Maximum */

/***
 * Problem Description
 * 
 * Given an array of integers A. There is a sliding window of size B which is
 * moving from the very left of the array to the very right. You can only see
 * the B numbers in the window. Each time the sliding window moves rightwards by
 * one position. You have to find the maximum for each window.
 * 
 * Return an array C, where C[i] is the maximum value in the array from A[i] to
 * A[i+B-1].
 * 
 * Refer to the given example for clarity.
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 * 
 * Problem Constraints
 * 1 <= |A|, B <= 106
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * 
 * Output Format
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 * 
 * Example Input
 * Input 1:
 * A = [1, 3, -1, -3, 5, 3, 6, 7]
 * B = 3
 * Input 2:
 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 * B = 6
 * 
 * Example Output
 * 
 * Output 1:
 * [3, 3, 5, 5, 6, 7]
 * Output 2:
 * [7, 7, 7, 7]
 * 
 * Example Explanation
 * Explanation 1:
 * Window position | Max
 * --------------------|-------
 * [1 3 -1] -3 5 3 6 7 | 3
 * 1 [3 -1 -3] 5 3 6 7 | 3
 * 1 3 [-1 -3 5] 3 6 7 | 5
 * 1 3 -1 [-3 5 3] 6 7 | 5
 * 1 3 -1 -3 [5 3 6] 7 | 6
 * 1 3 -1 -3 5 [3 6 7] | 7
 * 
 * Explanation 2:
 * Window position | Max
 * --------------------|-------
 * [1 2 3 4 2 7] 1 3 6 | 7
 * 1 [2 3 4 2 7 1] 3 6 | 7
 * 1 2 [3 4 2 7 1 3] 6 | 7
 * 1 2 3 [4 2 7 1 3 6] | 7
 */

/**
 * using sliding window + Dequeue approach
 * TC: O(N) - optimization to O(N) using dequeue
 * SC: O(N)
 */
public class q2_SlidingWindowMaximum_usingDeQueue {

    /* This approach uses the Dequeue + sliding window */
    /* TC: O(N) */
    /* SC: O(N) */

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] slidingMaximum(final int[] A, int B) {

        // initialize Deque and output array
        Deque<Integer> deque = new LinkedList<Integer>();
        // total windows/subrrays of size K will be N-K+1
        int output[] = new int[A.length - B + 1];
        int index = 0;

        // perform operations for first window
        for (int i = 0; i < B; i++) {

            while (deque.size() != 0 && deque.peekLast() < A[i]) {
                // remove from last until last element is < current element being inserted
                deque.pollLast();
            }
            // insert at last position
            deque.offerLast(A[i]);
        }
        // update answer
        output[index++] = deque.peekFirst();

        // for repeat similar for other windows
        for (int i = 1; i <= A.length - B; i++) {

            int eleToAdd = A[i + B - 1];
            int eleToRemove = A[i - 1];

            while (deque.size() != 0 && deque.peekLast() < eleToAdd) {
                deque.pollLast();
            }
            // insert at last position
            deque.offerLast(eleToAdd);

            // if element being removed is at front position of deque, remove it
            if (deque.peekFirst() == eleToRemove) {
                deque.pollFirst();
            }
            // update answer
            output[index++] = deque.peekFirst();
        }

        return output;
    }

    public static void print(int[] list) {
        System.out.println();
        for (int temp : list) {
            System.out.print(temp + " ");
        }
    }

    public static void main(String[] args) {

        // test case 1
        int[] A1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int B1 = 3;
        int[] output1 = slidingMaximum(A1, B1);
        print(output1); // expected output [3,3,5,5,6,7]

        // test case 2
        int[] A2 = { 1, 2, 3, 4, 2, 7, 1, 3, 6 };
        int B2 = 6;
        int[] output2 = slidingMaximum(A2, B2);
        print(output2); // expected output [7,7,7,7]

        // test case 3
        int[] A3 = { 10, 1, 8, 9, 7, 6, 5, 11, 3 };
        int B3 = 3;
        int[] output3 = slidingMaximum(A3, B3);
        print(output3); // expected output [10 9 9 9 7 11 11]

        // test case 4
        int[] A4 = { 3, 15, 6, 15, 12, 4, 2, 10, 9, 3, 7, 2, 9, 3 };
        int B4 = 4;
        int[] output4 = slidingMaximum(A4, B4);
        print(output4); // expected output [15 15 15 15 12 10 10 10 9 9 9]
    }

}
