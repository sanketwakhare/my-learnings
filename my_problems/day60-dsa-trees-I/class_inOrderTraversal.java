/**
 * In Order Traversal
 */
public class class_inOrderTraversal {

    public static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        inOrderTraversal(root); // expected output 10 20 40 50 30 60 70
    }
}
