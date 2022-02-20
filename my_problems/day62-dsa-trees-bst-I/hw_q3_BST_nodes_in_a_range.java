/* BST nodes in a range */

/*
Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lies in the given range.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 10^9

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return the count of the number of nodes that lies in the given range.

Example Input
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20
Input 2:

            8
           / \
          6  21
         / \
        1   4

     B = 2
     C = 20

Example Output
Output 1:
 5
Output 2:
 3

Example Explanation
Explanation 1:
 Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2:
 Nodes which are in range [2, 20] are : [8, 6, 4] */

public class hw_q3_BST_nodes_in_a_range {

  public static int solve(TreeNode root, int B, int C) {
    return countNodes(root, B, C);
  }

  public static int countNodes(TreeNode root, int start, int end) {
    if (root == null) {
      return 0;
    }
    int leftCount = countNodes(root.left, start, end);
    int rightCount = countNodes(root.right, start, end);
    int currentCount = 0;
    if (root.val >= start && root.val <= end) {
      currentCount = 1;
    }
    return leftCount + rightCount + currentCount;
  }

  public static void main(String[] args) {

    // test case 1
    // @formatter:off
    /* Tree A = 
      *        15
      *      /   \
      *     12     20
      *    /  \    / \
      *   10  14 16   27
      *  /
      * 8
      * B: 12
      * C: 20
      */
    // @formatter:on
    TreeNode A = new TreeNode(15);
    A.left = new TreeNode(12);
    A.right = new TreeNode(20);
    A.left.left = new TreeNode(10);
    A.left.right = new TreeNode(14);
    A.right.left = new TreeNode(16);
    A.right.right = new TreeNode(27);
    A.left.left.left = new TreeNode(8);

    System.out.println(solve(A, 12, 20));
    System.out.println(solve(A, 12, 15));

  }

}