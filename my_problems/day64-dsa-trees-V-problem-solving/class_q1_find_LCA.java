import java.util.ArrayList;

/* Find Least Common Ancestor */
public class class_q1_find_LCA {

    public static boolean findPath(TreeNode root, int K, ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }
        if (root.val == K) {
            path.add(root.val);
            return true;
        }
        if (findPath(root.left, K, path) || findPath(root.right, K, path)) {
            path.add(root.val);
            return true;
        }
        return false;
    }

    public static int findLCA(ArrayList<Integer> path1, ArrayList<Integer> path2) {

        int lca = -1;
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (path1.get(i) == path2.get(j)) {
                lca = path1.get(i);
            } else {
                break;
            }
            i--;
            j--;
        }

        ArrayList<Integer> pathBetween2Nodes = new ArrayList<Integer>();

        i++;
        int k = 0;
        while (k <= i) {
            pathBetween2Nodes.add(path1.get(k));
            k++;
        }
        while (j >= 0) {
            pathBetween2Nodes.add(path2.get(j));
            j--;
        }
        System.out.println("path between 2 nodes ->" + pathBetween2Nodes);
        System.out.println("LCA -> " + lca);
        return lca;
    }

    public static void main(String[] args) {

        // test 1
        // @formatter:off
        /* 
                    3
                  /   \
                 7     9
                /     /  \
               8     6    4
                   /   \    \
                  18    14   -9
                 /  \     \
                33   12    25
              /     /       \
             41   19         24
                  /
                17 
        */
        // @formatter:on
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(18);
        root.right.left.left.left = new TreeNode(33);
        root.right.left.left.right = new TreeNode(12);
        root.right.left.left.left.left = new TreeNode(41);
        root.right.left.left.right.left = new TreeNode(19);
        root.right.left.left.right.left.left = new TreeNode(17);
        root.right.left.right = new TreeNode(14);
        root.right.left.right.right = new TreeNode(25);
        root.right.left.right.right.right = new TreeNode(24);
        root.right.right.right = new TreeNode(-9);

        ArrayList<Integer> path1 = new ArrayList<Integer>();
        findPath(root, 41, path1);
        System.out.println(path1);
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        findPath(root, 17, path2);
        System.out.println(path2);

        int lca = findLCA(path1, path2);

    }
}