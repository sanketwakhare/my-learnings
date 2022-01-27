/* Reorder List */

/***
 * Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.

Problem Constraints
1 <= |A| <= 10^6

Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5] 
Input 2:
 A = [1, 2, 3, 4] 

Example Output
Output 1:
 [1, 5, 2, 4, 3] 
Output 2:
 [1, 4, 2, 3] 

Example Explanation
Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */

/**
 * TC: O(N)
 * SC: O(1)
 */
public class q3_ReorderList {

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

    // reverse a given node
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

    // merge two nodes where size of h1 >= size of h2
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

    // reorder function
    public static ListNode reorderList(ListNode head) {

        // step 1 - find middle c1
        ListNode c1 = findMiddle(head);

        // step 2 - break the list into 2 halves/lists
        // 0 to c1
        // c1+.next to end
        ListNode h1 = head;
        ListNode h2 = c1.next;
        c1.next = null;

        // step 3 - reverse second ll
        h2 = reverse(h2);

        // step 4 - merge 1st half and 2nd half
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
