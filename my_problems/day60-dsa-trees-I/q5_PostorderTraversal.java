import java.util.ArrayList;

/* Postorder Traversal */

/* Problem Description

Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.

Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:
 [3, 2, 1]
Output 2:
 [6, 3, 2, 1]

Example Explanation

Explanation 1:

 The Postorder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Postorder Traversal of the given tree is [6, 3, 2, 1]. */

/**
 * PostOrder traversal
 * TC: O(N)
 * SC: O(N)
 */
public class q5_PostorderTraversal {

    // pass output ArrayList as reference to store the values
    public static void postOrder(TreeNode root, ArrayList<Integer> output) {
        if (root == null) {
            return;
        }
        postOrder(root.left, output);
        postOrder(root.right, output);
        output.add(root.val);
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        postOrder(A, output);
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        ArrayList<Integer> postOrderList = new ArrayList<Integer>();
        postOrder(root, postOrderList);
        System.out.println("\nPostOrder traversal -> ");
        for (int ele : postOrderList) {
            System.out.print(ele + " ");
        }
    }
}
