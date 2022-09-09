/* Two Sum BST */
/* Leetcode: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/ */

/* TC: O(N logN)
 * SC: O(H)*/
public class xArch_TwoSum_BST_approach2 {
    public static void main(String[] args) {
        xArch_TwoSum_BST_approach2 t1 = new xArch_TwoSum_BST_approach2();
        TreeNode root = TreeUtils.createBSTForDelete();
        System.out.println(t1.twoSumBST(root, 80));
        System.out.println(t1.twoSumBST(root, 45));
    }

    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;
        return search(root, cur, k - cur.val)
                || dfs(root, cur.left, k)
                || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null) return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }

    public int twoSumBST(TreeNode root, int B) {
        return dfs(root, root, B) ? 1 : 0;
    }

}
