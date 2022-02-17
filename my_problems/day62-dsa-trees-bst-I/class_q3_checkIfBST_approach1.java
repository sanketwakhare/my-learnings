import java.util.ArrayList;

/* Check if given BST is valid BST or not */

/*  Idea: check inOrder traversal of a Tree, it should be sorted */
/**
 * TC: O(N)
 * SC: O(N) => for storing inOrder path
 */
public class class_q3_checkIfBST_approach1 {

    public static void inOrderTraversal(TreeNode root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right, inOrder);
    }

    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrderTraversal(root, inOrder);
        // check if inOrder traversal is sorted or not
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i) < inOrder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBST();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root));

        root = TreeUtils.createTree();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root));

        root = new TreeNode(50);
        root.right = TreeUtils.getRandomNode();
        root.left = TreeUtils.getRandomNode();
        TreeUtils.printInOrderOfATree(root);
        System.out.println(isValidBST(root));

    }
}
