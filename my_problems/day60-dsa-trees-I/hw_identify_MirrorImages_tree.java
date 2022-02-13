/* Given a tree, identify if the tree is symmetric from its center/mirror image */
public class hw_identify_MirrorImages_tree {

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return checkIfMirrorImages(root.left, root.right);
    }

    private static boolean checkIfMirrorImages(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkIfMirrorImages(left.left, right.right) && checkIfMirrorImages(left.right, right.left);
    }

    public static void main(String[] args) {

        // test 1
        // @formatter:off
        /*
         *     1
         *    /  \
         *   2    2
         *  /      \
         * 5        5
         **/
        // @formatter:on
        // expected answer : true
        System.out.println("\n****** test1 *******");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(5);
        TreeUtils.printTree(root);
        System.out.println("\nisSymmetric -> " + isSymmetric(root));

        // test 2
        // @formatter:off
        /*
         *      6
         *    /   \
         *   3     3
         *  / \   /  \
         * 2   5 5    2
         */
        // @formatter:on
        // expected output : true
        System.out.println("\n****** test2 *******");
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
        TreeUtils.printTree(root);
        System.out.println("\nisSymmetric -> " + isSymmetric(root));

        // test 3
        // @formatter:off
        /*
         *      6
         *    /   \
         *   3     3
         *    \   /  
         *     5 5    
         */
        // @formatter:on
        // expected output : true
        System.out.println("\n****** test3 *******");
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        TreeUtils.printTree(root);
        System.out.println("\nisSymmetric -> " + isSymmetric(root));

        // test 4
        // @formatter:off
        /*
         *      6
         *    /   \
         *   3     3
         *    \   /  
         *     5 6    
         */
        // @formatter:on
        // expected output : false
        System.out.println("\n****** test4 *******");
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        TreeUtils.printTree(root);
        System.out.println("\nisSymmetric -> " + isSymmetric(root));

    }
}
