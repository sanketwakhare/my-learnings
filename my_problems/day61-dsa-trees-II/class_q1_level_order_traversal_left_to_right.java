import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Level Order Traversal from left to Right */
/* Print data for every level on new line - identify the level start and level end points */

/**
 * Iterative solution using Queue
 * TC: O(N)
 * SC: O(N)
 */
public class class_q1_level_order_traversal_left_to_right {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        // initialize variables
        // output to store the 2D output array
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        // queue will help to traverse the elements in horizontal level
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // level to store the elements in each level
        ArrayList<Integer> level = new ArrayList<Integer>();

        // base condition , return null if root is null
        if (root == null) {
            return null;
        }
        // push root element and add null
        // null will help to identify the start/end of the level
        queue.add(root);
        queue.add(null);

        // this condition is used to not consider last null
        // otherwise might go to infinite loop
        while (queue.size() > 1) {

            // peek the first element from queue
            TreeNode temp = queue.peek();

            // if temp is not null, insert the possible left and right into the queue
            // and add temp to current level
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                level.add(temp.val);
            } else {

                // flush the level info into output
                output.add(level);
                // reset the level data
                level = new ArrayList<Integer>();
                // if null is found, it means th level is ended/or new level will start
                // insert one more null to identify the same
                queue.add(null);
            }
            // remove first element from queue
            queue.poll();
        }
        // insert last level data into 2D array
        output.add(level);
        // return output
        return output;
    }

    public static void main(String[] args) {

        // test 1
        System.out.println("\n******test1*******");
        TreeNode root = TreeUtils.createTree();
        TreeUtils.printTree(root);
        ArrayList<ArrayList<Integer>> output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 2
        System.out.println("\n******test2*******");
        root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 3
        // @formatter:off
        /*
         * 3
         * / \
         * 9 20
         *   / \
         *  15  7
         */
        // @formatter:on
        // expected output :
        /*
         * [
         * [3],
         * [9, 20],
         * [15, 7]
         * ]
         */
        System.out.println("\n******test3*******");
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right = new TreeNode(7);
        root.right.right.left = null;
        root.right.right.right = null;
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 4
        // @formatter:off
        /*
         *   1
         *  / \
         * 6   2
         *    /
         *   3 
         */
        // @formatter:on
        // expected output :
        /*
         * [
         * [1]
         * [6, 2]
         * [3]
         * ]
         */
        System.out.println("\n******test4*******");
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right = null;
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);
    }
}
