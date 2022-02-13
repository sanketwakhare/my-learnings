import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Print Left View of the Tree */
/**
 * Using Prev pointer
 * TC: O(N): using level wise traversing
 * SC: O(n)
 */
public class class_q4_print_left_view_of_tree_using_prev_pointer {

    public static ArrayList<Integer> leftView(TreeNode root) {

        // base condition
        if (root == null || root.val == -1) {
            return null;
        }
        // initialize the leftView list
        ArrayList<Integer> leftView = new ArrayList<Integer>();
        // initialize Queue which can help for level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        TreeNode prev = null;

        // insert roo into queue
        queue.add(root);
        // insert null along with it, to identify the end of the current level
        queue.add(null);

        while (queue.size() > 1) {

            // remove temp from queue, as it is no longer required
            TreeNode temp = queue.poll();

            if (temp != null) {
                // insert its left and right into queue
                if (temp.left != null && temp.left.val != -1) {
                    queue.add(temp.left);
                }
                if (temp.right != null && temp.right.val != -1) {
                    queue.add(temp.right);
                }
                if (prev == null) {
                    // temp is first node on left
                    leftView.add(temp.val);
                }
            } else {
                // level ends here
                queue.add(null);

            }
            // update prev pointer
            prev = temp;
        }

        return leftView;
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
        // expected output : [10, 20, 40]
        System.out.println("\n******test1*******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        ArrayList<Integer> output = leftView(root);
        TreeUtils.printList(output);

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
        // expected output : [3, 9, 15]
        System.out.println("\n******test2*******");
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtils.printTree(root);
        output = leftView(root);
        TreeUtils.printList(output);

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
        // expected output : [1, 6, 3]
        System.out.println("\n******test3*******");
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        TreeUtils.printTree(root);
        output = leftView(root);
        TreeUtils.printList(output);
    }

}
