import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* Print path between any two nodes in a Binary Tree */
/* https://www.geeksforgeeks.org/print-path-between-any-two-nodes-in-a-binary-tree/ */

public class class_find_Path_between_any_2_nodes_of_Tree {

    public static ArrayList<Integer> findPathBwtTwoNodesInBinaryTree(TreeNode root, int start, int end) {

        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        // find path from root for both the nodes
        findPathFromRoot(root, start, path1);
        findPathFromRoot(root, end, path2);

        ArrayList<Integer> path = new ArrayList<Integer>();
        // find if there is any common root

        // put path2 in hashMap
        Set<Integer> set = new HashSet<Integer>();
        for (int ele : path2) {
            set.add(ele);
        }

        // find common root and fill path until common root is found
        Integer commonRoot = null;
        for (int i = 0; i < path1.size(); i++) {
            int currentEle = path1.get(i);
            if (set.contains(currentEle)) {
                commonRoot = currentEle;
                break;
            } else {
                path.add(currentEle);
            }
        }

        Collections.reverse(path2);
        for (int i = path2.size() - 1; i >= 0; i--) {
            int currentEle = path2.get(i);
            if (currentEle == commonRoot) {
                path.add(currentEle);
                break;
            } else {
                path.add(currentEle);
            }
        }

        return path;
    }

    public static boolean findPathFromRoot(TreeNode root, int val, ArrayList<Integer> path) {

        if (root == null) {
            return false;
        }
        if (root.val == val) {
            // node found
            path.add(root.val);
            return true;
        }
        if (findPathFromRoot(root.left, val, path)) {
            path.add(root.val);
            return true;
        }
        if (findPathFromRoot(root.right, val, path)) {
            path.add(root.val);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // test 1
        // expected output: 210 80 40 20 10 30 70
        System.out.println("\n****** test1 *******");
        TreeNode root = TreeUtils.create5LevelBinaryTree();
        TreeUtils.printTree(root);
        ArrayList<Integer> path = findPathBwtTwoNodesInBinaryTree(root, 210, 70);
        TreeUtils.printList(path);

        // test 2
        // expected output: 250 100
        System.out.println("\n****** test2 *******");
        root = TreeUtils.create5LevelBinaryTree();
        TreeUtils.printTree(root);
        path = findPathBwtTwoNodesInBinaryTree(root, 250, 100);
        TreeUtils.printList(path);

        // test 3
        // expected output: 290 120 60 30 10 20 50 110
        System.out.println("\n****** test3 *******");
        root = TreeUtils.create5LevelBinaryTree();
        TreeUtils.printTree(root);
        path = findPathBwtTwoNodesInBinaryTree(root, 290, 110);
        TreeUtils.printList(path);

        // test 3
        // expected output: 110 50 20 10 30 60 120 290
        System.out.println("\n****** test3 *******");
        root = TreeUtils.create5LevelBinaryTree();
        TreeUtils.printTree(root);
        path = findPathBwtTwoNodesInBinaryTree(root, 110, 290);
        TreeUtils.printList(path);
    }

}
