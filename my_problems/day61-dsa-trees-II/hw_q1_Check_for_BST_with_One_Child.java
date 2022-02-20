
/* Check for BST with One Child */
import java.util.ArrayList;

/* Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints
1 <= number of nodes <= 100000

Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.

Output Format
Return a string "YES" if true else "NO".

Example Input
Input 1:
 A : [4, 10, 5, 8]
Input 2:
 A : [1, 5, 6, 4]

Example Output
Output 1:
 "YES"
Output 2:
 "NO"

Example Explanation
Explanation 1:
 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:
 There is no possible BST which have the above preorder traversal. */

public class hw_q1_Check_for_BST_with_One_Child {

    public static String solve(ArrayList<Integer> A) {

        int startRange = Integer.MIN_VALUE;
        int endRange = Integer.MAX_VALUE;

        if (A == null || A.size() == 0 || A.size() == 1) {
            return "YES";
        }

        // assume root is inserted, the range does not change
        int prev = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            int curr = A.get(i);
            if (curr < startRange || curr > endRange) {
                return "NO";
            }
            if (curr > prev) {
                // update start range
                startRange = prev + 1;
            } else if (curr < prev) {
                // update end range
                endRange = prev - 1;
            }
            // update prev
            prev = curr;
        }
        return "YES";
    }

    public static void main(String[] args) {

        // test case 1 A = [4, 10, 5, 8]
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(10);
        A.add(5);
        A.add(8);
        System.out.println(solve(A));

        // test case 1 A = [1, 5, 6, 4]
        A = new ArrayList<Integer>();
        A.add(1);
        A.add(5);
        A.add(6);
        A.add(4);
        System.out.println(solve(A));

    }

}
