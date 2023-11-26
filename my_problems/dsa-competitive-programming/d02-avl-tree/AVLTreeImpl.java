// TODO: Implement AVL Tree operations
public class AVLTreeImpl {
    // insert element into AVL Tree
    // delete element from AVL Tree
    // search element in AVL Tree

    // LL Rotation
    // RR Rotation

    // find height
    // find balance factor
    public static void main(String[] args) {
        AVLTreeImpl avlTree = new AVLTreeImpl();
        Node root = new Node(20);
        root = avlTree.insert(root, 10, null);
        root = avlTree.insert(root, 30, null);
        root = avlTree.insert(root, 40, null);
        root = avlTree.insert(root, 35, null);
        root = avlTree.insert(root, 50, null);
        root = avlTree.insert(root, 60, null);
        root = avlTree.insert(root, 15, null);
        root = avlTree.insert(root, 70, null);
        root = avlTree.insert(root, 80, null);
        root = avlTree.insert(root, 90, null);
        root = avlTree.insert(root, 100, null);
        root = avlTree.insert(root, 110, null);
        root = avlTree.insert(root, 5, null);
        root = avlTree.insert(root, 75, null);
        root = avlTree.insert(root, 25, null);
        root = avlTree.insert(root, 95, null);

        // Search element in AVL Tree
        boolean found = avlTree.search(root, 90);
        System.out.println("element " + (found ? "found" : "not found"));
    }

    // find height of the tree and populate teh height in all AVL Tree nodes
    public int height(Node root) {
        if (root == null) return 0;
        int ht = 1 + Math.max(height(root.left), height(root.right));
        root.height = ht;
        return ht;
    }

    // find balance factor
    public int findBalanceFactor(Node root) {

        if (root == null) return 0;

        int leftHeight = root.left != null ? root.left.height : 0;
        int rightHeight = root.right != null ? root.right.height : 0;
        return leftHeight - rightHeight;
    }

    // Left-Left Rotation
    public Node LLRotation(Node root) {
        Node child = root.left;
        root.left = child.right;
        child.right = root;

        root.height = 1 + Math.max(root.left != null ? root.left.height : 0,
                root.right != null ? root.right.height : 0);
        child.height = 1 + Math.max(child.left != null ? child.left.height : 0,
                child.right.height);

        return child;
    }

    // Right-Right Rotation
    public Node RRRotation(Node root) {

        Node child = root.right;
        root.right = child.left;
        child.left = root;

        root.height = 1 + Math.max(root.left != null ? root.left.height : 0,
                root.right != null ? root.right.height : 0);
        child.height = 1 + Math.max(child.left.height,
                child.right != null ? child.right.height : 0);

        return child;
    }

    // Insert the node in AVL tree
    public Node insert(Node root, int K, Node prev) {
        if (root == null) {
            // insert at this position
            Node temp = new Node(K);
            // if tree is empty
            if (prev != null) {
                if (prev.data > K) {
                    // insert at left of prev
                    prev.left = temp;
                } else {
                    // insert at right of prev
                    prev.right = temp;
                }
            }
            root = temp;
        } else if (root.data < K) {
            prev = root;
            root.right = insert(root.right, K, prev);
        } else {
            prev = root;
            root.left = insert(root.left, K, prev);
        }

        int balanceFactor = findBalanceFactor(root);
        if (balanceFactor > 1) {
            // apply LL or LR
            int leftChildBalanceFactor = findBalanceFactor(root.left);
            if (leftChildBalanceFactor > 0) {
                // LL Rotation
                root = LLRotation(root);
            } else {
                // LR Rotation
                root.left = RRRotation(root.left);
                root = LLRotation(root);
            }
        } else if (balanceFactor < -1) {
            // apply RR or RL
            int rightChildBalanceFactor = findBalanceFactor(root.right);
            if (rightChildBalanceFactor > 0) {
                // RL Rotation
                root.right = LLRotation(root.right);
                root = RRRotation(root);
            } else {
                // RR Rotation
                root = RRRotation(root);
            }
        }
        root.height = 1 + Math.max(root.left != null ? root.left.height : 0,
                root.right != null ? root.right.height : 0);
        return root;
    }

    // TODO: delete node from AVL tree
    public Node delete(Node root, int K, Node prev) {
        return root;
    }

    // search Node in AVL tree
    public boolean search(Node root, int K) {
        // base condition
        if (root == null)
            return false;

        Node temp = root;
        while (temp != null) {
            if (temp.data == K) {
                // element K is found
                return true;
            } else if (temp.data < K) {
                // search in RST
                temp = temp.right;
            } else {
                // search in LST
                temp = temp.left;
            }
        }
        // element K is not found
        return false;
    }
}
