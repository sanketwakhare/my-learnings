import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Find nearest/closest smaller element on RIGHT of current element
 */
public class class_NearestSmallerElementOnRight {

    public static ArrayList<Integer> nextSmaller(ArrayList<Integer> A) {

        // stack to store the index of elements instead of actual element
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        // traverse from right
        for (int i = A.size() - 1; i >= 0; i--) {
            // x is current element
            int x = A.get(i);

            // pop elements from array until A[top] is >= x
            while (!stack.isEmpty() && A.get(stack.peek()) >= x) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // store array size when no smaller element on right
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
        // expected answer: 27 11 4 1 1 1 1 8
        Integer[] A1 = { 39, 27, 11, 4, 24, 32, 32, 1 };
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(A1));
        ArrayList<Integer> outList1 = nextSmaller(list1);
        System.out.println();
        for (Integer result : outList1) {
            System.out.print(result + " ");
        }

        // test 2: A = [4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3]
        // expected answer: 2 2 1 8 7 4 8 4 4 3 1 12 1 16 16 16
        Integer[] A2 = { 4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3 };
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(A2));
        ArrayList<Integer> outList2 = nextSmaller(list2);
        System.out.println();
        for (Integer result : outList2) {
            System.out.print(result + " ");
        }

        // test 3: A = [2, 13, 8, 5, 4, 7]
        // expected answer: 6 8 5 4 6 6
        Integer[] A3 = { 2, 13, 8, 5, 4, 7 };
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(A3));
        ArrayList<Integer> outList3 = nextSmaller(list3);
        System.out.println();
        for (Integer result : outList3) {
            System.out.print(result + " ");
        }
    }
}
