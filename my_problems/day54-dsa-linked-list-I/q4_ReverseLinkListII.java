/* Reverse Link List II */

/***
 * Problem Description
 * 
 * Reverse a linked list A from position B to C.
 * NOTE: Do it in-place and in one-pass.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^6
 * 1 <= B <= C <= |A|
 * 
 * Input Format
 * The first argument contains a pointer to the head of the given linked list,
 * A.
 * The second argument contains an integer, B.
 * The third argument contains an integer C.
 * 
 * Output Format
 * Return a pointer to the head of the modified linked list.
 * 
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3 -> 4 -> 5
 * B = 2
 * C = 4
 * Input 2:
 * A = 1 -> 2 -> 3 -> 4 -> 5
 * B = 1
 * C = 5
 * 
 * Example Output
 * Output 1:
 * 1 -> 4 -> 3 -> 2 -> 5
 * Output 2:
 * 5 -> 4 -> 3 -> 2 -> 1
 * 
 * Example Explanation
 * Explanation 1:
 * In the first example, we want to reverse the highlighted part of the given
 * linked list : 1 -> 2 -> 3 -> 4 -> 5
 * Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
 * Explanation 2:
 * 
 * In the second example, we want to reverse the highlighted part of the given
 * linked list : 1 -> 4 -> 3 -> 2 -> 5
 * Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */

public class q4_ReverseLinkListII {

    public static ListNode reverseBetween(ListNode head, int start, int end) {

        // base condition for head
        if (head == null || head.next == null) {
            return head;
        }
        if (end - start == 0 || end < start) {
            return head;
        }

        int pos = 1;
        // when start is head
        if (start == 1) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode nxt = curr.next;

            while (curr.next != null && pos < end) {
                prev = curr;
                curr = nxt;
                nxt = nxt.next;
                curr.next = prev;
                pos++;
            }
            head.next = nxt;
            head = curr;
            return head;
        }
        // when end is tail
        pos = 1;

        // traverse till node before start position
        ListNode temp = head;
        while (pos < start - 1) {
            temp = temp.next;
            pos++;
        }

        ListNode prev = temp;
        ListNode curr = prev.next;
        ListNode nxt = curr.next;
        while (curr != null && pos < end) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            pos++;
        }
        temp.next.next = curr;
        temp.next = prev;

        // when start and end are in between

        return head;

    }

    public static void main(String[] args) {

        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = reverseBetween(head, 2, 4);
        LinkedListUtils.printLL(head);

        // even size
        head = LinkedListUtils.getTestData();
        ListNode x = new ListNode(10);
        x.next = head;
        head = x;
        LinkedListUtils.printLL(head);
        head = reverseBetween(head, 1, 5);
        LinkedListUtils.printLL(head);

    }

}
