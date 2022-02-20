public class class_q1_sortedArrayToBST {

    public static TreeNode construct(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode temp = new TreeNode(A[mid]);
        temp.left = construct(A, start, mid - 1);
        temp.right = construct(A, mid + 1, end);
        return temp;
    }

    public static TreeNode sortedArrayToBST(int[] A) {
        return construct(A, 0, A.length - 1);
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 2, 3 };
        TreeNode root = sortedArrayToBST(A1);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);

        int[] A2 = { 1, 2, 3, 5, 10 };
        root = sortedArrayToBST(A2);
        System.out.println();
        TreeUtils.printInOrderOfATree(root);
    }

}
