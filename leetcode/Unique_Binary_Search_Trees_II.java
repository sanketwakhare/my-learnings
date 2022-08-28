/* Unique Binary Search Trees II */

// Given an integer n, return all the structurally unique BST's (binary search trees),
// which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

// https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {
    public static void main(String[] args) {
        Unique_Binary_Search_Trees_II t1 = new Unique_Binary_Search_Trees_II();
        List<TreeNode> result = t1.generateTrees(4);
        for (TreeNode head : result) {
            List<TreeNode> preOrderList = new ArrayList<>();
            t1.preorder(head, preOrderList);
            System.out.println(preOrderList);
        }
    }

    public void preorder(TreeNode root, List<TreeNode> preOrderList) {
        if (root == null) {
            return;
        }
        preOrderList.add(root);
        preorder(root.left, preOrderList);
        preorder(root.right, preOrderList);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return backtrack(1, n);
    }

    public List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftBSTs = backtrack(start, i - 1);
            List<TreeNode> rightBSTs = backtrack(i + 1, end);

            for (TreeNode left : leftBSTs) {
                for (TreeNode right : rightBSTs) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
