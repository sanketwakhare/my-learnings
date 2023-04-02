/* Counting the Nodes */

/* Problem Description
Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.

Problem Constraints
1 <= Number of Nodes <= 200000
1 <= Value of Nodes <= 2000000000

Input Format
The first and only argument of input is a tree node.

Output Format
Return a single integer denoting the count of nodes that have more value than all of its ancestors.

Example Input
Input 1:

     3
Input 2:

    4
   / \
  5   2
     / \
    3   6

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 There's only one node in the tree that is the valid node.
Explanation 2:
 The valid nodes are 4, 5 and 6. */


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class xArch_CountingTheNodes {

    public int solve(TreeNode A) {
        if(A == null) return 0;
        int max = A.val;
        // root node
        return 1 + count(A, max);
    }

    public int count(TreeNode root, int max) {
        if(root == null) return 0;
        int currCount = 0;
        if(root.val > max) {
            currCount++;
        }
        return currCount + count(root.left, Math.max(max, root.val)) + count(root.right, Math.max(max, root.val));
    }

    public static void main(String[] args) {

        xArch_CountingTheNodes t1 = new xArch_CountingTheNodes();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(14);
        root.right.left.right = new TreeNode(5);
        System.out.println(t1.solve(root)); // 4

        root = new TreeNode(4);
        System.out.println(t1.solve(root)); // 1

        root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(t1.solve(root)); // 3
    }
}
