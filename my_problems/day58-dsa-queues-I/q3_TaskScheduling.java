import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * Problem Description
 * 
 * A CPU has N tasks to be performed. It is to be noted that the tasks have to
 * be performed in a specific order to avoid deadlock. In every clock cycle the
 * CPU can either perform a task or move it to the back of the queue. You are
 * given the current state of the scheduler queue in an array A and the required
 * order of the tasks in an array B.
 * Determine the minimum number of clock cycles to complete all the tasks.
 * 
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i], B[i] <= N
 * 
 * Input Format
 * First argument consist of integer array A.
 * Second argument consist of integer array B.
 * 
 * Output Format
 * Return an integer denoting the minimum number of clock cycles required to
 * complete all the tasks.
 * 
 * Example Input
 * Input 1:
 * A = [2, 3, 1, 5, 4]
 * B = [1, 3, 5, 4, 2]
 * Input 2:
 * A = [1]
 * B = [1]
 * 
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 1
 * 
 * Example Explanation
 * Explanation 1:
 * According to the order array B task 1 has to be performed first, so the CPU
 * will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
 * Total clock cycles till now = 2
 * Now CPU will perform task 1.
 * Total clock cycles till now = 3
 * Now, queue becomes [5, 4, 2, 3]
 * Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back
 * one-by-one.
 * Total clock cycles till now = 6
 * Now all the tasks in the queue are as in the required order so the CPU will
 * perform them one-by-one.
 * Total clock cycles = 10
 * Explanation 2:
 * 
 * Directly task 1 is completed.
 */
public class q3_TaskScheduling {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        // build Queue same as array
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Integer val : A) {
            queue.add(val);
        }

        int count = 0;
        for (int i = 0; i < B.size(); i++) {
            int taskToPerform = B.get(i);

            while (queue.peek() != taskToPerform) {
                int x = queue.poll();
                queue.add(x);
                // for each operation, increase clock cycle count
                count++;
            }

            if (queue.peek() == taskToPerform) {
                queue.poll();
                // for each operation, increase clock cycle count
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        // test case 1
        int[] A1 = { 2, 3, 1, 5, 4 };
        ArrayList<Integer> listA1 = new ArrayList<Integer>();
        for (int a : A1) {
            listA1.add(a);
        }
        int[] B1 = { 1, 3, 5, 4, 2 };
        ArrayList<Integer> listB1 = new ArrayList<Integer>();
        for (int b : B1) {
            listB1.add(b);
        }
        System.out.println("answer ->" + solve(listA1, listB1)); // expected output 10

        // test case 2
        int[] A2 = { 3, 5, 4, 2, 6, 7, 1, 8, 9, 10 };
        ArrayList<Integer> listA2 = new ArrayList<Integer>();
        for (int a : A2) {
            listA2.add(a);
        }
        int[] B2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ArrayList<Integer> listB2 = new ArrayList<Integer>();
        for (int b : B2) {
            listB2.add(b);
        }
        System.out.println("answer ->" + solve(listA2, listB2)); // expected output 33

        // test case 3
        int[] A3 = { 3 };
        ArrayList<Integer> listA3 = new ArrayList<Integer>();
        for (int a : A3) {
            listA3.add(a);
        }
        int[] B3 = { 3 };
        ArrayList<Integer> listB3 = new ArrayList<Integer>();
        for (int b : B3) {
            listB3.add(b);
        }
        System.out.println("answer ->" + solve(listA3, listB3)); // expected output 1
    }

}
