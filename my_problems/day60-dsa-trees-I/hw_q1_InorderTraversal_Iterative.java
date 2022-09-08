/*
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

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

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Inorder traversal Iterative using Stack */
public class hw_q1_InorderTraversal_Iterative {

    public static void main(String[] args) {
        hw_q1_InorderTraversal_Recursive t1 = new hw_q1_InorderTraversal_Recursive();
        TreeNode root = TreeUtils.createTestTree();
        int[] result = t1.inorderTraversal(root);
        System.out.println(Arrays.toString(result));
    }

    public int[] inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                TreeNode top = stack.pop();
                result.add(top.val);
                curr = top.right;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
