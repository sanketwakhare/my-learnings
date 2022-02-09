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
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode createTestTree() {
        TreeNode root = new TreeNode(10);
        TreeNode left = insertLeft(root, 20);
        TreeNode right = insertRight(root, 30);
        insertLeft(left, 40);
        insertRight(left, 50);
        insertLeft(right, 60);
        insertRight(right, 70);
        return root;
    }
}
