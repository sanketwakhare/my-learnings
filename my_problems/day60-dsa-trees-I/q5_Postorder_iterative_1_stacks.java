import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * PostOrder traversal
 * TC: O(N)
 * SC: O(N)
 */
public class q5_Postorder_iterative_1_stacks {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createTestTree();
        TreeUtils.printTree(root);
        q5_Postorder_iterative_1_stacks t1 = new q5_Postorder_iterative_1_stacks();
        List<Integer> postOrderList = t1.postOrder(root);
        System.out.println("\nPostOrder traversal -> ");
        for (int ele : postOrderList) {
            System.out.print(ele + " ");
        }
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.val);
                    // if there is any root
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return result;
    }
}
