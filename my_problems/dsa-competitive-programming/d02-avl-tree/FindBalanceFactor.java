public class FindBalanceFactor {

    public static void main(String[] args) {
        Node root = new Node(30);

        root.left = new Node(20);
        root.right = new Node(40);

        root.left.left = new Node(10);
        root.left.right = new Node(15);
        root.left.right.left = new Node(13);

        root.right.left = new Node(35);

        FindBalanceFactor t = new FindBalanceFactor();
        int ht = t.height(root);
        System.out.println(ht);

        int bf = t.findBalanceFactor(root);
        System.out.println(bf);
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
}
