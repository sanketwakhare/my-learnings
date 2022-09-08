import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Inorder traversal Iterative using Stack */
public class hw_q1_InorderTraversal_Iterative {

    public static void main(String[] args) {
        hw_q1_InorderTraversal_Recursive t1 = new hw_q1_InorderTraversal_Recursive();
        TreeNode root = TreeUtils.createTestTree();
        int[] result = t1.inorderTraversal(root);
        System.out.println(Arrays.toString(result));
    }

    public int[] inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                TreeNode top = stack.pop();
                result.add(top.val);
                curr = top.right;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
