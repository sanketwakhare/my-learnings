/* Node distance C in binary tree */

/* 
Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B.
You have to find all the nodes that are at a distance of exactly C from the node containing value B.
Return an array of integers consisting all the nodes that are C distance from node containing value B.

Note:
You may return the nodes in any order.
Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .

Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9 
0 <= B <= 10^9
0 <= C <= 100

For Example
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

     B = 3
     C = 3
Output 1:
    [4, 5]

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
        B = 4
        C = 1
Output 2:
    [2, 5]
 */
import java.util.ArrayList;

public class q1_node_distance_K_from_any_node {

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

    // get all the nodes with K distance from given node root
    public static void getNodesWithDistanceK(TreeNode root, int K, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (K == 0) {
            list.add(root.val);
            return;
        }
        getNodesWithDistanceK(root.left, K - 1, list);
        getNodesWithDistanceK(root.right, K - 1, list);
    }

    // find path from node B to root, store actual nodes info
    public static boolean findPath(TreeNode root, int B, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root.val == B) {
            path.add(root);
            return true;
        }
        if (findPath(root.left, B, path) || findPath(root.right, B, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> solve(TreeNode root, int B, int K) {

        // find path of B to root
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        findPath(root, B, path);

        ArrayList<Integer> list = new ArrayList<Integer>();
        // get all the nodes with distance K from current node B
        getNodesWithDistanceK(path.get(0), K, list);

        // move up
        K = K - 1;
        for (int i = 1; i < path.size(); i++) {
            // base condition if K becomes 0 there is no need to traverse further
            if (K == 0) {
                list.add(path.get(i).val);
                break;
            }
            // identify if next node is left or right of current node
            if (path.get(i).left == path.get(i - 1)) {
                // decrease K as we are moving down on right. this is considered as covering one
                // more distance
                getNodesWithDistanceK(path.get(i).right, K - 1, list);
            } else {
                // decrease K as we are moving down on left. this is considered as covering one
                // more distance
                getNodesWithDistanceK(path.get(i).left, K - 1, list);
            }
            // move up
            K = K - 1;
        }
        return list;
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
        System.out.println(solve(root, 30, 3));
        // expected answer [60, 90]

        // test case 2
        // @formatter:off
        /*
         *         1
         *       /   \
         *      2     3
         *     / \   / \
         *    4   5 6   7
         *   /
         *  8 
         */
        // @formatter:on
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        System.out.println(solve(root, 3, 3));
        // expected answer [4, 5]

        // test 3
        // @formatter:off
        /* 
                    1
                  /   \
                 2     3
                  \ 
                    4 
                      \
                       5 
        */
        // @formatter:on
        // expected output : [2, 5]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        System.out.println(solve(root, 4, 1));
    }

}
