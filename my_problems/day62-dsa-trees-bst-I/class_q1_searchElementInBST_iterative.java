/* Search element oin BST - Binary Search Tree */

/**
 * Iterative Approach
 * TC: O(logN) => O(Height)
 */
public class class_q1_searchElementInBST_iterative {

    public static boolean search(TreeNode root, int K) {

        // base condition
        if (root == null)
            return false;

        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == K) {
                // element K is found
                return true;
            } else if (temp.val < K) {
                // search in RST
                temp = temp.right;
            } else {
                // search in LST
                temp = temp.left;
            }
        }
        // element K is not found
        return false;
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
