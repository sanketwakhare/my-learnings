import java.util.ArrayList;
import java.util.HashSet;

/* Least Common Ancestor */

/* Problem Description

Find the lowest common ancestor in an unordered binary tree A given two values B and C in the tree.
Lowest common ancestor : the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 10^9

Input Format
First argument is head of tree A.
Second argument is integer B.
Third argument is integer C.

Output Format
Return the LCA.

Example Input
Input 1:
      1
     /  \
    2    3
B = 2
C = 3
Input 2:
      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 LCA is 1.
Explanation 2:
 LCA is 2. */

public class q3_LeastCommonAncestor {
    // find path of node K from root node
    public static boolean getPath(TreeNode root, int K, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.val == K) {
            path.add(root.val);
            return true;
        }
        if (getPath(root.left, K, path) || getPath(root.right, K, path)) {
            path.add(root.val);
            return true;
        }
        return false;
    }

    public static int lca(TreeNode A, int B, int C) {

        // find path of both B and C from root
        ArrayList<Integer> bPath = new ArrayList<Integer>();
        ArrayList<Integer> cPath = new ArrayList<Integer>();

        getPath(A, B, bPath);
        getPath(A, C, cPath);

        // store path of B into set to identify if common node is present
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < bPath.size(); i++) {
            set.add(bPath.get(i));
        }
        // find least common node
        int answer = -1;
        for (int i = 0; i < cPath.size(); i++) {
            if (bPath.contains(cPath.get(i))) {
                answer = cPath.get(i);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // test 1
        // @formatter:off
        /*
         *     1
         *    /  \
         *   2    3
         */
        // @formatter:on
        // expected output : 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int B = 2;
        int C = 3;
        System.out.println(lca(root, B, C));

        // test 2
        // @formatter:off
        /*
         *     10
         *    /  \
         *   20   30
         *  / \   / \
         * 40 50 60  70
         */
        // @formatter:on
        // expected output : 20
        root = TreeUtils.createTestTree();
        B = 20;
        C = 50;
        System.out.println(lca(root, B, C));

    }
}
