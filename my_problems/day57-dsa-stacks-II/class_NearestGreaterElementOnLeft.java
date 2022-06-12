import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Find nearest/closest greater element on left of current element
 */
public class class_NearestGreaterElementOnLeft {

    public static ArrayList<Integer> prevGreater(ArrayList<Integer> A) {

        // stack to store the index of elements instead of actual element
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            // x is current element
            int x = A.get(i);

            // pop elements from array until A[top] is < x
            // as those elements can not be greater to any elements on right ith/current
            // element
            while (!stack.isEmpty() && A.get(stack.peek()) <= x) {
                stack.pop();
            }

            // if current stack is empty, the closest min oin left is -1
            if (stack.isEmpty()) {
                output.add(-1);
            } else {
                // closest greater on left of x is top of stack. retrieve by index
                output.add(A.get(stack.peek()));
            }
            // add index of x into stack as x can be possible answer to elements on right
            stack.push(i);

        }
        return output;
    }

    public static void main(String[] args) {

        // test 1: A = [39, 27, 11, 4, 24, 32, 32, 1]
        // expected answer: -1 39 27 11 27 39 32 32
        Integer[] A1 = { 39, 27, 11, 4, 24, 32, 32, 1 };
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(A1));
        ArrayList<Integer> outList1 = prevGreater(list1);
        System.out.println();
        for (Integer result : outList1) {
            System.out.print(result + " ");
        }

        // test 2: A = [4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3]
        // expected answer: -1 -1 5 -1 10 8 10 9 -1 15 4 -1 20 12 12 12
        Integer[] A2 = { 4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3 };
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(A2));
        ArrayList<Integer> outList2 = prevGreater(list2);
        System.out.println();
        for (Integer result : outList2) {
            System.out.print(result + " ");
        }

        // test 3: A = [2, 13, 8, 5, 4, 7]
        // expected answer: -1 -1 13 8 5 8
        Integer[] A3 = { 2, 13, 8, 5, 4, 7 };
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(A3));
        ArrayList<Integer> outList3 = prevGreater(list3);
        System.out.println();
        for (Integer result : outList3) {
            System.out.print(result + " ");
        }
    }
}
