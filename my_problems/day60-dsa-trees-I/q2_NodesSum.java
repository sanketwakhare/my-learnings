/* Nodes Sum */

/* 
Problem Description

You are given the root node of a binary tree A. You have to find the sum of node values of this tree.

Problem Constraints
1 <= Number of nodes in the tree <= 10^5
0 <= Value of each node <= 10^4

Input Format
First and only argument is a tree node A.

Output Format
Return an integer denoting the sum of node values of the tree.

Example Input
Input 1:

 Values =  1 
          / \     
         4   3                        

Input 2:

 Values =  1      
          / \     
         8   3                       
        /         
       2                                     

Example Output
Output 1:
 8 
Output 2:
 14 

Example Explanation

Explanation 1:
Clearly, 1 + 4 + 3 = 8.

Explanation 2:
Clearly, 1 + 8 + 3 + 2 = 14. */

/**
 * Recursive approach
 * TC: O(N)
 * SC: O(N)
 */

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */

/**
 * sum all tree elements node values
 * TC: O(N)
 * SC: O(N) for recursive stack
 */
public class q2_NodesSum {

    // find sum of all nodes in Tree
    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.val;
    }

    public int solve(TreeNode A) {
        return sum(A);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree();
        TreeUtils.printTree(root);
        System.out.println("sum ->" + sum(root));
    }

}
