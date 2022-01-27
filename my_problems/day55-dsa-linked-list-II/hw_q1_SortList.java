/* Sort List */

/**
 * Problem Description
 * 
 * Sort a linked list, A in O(n log n) time using constant space complexity.
 * 
 * Problem Constraints
 * 0 <= |A| = 10^5
 * 
 * Input Format
 * The first and the only argument of input contains a pointer to the head of
 * the linked list, A.
 * 
 * Output Format
 * Return a pointer to the head of the sorted linked list.
 * 
 * Example Input
 * Input 1:
 * A = [3, 4, 2, 8]
 * Input 2:
 * A = [1]
 * 
 * Example Output
 * Output 1:
 * [2, 3, 4, 8]
 * Output 2:
 * [1]
 * 
 * Example Explanation
 * Explanation 1:
 * The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
 * Explanation 2:
 * The sorted form of [1] is [1].
 */

/**
 * TC: O(n log n)
 * SC: O(1)
 */
public class hw_q1_SortList {
    // Idea: use merge sort to sort the list

    // merge 2 sorted lists with constant space
    public static ListNode merge(ListNode h1, ListNode h2) {

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

    // find middle node of linked list
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

    public static ListNode sortList(ListNode head) {

        // base condition
        if (head == null || head.next == null) {
            return head;
        }

        // find middle and break the list into 2 halves
        ListNode mid = findMiddle(head);

        ListNode h1 = head;
        ListNode h2 = mid.next;
        mid.next = null;

        // sort first half recursively
        h1 = sortList(h1);
        // sort second half recursively
        h2 = sortList(h2);

        // merge 2 sorted lists
        head = merge(h1, h2);

        // return final head pointer
        return head;
    }

    public static void main(String[] args) {

        ListNode head = LinkedListUtils.getRandomList(10);
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getUnsortedList();
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getRandomList(1);
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getRandomList(2);
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getRandomList(0);
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getRandomList(20);
        LinkedListUtils.printLL(head);
        head = sortList(head);
        LinkedListUtils.printLL(head);

    }

}
