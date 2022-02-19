public class class_q3_checkIfValidBST_approach3 {

    // check if every node falls within expected range to be BST
    // start with [-Infinity, +Infinity] and check if all nodes satisfy the range
    public static boolean isValidBST(TreeNode root, long start, long end) {

        if (root == null) {
            return true;
        }
        // check if current node is valid and is within range min and max
        if (root.val >= start && root.val <= end) {
            // update the min and max
            boolean isLSTValidBST = isValidBST(root.left, start, root.val - 1);
            boolean isRSTValidBST = isValidBST(root.right, root.val + 1, end);
            return isLSTValidBST && isRSTValidBST;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBST();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

        root = TreeUtils.createTree();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

        root = new TreeNode(50);
        root.right = TreeUtils.getRandomNode();
        root.left = TreeUtils.getRandomNode();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

        root = new TreeNode(2147483647);
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

    }
}
