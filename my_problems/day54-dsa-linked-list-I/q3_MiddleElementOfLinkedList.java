/* Middle element of linked list */

/****
 * Problem Description
 * 
 * Given a linked list of integers. Find and return the middle element of the
 * linked list.
 * 
 * NOTE: If there are N nodes in the linked list and N is even then return the
 * (N/2 + 1)th element.
 * 
 * Problem Constraints
 * 1 <= length of the linked list <= 100000
 * 1 <= Node value <= 10^9
 * 
 * Input Format
 * The only argument given head pointer of linked list.
 * 
 * Output Format
 * Return the middle element of the linked list.
 * 
 * Example Input
 * Input 1:
 * 1 -> 2 -> 3 -> 4 -> 5
 * Input 2:
 * 1 -> 5 -> 6 -> 2 -> 3 -> 4
 * 
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * The middle element is 3.
 * Explanation 2:
 * 
 * The middle element in even length linked list of length N is ((N/2) + 1)th
 * element which is 2.
 */

public class q3_MiddleElementOfLinkedList {

    public static int middleElementOfLinkedList(ListNode head) {
        // base conditions for head
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            head = head.next;
            return 0;
        }

        // first find how many elements are present in ll
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // calculate position of node to be returned
        int targetNodePos = (size / 2) + 1;

        // reach till target node position
        temp = head;
        while ((targetNodePos > 1) && temp != null) {
            temp = temp.next;
            targetNodePos--;
        }

        // return node value
        return temp.val;
    }

    public static void main(String[] args) {
        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        System.out.println("answer -> " + middleElementOfLinkedList(head));

        // even size
        head = LinkedListUtils.getTestData();
        ListNode x = new ListNode(6);
        x.next = head;
        head = x;
        LinkedListUtils.printLL(head);
        System.out.println("answer -> " + middleElementOfLinkedList(head));
    }

}
