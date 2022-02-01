import java.util.Stack;

/* Sort Stack Using Another Stack */

/**
 * Problem Description
 * 
 * Given a stack of integers A, sort it using another stack.
 * Return the array of integers after sorting the stack using another stack.
 * 
 * Problem Constraints
 * 1 <= |A| <= 5000
 * 0 <= A[i] <= 1000000000
 * 
 * Input Format
 * The only argument given is the integer array A.
 * 
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 * 
 * Example Input
 * Input 1:
 * A = [5, 4, 3, 2, 1]
 * Input 2:
 * A = [5, 17, 100, 11]
 * 
 * Example Output
 * Output 1:
 * [1, 2, 3, 4, 5]
 * Output 2:
 * [5, 11, 17, 100]
 * 
 * Example Explanation
 * Explanation 1:
 * Just sort the given numbers.
 * Explanation 2:
 * Just sort the given numbers.
 */

public class hw_q4_SortStackUsingAnotherStack {

    public static int[] solve(int[] A) {

        // push all array elements into stack1
        Stack<Integer> stack1 = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            stack1.push(A[i]);
        }

        // maintain the stack 2 in descending order
        Stack<Integer> stack2 = new Stack<Integer>();
        while (!stack1.isEmpty()) {

            int x = stack1.pop();

            while (!stack2.isEmpty() && x < stack2.peek()) {

                int temp = stack2.pop();
                stack1.push(temp);
            }
            stack2.push(x);
        }

        // push back all the elements from stack2 into stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // update the input array A so that it will be sorted
        int i = 0;
        while (!stack1.isEmpty()) {
            A[i] = stack1.pop();
            i++;
        }

        return A;
    }

    public static void print(int[] A) {
        System.out.println();
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = { 66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12 };
        A = solve(A);
        print(A);

        print(solve(new int[] { 5, 4, 3, 2, 1 }));
        print(solve(new int[] { 5, 17, 100, 11 }));
    }

}
