import java.util.ArrayList;
import java.util.Collections;

/* Find path of an element K from root element in a Tree */
public class class_find_Path_of_K_from_root_in_a_Tree {

    public static boolean findPath(TreeNode root, int K, ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }

        // if element K is found, return flag to identify. will be helpful for parent
        // elements
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

    public static void main(String[] args) {

        TreeNode A = TreeUtils.createTestTree();
        ArrayList<Integer> path = new ArrayList<Integer>();

        // find path of 30
        findPath(A, 30, path);
        System.out.println("path of 30 is -> ");
        Collections.reverse(path);
        for (int x : path) {
            System.out.println(x);
        }

        // find path 40
        path = new ArrayList<Integer>();
        findPath(A, 40, path);
        Collections.reverse(path);
        System.out.println("path of 40 is -> ");
        for (int x : path) {
            System.out.println(x);
        }

        // find path 60
        path = new ArrayList<Integer>();
        findPath(A, 60, path);
        Collections.reverse(path);
        System.out.println("path of 60 is -> ");
        for (int x : path) {
            System.out.println(x);
        }

        // find path 100
        path = new ArrayList<Integer>();
        findPath(A, 100, path);
        Collections.reverse(path);
        System.out.println("path of 100 is -> ");
        for (int x : path) {
            System.out.println(x);
        }
    }
}
