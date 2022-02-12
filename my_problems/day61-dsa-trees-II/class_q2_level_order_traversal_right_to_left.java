import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class class_q2_level_order_traversal_right_to_left {

    public static ArrayList<ArrayList<Integer>> levelOrderRightToLeft(TreeNode root) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();

        if (root == null) {
            return null;
        }
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {

            TreeNode temp = queue.peek();

            if (temp != null) {
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                level.add(temp.val);
            } else {

                output.add(level);
                level = new ArrayList<Integer>();
                queue.add(null);
            }
            queue.poll();
        }
        output.add(level);
        return output;
    }

    public static void main(String[] args) {
        // test 1
        // @formatter:off
        /*
         *     10
         *    /  \
         *   20   30
         *  / \   / \
         * 40 50 60  70
         */
        // @formatter:on
        // expected output :
        /*
         * [
         * [10],
         * [30, 20],
         * [70, 60, 50, 40]
         * ]
         */
        System.out.println("\n******test1*******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        TreeUtils.printLevelWiseLeftToRight(levelOrderRightToLeft(root));

        // test 2
        // @formatter:off
        /*
         *  3
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
         * [20, 9],
         * [7, 15]
         * ]
         */
        System.out.println("\n******test2*******");
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtils.printTree(root);
        TreeUtils.printLevelWiseLeftToRight(levelOrderRightToLeft(root));

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
        TreeUtils.printLevelWiseLeftToRight(levelOrderRightToLeft(root));

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
         * [7,6,5,4],
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
        TreeUtils.printLevelWiseLeftToRight(levelOrderRightToLeft(root));

        // test 5
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
        // expected output :
        /*
         * [
         * [1],
         * [3,2],
         * [4],
         * [5]
         * ]
         */
        System.out.println("\n******test5*******");
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        TreeUtils.printTree(root);
        TreeUtils.printLevelWiseLeftToRight(levelOrderRightToLeft(root));
    }
}
