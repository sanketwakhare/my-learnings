/* Depth of Each Node */

/*
Problem Description

You are given the root node of a binary tree A. Each node has a value val and depth depth.

Initially depth of each node is set to -1. You have to fill the depth of each node with its correct value.
Depth of a node T is the number of nodes along the longest path from the root node down to node T. Also, depth of root node is always equal to 1.


Problem Constraints

1 <= Number of nodes <= 10^5
0 <= Value of each node <= 10^9
Initially, Depth of each node(depth) is set to -1.


Input Format

First and only argument is a tree node A.


Output Format

There is no output required.



Example Input

Input 1:


 Values =  1        Depths = -1
          / \                / \
         4   3             -1  -1
Input 2:


 Values =  1        Depths = -1
          / \                / \
         4   3             -1  -1
        /                  /
       2                 -1


Example Output

Output 1:


 Values =  1        Depths =  1
          / \                / \
         4   3              2   2
Output 2:


 Values =  1        Depths =  1
          / \                / \
         4   3              2   2
        /                  /
       2                  3


Example Explanation

Explanation 1:

 Depth of node having value 1 = 1 (root node)
 Depth of node having value 4 = 2
 Depth of node having value 3 = 2
Explanation 2:

 Depth of node having value 1 = 1 (root node)
 Depth of node having value 4 = 2
 Depth of node having value 3 = 2
 Depth of node having value 2 = 3

*/


public class xArch_Depth_of_Each_Node {
    static void solve(TreeNode A) {
        getDepth(A, 0);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        root1.left = left;
        root1.right = right;

        solve(root1);
    }

    public static int getDepth(TreeNode root, int parentDepth) {
        if (root == null) return -1;

        root.depth = parentDepth + 1;
        if (root.left != null) {
            root.left.depth = getDepth(root.left, parentDepth + 1);
        }
        if (root.right != null) {
            root.right.depth = getDepth(root.right, parentDepth + 1);
        }
        return root.depth;
    }

    //Definition for TreeNode.
    private static class TreeNode {
        public int val;
        public int depth;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.depth = -1;
        }
    }
}
