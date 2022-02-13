import java.util.HashMap;
import java.util.Map;

/* Construct Binary Tree from InOrder and PostOrder traversals */
public class class_q9_construct_binary_tree_from_InOrder_and_PostOrder {

    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        // prepare hashMap for inOrder array. search becomes faster
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);
    }

    public static TreeNode construct(int[] inOrder, int inStart, int inEnd, int[] postOrder, int pStart, int pEnd,
            Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode temp = new TreeNode(postOrder[pEnd]);
        // find index of root in InOrder array
        int midInd = map.get(postOrder[pEnd]);
        // x is not of elements on left of root/temp
        int x = midInd - inStart;

        temp.left = construct(inOrder, inStart, midInd - 1, postOrder, pStart, pStart + x - 1, map);
        temp.right = construct(inOrder, midInd + 1, inEnd, postOrder, pStart + x, pEnd - 1, map);
        return temp;
    }

    public static void main(String[] args) {

        // test 1
        int[] inOrder = new int[] { 2, 1, 3 };
        int[] postOrder = new int[] { 2, 3, 1 };
        TreeNode root = buildTree(inOrder, postOrder);
        TreeUtils.printTree(root);

        // test 2
        inOrder = new int[] { 6, 1, 3, 2 };
        postOrder = new int[] { 6, 3, 2, 1 };
        root = buildTree(inOrder, postOrder);
        TreeUtils.printTree(root);
    }
}
