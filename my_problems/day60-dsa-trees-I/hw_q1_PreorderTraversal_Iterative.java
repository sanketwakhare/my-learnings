/*
Problem Description
Given a binary tree, return the preorder traversal of its nodes values.

NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the preorder traversal of the given binary tree.

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
 [1, 2, 3]
Output 2:
 [1, 6, 2, 3]

Example Explanation
Explanation 1:
 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:
 The Preoder Traversal of the given tree is [1, 6, 2, 3].*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Preorder traversal Recursive */
public class hw_q1_PreorderTraversal_Iterative {

    public static void main(String[] args) {
        hw_q1_PreorderTraversal_Iterative t1 = new hw_q1_PreorderTraversal_Iterative();
        TreeNode root = TreeUtils.createTestTree();
        int[] result = t1.preorderTraversal(root);
        System.out.println(Arrays.toString(result));
    }

    public int[] preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    result.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                }
                TreeNode top = stack.pop();
                curr = top.right;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
