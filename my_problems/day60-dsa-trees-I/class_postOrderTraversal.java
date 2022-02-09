/**
 * Post Order Traversal
 */
public class class_postOrderTraversal {
    public static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        postOrderTraversal(root); // expected output 40 50 20 60 70 30 10
    }
}
