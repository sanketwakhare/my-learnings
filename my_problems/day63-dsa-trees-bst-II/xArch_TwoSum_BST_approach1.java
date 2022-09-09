import java.util.ArrayList;
import java.util.List;

/* Two Sum BST */
/* Leetcode: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/ */

/* TC: O(n)
 * SC: O(n)*/
public class xArch_TwoSum_BST_approach1 {
    public static void main(String[] args) {
        xArch_TwoSum_BST_approach1 t1 = new xArch_TwoSum_BST_approach1();
        TreeNode root = TreeUtils.createBSTForDelete();
        System.out.println(t1.twoSumBST(root, 80));
        System.out.println(t1.twoSumBST(root, 45));
    }

    public int twoSumBST(TreeNode root, int B) {
        List<Integer> inOrder = new ArrayList<>();
        traverse(root, inOrder);

        int start = 0;
        int end = inOrder.size() - 1;
        int sum;
        while (start < end) {
            sum = inOrder.get(start) + inOrder.get(end);
            if (sum == B) {
                return 1;
            } else if (sum > B) {
                end--;
            } else {
                start++;
            }
        }
        return 0;
    }

    private void traverse(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;
        traverse(root.left, inOrder);
        inOrder.add(root.val);
        traverse(root.right, inOrder);
    }
}
