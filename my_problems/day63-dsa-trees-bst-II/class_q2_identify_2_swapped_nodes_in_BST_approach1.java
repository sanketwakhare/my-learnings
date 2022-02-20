import java.util.ArrayList;

/* Identify the 2 swapped nodes in BST and swap those to make a BST */

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

        swapNodes(first, second);

    }

    public static void swapNodes(TreeNode first, TreeNode second) {
        // swap the culprit's data
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        System.out.println("Before Swapping");
        TreeUtils.printInOrderOfATree(A);
        findSwappedNodes(A);

        System.out.println("\nAfter correcting the node positions, BST became");
        TreeUtils.printInOrderOfATree(A);

    }

}
