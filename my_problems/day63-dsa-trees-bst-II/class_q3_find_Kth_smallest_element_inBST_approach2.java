import java.util.ArrayList;

/* Kth Smallest Element In BST */

/**
 * Find Kth smallest element in BST using count
 */
public class class_q3_find_Kth_smallest_element_inBST_approach2 {

    static int size = 0;
    static int answer = -1;

    public static void count(TreeNode root, int K) {
        if (root == null) {
            return;
        }
        count(root.left, K);
        // maintain the total size/fount of nodes done with inOrder traversal
        size = size + 1;
        if (size == K) {
            answer = root.val;
        }
        count(root.right, K);
    }

    public static int kthSmallest(TreeNode A, int K) {
        size = 0;
        answer = -1;
        count(A, K);
        return answer;
    }

    public static void main(String[] args) {

        // test 1
        TreeNode root = TreeUtils.createBST();
        System.out.println(kthSmallest(root, 3));

        // test 2
        System.out.println(kthSmallest(root, 8));
    }

}
