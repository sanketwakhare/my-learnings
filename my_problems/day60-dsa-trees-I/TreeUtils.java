import java.util.ArrayList;

public class TreeUtils {

    public static TreeNode insertLeft(TreeNode root, int x) {
        root.left = new TreeNode(x);
        return root.left;
    }

    public static TreeNode insertRight(TreeNode root, int x) {
        root.right = new TreeNode(x);
        return root.right;
    }

    public static TreeNode getRandomNode() {
        int value = (int) Math.floor(Math.random() * 100);
        TreeNode root = new TreeNode(value);
        return root;
    }

    public static int getRandomValue() {
        int value = (int) Math.floor(Math.random() * 100);
        return value;
    }

    public static TreeNode createTree() {
        TreeNode root = getRandomNode();
        TreeNode left = insertLeft(root, getRandomValue());
        TreeNode right = insertRight(root, getRandomValue());
        insertLeft(left, getRandomValue());
        insertRight(left, getRandomValue());
        insertLeft(right, getRandomValue());
        insertRight(right, getRandomValue());
        return root;
    }

    public static void printTree(TreeNode root) {
        // use any type of traversal to print the nodes data
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode createTestTree() {
        TreeNode root = new TreeNode(10);
        TreeNode left = insertLeft(root, 20);
        TreeNode right = insertRight(root, 30);
        insertLeft(left, 40);
        insertRight(left, 50);
        insertLeft(right, 60);
        insertRight(right, 70);
        return root;
    }

    public static void printLevelWiseLeftToRight(ArrayList<ArrayList<Integer>> output) {
        int index = 0;
        for (ArrayList<Integer> level : output) {
            System.out.print("\n" + index++ + "->");
            for (Integer node : level) {
                System.out.print(node + " ");
            }
        }
    }

    public static void printLevelWiseList(ArrayList<Integer> list) {
        System.out.println();
        int index = 0;
        for (Integer node : list) {
            System.out.println("level " + index++ + " - " + node);
        }
    }

    public static void printList(ArrayList<Integer> list) {
        System.out.println();
        for (Integer node : list) {
            System.out.print(node + " ");
        }
    }

    public static TreeNode create5LevelBinaryTree() {
        // level1
        TreeNode root = new TreeNode(10);
        // level2
        TreeNode twenty = insertLeft(root, 20);
        TreeNode thirty = insertRight(root, 30);
        // level3
        TreeNode forty = insertLeft(twenty, 40);
        TreeNode fifty = insertRight(twenty, 50);
        TreeNode sixty = insertLeft(thirty, 60);
        TreeNode seventy = insertRight(thirty, 70);
        // level4
        TreeNode eighty = insertLeft(forty, 80);
        TreeNode ninety = insertRight(forty, 90);
        TreeNode hundred = insertLeft(fifty, 100);
        TreeNode oneTen = insertRight(fifty, 110);
        TreeNode oneTwenty = insertLeft(sixty, 120);
        TreeNode oneThirty = insertRight(sixty, 130);
        TreeNode oneForty = insertLeft(seventy, 140);
        TreeNode oneFifty = insertRight(seventy, 150);
        // level5
        insertLeft(eighty, 210);
        insertRight(eighty, 220);
        insertLeft(ninety, 230);
        insertRight(ninety, 240);
        insertLeft(hundred, 250);
        insertRight(hundred, 260);
        insertLeft(oneTen, 270);
        insertRight(oneTen, 280);
        insertLeft(oneTwenty, 290);
        insertRight(oneTwenty, 300);
        insertLeft(oneThirty, 310);
        insertRight(oneThirty, 320);
        insertLeft(oneForty, 330);
        insertRight(oneForty, 340);
        insertLeft(oneFifty, 350);
        insertRight(oneFifty, 360);

        return root;
    }

    public static TreeNode createBST() {
        // level1
        TreeNode root = new TreeNode(50);

        // LST
        // level2
        TreeNode thirty = insertLeft(root, 30);
        // level3
        TreeNode ten = insertLeft(thirty, 10);
        insertRight(thirty, 40);
        // level4
        insertRight(ten, 20);

        // RST
        // level2
        TreeNode seventy = insertRight(root, 70);
        // level3
        insertLeft(seventy, 60);
        TreeNode ninety = insertRight(seventy, 90);
        // level4
        insertLeft(ninety, 80);
        insertRight(ninety, 100);

        return root;
    }

    public static TreeNode createBSTForDelete() {
        // level1
        TreeNode root = new TreeNode(50);

        // LST
        // level2
        TreeNode thirty = insertLeft(root, 30);
        // level3
        TreeNode ten = insertLeft(thirty, 10);
        insertRight(thirty, 40);
        // level4
        insertRight(ten, 20);

        // RST
        // level2
        TreeNode seventy = insertRight(root, 70);
        // level3
        TreeNode sixty = insertLeft(seventy, 60);
        TreeNode ninety = insertRight(seventy, 90);
        // level4
        insertLeft(ninety, 80);
        insertRight(ninety, 100);

        insertLeft(sixty, 55);
        insertRight(sixty, 65);

        return root;
    }

    public static void printInOrderOfATree(TreeNode root) {
        // use any type of traversal to print the nodes data
        if (root == null) {
            return;
        }
        printInOrderOfATree(root.left);
        System.out.print(root.val + " ");
        printInOrderOfATree(root.right);
    }

    public static TreeNode createTree2() {
        // test 1
        // @formatter:off
        /* 
                    3
                  /   \
                 7     9
                /     /  \
               8     6    4
                   /   \    \
                  18    14   -9
                 /  \     \
                33   12    25
              /     /       \
             41   19         24
                  /
                17 
        */
        // @formatter:on
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(18);
        root.right.left.left.left = new TreeNode(33);
        root.right.left.left.right = new TreeNode(12);
        root.right.left.left.left.left = new TreeNode(41);
        root.right.left.left.right.left = new TreeNode(19);
        root.right.left.left.right.left.left = new TreeNode(17);
        root.right.left.right = new TreeNode(14);
        root.right.left.right.right = new TreeNode(25);
        root.right.left.right.right.right = new TreeNode(24);
        root.right.right.right = new TreeNode(-9);
        return root;
    }
}
