public class TreeUtils {

    public static TreeNode insertLeft(TreeNode root, int x) {
        root.left = new TreeNode(x);
        return root.left;
    }

    public static TreeNode insertRight(TreeNode root, int x) {
        root.right = new TreeNode(x);
        return root.right;
    }

    public static TreeNode getRandomNode() {
        int value = (int) Math.floor(Math.random() * 100);
        TreeNode root = new TreeNode(value);
        return root;
    }

    public static int getRandomValue() {
        int value = (int) Math.floor(Math.random() * 100);
        return value;
    }

    public static TreeNode createTree() {
        TreeNode root = getRandomNode();
        TreeNode left = insertLeft(root, getRandomValue());
        TreeNode right = insertRight(root, getRandomValue());
        insertLeft(left, getRandomValue());
        insertRight(left, getRandomValue());
        insertLeft(right, getRandomValue());
        insertRight(right, getRandomValue());
        return root;
    }

    public static void printTree(TreeNode root) {
        // use any type of traversal to print the nodes data
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
