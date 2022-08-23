import java.util.ArrayList;
import java.util.List;

public class class_q4_deleteNodeFromBST {
    // case 1: delete when there are no child => 0 child
    // case 2: delete when there is 1 child
    // case 3: delete when there are 2 children or many grand children

    public static List<TreeNode> searchNode(TreeNode root, int K) {

        List<TreeNode> list = new ArrayList<>();
        TreeNode parent = null;
        // base condition
        if (root == null) {
            list.add(parent);
            list.add(null);
            return list;
        }

        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == K) {
                list.add(parent);
                list.add(temp);
                return list;
            } else if (temp.val > K) {
                parent = temp;
                temp = temp.left;
            } else {
                parent = temp;
                temp = temp.right;
            }
        }
        // if element K is not found
        list.add(null);
        list.add(null);
        return list;
    }

    public static TreeNode deleteNode(TreeNode root, int K) {

        // curr is the node with element K
        // parent will be previous node of current node
        List<TreeNode> list = searchNode(root, K);
        TreeNode parent = list.get(0);
        TreeNode curr = list.get(1);

        if (parent != null) {
            System.out.println("\n->parent " + parent.val);
        }
        if (curr != null) {
            System.out.println("->curr " + curr.val);
        }

        if (curr == null && parent == null) {
            System.out.println("\nnode not found!");
            return root;
        }

        // case 1: delete leaf node
        if (curr.left == null && curr.right == null) {
            // delete curr
            if (parent == null) {
                // entire tree is will be null
                // curr is new root
                curr = null;
                return curr;
            } else {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }

        // case 2: delete element with single child
        else if (curr.right == null || curr.left == null) {
            if (parent == null) {
                parent = curr;
                if (curr.left != null) {
                    curr = curr.left;
                    parent.left = null;
                } else {
                    curr = curr.right;
                    parent.right = null;
                }
                // curr is new root
                return curr;
            } else {
                if (parent.left == curr) {
                    // curr is left of parent
                    if (curr.left != null) {
                        parent.left = curr.left;
                    } else {
                        parent.left = curr.right;
                    }
                } else {
                    // curr is right of parent
                    if (curr.left != null) {
                        parent.right = curr.left;
                    } else {
                        parent.right = curr.right;
                    }
                }
            }
        }

        // case 3: delete element with two children
        else if (curr.left != null && curr.right != null) {

            // find the max element from LST
            TreeNode p = null;
            TreeNode maxLST = curr.left;

            while (maxLST.right != null) {
                p = maxLST;
                maxLST = maxLST.right;
            }

            if (p == null) {
                // immediate left of curr node is max of LST

                // connect left subtree of maxLST
                if (parent.left == curr) {
                    parent.left = maxLST;
                } else {
                    parent.right = maxLST;
                }
                maxLST.left = curr.left.left;
                maxLST.right = curr.right;
            } else {
                // connect left subtree of maxLST
                // maxLST.right will be always null and maxLST will always be on the right of
                // LST
                p.right = maxLST.left;
                if (parent.left == curr) {
                    parent.left = maxLST;
                } else {
                    parent.right = maxLST;
                }
                maxLST.left = curr.left;
                maxLST.right = curr.right;
            }

        }

        return root;

    }

    public static void main(String[] args) {

        TreeNode root = TreeUtils.createBSTForDelete();
        TreeUtils.printInOrderOfATree(root);
        root = deleteNode(root, 70);
        TreeUtils.printInOrderOfATree(root);
        root = deleteNode(root, 30);
        TreeUtils.printInOrderOfATree(root);
        root = deleteNode(root, 10);
        TreeUtils.printInOrderOfATree(root);
        root = deleteNode(root, 110);
        TreeUtils.printInOrderOfATree(root);

    }

    // case 3: delete element with two children - optimized Code
    // case3()
    // {

    // // find the max element from LST
    // TreeNode p = null;
    // TreeNode maxLST = curr.left;

    // while (maxLST.right != null) {
    // p = maxLST;
    // maxLST = maxLST.right;
    // }

    // if (p == null) {
    // // immediate left of curr node is max of LST
    // // connect left subtree of maxLST
    // curr.left = maxLST.left;
    // } else {
    // // connect left subtree of maxLST
    // // maxLST.right will be always null and maxLST will always be on the right of
    // // LST
    // p.right = maxLST.left;
    // }

    // // form new links
    // if (parent.left == curr) {
    // parent.left = maxLST;
    // } else {
    // parent.right = maxLST;
    // }
    // maxLST.left = curr.left;
    // maxLST.right = curr.right;

    // }

}
