import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Preorder traversal Recursive */
public class hw_q1_PreorderTraversal_Recursive {

    public static void main(String[] args) {
        hw_q1_PreorderTraversal_Recursive t1 = new hw_q1_PreorderTraversal_Recursive();
        TreeNode root = TreeUtils.createTestTree();
        int[] result = t1.preorderTraversal(root);
        System.out.println(Arrays.toString(result));
    }

    public int[] preorderTraversal(TreeNode A) {
        List<Integer> result = new ArrayList<>();
        performPreOrder(A, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void performPreOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        performPreOrder(root.left, result);
        performPreOrder(root.right, result);
    }
}
