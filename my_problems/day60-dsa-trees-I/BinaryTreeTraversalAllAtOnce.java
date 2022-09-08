import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Given a Binary Tree, get the Preorder, Inorder and Postorder traversal all at once */

public class BinaryTreeTraversalAllAtOnce {

    static class Pair {
        TreeNode first;
        int second;

        public Pair(TreeNode first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversalAllAtOnce t1 = new BinaryTreeTraversalAllAtOnce();
        TreeNode root = TreeUtils.createTestTree();
        List<List<Integer>> result = t1.traverse(root);
        System.out.println(result);
    }

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);

        if (root == null) return result;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            TreeNode node = curr.first;
            int value = curr.second;
            if (value == 1) {
                preOrder.add(node.val);
                curr.second = 2;
                stack.push(curr);
                if (node.left != null) {
                    stack.push(new Pair(node.left, 1));
                }
            } else if (value == 2) {
                inOrder.add(node.val);
                curr.second = 3;
                stack.push(curr);
                if (node.right != null) {
                    stack.push(new Pair(node.right, 1));
                }
            } else {
                postOrder.add(node.val);
            }
        }
        return result;
    }
}
