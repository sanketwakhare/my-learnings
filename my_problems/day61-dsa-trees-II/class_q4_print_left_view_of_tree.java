import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Print Left View of the Tree */
/**
 * TC: O(N): using level wise traversing
 * SC: O(n)
 */
public class class_q4_print_left_view_of_tree {

    public static ArrayList<Integer> leftView(TreeNode root) {

        // base condition
        if (root == null || root.val == -1) {
            return null;
        }
        // initialize the leftView list
        ArrayList<Integer> leftView = new ArrayList<Integer>();
        // initialize Queue which can help for level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        ArrayList<Integer> currentLevelNodes = new ArrayList<Integer>();

        // insert roo into queue
        queue.add(root);
        // insert null along with it, to identify the end of the current level
        queue.add(null);

        while (queue.size() > 1) {

            TreeNode temp = queue.peek();
            if (temp != null) {
                // insert its left and right into queue
                if (temp.left != null && temp.left.val != -1) {
                    queue.add(temp.left);
                }
                if (temp.right != null && temp.right.val != -1) {
                    queue.add(temp.right);
                }
                // store the current temp into level info
                currentLevelNodes.add(temp.val);
            } else {
                // level ends here
                queue.add(null);

                // get the first node from each level as it would be visible from LEFT
                if (currentLevelNodes.size() > 0) {
                    leftView.add(currentLevelNodes.get(0));
                }
                // reset the currentLevelNodes as new level is starting
                currentLevelNodes = new ArrayList<Integer>();
            }
            // remove temp from queue, as it is no longer required
            queue.poll();
        }
        // insert the first node for the last level
        if (currentLevelNodes.size() > 0) {
            leftView.add(currentLevelNodes.get(0));
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
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right = null;
        TreeUtils.printTree(root);
        output = leftView(root);
        TreeUtils.printList(output);
    }

}
