import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/* Nearest Smaller Element */

/**
 * Problem Description

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9

Input Format
The only argument given is integer array A.

Output Format
Return the integer array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.

Example Input
Input 1:
 A = [4, 5, 2, 10, 8]
Input 2:
 A = [3, 2, 1]

Example Output
Output 1:
[-1, 4, -1, 2, 2]
Output 2:
 [-1, -1, -1]

Example Explanation
Explanation 1:
index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

Explanation 2:
index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1
 */

/**
 * Find nearest/closest smaller element on <b>LEFT</b>
 * 
 * TC: O(N) as each element can be pushed and popped from stack only once-> 2n
 * operations for N elements
 * SC: O(N) for stack
 */
public class q2_NearestSmallerElement {

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        // stack to store the index of elements instead of actual element
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            // x is current element
            int x = A.get(i);

            // pop elements from array until top is > x
            // as those elements can not be smaller to any elements on right ith/current
            // element

            // while(!stack.isEmpty() && stack.peek() >= x) { value can also be stored
            // instead of indexes
            while (!stack.isEmpty() && A.get(stack.peek()) >= x) {
                stack.pop();
            }

            // if current stack is empty, closest min oin left is -1
            if (stack.isEmpty()) {
                output.add(-1);
            } else {
                // closest min on left of x is top of stack
                // output.add(stack.peek()); value can also be stored instead of indexes
                output.add(A.get(stack.peek()));
            }
            // add x into stack as x can be possible answer to elements on right
            // stack.push(x); value can also be stored instead of indexes
            stack.push(i);

        }
        return output;
    }

    public static void main(String[] args) {

        // test 1: A = [39, 27, 11, 4, 24, 32, 32, 1]
        // expected answer: -1 -1 -1 -1 4 24 24 -1
        Integer[] A1 = { 39, 27, 11, 4, 24, 32, 32, 1 };
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(A1));
        ArrayList<Integer> outList1 = prevSmaller(list1);
        System.out.println();
        for (Integer result : outList1) {
            System.out.print(result + " ");
        }

        // test 2: A = [4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3]
        // expected answer: -1 4 -1 2 2 2 7 7 8 2 2 3 3 -1 1 2
        Integer[] A2 = { 4, 5, 2, 10, 8, 7, 9, 8, 15, 4, 3, 20, 12, 1, 2, 3 };
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(A2));
        ArrayList<Integer> outList2 = prevSmaller(list2);
        System.out.println();
        for (Integer result : outList2) {
            System.out.print(result + " ");
        }
    }
}
