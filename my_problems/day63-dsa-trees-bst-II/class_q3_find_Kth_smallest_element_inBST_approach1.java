import java.util.ArrayList;

/* Kth Smallest Element In BST */

/**
 * Find Kth smallest element in BST using inOrder traversal
 */
public class class_q3_find_Kth_smallest_element_inBST_approach1 {

    public static void inOrderTraversal(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, path);
        path.add(root.val);
        inOrderTraversal(root.right, path);
    }

    public static int kthSmallest(TreeNode A, int K) {

        ArrayList<Integer> path = new ArrayList<Integer>();
        inOrderTraversal(A, path);
        return path.get(K - 1);
    }

    public static void main(String[] args) {

        // test 1
        System.out.println("\n******test1*******");
        TreeNode root = TreeUtils.createBST();
        System.out.println(kthSmallest(root, 3));

        // test 2
        System.out.println(kthSmallest(root, 8));
    }

}
