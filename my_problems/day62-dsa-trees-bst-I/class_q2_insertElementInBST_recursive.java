/* Insert element K into BST */

/**
 * Recursive Approach
 * TC: O(logN) => O(Height)
 * SC: O(Height)
 */
public class class_q2_insertElementInBST_recursive {

    // maintain a previous pointer
    static TreeNode prev;

    public static void insert(TreeNode root, int K) {
        if (root == null) {
            // insert at this position
            TreeNode temp = new TreeNode(K);
            if (prev != null) {
                if (prev.val > K) {
                    // insert at left of prev
                    prev.left = temp;
                } else {
                    // insert at right of prev
                    prev.right = temp;
                }
            } else {
                // if tree is empty
                root = temp;
            }
            return;
        } else if (root.val < K) {
            prev = root;
            insert(root.right, K);
        } else {
            prev = root;
            insert(root.left, K);
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBST();
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        // insert 45
        insert(root, 45);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        // insert 9
        insert(root, 9);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        // insert 73
        insert(root, 73);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        // insert 105
        insert(root, 105);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        // insert 82
        insert(root, 82);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);
    }

}
