/* Binary Tree Array Implementation*/

public class class_binaryTree_using_array {

    public void inOrderTraversal(int[] A, int i) {
        if (i < A.length) {
            System.out.print(A[i] + " ");
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            inOrderTraversal(A, leftChild);
            inOrderTraversal(A, rightChild);
        }
    }

    public void preOrderTraversal(int[] A, int i) {
        if (i < A.length) {
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            preOrderTraversal(A, leftChild);
            System.out.print(A[i] + " ");
            preOrderTraversal(A, rightChild);
        }
    }

    public void postOrderTraversal(int[] A, int i) {
        if (i < A.length) {
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            postOrderTraversal(A, leftChild);
            postOrderTraversal(A, rightChild);
            System.out.print(A[i] + " ");
        }
    }

    // Convert array [in form of level order traversal] into Tree
    public TreeNode serializeTree(int[] A, int i) {

        TreeNode root = null;
        if (i < A.length) {
            root = new TreeNode(A[i]);
            // System.out.print(A[i] + " ");
            int leftChild = (2 * i) + 1;
            int rightChild = (2 * i) + 2;
            root.left = serializeTree(A, leftChild);
            root.right = serializeTree(A, rightChild);
        }
        return root;
    }

    public static void main(String[] args) {

        int[] A = new int[] { 3, 4, 7, 6, 5, 2 };
        class_binaryTree_using_array t1 = new class_binaryTree_using_array();
        System.out.print("\ninOrder traversal -> ");
        t1.inOrderTraversal(A, 0);
        System.out.print("\npreOrder traversal -> ");
        t1.preOrderTraversal(A, 0);
        System.out.print("\npostOrder traversal -> ");
        t1.postOrderTraversal(A, 0);

        System.out.print("\nSerialized Tree -> ");
        TreeNode root = t1.serializeTree(A, 0);
        TreeUtils.printTree(root);

    }
}