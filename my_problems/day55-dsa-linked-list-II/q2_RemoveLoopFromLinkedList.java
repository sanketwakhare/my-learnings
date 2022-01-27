/* Remove Loop from Linked List */

/* 
Problem Description

Given a linked list which contains some loop.

You need to find the node, which creates a loop, and break it by making the node point to NULL.

Problem Constraints
1 <= number of nodes <= 1000

Input Format
Only argument is the head of the linked list.

Output Format
return the head of the updated linked list.

Example Input
Input 1:
1 -> 2
^    |
| - - 

Input 2:
3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -

Example Output
Output 1:
 1 -> 2 -> NULL
Output 2:
 3 -> 2 -> 4 -> 5 -> 6 -> NULL

Example Explanation
Explanation 1:
 Chain of 1->2 is broken.
Explanation 2:
 Chain of 4->6 is broken.
 */

/**
 * Break the loop in linked list
 * TC: O(N)
 * SC:O(1)
 */
public class q2_RemoveLoopFromLinkedList {

    public static ListNode solve(ListNode head) {

        // consider two pointers slow and fast
        // slow takes 1 hop and fast takes 2 hops at a given time
        // slow and fast will meet at some point in time when there is loop/cycle

        // base condition for head
        if (head == null) {
            return head;
        }

        // initialize pointers slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // find first meeting point inside loop if there exist a loop
        // if loop does not exist, this loop will break
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // this is the meeting point of both the pointers
                // cycle exist in given linked list
                break;
            }
        }

        // if no cycle exist, return head
        if (fast == null || fast.next == null) {
            return head;
        }

        // now we have to find the start of the loop
        // start two pointer from head position and current slow position each and
        // increase them by 1 every iteration
        // they will meet exactly at the start of the loop
        ListNode start = head;

        // maintain a previous pointer slow to be at the previous position of starting
        // of loop (within loop)
        ListNode prev = slow;

        while (start != slow) {
            prev = slow;
            start = start.next;
            slow = slow.next;
        }
        // break teh loop/cycle
        prev.next = null;

        // return head;
        return head;
    }

    public static void main(String[] args) {

        ListNode head = LinkedListUtils.getListWithLoop();
        head = solve(head);
        LinkedListUtils.printLL(head);

    }

}
