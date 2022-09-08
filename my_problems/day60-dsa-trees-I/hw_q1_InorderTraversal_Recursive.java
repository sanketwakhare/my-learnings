import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Inorder traversal Recursive */
public class hw_q1_InorderTraversal_Recursive {

    public static void main(String[] args) {
        hw_q1_InorderTraversal_Recursive t1 = new hw_q1_InorderTraversal_Recursive();
        TreeNode root = TreeUtils.createTestTree();
        int[] result = t1.inorderTraversal(root);
        System.out.println(Arrays.toString(result));
    }

    public int[] inorderTraversal(TreeNode A) {
        List<Integer> result = new ArrayList<>();
        performInOrder(A, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void performInOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        performInOrder(root.left, result);
        result.add(root.val);
        performInOrder(root.right, result);
    }
}
