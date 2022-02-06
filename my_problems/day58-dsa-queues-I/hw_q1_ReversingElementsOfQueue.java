import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Reversing Elements Of Queue */

/***
 * Problem Description

Given an array of integers A and an integer B. We need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.
NOTE: You are required to first insert elements into an auxiliary queue then perform Reversal of first B elements.

Problem Constraints
1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000

Input Format
The argument given is the integer array A and an integer B.

Output Format
Return an array of integer after reversing the first B elements of A using queue.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 3
Input 2:
 A = [5, 17, 100, 11]
 B = 2

Example Output
Output 1:
 [3, 2, 1, 4, 5]
Output 2:
 [17, 5, 100, 11]

Example Explanation
Explanation 1:
 Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
Explanation 2:
 Reverse first 2 elements so the array becomes [17, 5, 100, 11]
 */

/**
 * Use Stack to reverse the elements in Queue
 */
public class hw_q1_ReversingElementsOfQueue {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        // stack to store first B elements which can be fetched in reverse direction
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < B; i++) {
            stack.push(A.get(i));
        }

        // update the input array, first B elements in reverse direction
        int i = 0;
        while (!stack.isEmpty()) {
            A.set(i, stack.pop());
            i++;
        }

        return A;

    }

    public static void main(String[] args) {

        // test case 1
        int[] A = { 1, 2, 3, 4, 5 };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int a : A) {
            list.add(a);
        }
        int B = 3;
        System.out.println("answer ->" + solve(list, B));

        // test case 2
        int[] A2 = { 17, 5, 100, 11 };
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int a : A2) {
            list2.add(a);
        }
        int B2 = 2;
        System.out.println("answer ->" + solve(list2, B2));
    }
}
