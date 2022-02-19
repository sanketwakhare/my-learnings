/* Bottom up approach to find if given tree is BST or not */

// check if given nodes falls within max(LST) < root < min(RST) =>
// max(rightMax,leftMax) [max(LST)< root < min(RST)] => min(rightMin,leftMin)

class Data {
    long min;
    long max;
    boolean isBST;

    public Data() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
        isBST = true;
    }
}

public class class_q3_checkIfBST_approach2 {

    public static Data isValid(TreeNode root) {

        Data currentData = new Data();
        if (root == null) {
            return currentData;
        }

        Data leftData = isValid(root.left);
        Data rightData = isValid(root.right);

        if (leftData.isBST && rightData.isBST) {
            // current node value should be greater than max of LST and less than min of RST
            if (root.val >= leftData.max && root.val <= rightData.min) {
                currentData.isBST = true;
                // update current minimum as min will be present on LST
                currentData.min = Math.min(leftData.min, root.val);
                // update current maximum as max will be present on RST
                currentData.max = Math.max(rightData.max, root.val);
            } else {
                currentData.isBST = false;
            }
        } else {
            currentData.isBST = false;
        }
        return currentData;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBST();
        TreeUtils.printInOrderOfATree(root);
        Data currentData = isValid(root);
        System.out.println(currentData.isBST);

        root = TreeUtils.createTree();
        TreeUtils.printInOrderOfATree(root);
        currentData = isValid(root);
        System.out.println(currentData.isBST);

        root = new TreeNode(Integer.MAX_VALUE);
        TreeUtils.printInOrderOfATree(root);
        currentData = isValid(root);
        System.out.println(currentData.isBST);

    }
}
