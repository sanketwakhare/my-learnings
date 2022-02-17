/* Insert element K inside BST */

/**
 * Iterative Approach
 * TC: O(logN) => O(Height)
 */
public class class_q2_insertElementInBST_iterative {

    public static TreeNode insert(TreeNode root, int K) {
        // maintain a previous pointer because we have to insert a new node to
        // left/right of prev
        TreeNode prev = null;

        // iterate BST till we find correct vacant position
        TreeNode temp = root;
        while (temp != null) {
            prev = temp;
            if (temp.val > K) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (prev == null) {
            // BST is empty
            root = new TreeNode(K);
        } else {
            if (prev.val > K) {
                // insert to left of prev
                prev.left = new TreeNode(K);
            } else {
                // insert to right of prev
                prev.right = new TreeNode(K);
            }
        }
        return root;

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
