/* Clone a Linked List */

/***
 * Problem Description
 * Given a doubly linked list of integers with one pointer of each node pointing
 * to the next node (just like in a single link list) while the second pointer,
 * however, can point to any node in the list and not just the previous node.
 * You have to create a copy of this list and return the head pointer of the
 * duplicated list.
 * 
 * Problem Constraints
 * 1 <= length of the list <= 100000
 * 1 <= Value of node <= 100000
 * 
 * Input Format
 * The only argument given is head pointer of the doubly linked list.
 * 
 * Output Format
 * Return the head pointer of the duplicated list.
 * 
 * Example Input
 * Input 1:
 * 1 -> 2 -> 3 -> 4 -> 5
 * random pointer of each node
 * 1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
 * Input 2:
 * 1 -> 2 -> 3 -> 4 -> 5
 * random pointer of each node
 * 1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
 * 
 * Example Output
 * Output 1:
 * 1 -> 2 -> 3 -> 4 -> 5
 * random pointer of each node
 * 1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
 * Output 2:
 * 1 -> 2 -> 3 -> 4 -> 5
 * random pointer of each node
 * 1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
 * 
 * Example Explanation
 * Explanation 1:
 * Just clone the given list.
 * Explanation 2:
 * Just clone the given list
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class hw_q5_cloneLL {

    class ListNode {
        int val;
        ListNode next, random;

        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }

    // Step 1: create copy nodes and insert in between original nodes by only next
    // pointers
    public ListNode createCloneList(ListNode head) {

        // base condition for head
        if (head == null) {
            return null;
        }
        // initialize curr to traverse the list
        ListNode curr = head;

        while (curr != null) {
            ListNode x = new ListNode(curr.val);
            x.next = curr.next;
            curr.next = x;
            curr = curr.next.next;
        }
        // return the newly created list/combined list
        return head;
    }

    // Step 2 - assign random pointers to newly created nodes
    public ListNode assignRandomPointersToCopyNodes(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        return head;
    }

    // Step 3 - separate two lists into old and new list and return copy list head
    // pointer
    public ListNode separateTwoLists(ListNode head) {

        if (head == null) {
            return null;
        }

        // curr is usd to iterate over old list
        ListNode curr = head;
        ListNode headCopy = curr.next;

        // temp is used to iterate over copy list
        ListNode temp = headCopy;

        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            // ignore for last temp node as its next is already pointing to null
            if (curr != null) {
                temp.next = curr.next;
                temp = temp.next;
            }
        }

        // return copy list
        return headCopy;
    }

    public ListNode cloneList(ListNode head) {

        // Step 1: create copy nodes and insert in between original nodes by only next
        // pointers
        head = createCloneList(head);

        // Step 2 - assign random pointers to newly created nodes
        head = assignRandomPointersToCopyNodes(head);

        // Step 3 - separate two lists into old and new list and return copy list head
        // pointer
        ListNode copyHead = separateTwoLists(head);
        return copyHead;
    }
}
