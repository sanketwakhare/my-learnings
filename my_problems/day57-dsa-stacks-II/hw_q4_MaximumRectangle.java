/* Maximum Rectangle */

/** 
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Input Format
The only argument given is the integer matrix A.

Output Format
Return the area of the largest rectangle containing only 1's.

Constraints
1 <= N, M <= 1000
0 <= A[i] <= 1

For Example
Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1
*/
import java.util.Stack;

/**
 * Idea: use the histogram problem as reference. For each row find the area and
 * combine for next rows
 * TC: O(N^M)
 * SC: O(M)
 */
public class hw_q4_MaximumRectangle {

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

    public static int solve(int[][] A) {

        int N = A.length;
        int M = A[0].length;
        // for each row find the largest area of rectangle
        int answer = 0;
        int[] row = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int prevVal = row[j];
                if (A[i][j] == 0 && i > 0) {
                    row[j] = 0;
                } else {
                    row[j] = prevVal + A[i][j];
                }
            }
            answer = Math.max(answer, findLargestRectangleAreaInHistogram(row));
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        // test case 1
        int[][] A1 = new int[][] { new int[] { 0, 1, 1 },
                new int[] { 1, 0, 0 },
                new int[] { 1, 0, 0 },
                new int[] { 1, 0, 0 },
                new int[] { 1, 0, 0 },
                new int[] { 1, 1, 1 },
                new int[] { 0, 1, 0 } };
        solve(A1); // expected answer 5

        // test case 2
        int[][] A2 = new int[][] { new int[] { 0, 0, 1 },
                new int[] { 0, 1, 1 },
                new int[] { 1, 1, 1 } };
        solve(A2); // expected answer 4

        // test case 3
        int[][] A3 = new int[][] { new int[] { 0, 1, 0, 1 },
                new int[] { 1, 0, 1, 0 } };
        solve(A3); // expected answer 1
    }

}
