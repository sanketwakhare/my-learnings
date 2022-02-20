public class class_q2_identify_2_swapped_nodes_in_BST_approach2 {

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    public static void findSwappedNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findSwappedNodes(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        findSwappedNodes(root.right);
    }

    public static void swapNodes(TreeNode first, TreeNode second) {
        // swap the culprit's data
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {

        // test 1
        // @formatter:off
        /* 
                    1
                  /   \
                 2     3
        */
        // @formatter:on
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        System.out.println("\nBefore Swapping");
        TreeUtils.printInOrderOfATree(A);
        first = null;
        second = null;
        prev = null;
        findSwappedNodes(A);
        // swap first and second nodes
        swapNodes(first, second);

        System.out.println("\nAfter correcting the node positions, BST became");
        TreeUtils.printInOrderOfATree(A);

        // test 2
        // @formatter:off
        /* 
                    15
                  /    \
                 10      3
               /   \    /  \
              5    24  18  35
             / \   /   / \
            3   8 11  16  20
                            \
                             22
        */
        // @formatter:on
        A = new TreeNode(15);
        A.left = new TreeNode(10);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(5);
        A.left.right = new TreeNode(24);
        A.right.left = new TreeNode(18);
        A.right.right = new TreeNode(35);
        A.left.left.left = new TreeNode(3);
        A.left.left.right = new TreeNode(8);
        A.left.right.left = new TreeNode(11);
        A.right.left.left = new TreeNode(16);
        A.right.left.right = new TreeNode(20);
        A.right.left.right.right = new TreeNode(22);
        System.out.println("\nBefore Swapping");
        TreeUtils.printInOrderOfATree(A);
        first = null;
        second = null;
        prev = null;
        findSwappedNodes(A);
        // swap first and second nodes
        swapNodes(first, second);

        System.out.println("\nAfter correcting the node positions, BST became");
        TreeUtils.printInOrderOfATree(A);

    }
}
