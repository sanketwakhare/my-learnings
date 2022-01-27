/* Intersection of Linked Lists */

/**
 * Problem Description
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists, A and B, begins. For example, the following two linked lists:
 * 
 * A: a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B: b1 → b2 → b3
 * 
 * NOTE:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * The custom input to be given is different than the one explained in the
 * examples. Please be careful.
 * 
 * Problem Constraints
 * 0 <= |A|, |B| <= 10^6
 * 
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list
 * A.
 * 
 * The second argument of input contains a pointer to the head of the linked
 * list B.
 * 
 * Output Format
 * Return a pointer to the node after which the linked list is intersecting.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [6, 3, 4, 5]
 * Input 2:
 * A = [1, 2, 3]
 * B = [4, 5]
 * 
 * 
 * Example Output
 * Output 1:
 * [3, 4, 5]
 * Output 2:
 * []
 * 
 * Example Explanation
 * Explanation 1:
 * In the first example, the nodes have the same values after 3rd node in A and
 * 2nd node in B. Thus, the linked lists are intersecting after that point.
 * 
 * Explanation 2:
 * In the second example, the nodes don't have the same values, thus we can
 * return None/Null.
 */

/**
 * TC: O(N+M) => for list starting with a1 and b1
 * SC: O(1) no extra space
 */
public class hw_q3_IntersectionOfLinkedLists {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
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

    public static ListNode getIntersectionNode(ListNode a1, ListNode b1) {

        // edge case if a1 or a2 is null
        if (a1 == null || b1 == null) {
            return null;
        }

        // join the two lists a1 and b1 so that if intersection point is present, it
        // will form a loop
        ListNode temp = a1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = b1;

        // now find the start node if there exist a loop
        ListNode head = a1;
        ListNode intersectionNode = detectCycle(head);
        return intersectionNode;
    }

    public static void main(String[] args) {

        // A = [1, 2, 3, 4, 5]
        // B = [6, 3, 4, 5]
        ListNode a1 = new ListNode(1);
        a1 = LinkedListUtils.insertAtEnd(a1, 2);
        a1 = LinkedListUtils.insertAtEnd(a1, 3);
        a1 = LinkedListUtils.insertAtEnd(a1, 4);
        a1 = LinkedListUtils.insertAtEnd(a1, 5);

        // get pointer of 3
        ListNode temp = a1;
        while (temp != null && temp.val != 3) {
            temp = temp.next;
        }
        ListNode b1 = new ListNode(6);
        b1.next = temp;

        ListNode intersectionNode = getIntersectionNode(a1, b1);
        if (intersectionNode != null) {
            System.out.println(intersectionNode.val);
        } else {
            System.out.println("There are no intersection nodes");
        }

    }
}
