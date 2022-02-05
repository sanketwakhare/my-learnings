import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* N integers containing only 1, 2 & 3 */

/**
 * Problem Description
 * 
 * Given an integer A. Find and Return first positive A integers in ascending
 * order containing only digits 1, 2 and 3.
 * NOTE: All the A integers will fit in 32 bit integer.
 * 
 * Problem Constraints
 * 1 <= A <= 29500
 * 
 * Input Format
 * The only argument given is integer A.
 * 
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending
 * order containing only digits 1, 2 and 3.
 * 
 * Example Input
 * Input 1:
 * A = 3
 * Input 2:
 * A = 7
 * 
 * Example Output
 * Output 1:
 * [1, 2, 3]
 * Output 2:
 * [1, 2, 3, 11, 12, 13, 21]
 * 
 * Example Explanation
 * Explanation 1:
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class q2_N_IntegersContainingOnly_1_2_and_3 {

    public static ArrayList<Integer> solve(int A) {

        // use queue to store the elements which can be used as reference to generate
        // the next numbers with required pattern
        Queue<Integer> queue = new LinkedList<Integer>();
        // use array to store the Nth elements
        ArrayList<Integer> list = new ArrayList<Integer>();

        // condition for first 3 numbers
        int count = 0;
        int[] numbers = { 1, 2, 3 };
        while (count < A && count < numbers.length) {
            list.add(numbers[count]);
            queue.add(numbers[count]);
            count++;
        }
        if (count < numbers.length) {
            return list;
        }

        // A > 3 here
        while (count < A && !queue.isEmpty()) {
            // pop the first element from queue. This will be used to generate next number
            // in sequence
            int x = queue.poll();
            int i = 0;
            while (count < A && i < numbers.length) {
                // generate next number in sequence
                int next = (x * 10) + numbers[i];

                // add element to end of the queue
                queue.add(next);
                // add element in list
                list.add(next);
                i++;
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println("answer -> " + solve(1));
        // expected answer [1, 2, 3, 11]
        System.out.println("answer -> " + solve(4));
        System.out.println("answer -> " + solve(3));
        System.out.println("answer -> " + solve(2));
        System.out.println("answer -> " + solve(10));
        // expected answer [1, 2, 3, 11, 12, 13, 21, 22, 23, 31, 32, 33, 111, 112, 113,
        // 121, 122, 123, 131, 132, 133]
        System.out.println("answer -> " + solve(21));
    }

}
