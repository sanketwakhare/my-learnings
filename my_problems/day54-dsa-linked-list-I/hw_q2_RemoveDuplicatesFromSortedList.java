/* Remove Duplicates from Sorted List */

/***
 * Problem Description
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Problem Constraints
 * 0 <= length of linked list <= 10^6
 * 
 * Input Format
 * First argument is the head pointer of the linked list.
 * 
 * Output Format
 * Return the head pointer of the linked list after removing all duplicates.
 * 
 * Example Input
 * Input 1:
 * 1->1->2
 * Input 2:
 * 1->1->2->3->3
 * 
 * Example Output
 * Output 1:
 * 1->2
 * Output 2:
 * 1->2->3
 * 
 * Example Explanation
 * Explanation 1:
 * Each element appear only once in 1->2.
 */

// Definition for singly-linked list.
// class ListNode {
// public int val;
// public ListNode next;

// ListNode(int x) {
// val = x;
// next = null;
// }
// }

public class hw_q2_RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {

        // base condition for head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode temp = prev.next;

        while (temp != null) {
            while (temp != null && temp.val == prev.val) {
                // delete temp node
                prev.next = temp.next;
                temp.next = null;
                temp = prev.next;
            }
            if (temp != null) {
                // move to next elements if there are still some elements left in list
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode t1 = new ListNode(1);
        head.next = t1;
        ListNode t2 = new ListNode(1);
        t1.next = t2;
        ListNode t3 = new ListNode(2);
        t2.next = t3;
        ListNode t4 = new ListNode(2);
        t3.next = t4;
        ListNode t5 = new ListNode(3);
        t4.next = t5;
        ListNode t6 = new ListNode(4);
        t5.next = t6;
        ListNode t7 = new ListNode(5);
        t6.next = t7;
        ListNode t8 = new ListNode(5);
        t7.next = t8;

        LinkedListUtils.printLL(head);
        head = deleteDuplicates(head);
        LinkedListUtils.printLL(head);
    }

}
