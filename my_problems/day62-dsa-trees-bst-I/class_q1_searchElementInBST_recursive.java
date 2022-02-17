/* Search element oin BST - Binary Search Tree */

/**
 * Recursive Approach
 * TC: O(logN) => O(Height)
 * SC: O(Height)
 */
public class class_q1_searchElementInBST_recursive {

    public static boolean search(TreeNode root, int K) {
        if (root == null) {
            // element K is not found
            return false;
        }
        if (root.val == K) {
            // element K is found
            return true;
        } else if (root.val < K) {
            // search in RST
            return search(root.right, K);
        } else {
            // search in LST
            return search(root.left, K);
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBST();
        System.out.println(search(root, 30));
        System.out.println(search(root, 70));
        System.out.println(search(root, 100));
        System.out.println(search(root, 20));
        System.out.println(search(root, 25));
        System.out.println(search(root, 45));
        System.out.println(search(root, 90));
        System.out.println(search(root, 80));
        System.out.println(search(root, 85));
    }

}
