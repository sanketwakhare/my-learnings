/* Find longest path which occurs through root*/
public class class_q4_longestPath_through_root {

    // height function
    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }

    // longest path will be height(lst) + height(rst) + 2 edges connecting root
    public static int getLongestPath(TreeNode root) {
        int lst = height(root.left);
        int rst = height(root.right);
        return lst + rst + 2;
    }

    public static void main(String[] args) {
        // test case 1
        // @formatter:off
        /*
         *     50
         *    /  \
         *   30   70
         *  / \   / \
         * 10 40 60  90
         *  \       /  \
         *   20    80  100
         */
        // @formatter:on
        TreeNode root = TreeUtils.createBST();
        System.out.println(getLongestPath(root));
        // expected answer 6

        // test case 2
        // @formatter:off
        /*
         *         1
         *       /   \
         *      2     3
         *     / \   / \
         *    4   5 6   7
         *   /
         *  8 
         */
        // @formatter:on
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        System.out.println(getLongestPath(root));
        // expected answer 5

        // test 3
        // @formatter:off
        /* 
                    1
                  /   \
                 2     3
                  \ 
                    4 
                      \
                       5 
        */
        // @formatter:on
        // expected output : 4
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        System.out.println(getLongestPath(root));
    }

}
