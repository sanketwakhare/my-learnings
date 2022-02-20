import java.util.ArrayList;

/* Identify the 2 swapped nodes in BST and swap those to make a BST */

/**
 * Using inOrder traversal and finding the culprit nodes
 */
public class class_q2_identify_2_swapped_nodes_in_BST_approach1 {

    public static void inOrderTraversal(TreeNode root, ArrayList<TreeNode> inOrder) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root);
        inOrderTraversal(root.right, inOrder);
    }

    public static void findSwappedNodes(TreeNode root) {

        // store inOrder traversal of tree and identify the Swapped nodes
        ArrayList<TreeNode> inOrder = new ArrayList<TreeNode>();
        inOrderTraversal(root, inOrder);

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        for (int i = 0; i < inOrder.size(); i++) {
            TreeNode curr = inOrder.get(i);

            // identify the 2 low points
            if (prev != null && curr.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }
            prev = curr;
        }
        System.out.println("\nCulprits -> " + first.val + " " + second.val);
        swapNodes(first, second);
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
        System.out.println("Before Swapping");
        TreeUtils.printInOrderOfATree(A);
        findSwappedNodes(A);

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
        System.out.println("Before Swapping");
        TreeUtils.printInOrderOfATree(A);
        findSwappedNodes(A);

        System.out.println("\nAfter correcting the node positions, BST became");
        TreeUtils.printInOrderOfATree(A);

    }

}
