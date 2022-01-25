/* K reverse linked list */

/***
 * Problem Description
 * 
 * Given a singly linked list A and an integer B, reverse the nodes of the list
 * B at a time and return modified linked list.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^3
 * B always divides A
 * 
 * Input Format
 * The first argument of input contains a pointer to the head of the linked
 * list.
 * The second argument of input contains the integer, B.
 * 
 * Output Format
 * Return a pointer to the head of the modified linked list.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5, 6]
 * B = 2
 * Input 2:
 * A = [1, 2, 3, 4, 5, 6]
 * B = 3
 * 
 * Example Output
 * Output 1:
 * [2, 1, 4, 3, 6, 5]
 * Output 2:
 * [3, 2, 1, 6, 5, 4]
 * 
 * Example Explanation
 * Explanation 1:
 * For the first example, the list can be reversed in groups of 2.
 * [[1, 2], [3, 4], [5, 6]]
 * After reversing the K-linked list
 * [[2, 1], [4, 3], [6, 5]]
 * Explanation 2:
 * For the second example, the list can be reversed in groups of 3.
 * [[1, 2, 3], [4, 5, 6]]
 * After reversing the K-linked list
 * [[3, 2, 1], [6, 5, 4]]
 */

public class q2_K_ReverseLinkedList {

    public static ListNode reverseList(ListNode head, int K) {

        // Idea: use recursive approach to solve this problem

        // base condition
        if (head == null) {
            return null;
        }

        // initialize all 3 pointers
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;

        int tempK = K;
        while (curr != null && tempK > 0) {

            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            tempK--;
        }
        // recursive call
        // this head here is old head
        head.next = reverseList(curr, K);
        // this is new head, kth element in list
        return prev;

    }

    public static void main(String[] args) {

        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = reverseList(head, 2);
        LinkedListUtils.printLL(head);

        // even size
        head = LinkedListUtils.getTestData();
        ListNode x = new ListNode(6);
        x.next = head;
        head = x;
        LinkedListUtils.printLL(head);
        head = reverseList(head, 3);
        LinkedListUtils.printLL(head);

    }

}
