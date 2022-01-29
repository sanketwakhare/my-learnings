/* Swap List Nodes in pairs */

/***
 * Problem Description
 * 
 * Given a linked list A, swap every two adjacent nodes and return its head.
 * 
 * NOTE: Your algorithm should use only constant space. You may not modify the
 * values in the list, only nodes itself can be changed.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^6
 * 
 * Input Format
 * The first and the only argument of input contains a pointer to the head of
 * the given linked list.
 * 
 * Output Format
 * Return a pointer to the head of the modified linked list.
 * 
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3 -> 4
 * Input 2:
 * A = 7 -> 2 -> 1
 * 
 * Example Output
 * Output 1:
 * 2 -> 1 -> 4 -> 3
 * Output 2:
 * 2 -> 7 -> 1
 * 
 * Example Explanation
 * Explanation 1:
 * In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them
 * will result in 2 -> 1 -> 4 -> 3
 * Explanation 2:
 * In the second example, 3rd element i.e. 1 does not have an adjacent node, so
 * it won't be swapped.
 */

/**
 * TC: O(N)
 * SC: O(1)
 */
public class q4_SwapListNodesInPairs {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public static ListNode swapPairs(ListNode head) {

        // base condition for head
        if (head == null || head.next == null) {
            return head;
        }

        // new head to return
        ListNode newHead = head.next;

        // maintain prev curr and nxt pointers
        ListNode curr = head;
        ListNode prev = curr;
        ListNode nxt = curr.next;

        while (curr != null && curr.next != null) {

            // link prev's next to the current's next
            prev.next = curr.next;
            nxt = curr.next;

            // move the prev to curr
            prev = curr;

            // change curr's and nxt's next links
            curr.next = nxt.next;
            nxt.next = curr;

            curr = curr.next;
        }

        return newHead;
    }

    public static void main(String[] args) {

        // test case 1
        ListNode head = LinkedListUtils.getRandomList(10);
        LinkedListUtils.printLL(head);
        head = swapPairs(head);
        LinkedListUtils.printLL(head);

        // test case 2
        head = LinkedListUtils.getRandomList(21);
        LinkedListUtils.printLL(head);
        head = swapPairs(head);
        LinkedListUtils.printLL(head);

    }

}
