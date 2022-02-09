/**
 * Search element K in Tree
 * TC: O(N)
 * SC: O(N)
 */
public class class_searchElementInTree {

    public static boolean search(TreeNode root, int K) {

        if (root == null) {
            return false;
        }

        if (root.val == K) {
            return true;
        }

        if (search(root.left, K) || search(root.right, K)) {
            return true;
        }

        // return false if no element is found until this subtree
        return false;
    }

    public static void main(String[] args) {

        TreeNode A = TreeUtils.createTestTree();
        System.out.println("is 40 present? -> " + search(A, 40));
        System.out.println("is 30 present? -> " + search(A, 30));
        System.out.println("is 100 present? -> " + search(A, 100));
        System.out.println("is 45 present? -> " + search(A, 45));
        System.out.println("is 20 present? -> " + search(A, 20));

    }
}
