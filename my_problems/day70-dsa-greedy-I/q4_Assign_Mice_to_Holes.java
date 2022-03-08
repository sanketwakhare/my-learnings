import java.util.Arrays;

/* Assign Mice to Holes */

/* Problem Description

There are N Mice and N holes that are placed in a straight line. Each hole can accomodate only 1 mouse.

The positions of Mice are denoted by array A and the position of holes are denoted by array B.

A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.

Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.


Problem Constraints

1 <= N <= 10^5
-10^9 <= A[i], B[i] <= 10^9


Input Format

First argument is an integer array A.
Second argument is an integer array B.


Output Format

Return an integer denoting the minimum time when the last nouse gets inside the holes.


Example Input

Input 1:

 A = [-4, 2, 3]
 B = [0, -2, 4]
Input 2:

 A = [-2]
 B = [-6]

Example Output

Output 1:

 2
Output 2:

 4

Example Explanation

Explanation 1:

 Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
 The number of moves required will be 2, 2 and 1 respectively.
 So, the time taken will be 2.
Explanation 2:

 Assign the mouse at position -2 to -6.
 The number of moves required will be 4.
 So, the time taken will be 4. */

/**
 * Idea: Sort both the arrays -> which will place the mice to its possibly
 * closer holes
 * Then find the difference corresponding elements of array A and array B
 * return max difference - > time taken for all mice
 * 
 * TC: O(N logN)
 * SC: O(1)
 */
public class q4_Assign_Mice_to_Holes {

    public int mice(int[] A, int[] B) {

        // sort A
        Arrays.sort(A);
        // sort B
        Arrays.sort(B);

        // find difference of each element from A and B array
        // and also maintain a max diff which is eventually the answer
        int diff = 0;
        int maxDiff = 0;
        for (int i = 0; i < A.length; i++) {
            diff = Math.abs(A[i] - B[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {

        q4_Assign_Mice_to_Holes t1 = new q4_Assign_Mice_to_Holes();

        int[] A = new int[] { -4, 2, 3 };
        int[] B = new int[] { 0, -2, 4 };
        System.out.println("answer: " + t1.mice(A, B)); // 2

        A = new int[] { -2 };
        B = new int[] { -6 };
        System.out.println("answer: " + t1.mice(A, B)); // 4

        A = new int[] { 4, -4, 2 };
        B = new int[] { 4, 0, 5 };
        System.out.println("answer: " + t1.mice(A, B)); // 4

    }

}