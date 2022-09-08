import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * PostOrder traversal
 * TC: O(N)
 * SC: O(N)
 */
public class q5_Postorder_iterative_2_stacks {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        q5_Postorder_iterative_2_stacks t1 = new q5_Postorder_iterative_2_stacks();
        List<Integer> postOrderList = t1.postOrder(root);
        System.out.println("\nPostOrder traversal -> ");
        for (int ele : postOrderList) {
            System.out.print(ele + " ");
        }
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        if (root == null) return result;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode top = stack1.pop();
            stack2.push(top.val);
            if (top.left != null) {
                stack1.push(top.left);
            }
            if (top.right != null) {
                stack1.push(top.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop());
        }
        return result;
    }
}
