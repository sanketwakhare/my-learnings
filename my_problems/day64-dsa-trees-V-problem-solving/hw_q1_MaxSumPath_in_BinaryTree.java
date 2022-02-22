/* Max Sum Path in Binary Tree */

/* 
Problem Description

Given a binary tree T, find the maximum path sum.
The path may start and end at any node in the tree.

Problem Constraints
1 <= Number of Nodes <= 7e4
-1000 <= Value of Node in T <= 1000

Input Format
The first and the only argument contains a pointer to the root of T, A.

Output Format
Return an integer representing the maximum sum path.

Example Input
Input 1:
  
    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50

Example Output

Output 1:
 6
Output 2:
 40

Example Explanation

Explanation 1:
     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:
     The path with maximum sum is: 20 -> 20
 */

public class hw_q1_MaxSumPath_in_BinaryTree {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x = maxPath(root.left);
        int y = maxPath(root.right);

        // store the maxSum for all the nodes
        maxSum = Math.max(maxSum, root.val + Math.max(x, 0) + Math.max(y, 0));

        // return max sum for including current root/node
        return Math.max(Math.max(x, y), 0) + root.val;
    }

    public static int maxPathSum(TreeNode A) {
        maxSum = Integer.MIN_VALUE;
        maxPath(A);
        return maxSum;
    }

    public static void main(String[] args) {

        // test 1
        // @formatter:off
        /*
         *     50
         *    /  \
         *   30   70
         *  / \   / \
         * 10 40 60  90
         *  \       /  \
         *   20    80  100
         */
        // @formatter:on
        TreeNode root = TreeUtils.createBST();
        System.out.println("answer -> " + maxPathSum(root));

        // test 2
        // @formatter:off
        /* 
              1
            /   \
           2     3
        */
        // @formatter:on
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("answer -> " + maxPathSum(root));

    }

}
