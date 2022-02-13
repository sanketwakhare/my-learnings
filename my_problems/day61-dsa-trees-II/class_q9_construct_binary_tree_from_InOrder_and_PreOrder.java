import java.util.HashMap;
import java.util.Map;

/* Construct Binary Tree from InOrder and PreOrder traversals */
public class class_q9_construct_binary_tree_from_InOrder_and_PreOrder {

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        // store inOrder in map to find the index of current root
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return construct(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, map);
    }

    public static TreeNode construct(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd,
            Map<Integer, Integer> map) {

        // base condition
        if (inStart > inEnd) {
            return null;
        }
        TreeNode temp = new TreeNode(preOrder[preStart]);

        // current index of root in inOrder array
        int midInd = (Integer) map.get(preOrder[preStart]);
        // x is the count of elements in left subtree of temp
        int x = midInd - inStart;

        // recursively build the left and right subtree
        temp.left = construct(inOrder, inStart, midInd - 1, preOrder, preStart + 1, preStart + x, map);
        temp.right = construct(inOrder, midInd + 1, inEnd, preOrder, preStart + x + 1, preEnd, map);
        return temp;
    }

    public static void main(String[] args) {

        // test 1
        int[] preOrder = new int[] { 1, 2, 3 };
        int[] inOrder = new int[] { 2, 1, 3 };
        TreeNode root = buildTree(preOrder, inOrder);
        TreeUtils.printTree(root);

        // test 2
        preOrder = new int[] { 1, 6, 2, 3 };
        inOrder = new int[] { 6, 1, 3, 2 };
        root = buildTree(preOrder, inOrder);
        TreeUtils.printTree(root);
    }

}
