import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Print Right View of the Tree */
/* Using level traversal from LEFT to RIGHT */
/* return LAST element from each level for Right View*/
public class class_q5_print_right_view_of_tree {

    public static ArrayList<Integer> rightView(TreeNode root) {

        // base condition when root is null, return null
        if (root == null) {
            return null;
        }
        // initialize rightView List
        ArrayList<Integer> rightView = new ArrayList<Integer>();
        // initialize queue. This will help to traverse level wise
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // currentLevelNodes is used to store the nodes of the current level
        ArrayList<Integer> currentLevelNodes = new ArrayList<Integer>();

        // insert root into queue followed by null
        // null will help to identify the end of current level
        queue.add(root);
        queue.add(null);

        // traverse until all the nodes are traversed from left to right
        while (queue.size() > 1) {

            // retrieve current topnode from queue
            TreeNode temp = queue.peek();
            // if the node is not null, insert its left and right into queue
            // and add temp data to current level
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                currentLevelNodes.add(temp.val);
            } else {
                // if temp is null, insert another null to identify/mark the end of the current
                // level
                queue.add(null);
                // retrieve the last element from the levels for Right View
                if (currentLevelNodes.size() > 0) {
                    int lastIndex = currentLevelNodes.size() - 1;
                    rightView.add(currentLevelNodes.get(lastIndex));
                }
                // reset the current levels as it ended
                currentLevelNodes = new ArrayList<Integer>();
            }
            // remove temp every time it is visited
            queue.poll();
        }

        // retrieve the elements from last level
        if (currentLevelNodes.size() > 0) {
            int lastIndex = currentLevelNodes.size() - 1;
            rightView.add(currentLevelNodes.get(lastIndex));
        }
        return rightView;
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
        // expected output : [10, 30, 70]
        System.out.println("\n******test1*******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        ArrayList<Integer> output = rightView(root);
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
        // expected output : [3, 20, 7]
        System.out.println("\n******test2*******");
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtils.printTree(root);
        output = rightView(root);
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
        // expected output : [1, 2, 3]
        System.out.println("\n******test3*******");
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        TreeUtils.printTree(root);
        output = rightView(root);
        TreeUtils.printList(output);

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
        // expected output : [1, 3, 7, 8]
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
        output = rightView(root);
        TreeUtils.printList(output);

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
        // expected output : [1, 3, 4, 5]
        System.out.println("\n******test5*******");
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        TreeUtils.printTree(root);
        output = rightView(root);
        TreeUtils.printList(output);
    }
}