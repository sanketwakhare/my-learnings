
/* Boundary Traversal Of Binary Tree */
import java.util.ArrayList;
import java.util.Stack;

/* 
Given a binary tree. Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from the root to the left-most node. Right boundary is defined as the path from the root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Return an array of integers denoting the boundary values of tree in anti-clockwise order.

For Example

Input 1:
               _____1_____
              /           \
             2             3
            / \            / 
           4   5          6   
              / \        / \
             7   8      9  10  
Output 1:
    [1, 2, 4, 7, 8, 9, 10, 6, 3]
    Explanation 1:
        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
        The leaves are node 4,7,8,9,10.
        The right boundary are node 1,3,6,10. (10 is the right-most node).
        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

Input 2:
                1
               / \
              2   3
             / \  / \
            4   5 6  7
Output 2:
     [1, 2, 4, 5, 6, 7, 3] 
 */

/**
 * TC: O(N)
 * SC: O(N) to store the boundary traversals
 */
public class hw_q2_BoundaryTraversal {

    public static ArrayList<Integer> boundaryTraversal(TreeNode A) {

        if (A == null) {
            return null;
        }

        // step 01 - traverse left boundary
        TreeNode temp = A;
        ArrayList<Integer> leftBoundary = new ArrayList<Integer>();
        traverseLeftBoundary(temp, leftBoundary);

        // step 02 - traverse all leaf nodes
        temp = A;
        ArrayList<Integer> leafs = new ArrayList<Integer>();
        getLeafNodes(temp, leafs);

        // step 03 - traverse right boundary
        // use stack as order will be reverse
        temp = A;
        Stack<Integer> rightBoundary = new Stack<Integer>();
        traverseRightBoundary(temp, rightBoundary);

        // populate in anticlockwise order
        ArrayList<Integer> output = new ArrayList<Integer>();
        // 01 populate left boundary
        for (int i = 0; i < leftBoundary.size(); i++) {
            output.add(leftBoundary.get(i));
        }
        // 02 populate leaf nodes. do not consider first leaf as it is already part of
        // left
        // boundary
        for (int i = 1; i < leafs.size(); i++) {
            output.add(leafs.get(i));
        }
        // 03 populate right boundary. do not consider first top of rightBoundary as it
        // is
        // already part of leaf nodes
        rightBoundary.pop();
        while (!rightBoundary.isEmpty()) {
            output.add(rightBoundary.pop());
        }
        return output;
    }

    public static void traverseLeftBoundary(TreeNode temp, ArrayList<Integer> leftBoundary) {
        while (temp != null) {
            leftBoundary.add(temp.val);
            if (temp.left == null && temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
    }

    public static void getLeafNodes(TreeNode root, ArrayList<Integer> leafs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
            return;
        }
        getLeafNodes(root.left, leafs);
        getLeafNodes(root.right, leafs);
    }

    public static void traverseRightBoundary(TreeNode temp, Stack<Integer> rightBoundary) {

        while (temp != null) {
            if (temp.right == null && temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            // ignore adding duplicate entry for root of the tree
            if (temp != null) {
                rightBoundary.push(temp.val);
            }
        }
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
        // expected answer : [50, 30, 10, 20, 40, 60, 80, 100, 90, 70]
        TreeNode root = TreeUtils.createBST();
        System.out.println(boundaryTraversal(root));

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
        // expected answer : [1, 2, 4, 8, 80, 3]
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
        System.out.println(boundaryTraversal(root));

        // test case 3
        // @formatter:off
        /*
         *         1
         *       /   \
         *      2      3
         *     / \    /
         *    4   5  6    
         *   /
         *  7
         */
        // @formatter:on
        // expected answer : [1, 2, 4, 7, 5, 6, 3]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        System.out.println(boundaryTraversal(root));

        // test case 4
        // @formatter:off
        /*
         *         _ 1 _
         *       /       \
         *      2         3
         *     / \       /
         *    4   5     6    
         *       / \   / \
         *      7  8  9   10  
         */
        // @formatter:on
        // expected answer : [1, 2, 4, 7, 8, 9, 10, 6, 3]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(boundaryTraversal(root));

    }
}