/* Remove Nth Node from List End */

/***
 * Problem Description
 * 
 * Given a linked list A, remove the B-th node from the end of list and return
 * its head.
 * 
 * For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the
 * second node from the end, the linked list becomes 1->2->3->5.
 * 
 * NOTE: If B is greater than the size of the list, remove the first node of the
 * list.
 * 
 * NOTE: Try doing it using constant additional space.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^6
 * 
 * Input Format
 * The first argument of input contains a pointer to the head of the linked
 * list.
 * The second argument of input contains the integer B.
 * 
 * Output Format
 * Return the head of the linked list after deleting the B-th element from the
 * end.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 2
 * Input 2:
 * A = [1]
 * B = 1
 * 
 * Example Output
 * Output 1:
 * [1, 2, 3, 5]
 * Output 2:
 * []
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * In the first example, 4 is the second last element.
 * Explanation 2:
 * In the second example, 1 is the first and the last element.
 */

public class hw_q1_RemoveNthNodeFromListEnd {

    public static ListNode removeNthFromEnd(ListNode head, int B) {

        // find size of linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (B >= size) {
            // remove head when B > size
            head = head.next;
        } else {
            // posOfElementToRemove it 0 based
            int posOfElementToRemove = size - B;

            ListNode prev = head;
            temp = prev.next;
            while (temp != null && posOfElementToRemove > 1) {
                prev = temp;
                temp = temp.next;
                posOfElementToRemove--;
            }
            // remove temp
            if (temp != null) {
                prev.next = temp.next;
                temp.next = null;
            } else {
                // delete last node, temp is last node
                prev.next = null;
            }
        }

        return head;

    }

    public static void main(String[] args) {

        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = removeNthFromEnd(head, 1);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = removeNthFromEnd(head, 3);
        LinkedListUtils.printLL(head);

        head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = removeNthFromEnd(head, 5);
        LinkedListUtils.printLL(head);

        // when B>size
        head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = removeNthFromEnd(head, 40);
        LinkedListUtils.printLL(head);

    }

}
