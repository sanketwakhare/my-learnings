import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Top View of the Tree using vertical level order traversal
 * Print every first element from each vertical level stored in map
 */
public class class_q7_print_top_view_of_tree {

    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> topView = new ArrayList<Integer>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int maxLevel = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;

        if (root == null) {
            return null;
        }

        nodeQueue.add(root);
        nodeQueue.add(null);
        levelQueue.add(0);
        levelQueue.add(null);

        while (nodeQueue.size() > 1) {
            TreeNode temp = nodeQueue.poll();
            Integer level = levelQueue.poll();
            if (level != null) {
                maxLevel = Math.max(maxLevel, level);
                minLevel = Math.min(minLevel, level);
            }

            if (temp != null) {
                if (temp.left != null) {
                    nodeQueue.add(temp.left);
                    levelQueue.add(level - 1);
                }
                if (temp.right != null) {
                    nodeQueue.add(temp.right);
                    levelQueue.add(level + 1);
                }

                // update hashMap<level, list of elements in the level>
                ArrayList<Integer> nodeList = new ArrayList<Integer>();
                if (map.containsKey(level)) {
                    nodeList = map.get(level);
                }
                nodeList.add(temp.val);
                map.put(level, nodeList);

            } else {
                nodeQueue.add(null);
                levelQueue.add(null);
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            topView.add(map.get(i).iterator().next());
        }

        return topView;
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
         * [40, 20, 10, 30, 70]
         */
        System.out.println("\n****** test1 *******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        ArrayList<Integer> topView = topView(root);
        System.out.print("\nTop View");
        TreeUtils.printList(topView);

        // test 2
        // @formatter:off
        /*
         *     6
         *    /  \
         *   3    7
         *  / \     \
         * 2   5     9
         */
        // @formatter:on
        // expected output : [2, 3, 6, 7, 9]
        System.out.println("\n****** test2 *******");
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        TreeUtils.printTree(root);
        topView = topView(root);
        System.out.print("\nTop View");
        TreeUtils.printList(topView);

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
        // expected output : [6, 1, 2]
        System.out.println("\n****** test3 *******");
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        TreeUtils.printTree(root);
        topView = topView(root);
        System.out.print("\nTop View");
        TreeUtils.printList(topView);

        // test 4
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
        // expected output : [2, 1, 3]
        System.out.println("\n****** test4 *******");
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        TreeUtils.printTree(root);
        topView = topView(root);
        System.out.print("\nTop View");
        TreeUtils.printList(topView);

    }

}
