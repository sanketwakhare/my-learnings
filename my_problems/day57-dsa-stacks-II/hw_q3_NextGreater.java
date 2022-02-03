import java.util.Stack;

/* Next Greater */

/**
 * Problem Description
 * 
 * Given an array A, find the next greater element G[i] for every element A[i]
 * in the array. The Next greater Element for an element A[i] is the first
 * greater element on the right side of A[i] in array, A.
 * 
 * More formally:
 * 
 * G[i] for an element A[i] = an element A[j] such that
 * j is minimum possible AND
 * j > i AND
 * A[j] > A[i]
 * Elements for which no greater element exists, consider the next greater
 * element as -1.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^5
 * 1 <= A[i] <= 10^7
 * 
 * Input Format
 * The first and the only argument of input contains the integer array, A.
 * 
 * Output Format
 * Return an integer array representing the next greater element for each index
 * in A.
 * 
 * Example Input
 * Input 1:
 * A = [4, 5, 2, 10]
 * Input 2:
 * A = [3, 2, 1]
 * 
 * Example Output
 * Output 1:
 * [5, 10, 10, -1]
 * Output 2:
 * [-1, -1, -1]
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * For 4, the next greater element towards its right is 5.
 * For 5 and 2, the next greater element towards their right is 10.
 * For 10, there is no next greater element towards its right.
 * 
 * Explanation 2:
 * As the array is in descending order, there is no next greater element for all
 * the elements.
 */

/***
 * Find closest max on RIGHT of array
 * TC: O(N)
 * SC: O(N)
 */
public class hw_q3_NextGreater {

    public static int[] nextGreater(int[] A) {

        Stack<Integer> stack = new Stack<Integer>();
        int[] nextGreaterArray = new int[A.length];

        // traverse from right to left
        for (int i = A.length - 1; i >= 0; i--) {
            // remove all elements from stack which are less than = current element
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            // update output array nextGreaterArray
            if (stack.isEmpty()) {
                nextGreaterArray[i] = -1;
            } else {
                nextGreaterArray[i] = stack.peek();
            }
            // update stack - pus current elemnt in stack
            stack.push(A[i]);
        }

        return nextGreaterArray;
    }

    public static void main(String[] args) {
        // test case 1
        int[] A1 = { 4, 5, 2, 10 };
        int[] rightClosestMax = nextGreater(A1);
        System.out.println();
        for (Integer result : rightClosestMax) {
            System.out.print(result + " ");
        }

        // test case 2
        int[] A2 = { 3, 2, 1 };
        rightClosestMax = nextGreater(A2);
        System.out.println();
        for (Integer result : rightClosestMax) {
            System.out.print(result + " ");
        }

    }

}
