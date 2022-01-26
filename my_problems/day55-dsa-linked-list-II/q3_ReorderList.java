/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class q3_ReorderList {

    public static ListNode findMiddle(ListNode head) {

        // do it in single pass

        // edge case for head
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // after above loop, slow will point to the middle node
        return slow;
    }

    public static ListNode reverse(ListNode head) {

        // base case for head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;

        // reverse ll
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // return new head as prev
        return prev;
    }

    public static ListNode merge(ListNode h1, ListNode h2) {

        ListNode head = h1;
        ListNode temp = h2;

        // iterate over h2 and insert h2 element in between each h1 elements
        while (h2 != null) {
            temp = h2;
            h2 = h2.next;
            temp.next = h1.next;
            h1.next = temp;
            h1 = h1.next.next;
        }
        return head;
    }

    public static ListNode reorderList(ListNode head) {

        // find middle c1
        ListNode c1 = findMiddle(head);

        // break the list into 2 halfs/lists
        // 0 to c1
        // c1+.next to end
        ListNode h1 = head;
        ListNode h2 = c1.next;
        c1.next = null;

        // reverse second ll
        h2 = reverse(h2);

        // merge 1st half and 2nd half
        head = merge(h1, h2);
        return head;
    }

    public static void main(String[] args) {

        // odd length ll
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = reorderList(head);
        LinkedListUtils.printLL(head);

        // even length ll
        head = LinkedListUtils.getTestData();
        ListNode t1 = new ListNode(6);
        t1.next = head;
        head = t1;
        LinkedListUtils.printLL(head);
        head = reorderList(head);
        LinkedListUtils.printLL(head);
    }
}
