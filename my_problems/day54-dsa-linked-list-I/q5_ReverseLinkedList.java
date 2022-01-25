/* Reverse Linked List */

/***
 * Problem Description
 * 
 * You are given a singly linked list having head node A. You have to reverse
 * the linked list and return the head node of that reversed list.
 * 
 * NOTE: You have to do it in-place and in one-pass.
 * 
 * Problem Constraints
 * 1 <= Length of linked list <= 10^5
 * 
 * Value of each node is within the range of a 32-bit integer.
 * 
 * Input Format
 * First and only argument is a linked-list node A.
 * 
 * Output Format
 * Return a linked-list node denoting the head of the reversed linked list.
 * 
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * Input 2:
 * A = 3 -> NULL
 * 
 * Example Output
 * Output 1:
 * 5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * Output 2:
 * 3 -> NULL
 * 
 * Example Explanation
 * Explanation 1:
 * The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4
 * -> 3 -> 2 -> 1 -> NULL
 * Explanation 2:
 * The linked list consists of only a single node. After reversing it, the list
 * becomes : 3 -> NULL
 */

public class q5_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        // base conditions for head
        if (head == null || head.next == null) {
            return head;
        }

        // use 3 pointers to manipulate the links
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = curr.next;

        // iterate and change the node links in place while nxt is not null
        while (nxt != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }

        // change last link
        curr.next = prev;
        // finally assign new head as curr
        head = curr;

        return head;

    }

    public static void main(String[] args) {
        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = reverseList(head);
        LinkedListUtils.printLL(head);

        // even size
        head = LinkedListUtils.getTestData();
        ListNode x = new ListNode(10);
        x.next = head;
        head = x;
        LinkedListUtils.printLL(head);
        head = reverseList(head);
        LinkedListUtils.printLL(head);

        // size = 1
        head = new ListNode(20);
        LinkedListUtils.printLL(head);
        head = reverseList(head);
        LinkedListUtils.printLL(head);
    }

}
