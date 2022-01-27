/* Merge Two Sorted Lists */

/**
 * Problem Description
 * 
 * Merge two sorted linked lists A and B and return it as a new list.
 * 
 * The new list should be made by splicing together the nodes of the first two
 * lists, and should also be sorted.
 * 
 * 
 * Problem Constraints
 * 0 <= |A|, |B| <= 10^5
 * 
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 * The second argument of input contains a pointer to the head of linked list B.
 * 
 * Output Format
 * Return a pointer to the head of the merged linked list.
 * 
 * Example Input
 * Input 1:
 * A = 5 -> 8 -> 20
 * B = 4 -> 11 -> 15
 * Input 2:
 * A = 1 -> 2 -> 3
 * B = Null
 * 
 * Example Output
 * Output 1:
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 * 1 -> 2 -> 3
 * 
 * Example Explanation
 * Explanation 1:
 * Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 * We don't need to merge as B is empty.
 */

/**
 * TC: O(N+M)
 * SC: O(1)
 */
public class hw_q2_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {

        ListNode head = null;

        // base conditions if (h1 and h2) or (h1) or (h2) are null
        if (h1 == null && h2 == null) {
            return null;
        } else if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }

        // merge the h1 and h2 in sorted order
        ListNode p1 = h1;
        ListNode p2 = h2;
        // initialize head
        if (p1.val < p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        // initialize current pointer which will point to current node in sorted linked
        // list
        ListNode curr = head;

        while (p1 != null && p2 != null) {
            ListNode temp;
            if (p1.val < p2.val) {
                temp = p1;
                p1 = p1.next;
            } else {
                temp = p2;
                p2 = p2.next;
            }
            // attach temp node current pointer nad increment current pointer
            temp.next = null;
            curr.next = temp;
            curr = temp;
        }

        // merge remaining elements from p1
        if (p1 != null) {
            curr.next = p1;
        }

        // merge remaining elements from p2
        if (p2 != null) {
            curr.next = p2;
        }

        // return head node
        return head;
    }

    public static void main(String[] args) {

        // test case 1
        ListNode h1 = LinkedListUtils.getSortedList(4);
        LinkedListUtils.printLL(h1);
        ListNode h2 = LinkedListUtils.getSortedList(4);
        LinkedListUtils.printLL(h2);
        ListNode head = mergeTwoLists(h1, h2);
        LinkedListUtils.printLL(head);

        // test case 2
        h1 = LinkedListUtils.getSortedList(3);
        LinkedListUtils.printLL(h1);
        h2 = LinkedListUtils.getSortedList(0);
        LinkedListUtils.printLL(h2);
        head = mergeTwoLists(h1, h2);
        LinkedListUtils.printLL(head);
    }
}
