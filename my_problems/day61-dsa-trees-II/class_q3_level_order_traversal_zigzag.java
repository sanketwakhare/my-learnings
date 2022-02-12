import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ZigZag traversal Level Order using Stack and Queue
 * TC: O(N)
 * SC: O(N)
 */
public class class_q3_level_order_traversal_zigzag {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        // initialize variables
        // output to store the 2D output array
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        // queue will help to traverse the elements in horizontal level
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // level to store the elements in each level
        ArrayList<Integer> level = new ArrayList<Integer>();
        // maintain a stack and a flag to reverse the insertion
        boolean isLeftToRight = true;
        Stack<TreeNode> stack = new Stack<TreeNode>();

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

            // remove first element from queue
            TreeNode temp = queue.poll();

            // if temp is not null, insert the possible left and right into stack
            // and add temp to current level
            if (temp != null) {
                // store in stack and then it can be flushed to queue once the current level is
                // finished
                if (isLeftToRight) {
                    if (temp.left != null) {
                        stack.add(temp.left);
                    }
                    if (temp.right != null) {
                        stack.add(temp.right);
                    }
                } else {
                    if (temp.right != null) {
                        stack.add(temp.right);
                    }
                    if (temp.left != null) {
                        stack.add(temp.left);
                    }
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

                // toggle after every level
                isLeftToRight = !isLeftToRight;
            }

            // if queue size becomes one, that means the current level is finished, flush
            // everything from stack into Queue
            if (queue.size() == 1) {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
            }
        }
        // insert last level data into 2D array
        output.add(level);
        // return output
        return output;
    }

    public static void main(String[] args) {

        // test 1
        System.out.println("\n****** test1 *******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        ArrayList<ArrayList<Integer>> output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 2
        System.out.println("\n****** test2 *******");
        root = TreeUtils.create5LevelBinaryTree();
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 3
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
         * [1],
         * [2,6],
         * [3]
         * ]
         */
        System.out.println("\n******test3*******");
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 4
        // @formatter:off
        /* 
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
              /
             8  
        */
        // @formatter:on
        // expected output :
        /*
         * [
         * [1],
         * [3,2],
         * [4,5,6,7],
         * [8]
         * ]
         */
        System.out.println("\n******test4*******");
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

        // test 5
        // @formatter:off
        /* 
                    1
                  /   \
                 2     3
                  \     \
                    4    9
                  /   \
                 7     5 
        */
        // @formatter:on
        // expected output :
        /*
         * [
         * [1],
         * [3,2],
         * [4,9],
         * [5,7]
         * ]
         */
        System.out.println("\n******test5*******");
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(7);
        TreeUtils.printTree(root);
        output = levelOrder(root);
        TreeUtils.printLevelWiseLeftToRight(output);

    }
}
