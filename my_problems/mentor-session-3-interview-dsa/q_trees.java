import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// write your code here...
class TreeNode1 {
    int data;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

class SLLNode1 {
    int data;
    SLLNode1 next;

    public SLLNode1(int value) {
        this.data = value;
        this.next = null;
    }
}

public class q_trees {

    public static ArrayList<SLLNode1> levelOrder(TreeNode1 root) {

        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        SLLNode1 head = null;
        SLLNode1 last = head;

        // 1 null 2 3 null 4 5 6 7 null
        ArrayList<SLLNode1> levelWiseLL = new ArrayList<SLLNode1>();

        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            TreeNode1 curr = queue.poll();
            if (curr != null) {
                // create LL - append the curr node to LL
                SLLNode1 temp = new SLLNode1(curr.data);
                ArrayList<SLLNode1> headAndLast = appendAtLast(head, last, temp);
                head = headAndLast.get(0);
                last = headAndLast.get(1);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            } else {
                // end iof the current level
                // add null to last of ll
                // add head to arrayList
                levelWiseLL.add(head);
                queue.add(null);
                // start of next level
                head = null;
                last = head;
            }
        }
        // last case
        levelWiseLL.add(head);
        return levelWiseLL;
    }

    public static ArrayList<SLLNode1> appendAtLast(SLLNode1 head, SLLNode1 last, SLLNode1 temp) {
        // append the temp to last of linked list
        ArrayList<SLLNode1> output = new ArrayList<SLLNode1>();
        if (head == null && last == null) {
            head = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
        output.add(head);
        output.add(last);
        return output;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        ArrayList<SLLNode1> output = levelOrder(root);
        System.out.println(output);

        for (SLLNode1 currentHead : output) {
            printList(currentHead);
        }
    }

    public static void printList(SLLNode1 head) {
        SLLNode1 temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

}