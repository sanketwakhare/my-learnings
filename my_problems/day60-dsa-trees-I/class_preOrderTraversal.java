/**
 * Pre Order Traversal
 */
public class class_preOrderTraversal {
    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        System.out.print(root.val + " ");
        postOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        postOrderTraversal(root); // expected output 40 20 50 10 60 30 70
    }
}
