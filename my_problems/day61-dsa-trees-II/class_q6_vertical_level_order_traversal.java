import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

/**
 * Vertical Level Order Traversal
 * TC: O(N)
 * SC: O(N)
 */
public class class_q6_vertical_level_order_traversal {

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> verticalTraversal = new ArrayList<ArrayList<Integer>>();
        // queue stores the node and level information
        Queue<Map<TreeNode, Integer>> queue = new LinkedList<Map<TreeNode, Integer>>();
        // map stores the elements in each vertical level
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        // root's vertical level is 0
        queue.add(prepareQueueEntry(root, 0));
        queue.add(null);

        while (queue.size() > 1) {

            Map<TreeNode, Integer> temp = queue.peek();
            if (temp != null) {
                Entry<TreeNode, Integer> currentEntry = temp.entrySet().iterator().next();
                TreeNode tempNode = currentEntry.getKey();
                Integer level = currentEntry.getValue();

                if (tempNode.left != null) {
                    // left element will have level as current level - 1
                    queue.add(prepareQueueEntry(tempNode.left, level - 1));
                }
                if (tempNode.right != null) {
                    // right element will have level as current level + 1
                    queue.add(prepareQueueEntry(tempNode.right, level + 1));
                }

                // update map
                if (map.containsKey(level)) {
                    // if key is present, add current node value to list
                    ArrayList<Integer> list = map.get(level);
                    list.add(tempNode.val);
                    map.put(level, list);
                } else {
                    // if key is not present, create new list and entry
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(tempNode.val);
                    map.put(level, list);
                }
            } else {
                // add null as end of current level
                queue.add(null);
            }
            // remove temp entry from queue as it is no more required
            queue.poll();
        }

        // find min and max key from map
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        // populate output array list
        for (int i = min; i <= max; i++) {
            verticalTraversal.add(map.get(i));
        }

        return verticalTraversal;
    }

    private static Map<TreeNode, Integer> prepareQueueEntry(TreeNode root, int level) {
        Map<TreeNode, Integer> queueEntry = new HashMap<TreeNode, Integer>();
        queueEntry.put(root, level);
        return queueEntry;
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
         * [40],
         * [20],
         * [10, 50, 60],
         * [30],
         * [70]
         * ]
         */
        System.out.println("\n****** test1 *******");
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        TreeUtils.printLevelWiseLeftToRight(verticalOrderTraversal(root));

        // test 2
        // @formatter:off
        /*
         *     6
         *    /  \
         *   3    7
         *  / \     \
         * 2   5     9
         *
        // @formatter:on
        // expected output :
        /*
         * [
         * [2],
         * [3],
         * [6, 5],
         * [7],
         * [9]
         * ]
         */
        System.out.println("\n****** test2 *******");
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        TreeUtils.printTree(root);
        TreeUtils.printLevelWiseLeftToRight(verticalOrderTraversal(root));

    }
}
