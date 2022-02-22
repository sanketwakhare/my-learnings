/* Find Diameter of a Binary Tree/ longest path from any node */

/* 
Problem Description

Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

Problem Constraints
0 <= N <= 10^5

Input Format
First and only Argument represents the root of binary tree A.

Output Format
Return an single integer denoting the diameter of the tree.

Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:
 3
Output 2:
 4

Example Explanation
Explanation 1:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
*/

public class q2_diameter_of_tree {

    static int diameter = 0;

    // height function
    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = height(root.left);
        int r = height(root.right);

        diameter = Math.max(diameter, l + r + 2);

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {

        // test case 1
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
        // reset
        diameter = 0;
        height(root);
        System.out.println(diameter);
        // expected answer 6

        // test case 2
        // @formatter:off
        /*
         *         1
         *       /   \
         *      2     3
         *     / \ 
         *    4   5
         *   /      \
         *  8       50
         *            \
         *             60
         *               \
         *                70
         *                  \
         *                   80
         */
        // @formatter:on
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(50);
        root.left.right.right.right = new TreeNode(60);
        root.left.right.right.right.right = new TreeNode(70);
        root.left.right.right.right.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(8);

        // reset
        diameter = 0;
        height(root);
        System.out.println(diameter);
        // expected answer 7

        // test 3
        // @formatter:off
        /* 
                    3
                  /   \
                 7     9
                     /   \ 
                    6     4 
                  /  \      \
                18    14    -9
               /  \     \      \
              33   12    25     22
             /    /       \       \
            41   19        24      26
                /
               17
        */
        // @formatter:on
        // expected output : 9
        root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        root.right.left.left = new TreeNode(18);
        root.right.left.right = new TreeNode(14);
        root.right.right.right = new TreeNode(-9);

        root.right.left.left.left = new TreeNode(33);
        root.right.left.left.right = new TreeNode(12);
        root.right.left.right.right = new TreeNode(25);
        root.right.right.right.right = new TreeNode(22);

        root.right.left.left.left.left = new TreeNode(41);
        root.right.left.left.right.left = new TreeNode(19);
        root.right.left.right.right.right = new TreeNode(24);
        root.right.right.right.right.right = new TreeNode(26);

        root.right.left.left.right.left.left = new TreeNode(17);

        // reset
        diameter = 0;
        height(root);
        System.out.println(diameter);
    }

}
