import java.util.Stack;

/* Max Rectangle in Binary Matrix */

/* Problem Description
Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.


Problem Constraints
1 <= N, M <= 100

Input Format
The first argument is a 2-D binary array A.


Output Format
Return an integer denoting the area of the largest rectangle containing only ones.


Example Input
Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 


Example Output
Output 1:

 4
Output 2:

 3


Example Explanation
Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2). */
public class hw_q2_Max_Rectangle_in_Binary_Matrix {

    public int maximalRectangle(int[][] A) {

        // for every row, find max rectangle area using max area under histogram
        // technique

        int area, maxArea = 0;
        int[] prevMin;
        int[] nextMin;

        int[] temp = new int[A[0].length];
        temp = A[0];
        prevMin = getPrevMinIndex(temp);
        nextMin = getNextMinIndex(temp);
        area = getMaxArea(temp, prevMin, nextMin);
        maxArea = Math.max(maxArea, area);

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    temp[j] = temp[j] + A[i][j];
                } else {
                    temp[j] = 0;
                }
            }
            prevMin = getPrevMinIndex(temp);
            nextMin = getNextMinIndex(temp);
            area = getMaxArea(temp, prevMin, nextMin);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int getMaxArea(int[] A, int[] prevMin, int[] nextMin) {
        int maxArea = 0;

        for (int i = 0; i < A.length; i++) {
            int prevMinIndex = prevMin[i];
            int nextMinIndex = nextMin[i];

            int width = nextMinIndex - prevMinIndex - 1;
            int currentArea = width * A[i];
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    private int[] getNextMinIndex(int[] A) {

        int[] nextMin = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = A.length - 1; i >= 0; i--) {

            int currEle = A[i];

            while (!stack.isEmpty() && A[stack.peek()] >= currEle) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextMin[i] = A.length;
            } else {
                nextMin[i] = stack.peek();
            }
            stack.push(i);

        }

        return nextMin;
    }

    private int[] getPrevMinIndex(int[] A) {

        int[] prevMin = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; i++) {

            int currEle = A[i];

            while (!stack.isEmpty() && A[stack.peek()] >= currEle) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = stack.peek();
            }
            stack.push(i);

        }
        return prevMin;
    }

    public static void main(String[] args) {

        hw_q2_Max_Rectangle_in_Binary_Matrix t1 = new hw_q2_Max_Rectangle_in_Binary_Matrix();
        int[][] A;

        // test case 1
        A = new int[][] {
                { 1, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 0 }
        };
        System.out.println(t1.maximalRectangle(A));

    }

}
