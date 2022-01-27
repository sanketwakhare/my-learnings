/* List Cycle */

/**
 * Problem Description
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Try solving it using constant additional space.
 * 
 * Example:
 * 
 * Input:
 * 
            * ______
            * | |
            * \/ |
 * 1 -> 2 -> 3 -> 4
 * 
 * Return the node corresponding to node 3.
 */

/**
 * Detect a loop/cycle in a linked list
 * TC: O(N)
 * SC: O(1) - without extra space
 */
public class q1_ListCycle {

    public static ListNode detectCycle(ListNode head) {

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

        // if no cycle exist
        if (fast == null || fast.next == null) {
            return null;
        }

        // now we have to find the start of the loop
        // start two pointer from head position and current slow position each and
        // increase them by 1 every iteration
        // they will meet exactly at the start of the loop
        ListNode start = head;

        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        // after the while loop, we will get the start node of loop and return it
        return slow;

    }

    public static void main(String[] args) {

        ListNode head = LinkedListUtils.getListWithLoop();
        ListNode targetNode = detectCycle(head);
        if (targetNode != null) {
            System.out.println("loop starting at node " + targetNode.val);
        } else {
            System.out.println("no loop in given linked list");
        }
    }

}
