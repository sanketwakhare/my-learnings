import java.util.ArrayList;

/* Merge K Sorted Lists */

/***
 * Problem Description
 * Given a list containing head pointers of N sorted linked lists. Merge these N
 * given sorted linked lists and return it as one sorted list.
 * 
 * Problem Constraints
 * 1 <= total number of elements in given linked lists <= 100000
 * 
 * Input Format
 * First and only argument is a list containing N head pointers.
 * 
 * Output Format
 * Return a pointer to the head of the sorted linked list after merging all the
 * given linked lists.
 * 
 * Example Input
 * Input 1:
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * Input 2:
 * 10 -> 12
 * 13
 * 5 -> 6
 * 
 * Example Output
 * Output 1:
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Output 2:
 * 5 -> 6 -> 10 -> 12 ->13
 * 
 * Example Explanation
 * Explanation 1:
 * The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 ->
 * 9 -> 10 -> 11 -> 13 -> 20.
 * Explanation 2:
 * The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12
 * ->13.
 */

/**
 * TC: O(N)
 * SC: O(1)
 */
public class hw_q6_MergeKSortedLists {

    /** Merge two sorted lists. */
    ListNode mergeSortedLists(ListNode h1, ListNode h2) {

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
            h1 = h1.next;
        } else {
            h3 = h2;
            h2 = h2.next;
        }
        ListNode head = h3;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                h3.next = h1;
                h3 = h3.next;
                h1 = h1.next;
            } else {
                h3.next = h2;
                h3 = h3.next;
                h2 = h2.next;
            }
        }

        if (h1 != null) {
            h3.next = h1;
        }

        if (h2 != null) {
            h3.next = h2;
        }

        return head;
    }

    public ListNode mergeKLists(ArrayList<ListNode> list) {

        ListNode head = null;

        for (int i = 0; i < list.size(); i++) {

            ListNode h2 = list.get(i);
            head = mergeSortedLists(head, h2);
        }

        return head;

    }

}
