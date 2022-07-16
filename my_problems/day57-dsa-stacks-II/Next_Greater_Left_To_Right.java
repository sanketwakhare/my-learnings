import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Left_To_Right {

    public int[] nextGreater(int[] A) {

        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (A[i] <= A[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                        output[stack.pop()] = A[i];
                    }
                    stack.push(i);
                }
            }
        }
        // for every element remaining in stack m insert -1 as answer
        while (!stack.isEmpty()) {
            output[stack.pop()] = -1;
        }
        return output;
    }

    public static void main(String[] args) {
        Next_Greater_Left_To_Right t1 = new Next_Greater_Left_To_Right();
        System.out.println(Arrays.toString(t1.nextGreater(new int[]{4, 6, 10, 11, 7, 8, 3, 5})));
    }

}
