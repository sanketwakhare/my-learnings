import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Find nearest/closest greater element on RIGHT of current element
 */
public class class_NearestGreaterElementOnRight {

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {

        // stack to store the index of elements instead of actual element
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        // traverse from right
        for (int i = A.size() - 1; i >= 0; i--) {
            // x is current element
            int x = A.get(i);

            // pop elements from array until A[top] is <= x
            while (!stack.isEmpty() && A.get(stack.peek()) <= x) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // store array size when no greater element on right
                output.add(A.size());
            } else {
                output.add(A.get(stack.peek()));
            }

            // add current index i into stack as A[i] or x can be possible answer
            stack.push(i);
        }

        // reverse list and return
        reverseList(output);
        return output;
    }

    private static void reverseList(ArrayList<Integer> list) {
        // reverse the output ArrayList
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            int temp2 = list.get(j);
            list.remove(i);
            list.add(i, temp2);
            list.remove(j);
            list.add(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        // test 1: A = [39, 27, 11, 4, 24, 32, 32, 1]
        // expected answer: 8 32 24 24 32 8 8 8
        Integer[] A1 = { 39, 27, 11, 4, 24, 32, 32, 1 };
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(A1));
        ArrayList<Integer> outList1 = nextGreater(list1);
        System.out.println();
        for (Integer result : outList1) {
            System.out.print(result + " ");
        }

        // test 2: A = [4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3]
        // expected answer: 5 10 10 15 9 9 15 15 20 20 20 16 16 2 3 16
        Integer[] A2 = { 4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3 };
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(A2));
        ArrayList<Integer> outList2 = nextGreater(list2);
        System.out.println();
        for (Integer result : outList2) {
            System.out.print(result + " ");
        }

        // test 3: A = [2, 13, 8, 5, 4, 7]
        // expected answer: 13 6 6 7 7 6
        Integer[] A3 = { 2, 13, 8, 5, 4, 7 };
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(A3));
        ArrayList<Integer> outList3 = nextGreater(list3);
        System.out.println();
        for (Integer result : outList3) {
            System.out.print(result + " ");
        }
    }
}
