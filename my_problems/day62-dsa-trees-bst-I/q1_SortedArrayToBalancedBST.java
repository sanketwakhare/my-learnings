/* Sorted Array To Balanced BST */

/***
 * Problem Description
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height Balanced Binary Search Tree (BBST).
 * 
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than
 * 1.
 * 
 * 
 * 
 * Problem Constraints
 * 
 * 1 <= length of array <= 100000
 * 
 * 
 * 
 * Input Format
 * 
 * First argument is an integer array A.
 * 
 * 
 * 
 * Output Format
 * 
 * Return a root node of the Binary Search Tree.
 * 
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * A : [1, 2, 3]
 * Input 2:
 * 
 * A : [1, 2, 3, 5, 10]
 * 
 * 
 * Example Output
 * 
 * Output 1:
 * 
 * 2
 * / \
 * 1 3
 * Output 2:
 * 
 * 3
 * / \
 * 2 5
 * / \
 * 1 10
 * 
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * 
 * You need to return the root node of the Binary Tree.
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

/* Idea: Use Binary Search approach to build the tree from mid position */
/**
 * TC: O(N)
 * SC: O(N)
 */
public class q1_SortedArrayToBalancedBST {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static TreeNode sortedArrayToBST(final int[] A) {
        return buildTree(A, 0, A.length - 1);
    }

    // construct the tree from mid so that it will be balanced
    public static TreeNode buildTree(int[] A, int start, int end) {

        // base condition
        if (start > end) {
            return null;
        }

        // find mid and construct mid node first
        int mid = start + (end - start) / 2;
        TreeNode temp = new TreeNode(A[mid]);

        // recursively construct left and right subtrees
        temp.left = buildTree(A, start, mid - 1);
        temp.right = buildTree(A, mid + 1, end);

        return temp;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 2, 3 };
        TreeNode root = sortedArrayToBST(A1);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        int[] A2 = { 1, 2, 3, 5, 10 };
        root = sortedArrayToBST(A2);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

    }
}
