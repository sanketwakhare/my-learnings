/* Tree Height */

/* Problem Description

You are given the root node of a binary tree A, You have to find the height of the given tree.
A binary tree's height is the number of nodes along the longest path from the root node down to the farthest leaf node.

Problem Constraints
1 <= Number of nodes in the tree <= 10^5
0 <= Value of each node <= 10^9

Input Format
First and only argument is a tree node A.

Output Format
Return an integer denoting the height of the tree.

Example Input
Input 1:

 Values =  1 
          / \     
         4   3                        

Input 2:
 
 Values =  1      
          / \     
         4   3                       
        /         
       2                                     

Example Output
Output 1:
 2 
Output 2:
 3 

Example Explanation

Explanation 1:
 Distance of node having value 1 from root node = 1
 Distance of node having value 4 from root node = 2 (max)
 Distance of node having value 3 from root node = 2 (max)

Explanation 2:
 Distance of node having value 1 from root node = 1
 Distance of node having value 4 from root node = 2
 Distance of node having value 3 from root node = 2
 Distance of node having value 2 from root node = 3 (max) */

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

/**
 * Find height of tree using recursion
 * TC: O(N)
 * SC: O(N) for recursive stack
 */
public class q3_TreeHeight {

    // height of root node of the tree
    public static int height(TreeNode root) {
        // base condition
        if (root == null) {
            return 0;
        }
        // recursive relation to find height
        // max (height of left subtree, height of right subtree) + 1
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int solve(TreeNode A) {
        return height(A);
    }

    public static void main(String[] args) {

        TreeNode A = TreeUtils.createTree();
        System.out.println("height of tree -> " + height(A));

        TreeNode B = TreeUtils.getRandomNode();
        System.out.println("height of tree -> " + height(B));

        TreeNode C = TreeUtils.getRandomNode();
        TreeUtils.insertLeft(C, 10);

        System.out.println("height of tree -> " + height(C));
    }

}
