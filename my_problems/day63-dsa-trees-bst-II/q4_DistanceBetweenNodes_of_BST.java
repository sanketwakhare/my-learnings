import java.util.ArrayList;
import java.util.HashSet;

/* Distance between Nodes of BST */

/* Problem Description

Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 10^9

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer denoting the distance between two nodes with given two keys B and C

Example Input
Input 1:
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6

Example Output
Output 1:
 3
Output 2:
 1
Example Explanation
Explanation 1:
 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:
 Path between 2 and 6 is: 2 -> 6. Distance will be 1 */

public class q4_DistanceBetweenNodes_of_BST {

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

    public static int solve(TreeNode A, int B, int C) {

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
        int leastCommonAncestor = -1;
        for (int i = 0; i < cPath.size(); i++) {
            if (bPath.contains(cPath.get(i))) {
                leastCommonAncestor = cPath.get(i);
                break;
            }
        }

        int distance = 0;
        for (int i = 0; i < bPath.size(); i++) {
            int curr = bPath.get(i);
            if (curr != leastCommonAncestor) {
                distance++;
            } else {
                break;
            }
        }
        for (int i = 0; i < cPath.size(); i++) {
            int curr = cPath.get(i);
            if (curr != leastCommonAncestor) {
                distance++;
            } else {
                break;
            }
        }
        return distance;

    }

    public static void main(String[] args) {
        // test 1
        // @formatter:off
        /*
         *     10
         *    /  \
         *   20   30
         *  / \   / \
         * 40 50 60  70
         */
        // @formatter:on
        // expected distance : 4
        TreeNode root = TreeUtils.createTestTree();
        int B = 40;
        int C = 60;
        System.out.println(solve(root, B, C));
        System.out.println(solve(root, 70, 20)); // expected output 3
        System.out.println(solve(root, 30, 10)); // expected output 1
        System.out.println(solve(root, 50, 50)); // expected output 0
    }
}
