public class class_q2_countNodes_at_distance_K_from_root {

    public static int countNodesAtDistanceK(TreeNode root, int K) {
        if (root == null) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        int x = countNodesAtDistanceK(root.left, K - 1);
        int y = countNodesAtDistanceK(root.right, K - 1);
        return x + y;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTree2();
        int count = countNodesAtDistanceK(root, 2);
        System.out.println(count);

        count = countNodesAtDistanceK(root, 6);
        System.out.println(count);

    }

}
