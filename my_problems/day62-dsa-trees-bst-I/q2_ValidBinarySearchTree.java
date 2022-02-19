/* Valid Binary Search Tree */

/* Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return 0 if false and 1 if true.

Example Input
Input 1:
 
   1
  /  \
 2    3
Input 2:
 
  2
 / \
1   3

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 2 is not less than 1 but is in left subtree of 1.
Explanation 2:
Satisfies all conditions. */

/* Bottom up approach to find if given tree is BST or not */

// check if given nodes falls within max(LST) < root < min(RST) =>
// max(rightMax,leftMax) [max(LST)< root < min(RST)] => min(rightMin,leftMin)

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
class Data {
    long min;
    long max;
    boolean isBST;

    public Data() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
        isBST = true;
    }
}

public class q2_ValidBinarySearchTree {

    public static Data isValid(TreeNode root) {

        Data currentData = new Data();
        if (root == null) {
            return currentData;
        }

        Data leftData = isValid(root.left);
        Data rightData = isValid(root.right);

        if (leftData.isBST && rightData.isBST) {
            // current node value should be greater than max of LST and less than min of RST
            if (root.val > leftData.max && root.val < rightData.min) {
                currentData.isBST = true;
                // update current minimum as min will be present on LST
                currentData.min = Math.min(leftData.min, root.val);
                // update current maximum as max will be present on RST
                currentData.max = Math.max(rightData.max, root.val);
            } else {
                currentData.isBST = false;
            }
        } else {
            currentData.isBST = false;
        }
        return currentData;
    }

    public static int isValidBST(TreeNode A) {
        Data currentData = isValid(A);
        return currentData.isBST ? 1 : 0;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));

    }
}
