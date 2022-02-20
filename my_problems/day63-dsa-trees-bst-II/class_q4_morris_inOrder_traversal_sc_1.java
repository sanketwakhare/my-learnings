/* Morris InOrder traversal algorithm
SC: O(1) */
public class class_q4_morris_inOrder_traversal_sc_1 {

    public static void morrisInOrderTraversal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    // traverse to right until we find null or right of temp is curr
                    temp = temp.right;
                }

                if (temp.right == null) {
                    // form link from end of right to curr
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    // break link from end of right to curr
                    temp.right = null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBST();
        morrisInOrderTraversal(root);

        root = TreeUtils.createTestTree();
        morrisInOrderTraversal(root);

    }

}
