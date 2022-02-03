import java.util.Stack;

/*  Largest Rectangle in Histogram */

/**
 * Problem Description
 * 
 * Given an array of integers A .
 * A represents a histogram i.e A[i] denotes height of the ith histogram's bar.
 * Width of each bar is 1.
 * Find the area of the largest rectangle formed by the histogram.
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 1000000000
 * 
 * Input Format
 * The only argument given is the integer array A.
 * 
 * Output Format
 * Return the area of largest rectangle in the histogram.
 * 
 * Example Input
 * Input 1:
 * A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 * A = [2]
 * 
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 * Largest rectangle has area 2.
 */

/**
 * Idea: find closest min on left and closest min on right
 * For every index/array element, fix the height, now find the max possible
 * width for current index/element
 * 
 * Area = height * width
 */
public class q3_LargestRectangleInHistogram {

    // generate closest minimum on LEFT for input array
    public static final int[] prevSmaller(int[] A) {
        int[] output = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = stack.peek();
            }
            stack.push(i);
        }
        return output;
    }

    // generate closest minimum on RIGHT for input array
    public static final int[] nextSmaller(int[] A) {
        int[] output = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output[i] = A.length;
            } else {
                output[i] = stack.peek();
            }
            stack.push(i);
        }
        return output;
    }

    public static int findLargestRectangleAreaInHistogram(int[] A) {

        int[] prevSmallerArray = prevSmaller(A);
        int[] nextSmallerArray = nextSmaller(A);
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            // fix i and find closest min onb left and closest min on right
            int area = A[i] * (nextSmallerArray[i] - prevSmallerArray[i] - 1);
            answer = Math.max(answer, area);
        }

        return answer;
    }

    public static void main(String[] args) {
        // test case 1
        // expected answer 10
        int[] A1 = { 2, 1, 5, 6, 2, 3 };
        int answer = findLargestRectangleAreaInHistogram(A1);
        System.out.println("answer -> " + answer);

        // test case 2
        // expected answer 45
        int[] A2 = { 45 };
        answer = findLargestRectangleAreaInHistogram(A2);
        System.out.println("answer -> " + answer);
    }

}
