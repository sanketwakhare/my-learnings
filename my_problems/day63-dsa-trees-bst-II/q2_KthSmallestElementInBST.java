import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Kth Smallest Element In BST */

/* Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an integer, representing the Bth element.

Example Input
Input 1:
            2
          /   \
         1    3
B = 2
Input 2:
            3
           /
          2
         /
        1
B = 1

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
2nd element is 2.
Explanation 2:
1st element is 1. */

public class q2_KthSmallestElementInBST {

    public static int kthSmallest(TreeNode root, int K, Map<TreeNode, ArrayList<Integer>> map) {

        TreeNode temp = root;
        while (temp != null) {
            int lstSize = map.get(temp).get(0);
            if (lstSize == K - 1) {
                return temp.val;
            } else if (lstSize > K - 1) {
                temp = temp.left;
            } else {
                K = K - 1 - lstSize;
                temp = temp.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // pre-compute size of lst and rst for each node
        TreeNode root = TreeUtils.createBST();
        Map<TreeNode, ArrayList<Integer>> map = new HashMap<TreeNode, ArrayList<Integer>>();
        preComputeSize(root, map);
        for (Map.Entry<TreeNode, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            System.out.println(entry.getKey().val + " " + value.get(0) + " " + value.get(1));
        }

        // test 1
        System.out.println(kthSmallest(root, 2, map));
        // test 2
        System.out.println(kthSmallest(root, 8, map));
    }

    private static int preComputeSize(TreeNode root, Map<TreeNode, ArrayList<Integer>> map) {

        if (root == null) {
            return 0;
        }
        int x = preComputeSize(root.left, map);
        int y = preComputeSize(root.right, map);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(x);
        list.add(y);
        map.put(root, list);
        return x + y + 1;
    }

}
