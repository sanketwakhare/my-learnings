/* Flatten a linked list */

/**
 * Problem Description
 * 
 * Given a linked list where every node represents a linked list and contains
 * two pointers of its type:
 * 
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked
 * lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer
 * to link nodes of the flattened list. The flattened linked list should also be
 * sorted.
 * 
 * Problem Constraints
 * 1 <= Total nodes in the list <= 100000
 * 1 <= Value of node <= 10^9
 * 
 * Input Format
 * The only argument given is head pointer of the doubly linked list.
 * 
 * Output Format
 * Return the head pointer of the Flattened list.
 * 
 * Example Input
 * Input 1:
 * 3 -> 4 -> 20 -> 20 ->30
 * | | | | |
 * 7 11 22 20 31
 * | | |
 * 7 28 39
 * | |
 * 8 39
 * Input 2:
 * 2 -> 4
 * | |
 * 7 11
 * |
 * 7
 * 
 * Example Output
 * Output 1:
 * 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39
 * -> 39
 * Output 2:
 * 2 -> 4 -> 7 -> 7 -> 11
 * 
 * Example Explanation
 * Explanation 1:
 * The return linked list is the flatten sorted list.
 */

public class hw_q3_FlattenALinkedList {

    public static class ListNode {
        int val;
        ListNode right, down;

        public ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    // merge 2 sorted lists
    public static ListNode mergeSortedLists(ListNode h1, ListNode h2) {

        // base conditions
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }

        // initialize head of merged list
        ListNode h3;
        if (h1.val < h2.val) {
            h3 = h1;
            h1 = h1.down;
        } else {
            h3 = h2;
            h2 = h2.down;
        }
        ListNode head = h3;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                h3.down = h1;
                h3 = h3.down;
                h1 = h1.down;
            } else {
                h3.down = h2;
                h3 = h3.down;
                h2 = h2.down;
            }
        }

        if (h1 != null) {
            h3.down = h1;
        }

        if (h2 != null) {
            h3.down = h2;
        }

        return head;
    }

    // flatten the lists
    public static ListNode flatten(ListNode root) {

        ListNode h1 = null;

        ListNode curr = root;
        ListNode nxt;
        while (curr != null) {
            // save the list on right of current
            nxt = curr.right;

            // remove the right pointers from lists
            curr.right = null;

            // sort h1 and h2
            ListNode h2 = curr;
            h1 = mergeSortedLists(h1, h2);

            // assign curr to earlier saved list
            curr = nxt;
        }

        // return final list connected with only down pointers
        return h1;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp.down != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.down;
        }
        System.out.println(temp.val);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode d1 = new ListNode(10);
        ListNode d2 = new ListNode(15);
        ListNode d3 = new ListNode(19);
        head.down = d1;
        d1.down = d2;
        d2.down = d3;
        print(head);

        ListNode head2 = new ListNode(2);
        ListNode d21 = new ListNode(8);
        head2.down = d21;
        head.right = head2;
        print(head2);

        ListNode head3 = new ListNode(12);
        ListNode d31 = new ListNode(18);
        ListNode d32 = new ListNode(24);
        head3.down = d31;
        d31.down = d32;
        head2.right = head3;
        print(head3);

        head = flatten(head);
        System.out.println("flattened list:");
        print(head);

    }
}
